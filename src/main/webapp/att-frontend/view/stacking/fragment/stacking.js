sap.ui.define(
  [
    "sap/ui/base/Object",
    "sap/ui/core/Fragment",
    "sap/ui/model/json/JSONModel",
    "att/view/stacking/stackingApi",
  ],
  function (Object, Fragment, JSONModel) {
    "use strict";

    return Object.extend("att.view.stacking.fragment.stacking", {
      //開啟畫面
      open: function (me) {
        this.me = me;

        // fragment id, control/element id
        let dialog = Fragment.byId("stacking", "stackingDialog");

        if (!dialog) {

          Fragment.load({
            name: "att.view.stacking.fragment.stacking",
            type: "XML",
            controller: this,
            id: "stacking",

          }).then((oDialog) => {

            this.dialog = oDialog;
            // 開窗 model
            oDialog.setModel(
              new JSONModel({
                shippingDate: ""
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
      // 確認
      confirm: function (oEvent) {
        let dialog = Fragment.byId("stacking", "stackingDialog");
        let oData = dialog.getModel().getData()
        let meData = this.me.getData()
        let me = this.me

        $stacking.openStackNo({
          site: meData.site,
          user: meData.user,
          containerType: meData.containerType,
          containerNo: meData.stackNo,        // 棧板號
          status: meData.stackStatus,      // 開啟箱號(棧板)時才給
          weight: "",
          shippingDate: oData.shippingDate    // 出貨日期，彈出出貨日期畫面時才給
        },
          () => {
            meData.shippingDate = oData.shippingDate
            oEvent.getSource().getParent().destroy();
            this.dialog = "";
            me.refresh()
          },
          me.showMessage
        )
      },
    });
  }
);
