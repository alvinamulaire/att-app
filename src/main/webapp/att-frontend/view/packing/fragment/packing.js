sap.ui.define(
  [
    "sap/ui/base/Object",
    "sap/ui/core/Fragment",
    "sap/ui/model/json/JSONModel",
    "att/view/packing/packingApi",
  ],
  function (Object, Fragment, JSONModel) {
    "use strict";

    return Object.extend("att.view.packing.fragment.packing", {
      //開啟畫面
      open: function (me) {
        this.me = me;

        // fragment id, control/element id
        let dialog = Fragment.byId("packing", "packingDialog");

        if (!dialog) {

          Fragment.load({
            name: "att.view.packing.fragment.packing",
            type: "XML",
            controller: this,
            id: "packing",

          }).then((oDialog) => {

            this.dialog = oDialog;
            // 開窗 model
            oDialog.setModel(
              new JSONModel({
                weight: ""
              }, dialog)
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
        let me = this.me
        let meData = me.getData()
        let dialog = Fragment.byId("packing", "packingDialog");
        let oData = dialog.getModel().getData()

        $packing.openContainerNo(
          {
            site: meData.site,
            user: meData.user,
            containerType: meData.containerType,
            containerNo: meData.containerNo,
            status: meData.containerStatus,      // 開啟箱號(棧板)時才給
            weight: oData.weight,
            shippingDate: ""    // 出貨日期，彈出出貨日期畫面時才給
          },
          () => {
            meData.containerWeight = oData.weight
            oEvent.getSource().getParent().destroy();
            this.dialog = "";
            me.refresh()
          },
          me.showMessage
        )
      },
      // 檢查輸入值
      check: function (oEvent) {
        let oSource = oEvent.getSource();
        let customDatas = oSource.getCustomData();
        let number = oSource.getValue();
        let max, negative, decimal, decimalMax, symbol;
        if (customDatas) {
          customDatas.forEach(function (cData, index) {
            switch (cData.getKey().toUpperCase()) {
              case 'max'.toUpperCase():
                if (cData.getValue()) max = parseInt(cData.getValue());
                break;
              case 'negative'.toUpperCase():
                negative = cData.getValue() == 'true' ? true : false;
                break;
              case 'decimal'.toUpperCase():
                decimal = cData.getValue() == 'true' ? true : false;
                break;
              case 'decimalMax'.toUpperCase():
                if (cData.getValue()) decimalMax = parseInt(cData.getValue());
                break;
              case 'symbol'.toUpperCase():
                symbol = cData.getValue() == 'true' ? true : false;
                break;
            }
          });
        }

        number = number.replace(/^[0.]/g, "") // 開頭不能為 0 和 .
        number = number.replace(/[A-Za-z]/g, ''); // 不能英文
        number = number.replace(/[^\x00-\x80]/g, ''); // 不能中文
        number = number.replace(/[^\d\.]/g, ''); // 不能 . 以外符號        

        if (max > 0) number = number.substring(0, max);

        if (negative) number = number.replace(/-/g, '');

        if (decimal) number = number.replace(/\./g, '');

        if (symbol) {
          number = number.replace(/[/\\?\\*\\,]/g, '');
        }

        if (number.match(/\./g)) {
          var arr = number.split('.');
          number = arr[0] + '.' + arr[1].substring(0, decimalMax);
        }

        oSource.setValue(number);
      }
    });
  }
);
