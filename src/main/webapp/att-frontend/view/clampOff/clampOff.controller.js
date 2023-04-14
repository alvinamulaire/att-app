sap.ui.define(
  [
    "fw/core/BaseController",
    "fw/fragment/TableSelectDialog",
    "att/view/clampOff/clampOffApi",
  ],
  function (BaseController, TableSelectDialog) {
    "use strict";

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.clampOff.clampOff", {
      onInit: function () {
        this.attachPatternMatched("clampOff", this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        let me = this
        let i18n = this.getI18N()
        let oView = this.getView()
        let req = oEvent.getParameter('arguments')['?req']

        this.setModel({
          site: this.getSite(),
          user: this.getUser(),
          resource: "",
          operation: "",
          resourceDesc: "",
          operationDesc: "",
          toolNumber: "",
          toolStateList: []
        });

        let oData = this.getData()

        // 檢查從哪進入
        if (req.WPMF_LEGACY_PLUGIN) {
          if (!req.OPERATION) {
            oView.setBlocked(true)
            this.error(i18n.getText("clampOff.warning5"))
          }
          if (!req.RESOURCE) {
            oView.setBlocked(true)
            this.error(i18n.getText("clampOff.warning3"))
          }
          oData.resource = req.RESOURCE
          oData.operation = req.OPERATION

          // 通過後, 刷資源
          this.search()
        }

        // 取得說明
        $clampOff.getDesc({
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
      },
      // 開窗
      openDialog: function (oEvent) {
        let me = this;
        let oData = this.getData();
        let oSource = oEvent.getSource();
        let id = oSource.getId()

        // 資源開窗
        if (id.includes("resource")) {
          this.isEmpty(oData.operation, "g.operation")

          $clampOff.getResource(oData, (res) => {
            new TableSelectDialog().open(oSource, res, (data) => {
              oData.resource = data.resrce
              oData.resourceDesc = data.description
              me.refresh()
            });
          },
            me.showMessage
          )
        }
        // 作業開窗
        if (id.includes("operation")) {
          $clampOff.getOperation(oData, (res) => {
            new TableSelectDialog().open(oSource, res, (data) => {
              oData.operation = data.operation
              oData.operationDesc = data.description
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
        oData.toolStateList = []
        this.refresh()

        this.isEmpty([
          oData.operation,
          oData.resource
        ], [
          "g.operation",
          "g.resource"
        ])

        $clampOff.scanResource({
          site: oData.site,
          resource: oData.resource,
          operation: oData.operation
        },
          (res) => {
            // 始終添加數量 1
            res.toolStateList.forEach(element => {
              element.qty = 1
            })
            oData.toolStateList = res.toolStateList

            me.byId('resource').setEditable(false)
            me.byId('operation').setEditable(false)
            me.refresh()
          },
          me.showMessage
        )

        me.setTableRowCountAuto('table');
      },
      // 清除
      clear: function () {
        let me = this;
        let oData = this.getData();
        let excludes = []
        let oTable = this.byId("table")

        this.messageBox(
          {
            key: 'g.warning1',
            type: 'warning'
          },
          () => {
            oTable.clearSelection()
            me.clearData(oData, excludes)
            me.byId('resource').setEditable(true)
            me.byId('operation').setEditable(true)
            me.refresh();
          }
        )
      },
      // 檢查工具編號存在清單與否
      checkToolNumber: function () {
        let i18n = this.getI18N()
        let oData = this.getData()
        let oTable = this.byId("table")
        let selectedArray = oTable.getSelectedIndices()

        let index = oData.toolStateList.findIndex(element => {
          return element.toolNumber === oData.toolNumber
        })

        if (index == "-1") {
          this.error(i18n.getText("clampOff.warning4", oData.toolNumber))
        } else {    // 判斷 select 狀態
          if (selectedArray.includes(index)) {
            oTable.removeSelectionInterval(index, index)
          } else oTable.addSelectionInterval(index, index)

          oData.toolNumber = ""
          this.refresh()
        }
      },
      // 下機
      off: function () {
        let me = this
        let i18n = this.getI18N()
        let oData = this.getData()
        let oTable = this.byId("table")
        let selectedArray = oTable.getSelectedIndices()

        if (selectedArray.length == 0) {
          this.error(i18n.getText("clampOff.warning1"))
        } else {
          let selectedList = []

          selectedArray.forEach(element => {
            selectedList.push({
              sfc: oData.toolStateList[element].sfc,
              sn: oData.toolStateList[element].sn,
              toolNumber: oData.toolStateList[element].toolNumber,
            })
          })

          $clampOff.off(
            {
              site: oData.site,
              resource: oData.resource,
              operation: oData.operation,
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
                    key: 'clampOff.warning2',
                    type: 'success'
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
      }
    });
  }
);
