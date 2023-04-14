sap.ui.define(
  [
    "sap/ui/base/Object",
    "sap/ui/core/Fragment",
    "sap/ui/model/json/JSONModel",
    "fw/fragment/TableSelectDialog",
    "att/view/productionKanban/productionKanbanApi",
  ],
  function (Object, Fragment, JSONModel, TableSelectDialog) {
    "use strict";

    return Object.extend("att.view.productionKanban.fragment.kanbanSetting", {
      open: function (me) {
        this.me = me;
        let meData = me.getData()
        let kanbanType = localStorage.getItem('kanbanType')

        // fragment id, control/element id
        let dialog = Fragment.byId("kanbanSetting", "kanbanSettingDialog")
        // esc 關閉, dialog 並未清除, 開啟前先清除
        if (dialog) {
          dialog.destroy()
          dialog = null
        }

        if (!dialog) {
          Fragment.load(
            {
              name: "att.view.productionKanban.fragment.kanbanSetting",
              type: "XML",
              controller: this,
              id: "kanbanSetting",
            }).then((oDialog) => {

              this.dialog = oDialog;
              // 開窗 model
              oDialog.setModel(
                new JSONModel({
                  site: meData.site,
                  table: meData.itemTable,
                  refreshFrequency: localStorage.getItem('refreshFrequency') || 10,
                  kanbanType: localStorage.getItem('kanbanType') == null ? true : JSON.parse(localStorage.getItem('kanbanType'))  // true 自動; false 手動
                }, "dialog")
              )
              // 開窗載入 i18n
              oDialog.setModel(me.getModel("i18n"), "i18n")
              oDialog.open()
            });
        }
        return this
      },
      // 關閉畫面
      close: function (oEvent) {
        this.dialog.destroy()
        this.dialog = ''
      },
      add: function () {
        let oData = this.dialog.getModel().getData()
        let dialog = Fragment.byId("kanbanSetting", "kanbanSettingDialog")
        let oModel = dialog.getModel()

        oData.table.push({})
        oModel.refresh()
      },
      minus: function () {
        let oData = this.dialog.getModel().getData()
        let dialog = Fragment.byId("kanbanSetting", "kanbanSettingDialog")
        let oModel = dialog.getModel()
        let oTable = Fragment.byId("kanbanSetting", "table")
        let index = oTable.getSelectedIndices()[0]

        oData.table.splice(index, 1)
        oTable.clearSelection()
        oModel.refresh()
      },
      // 開窗
      openDialog: function (oEvent) {
        let me = this.me
        let dialog = Fragment.byId("kanbanSetting", "kanbanSettingDialog")
        let oModel = dialog.getModel()
        let oData = this.dialog.getModel().getData()
        let oSource = oEvent.getSource()
        let id = oSource.getId()
        let index = oSource.getBindingContext(undefined).getPath().split('/')[2]

        // 物料
        if (id.includes('item')) {
          $productionKanban.getItem(oData, (res) => {
            new TableSelectDialog().open(oSource, res, (data) => {
              oData.table[index].itemDesc = data.description
            })
          },
            me.showMessage
          )
        }
        //  途程
        if (id.includes('router')) {
          $productionKanban.getRouter(oData, (res) => {
            res.forEach(element => {
              element.currentRevision = element.currentRevision ? 'Y' : ''
            })
            new TableSelectDialog().open(oSource, res, (data) => {
              oData.table[index].routerReversion = data.revision
              oData.table[index].routerBo = data.handle
            })
          },
            me.showMessage
          )
        }
        oModel.refresh()
      },
      // 暫停
      pause: function () {
        let me = this.me
        let meData = me.getData()
        let oData = this.dialog.getModel().getData()

        if (oData.kanbanType) meData.refreshFrequency = ''
        this.close()
      },
      // 啟動
      activate: function () {
        let me = this.me
        let meData = me.getData()
        let oData = this.dialog.getModel().getData()

        // error : 選擇查詢清單
        if (oData.table.length == 0) me.error('productionKanban.warning1')
        // error : 自動看板 刷新頻率為空
        if (oData.kanbanType && !oData.refreshFrequency) me.error('productionKanban.warning2')

        // error : 檢查 table 物料 途程為空
        oData.table.forEach(row => {
          if (!row.item) me.error('productionKanban.warning3')
          if (!row.router) me.error('productionKanban.warning4')
        })

        // 存 attribute
        $productionKanban.saveAttribute(
          {
            site: meData.site,
            user: meData.user,
            activity: meData.activity,
            data: [...oData.table]
          },
          () => { },
          me.showMessage
        )

        meData.refreshFrequency = oData.refreshFrequency
        meData.refreshLists = oData.table
        // 檢驗類型, 頻率 存入 localStorage
        localStorage.setItem('refreshFrequency', oData.refreshFrequency)
        localStorage.setItem('kanbanType', oData.kanbanType)

        me.getPageInfo(meData.refreshLists[0])
        if (oData.kanbanType) me.refreshPage()

        this.close()
      },
      // 數字 卡控
      numberControl: function (oEvent) {
        var oSource = oEvent.getSource()
        var customDatas = oSource.getCustomData()
        var number = oSource.getValue()
        var max,
          negative,
          decimal,
          decimalMax,
          symbol
        if (customDatas) {
          customDatas.forEach(function (cData, index) {
            switch (cData.getKey().toUpperCase()) {
              case 'max'.toUpperCase():
                if (cData.getValue()) {
                  max = parseInt(cData.getValue())
                }
                break
              case 'negative'.toUpperCase():
                negative = cData.getValue() == 'true' ? true : false
                break
              case 'decimal'.toUpperCase():
                decimal = cData.getValue() == 'true' ? true : false
                break
              case 'decimalMax'.toUpperCase():
                if (cData.getValue()) {
                  decimalMax = parseInt(cData.getValue())
                }
                break
              case 'symbol'.toUpperCase():
                symbol = cData.getValue() == 'true' ? true : false
                break
            }
          })
        }

        number = number.replace(/^[0]/g, '') // 不能 0
        number = number.replace(/[A-Za-z]/g, '') // 不能英文
        number = number.replace(/[^\x00-\x80]/g, '') // 不能中文
        number = number.replace(/[^\d\\?\\*\\,\\/.-]/g, '') // 不能? * , . - /以外符號

        if (max > 0) number = number.substring(0, max)
        if (negative) number = number.replace(/-/g, '')
        if (decimal) number = number.replace(/\./g, '')
        if (symbol) number = number.replace(/[/\\?\\*\\,]/g, '')
        if (number.match(/\./g)) {
          var arr = number.split('.')
          number = arr[0] + '.' + arr[1].substring(0, decimalMax)
        }

        let n = number.split('-').filter(str => str !== '')
        if (n.length > 0) n = n[0]


        if (number.startsWith('-')) {
          number = '-' + n
        } else {
          number = n
        }

        oSource.setValue(number)
      },
    });
  }
);
