sap.ui.define(
  [
    "fw/core/BaseController",
    "att/view/ncOperation/ncOperationApi",
  ],
  function (BaseController) {
    "use strict";
    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.ncOperation.ncOperation", {
      onInit: function () {
        this.attachPatternMatched("ncOperation", this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        let me = this
        let i18n = this.getI18N()
        let oView = this.getView();
        let req = oEvent.getParameter('arguments')['?req']

        // error : 作業
        if (!req.OPERATION) {
          oView.setBlocked(true);
          this.error(i18n.getText('ncOperation.warning6'));
        }
        // error : 資源
        if (!req.RESOURCE) {
          oView.setBlocked(true);
          this.error(i18n.getText('ncOperation.warning7'));
        }
        // error : SFC
        if (!req.SFC) {
          oView.setBlocked(true);
          this.error(i18n.getText('ncOperation.warning8'));
        }

        this.setModel({
          site: this.getSite(),
          user: this.getUser(),
          sfc: req.SFC,
          operation: req.OPERATION,
          resource: req.RESOURCE,
          table: [],
        });

        this.getSfcInfo()
        this.getColsInfo()
      },
      // 取得 SFC 資訊
      getSfcInfo: function () {
        let me = this;
        let oData = this.getData();

        // 取得 SFC 資訊
        $ncOperation.getSfc(
          {
            "site": oData.site,
            "sfc": oData.sfc,
            "operation": oData.operation,
            "resource": oData.resource
          },
          (res) => {
            oData.sfc = res.sfc
            oData.operation = res.operation
            oData.operationDesc = res.operationDesc
            oData.resource = res.resource
            oData.resourceDesc = res.resourceDesc
            oData.inWorkQty = res.inWorkQty

            if (!res.inWorkQty) error(i18n.getText('ncOperation.warning11'))
            else oData.table.push({})
            me.refresh()
          },
          me.showMessage
        )
      },
      // 檢索
      getColsInfo: function () {
        let me = this;
        let oData = this.getData();
        let oTable = this.byId('table')

        // 取得 欄位資料
        $ncOperation.getCols(
          {
            "site": oData.site,
          },
          (res) => {
            res.forEach(element => {
              oTable.addColumn(
                new sap.ui.table.Column(
                  {
                    hAlign: "Center",
                    resizable: false,
                    label: element.dataTag,
                    template: new sap.m.Text({
                      text: `{${element.dataField}}`
                    })
                  })
              )
            });
            me.refresh()
          },
          me.showMessage
        )

        setTimeout(() => {
          this.attachPasteEvent()
        }, 500)
      },
      // input 綁上 paste 監聽器
      attachPasteEvent: function () {
        let me = this
        let oRows = this.byId('table').getAggregation('rows')

        oRows.forEach((row) => {
          row.getCells().forEach((cell) => {
            cell.attachBrowserEvent('paste', function (oEvent) {
              me.paste.call(this, oEvent, me);
            });
          });
        });
      },
      paste: function (oEvent, me) {
        let i18n = this.getModel('i18n').getResourceBundle();
        let oData = this.getModel().getData()
        let oTable = this.getParent().getParent();
        let totalCols = oTable.getColumns()

        oEvent.stopPropagation();
        oEvent.preventDefault();

        // 取得 每一 row 的貼上文字
        let text = (oEvent.originalEvent || oEvent).clipboardData.getData('text/plain');
        // 為一個陣列 取得 每 row 的 text 字串  "NC001\t1\t\"AAA\nBBB\""
        let textArray = text.split(/\r/)
        // 取得 起始 row index
        let pathRow = this.getParent().getBindingContext().sPath;
        let startRowIndex = parseInt(pathRow.split('/')[2])
        let colKeysArray = []

        // 取得 col key 值
        totalCols.forEach(col => {
          let colKey =
            col.getAggregation('template').getBindingPath('text') ||
            col.getAggregation('template').getBindingPath('value')

          colKeysArray.push(colKey)
        })

        for (let i = 0; i < textArray.length - 1; i++) {
          let rowTextArray = textArray[i].split(/\t/)

          // error : 貼上欄位超出不合格介面
          if (rowTextArray.length > totalCols.length) me.error(i18n.getText('ncOperation.warning1'))
          // error : 不合格代碼不可為空
          if (rowTextArray[0].replace('\n', "") == '') me.error(i18n.getText('ncOperation.warning2'))
          // error : 數量不可為空
          if (rowTextArray[1] == '') me.error(i18n.getText('ncOperation.warning3'))
          // error : 數量僅可輸入數值
          if (isNaN(rowTextArray[1])) me.error(i18n.getText('ncOperation.warning4'))

          // row 傳入 每 col 的值
          rowTextArray.forEach((cellText, index) => {
            let txt
            // row 首 col 有 \n 換行符 
            if (index == 0) {
              txt = cellText.replace('\n', "").replace('\"', "").replace('\"', "")
            } else {
              txt = cellText.replace('\"', "").replace('\"', "")
            }

            if (!oData.table[startRowIndex + i]) oData.table.push({})
            if (index == rowTextArray.length - 1) oData.table[startRowIndex + i][colKeysArray[index]] = txt
            else oData.table[startRowIndex + i][colKeysArray[index]] = txt
          })
          // 最後始終增加一 row 供複製貼上
          if ((textArray.length - 1 + startRowIndex) == oData.table.length) oData.table.push({})
        }
        me.refresh();
      },
      // 確認
      confirm: function () {
        let me = this
        let i18n = this.getI18N()
        let oData = this.getData()
        let ncList = []
        let totalQty = 0

        // error : 清單無任何資料
        if (oData.table.length == 1 && !oData.table[0].ncCode) this.error(i18n.getText('ncOperation.warning9'))

        oData.table.forEach((row) => {
          totalQty = Number(totalQty) + Number(row.qty)
          // error : 不合格數量不可大於當站作業中數量
          if (totalQty > oData.inWorkQty) this.error(i18n.getText('ncOperation.warning5'))
          // error : 數量不可為空
          if (row.ncCode && !row.qty) me.error(i18n.getText('ncOperation.warning3'))
          // error : 不合格代碼不可為空
          if (!row.ncCode && row.qty) me.error(i18n.getText('ncOperation.warning2'))
          if (row.ncCode) ncList.push(row)
        })

        $ncOperation.save(
          {
            "site": oData.site,
            "sfc": oData.sfc,
            "operation": oData.operation,
            "resource": oData.resource,
            "user": oData.user,
            "ncList": ncList
          },
          (res) => {
            me.messageBox(
              {
                key: 'ncOperation.warning10',
                type: 'success'
              },
              // action
              () => { },
              // cancel
              () => {
                oData.table = []
                me.refresh()
                me.getSfcInfo()
              }
            );
          },
          me.showMessage
        )
      },
      // 清除
      clear: function () {
        let me = this
        let oData = this.getData()

        this.messageBox(
          {
            key: 'g.warning1',
            type: 'warning'
          },
          function () {
            oData.table = [{}]
            me.refresh()
          }
        )
      }
    });
  }
);
