sap.ui.define(
  [
    "sap/ui/base/Object",
    "sap/ui/core/Fragment",
    "sap/ui/model/json/JSONModel",
    "att/view/productionDailyReport/productionDailyReportApi",
  ],
  function (Object, Fragment, JSONModel) {
    "use strict";

    return Object.extend("att.view.productionDailyReport.fragment.shopOrder", {
      //開啟畫面
      open: function (me) {
        this.me = me;
        let i18n = me.getI18N()
        let meData = me.getData()

        // fragment id, control/element id
        let dialog = Fragment.byId("shopOrder", "shopOrderDialog");

        // esc 關閉, dialog 並未清除, 開啟前先清除
        if (dialog) {
          dialog.destroy();
          dialog = null;
        }

        if (!dialog) {
          Fragment.load(
            {
              name: "att.view.productionDailyReport.fragment.shopOrder",
              type: "XML",
              controller: this,
              id: "shopOrder",
            }).then((oDialog) => {

              this.dialog = oDialog;
              // 開窗 model
              oDialog.setModel(
                new JSONModel({
                  plannedItem: "",      // 物料
                  plannedCompDateStartStr: "",
                  plannedCompDateEndStr: "",
                  shopOrder: "",       // 工單
                  status: "",          // 工單狀態
                  auart: "",           // 工單類型
                  statusOptions: [
                    { key: "", name: "" },
                    { key: 501, name: i18n.getText('shopOrder.status1') },
                    { key: 504, name: i18n.getText('shopOrder.status2') },
                    { key: 503, name: i18n.getText('shopOrder.status3') },
                    { key: 502, name: i18n.getText('shopOrder.status4') }
                  ],
                  auartOptions: meData.auartOptions,
                  table: [],
                }, "dialog")
              )
              // 開窗載入 i18n
              oDialog.setModel(me.getModel("i18n"), "i18n")
              oDialog.open()
            });
        }
        return this;
      },
      // 關閉畫面
      close: function (oEvent) {
        oEvent.getSource().getParent().destroy();
        this.dialog = "";
      },
      // 選擇
      select: function (oEvent) {
        let dialog = Fragment.byId("shopOrder", "shopOrderDialog");
        let oData = dialog.getModel().getData()
        let meData = this.me.getData()
        let me = this.me
        let shopOrderTable = Fragment.byId('shopOrder', 'shopOrderTable')
        let index = shopOrderTable.getSelectedIndices()[0]

        me.byId('shopOrder').setValue(oData.table[index].shopOrder)
        this.close(oEvent)
        me.refresh()
      },
      // 檢索
      search: function () {
        let me = this.me
        let i18n = me.getI18N()
        let dialog = Fragment.byId("shopOrder", "shopOrderDialog");
        let oData = dialog.getModel().getData()
        let meData = me.getData()
        let oModel = dialog.getModel()

        // 檢索條件至少一筆
        if (
          !oData.shopOrder && !oData.plannedItem &&
          !oData.status && !oData.auart &&
          !oData.plannedCompDateStartStr && !oData.plannedCompDateEndStr
        ) {
          me.error(i18n.getText('g.warning2'))
        }

        // 使用時間來檢索
        if (oData.plannedCompDateStartStr || oData.plannedCompDateEndStr) {
          if (!oData.plannedCompDateStartStr) me.error(i18n.getText('productionDailyReport.warning2'))
          if (!oData.plannedCompDateEndStr) me.error(i18n.getText('productionDailyReport.warning3'))
          // 日期結束不可大於開始
          if (moment(oData.plannedCompDateStartStr).isAfter(oData.plannedCompDateEndStr, 'second')) me.error(i18n.getText('productionDailyReport.warning1'))
        }

        $productionDailyReport.getShopOrder(
          {
            "site": meData.site,
            "plannedCompDateStartStr": oData.plannedCompDateStartStr ? oData.plannedCompDateStartStr + ':00' : "",
            "plannedCompDateEndStr": oData.plannedCompDateEndStr ? oData.plannedCompDateEndStr + ':00' : "",
            "shopOrder": oData.shopOrder,
            "auart": oData.auart,
            "plannedItem": oData.plannedItem,
            "status": oData.status
          },
          (res) => {
            oData.table = res

            oModel.refresh()
          },
          me.showMessage
        )

      },
      // 清除
      clear: function () {
        let dialog = Fragment.byId("shopOrder", "shopOrderDialog");
        let oData = dialog.getModel().getData()
        let oModel = dialog.getModel()

        oData.shopOrder = ''
        oData.item = ''
        oData.shopOrderType = ''
        oData.shopOrderStatus = ''
        oData.plannedCompDateStartStr = ''
        oData.plannedCompDateEndStr = ''
        oData.table = []

        oModel.refresh()
      }
    });
  }
);
