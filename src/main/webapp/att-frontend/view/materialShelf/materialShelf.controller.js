sap.ui.define(
  [
    "fw/core/BaseController",
    "att/view/materialShelf/materialShelfApi",
  ],
  function (BaseController) {
    "use strict";

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.materialShelf.materialShelf", {
      onInit: function () {
        this.attachPatternMatched("materialShelf", this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        let i18n = this.getI18N()
        let req = oEvent.getParameter('arguments')['?req']

        // 未選擇 作業站
        if (!req.OPERATION) {
          this.error(i18n.getText("att.materialShelf.warning9"))
          // 未選擇 資源
        } else if (!req.RESOURCE) {
          this.error(i18n.getText("att.materialShelf.warning10"))
          // 未選擇 SFC
        } else if (!req.SFC) {
          this.error(i18n.getText("att.materialShelf.warning11"))
        } else {
          this.setModel({
            site: req.SITE,
            user: this.getUser(),
            sfc: req.SFC,
            operation: req.OPERATION,
            operationDesc: "",
            resource: req.RESOURCE,
            resourceDesc: "",
            sfcQty: "",   // 作業中數量
            rackQty: "",  // 料架數量
            shelfList: [],
            qty: "",
            rackNum: ""
          });
        }

        // 取得料架資料
        this.searchRack()
      },
      // 檢查數量欄位
      checkQty: function (oEvent) {
        var oSource = oEvent.getSource();
        var customDatas = oSource.getCustomData();
        var number = oSource.getValue();
        var max, negative, decimal, decimalMax, symbol;
        if (customDatas) {
          customDatas.forEach(function (cData, index) {
            switch (cData.getKey().toUpperCase()) {
              case "max".toUpperCase():
                if (cData.getValue()) max = parseInt(cData.getValue());
                break;
              case "negative".toUpperCase():
                negative = cData.getValue() == "true" ? true : false;
                break;
              case "decimal".toUpperCase():
                decimal = cData.getValue() == "true" ? true : false;
                break;
              case "decimalMax".toUpperCase():
                if (cData.getValue()) decimalMax = parseInt(cData.getValue());
                break;
              case "symbol".toUpperCase():
                symbol = cData.getValue() == "true" ? true : false;
                break;
            }
          });
        }
        number = number.replace(/^[0]/g, "") // 開頭不能為 0
        number = number.replace(/[A-Za-z]/g, ""); // 不能英文
        number = number.replace(/[^\x00-\x80]/g, ""); // 不能中文
        number = number.replace(/[^\d\\?\\*\\,\\/.-]/g, ""); // 不能? * , . - /以外符號

        if (max > 0) number = number.substring(0, max);

        if (negative) number = number.replace(/-/g, "");

        if (decimal) number = number.replace(/\./g, "");

        if (symbol) {
          number = number.replace(/[/\\?\\*\\,]/g, "");
        }

        if (number.match(/\./g)) {
          var arr = number.split(".");
          number = arr[0] + "." + arr[1].substring(0, decimalMax);
        }

        oSource.setValue(number);
      },
      // 檢查料架編號欄位
      checkRackNum: function (oEvent) {
        let oSource = oEvent.getSource();
        let customDatas = oSource.getCustomData();
        let symbol;
        if (customDatas) {
          customDatas.forEach(function (cData, index) {
            switch (cData.getKey().toUpperCase()) {
              case "symbol".toUpperCase():
                symbol = cData.getValue() == "true" ? true : false;
                break;
            }
          });
        }

        let string = oSource.getValue();
        string = string.replace(/[^\w\-]/g, "");   // 不能  - 以外符號

        if (symbol) {
          string = string.replace(/[/\\?\\*\\,]/g, "");
        }
        oSource.setValue(string);
      },
      // + 按鈕
      add: function () {
        let oData = this.getData()
        let i18n = this.getI18N()
        let me = this
        let regex = /^[-0-9a-zA-Z]+$/
        let newVal = this.byId("rackNum").getValue()

        if (!oData.qty) {
          // 數量未填寫
          this.byId("qty").focus()
          this.error(i18n.getText("att.materialShelf.warning2"))
        } else if (newVal && !newVal.match(regex)) {
          // 料架填寫規則　(英數字-)
          this.error(i18n.getText("att.materialShelf.warning8"))
        } else if (oData.sfcQty - oData.rackQty < 1) {
          // 可上架數量是否為 0
          this.error(i18n.getText("att.materialShelf.warning3"))
        } else if (oData.sfcQty - oData.rackQty - oData.qty < 0) {
          // 數量欄位是否符合可上架數量
          this.byId("qty").focus()
          this.error(i18n.getText("att.materialShelf.warning4"))
        } else if (!oData.rackNum) {
          // 料架編號是否有值
          this.error(i18n.getText("att.materialShelf.warning5"))
        } else if (oData.shelfList.some(item => { item.shelfNo == oData.rackNum })) {
          // 料架編號是否存在
          this.error(i18n.getText("att.materialShelf.warning6", [oData.rackNum, oData.sfc]))
        } else {
          $materialShelf.RackOn({
            site: oData.site,
            sfc: oData.sfc,
            operation: oData.operation,
            resource: oData.resource,
            rack: oData.rackNum,
            rackQty: oData.qty
          },
            function () {
              oData.rackNum = ""
              oData.qty = ""

              // 再次檢索, 取得料架數量
              me.searchRack()
              me.refresh()
              me.byId("qty").focus()
            },
            me.showMessage)
        }
      },
      // - 按鈕
      minus: function () {
        let oData = this.getData()
        let i18n = this.getI18N()
        let me = this
        let oTable = this.byId("table")
        let selectArray = oTable.getSelectedIndices()
        let rackOffArray = []

        if (selectArray.length == 0) {
          this.error(i18n.getText("att.materialShelf.warning7"))
        } else {
          selectArray.forEach(item => {
            rackOffArray.push({
              site: oData.shelfList[item].site,
              sfc: oData.shelfList[item].sfc,
              rack: oData.shelfList[item].shelfNo,
              user: oData.user
            })
          });

          $materialShelf.RackOff(
            rackOffArray,
            function () {
              me.searchRack()
              me.byId("table").clearSelection();
              me.refresh()
            },
            me.showMessage
          )
        }
      },
      // focus 到 rackNum
      switchFocus: function () {
        this.byId("rackNum").focus()
      },
      // 取得料架資料
      searchRack: function () {
        let me = this
        let oData = this.getData()

        $materialShelf.searchRack({
          site: oData.site,
          sfc: oData.sfc,
          operation: oData.operation,
          resource: oData.resource
        },
          function (data) {
            oData.operationDesc = data.operationDesc
            oData.resourceDesc = data.resourceDesc
            oData.sfcQty = data.sfcQty
            oData.rackQty = data.rackQty

            for (let i = 0; i < data.shelfList.length; i++) {
              data.shelfList[i].index = i + 1
            }
            oData.shelfList = data.shelfList

            me.refresh()
          },
          me.showMessage
        )
      }
    });
  }
);
