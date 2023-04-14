sap.ui.define(
  [
    "fw/core/BaseController",
    "fw/fragment/TableSelectDialog",
    "att/view/clampStart/clampStartApi",
  ],
  function (BaseController, TableSelectDialog) {
    "use strict";

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.clampStart.clampStart", {
      onInit: function () {
        this.setModel({
          site: this.getSite(),
          activity: "",
          operation: "",
          operationDesc: "",
          resource: "",
          resourceDesc: "",
          tlRule: false,            // TL焊接碼 規則
          preCheckedRule: false,    // 預設勾選 規則
          sfc: "",
          sfcStatus: "",            // SFC 狀態
          qtyInQueue: "",
          toolNumber: "",
          sn: "",
          snQty: "",
          toolStateList: [],
          firstVisibleRow: 0      // table focus 的 row
        });

        this.attachPatternMatched("clampStart", this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        let me = this
        let i18n = this.getI18N()
        let oData = this.getData()
        let oView = this.getView()
        let req = oEvent.getParameter('arguments')['?req']

        if (!req.OPERATION) {
          oView.setBlocked(true)
          this.error(i18n.getText("clampStart.warning1"))
        }

        if (!req.RESOURCE) {
          oView.setBlocked(true)
          this.error(i18n.getText("clampStart.warning2"))
        } else {
          oData.resource = req.RESOURCE
          oData.operation = req.OPERATION
          oData.activity = req.ACTIVITY_ID
        }

        // 取得 資源, 作業說明
        $clampStart.getInfo(
          {
            site: oData.site,
            operation: oData.operation,
            resource: oData.resource
          },
          (res) => {
            oData.resourceDesc = res.resourceDesc
            oData.operationDesc = res.operationDesc
            me.refresh()
          },
          me.showMessage
        )

        // 取得活動規則
        new activity(this.getWebApi()).activityOption(oData.activity,
          (res) => {
            res.forEach(element => {
              if (element.execUnitOption === "TL_CODE" && element.setting === "Y") {
                oData.tlRule = true
                me.refresh()
              }
              if (element.execUnitOption === "CHOOSE" && element.setting === "Y") {
                oData.preCheckedRule = true
                me.refresh()
              }
            });
          },
          this.showMessage
        )
      },
      // 開窗
      openDialog: function (oEvent) {
        let me = this;
        let oData = this.getData();
        let oSource = oEvent.getSource();
        let id = oSource.getId()

        if (id.includes("sfc")) {
          $clampStart.getSFC(oData, (res) => {
            new TableSelectDialog().open(oSource, res, (data) => {
              oData.sfc = data.sfc
              me.refresh()
            });
          },
            me.showMessage
          )
        }
      },
      // 檢索
      search: function () {
        let me = this
        let oData = this.getData()
        let oTable = this.byId("table")

        this.isEmpty(oData.sfc, "g.sfc")

        $clampStart.scanSFC({
          site: oData.site,
          sfc: oData.sfc,
          operation: oData.operation,
          type: "start"   // SN夾具上機開始
        },
          (res) => {
            oData.snQty = res.snQty
            oData.qtyInQueue = res.qtyInQueue
            oData.toolStateList = res.toolStateList
            oData.sfcStatus = res.sfcStatus

            me.byId('sfc').setEditable(false)
            me.byId('toolNumber').focus()
            me.refresh()
            me.setTableRowCountAuto('table')
          },
          me.showMessage
        )

        if (oData.preCheckedRule) {
          oTable.selectAll()
        }
      },
      // 清除
      clear: function () {
        let oData = this.getData();
        let me = this;
        let excludes = [
          "operation",
          "resource",
          "operationDesc",
          "resourceDesc",
          "tlRule",
          "preCheckedRule",
        ]

        this.messageBox(
          {
            key: 'g.warning1',
            type: 'warning'
          },
          () => {
            me.clearData(oData, excludes)
            me.byId('sfc').setEditable(true)
            me.refresh();
          }
        )
      },
      // TL焊接碼 按紐
      tlSn: function () {
        let oData = this.getData()
        // 傳多個參數 陣列相對應 index back = Y; activity = 資料
        this.navTo('tlSn', ['back', 'ACTIVITY_ID'], ['Y', oData.activity])
      },
      // 工具編號
      checkToolNumber: function () {
        this.byId("sn").focus()
      },
      // SN 僅限 英數 -
      checkSN: function (oEvent) {
        let oSource = oEvent.getSource();
        let string = oSource.getValue();
        let customData = oSource.getCustomData();
        let symbol;

        if (customData) {
          customData.forEach((cData, index) => {
            switch (cData.getKey().toUpperCase()) {
              case "symbol".toUpperCase():
                symbol = cData.getValue() == "true" ? true : false;
                break;
            }
          });
        }

        string = string.replace(/[^\w\-]/g, "");  // 不能 - 以外符號

        if (symbol) {
          string = string.replace(/[/\\?\\*\\,]/g, "");
        }

        oSource.setValue(string);
      },
      // SN submit
      submitSN: function () {
        this.add()
        this.byId("toolNumber").focus()
      },
      // table + add
      add: function () {
        let me = this
        let oData = this.getData()
        let i18n = this.getI18N()
        let oTable = this.byId("table")

        if (this.byId("sfc").getEditable()) this.error(i18n.getText("clampStart.warning3"))

        this.isEmpty([
          oData.toolNumber,
          oData.sn
        ], [
          "clampStart.label4",
          "clampStart.label5"
        ])

        $clampStart.scanSNTooL({
          site: oData.site,
          sfc: oData.sfc,
          operation: oData.operation,
          resource: oData.resource,
          tool: oData.toolNumber,
          sn: oData.sn
        },
          (res) => {
            oData.toolStateList = res.toolStateList
            oData.snQty = res.snQty
            oData.inWorkQty = res.inWorkQty
            oData.sn = ""
            oData.toolNumber = ""
            // 新增後調整捲動到新增
            oData.firstVisibleRow = res.toolStateList.length

            me.refresh()
            me.setTableRowCountAuto('table')
          },
          me.showMessage
        )

        if (oData.preCheckedRule) {
          oTable.selectAll()
        }
      },
      // table - minus
      minus: function () {
        let me = this
        let i18n = this.getI18N()
        let oData = this.getData()
        let oTable = this.byId("table")
        let selectedArray = oTable.getSelectedIndices()

        if (selectedArray.length == 0) {
          this.error(i18n.getText("clampStart.warning4"))
        } else {
          let selectedList = []

          selectedArray.forEach(element => {
            selectedList.push({
              toolNumber: oData.toolStateList[element].toolNumber,
              sn: oData.toolStateList[element].sn,
            })
          })

          $clampStart.deleteSNTool({
            site: oData.site,
            sfc: oData.sfc,
            operation: oData.operation,
            toolStateList: selectedList
          },
            (res) => {
              oData.snQty = res.snQty
              oData.qtyInQueue = res.qtyInQueue
              oData.toolStateList = res.toolStateList

              oTable.clearSelection();

              me.refresh()
            },
            me.showMessage
          )
        }
      },
      // 開始
      start: function () {
        let me = this
        let i18n = this.getI18N()
        let oData = this.getData()
        let oTable = this.byId("table")
        let selectedArray = oTable.getSelectedIndices()
        let selectedList = []

        if (this.byId("sfc").getEditable()) {
          this.error(i18n.getText("clampStart.warning3"))
        }
        if (selectedArray.length == 0) {
          this.error(i18n.getText("clampStart.warning5"))
        }

        selectedArray.forEach(element => {
          selectedList.push({
            sn: oData.toolStateList[element].sn,
            toolNumber: oData.toolStateList[element].toolNumber,
          })
        })

        $clampStart.start({
          site: oData.site,
          sfc: oData.sfc,
          operation: oData.operation,
          resource: oData.resource,
          toolStateList: selectedList
        },
          (res) => {
            if (res) {
              me.messageBox({
                key: i18n.getText("clampStart.warning7", res),
                type: 'WARNING'
              })
            } else {
              me.messageBox(
                {
                  key: 'clampStart.warning6',
                  type: 'SUCCESS'
                },
                // action 
                () => { },
                // cancel
                () => {
                  oTable.clearSelection();
                  me.search()
                }
              )
            }
          },
          me.showMessage
        )
      }
    });
  }
);
