sap.ui.define(
  [
    "fw/core/BaseController",
    "fw/fragment/TableSelectDialog",
    "att/view/tmsalerman/tmsalermanApi",
  ],
  function (BaseController, TableSelectDialog) {
    "use strict";
    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.tmsalerman.tmsalerman", {
      onInit: function () {
        this.attachPatternMatched("tmsalerman", this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        this.setModel({
          site: this.getSite(),
          shopOrder: "",      // 包裝工單
          palletNo: [],       // 棧板
          cartonNo: [],       // 箱號
          sn: [],
          planStartDate: moment().format('YYYY-MM-01 00:00:00'),
          planEndDate: moment().format('YYYY-MM-DD 23:59:59'),
          tableLists: [],
        });
      },
      // 開窗 (模糊搜尋)
      openDialog: function (oEvent) {
        let me = this;
        let oData = this.getData();
        let oSource = oEvent.getSource();
        let id = oSource.getId()
        let palletNoList = []
        let cartonNoList = []

        // 包裝工單
        if (id.includes("shopOrder")) {
          $tmsalerman.getSO(
            {
              site: oData.site,
              shopOrder: oData.shopOrder,
              planStartDate: oData.planStartDate,
              planEndDate: oData.planEndDate
            },
            (data) => {
              new TableSelectDialog().open(oSource, data, (data) => {
                oData.shopOrder = data.shopOrder
                me.refresh()
              });
            },
            me.showMessage
          )
        }
        // 棧板
        if (id.includes("pallet")) {
          this.isEmpty(oData.shopOrder, "tmsalerman.label2")

          $tmsalerman.getPallet(
            {
              site: oData.site,
              shopOrder: oData.shopOrder,
            },
            (data) => {
              // 多選 input 不用另外賦值, 在 xml 設定
              new TableSelectDialog().open(oSource, data, (data) => { });
            },
            me.showMessage
          )
        }
        // 箱號
        if (id.includes("carton")) {
          this.isEmpty(oData.shopOrder, "tmsalerman.label2")

          oData.palletNo.forEach(element => {
            palletNoList.push(element.palletNo)
          })

          $tmsalerman.getCarton(
            {
              site: oData.site,
              shopOrder: oData.shopOrder,
              palletNoList: palletNoList
            },
            (data) => {
              new TableSelectDialog().open(oSource, data, (data) => { });
            },
            me.showMessage
          )
        }
        // SN
        if (id.includes("sn")) {
          this.isEmpty(oData.shopOrder, "tmsalerman.label2")

          oData.palletNo.forEach(element => {
            palletNoList.push(element.palletNo)
          })
          oData.cartonNo.forEach(element => {
            cartonNoList.push(element.cartonNo)
          })

          $tmsalerman.getSN(
            {
              site: oData.site,
              shopOrder: oData.shopOrder,
              palletNoList: palletNoList,
              cartonNoList: cartonNoList
            },
            (data) => {
              new TableSelectDialog().open(oSource, data, (data) => { });
            },
            me.showMessage
          )
        }
      },
      // 檢索
      search: function () {
        let me = this;
        let oData = this.getData();
        let oTable = this.byId("table")
        let palletNoList = []
        let cartonNoList = []
        let snList = []
        let tableMode = oTable.getVisibleRowCountMode()

        // 避免重新檢索時, table 自動調整高度
        oTable.setMinAutoRowCount(oTable.getVisibleRowCount())

        // 每次檢索, 先清空上次新增 Cols
        oTable.destroyColumns()
        oData.tableLists = ""

        this.isEmpty(oData.shopOrder, "tmsalerman.label2")

        // 取出多選輸入框的必要值
        oData.palletNo.forEach(element => {
          palletNoList.push(element.palletNo)
        })
        oData.cartonNo.forEach(element => {
          cartonNoList.push(element.cartonNo)
        })
        oData.sn.forEach(element => {
          snList.push(element.sn)
        })

        $tmsalerman.retrieve(
          {
            site: oData.site,
            shopOrder: oData.shopOrder,
            palletNoList: palletNoList,
            cartonNoList: cartonNoList,
            snList: snList,
            planStartDate: oData.planStartDate,
            planEndDate: oData.planEndDate
          },
          (res) => {
            let keyArray = Object.keys(res[0])
            keyArray.sort((a, b) => a.localeCompare(b, 'en', { numeric: true }))

            // table 適應裝置高度
            if (tableMode !== "Auto") oTable.setVisibleRowCountMode("Auto")

            // 新增 col
            keyArray.forEach(element => {
              oTable.addColumn(
                new sap.ui.table.Column(
                  {
                    hAlign: "Center",
                    resizable: false,
                    width: "10rem",
                    template: new sap.m.Text({
                      text: `{${element}}`
                    })
                  })
              )
            })
            oData.tableLists = res
            me.refresh()
          },
          me.showMessage
        )
      },
      // 刪除
      minus: function () {
        let i18n = this.getI18N()
        let oData = this.getData()
        let oTable = this.byId("table")
        let selectedArray = oTable.getSelectedIndices()

        if (selectedArray.length > 0) {
          selectedArray.reverse().forEach(index => {
            oData.tableLists.splice(index, 1);
            oTable.clearSelection()
            this.refresh()
          });
        } else this.error(i18n.getText("tmsalerman.warning1"))
      },
      // 匯出
      export: function () {
        let me = this;
        let oData = this.getData()

        this.fw_checkEmpty([oData.tableLists], ["tmsalerman.warning2"])

        // 取得模板資料
        $tmsalerman.getExcel(
          oData.tableLists,
          (res) => {
            if (res) {
              // 解碼
              let decodedPdfContent = atob(res);
              // 建出 uint8 陣列
              let byteArray = new Uint8Array(decodedPdfContent.length);

              for (let i = 0; i < decodedPdfContent.length; i++) {
                byteArray[i] = decodedPdfContent.charCodeAt(i);
              }
              // 輸出 Blob
              let blob = new Blob([byteArray.buffer],
                { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,' }
              )

              let fileName = moment().format("YYYY-MM-DD") + " Delivery Report"
              saveAs(blob, fileName + ".xlsx");
            }
          },
          me.showMessage
        )
      },
      // 清除 row 0 - 6 的標題選擇
      click: function () {
        let oTable = this.byId("table")

        setTimeout(() => {
          oTable.removeSelectionInterval(0, 6)
        }, 1);
      },
      // 清除
      clear: function () {
        let me = this;
        let oData = this.getData();
        let oTable = this.byId("table")
        let excludes = []

        this.messageBox(
          {
            key: 'g.clear.page',
            type: 'warning'
          },
          () => {
            me.clearData(oData, excludes)
            oTable.clearSelection()
            oData.planStartDate = moment().format('YYYY-MM-01 00:00:00')
            oData.planEndDate = moment().format('YYYY-MM-DD 23:59:59')
            me.refresh();
          }
        )
      },
      // 包裝工單 改變值
      change: function (oEvent) {
        let me = this
        let input = oEvent.getSource()

        input.setValue(oEvent.getParameter('newValue'))
        me.refresh();
      }
    });
  }
);
