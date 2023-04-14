sap.ui.define(
  [
    "sap/ui/base/Object",
    "sap/ui/core/Fragment",
    "sap/ui/model/json/JSONModel",
    "att/view/sfcRelease/sfcReleaseApi",
  ],
  function (Object, Fragment, JSONModel) {
    "use strict";

    return Object.extend("att.view.sfcRelease.fragment.releasedLists", {
      //開啟畫面
      open: function (me) {
        this.me = me;
        let i18n = me.getI18N()
        let meData = me.getData()

        // fragment id, control/element id
        let dialog = Fragment.byId("releasedLists", "releasedListsDialog");

        if (!dialog) {

          Fragment.load({
            name: "att.view.sfcRelease.fragment.releasedLists",
            type: "XML",
            controller: this,
            id: "releasedLists",

          }).then((oDialog) => {

            this.dialog = oDialog;
            // 開窗 model
            oDialog.setModel(
              new JSONModel({
                releasedSFC: meData.releasedSFCLists,
                shopOrder: i18n.getText("att.sfcRelease.label2", meData.shopOrder)
              })
            )

            // 開窗載入 i18n
            oDialog.setModel(me.getModel("i18n"), "i18n")
            oDialog.open()
          });
        }
        return this;
      },
      // 關閉開窗
      close: function (oEvent) {
        oEvent.getSource().getParent().destroy();
        this.dialog = "";
      },
    });
  }
);
