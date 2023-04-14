sap.ui.define(
  ['fw/core/BaseController', 'att/view/clampComplete/clampCompleteApi'],
  function (BaseController) {
    'use strict';

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend('att.view.clampComplete.clampComplete', {
      onInit: function () {
        this.attachPatternMatched('clampComplete', this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        let me = this;
        let i18n = this.getI18N();
        let oView = this.getView();
        let req = oEvent.getParameter('arguments')['?req'];
        let oTable = this.byId('table');

        // 檢查 作業
        if (!req.OPERATION) {
          oView.setBlocked(true);
          this.error(i18n.getText('clampComplete.warning1'));
        }
        // 檢查 資源
        if (!req.RESOURCE) {
          oView.setBlocked(true);
          this.error(i18n.getText('clampComplete.warning2'));
        }
        // 檢查 SFC
        if (!req.SFC) {
          oView.setBlocked(true);
          this.error(i18n.getText('clampComplete.warning3'));
        }

        this.setModel({
          site: this.getSite(),
          operation: req.OPERATION,
          operationDesc: "",
          resource: req.RESOURCE,
          resourceDesc: "",
          activity: req.ACTIVITY_ID,
          sfc: req.SFC,
          snQty: "",
          qtyInQueue: "",
          chooseRule: false,    // choose 規則
          toolNumber: "",
          toolStateList: []
        });

        let oData = this.getData();

        // 取得 資源, 作業說明
        $clampComplete.getDesc({
          site: oData.site,
          operation: oData.operation,
          resource: oData.resource
        },
          (res) => {
            oData.resourceDesc = res.resourceDesc;
            oData.operationDesc = res.operationDesc;
            me.refresh();
          },
          me.showMessage
        );
        // 取得 SFC, 佇業數量
        this.scanSFC();

        // 取得活動規則
        new activity(this.getWebApi()).activityOption(oData.activity,
          (res) => {
            res.forEach(element => {
              if (element.execUnitOption === "CHOOSE" && element.setting === "Y") {
                oData.chooseRule = true
                oTable.selectAll()

                me.refresh();
              }
            });
          },
          this.showMessage
        );

        this.byId('table').addEventDelegate({
          onAfterRendering: function () {
            me.setTableRowCountAuto('table');
          }
        })
      },
      // 檢查工具編號
      scanToolNumber: function () {
        let i18n = this.getI18N();
        let oData = this.getData();
        let oTable = this.byId('table');
        let selectedArray = oTable.getSelectedIndices();

        let index = oData.toolStateList.findIndex((element) => {
          return element.toolNumber === oData.toolNumber;
        });

        if (index == '-1') {
          this.error(i18n.getText('clampComplete.warning7'));
        } else {
          // 判斷 select 狀態
          if (selectedArray.includes(index)) {
            oTable.removeSelectionInterval(index, index);
          } else oTable.addSelectionInterval(index, index);

          oData.toolNumber = '';
          this.refresh();
        }
      },
      // 檢索 SFC 取得清單
      scanSFC: function () {
        let me = this;
        let oData = this.getData();
        let I18N = this.getI18N();

        $clampComplete.scanSFC(
          {
            site: oData.site,
            sfc: oData.sfc,
            operation: oData.operation,
            type: 'complete'
          },
          (res) => {
            oData.toolStateList = res.toolStateList;
            oData.qtyInWork = res.qtyInWork;
            oData.snQty = res.snQty;

            me.byId('sfc').setEditable(false);
            me.refresh();
            if (oData.toolStateList.length == 0) {
              me.error(I18N.getText('clampComplete.warning8', [oData.sfc]));
            }
          },
          me.showMessage
        );
      },
      // 完成
      complete: function () {
        let me = this;
        let i18n = this.getI18N();
        let oData = this.getData();
        let oTable = this.byId('table');
        let selectedArray = oTable.getSelectedIndices();

        if (selectedArray.length == 0) {
          this.error(i18n.getText('clampComplete.warning4'));
        }

        let selectedList = [];

        selectedArray.forEach((element) => {
          selectedList.push({
            sn: oData.toolStateList[element].sn,
            toolNumber: oData.toolStateList[element].toolNumber
          });
        });

        $clampComplete.complete(
          {
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
                  key: 'clampComplete.warning5',
                  type: 'success'
                },
                // action
                () => { },
                // cancel
                () => {
                  // 清空再重新檢索
                  oTable.clearSelection();

                  if (selectedArray.length === oData.toolStateList.length) {
                    oData.snQty = 0;
                    oData.qtyInWork = oData.qtyInWork - selectedArray.length;
                    oData.toolStateList = [];
                    me.refresh()
                  } else {
                    me.scanSFC();
                  }
                }
              );
            }
          },
          me.showMessage
        );

      }
    });
  }
);
