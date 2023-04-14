sap.ui.define(
  [
    "fw/core/BaseController",
    "att/view/sn/snApi",
  ],
  function (BaseController) {
    "use strict";

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.sn.sn", {
      onInit: function () {
        this.attachPatternMatched("sn", this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        let i18n = this.getI18N()
        let req = oEvent.getParameter('arguments')['?req']
        let me = this
        let oView = this.getView();
        // 檢查是否選擇 sfc
        if (req.SFC) {
          $sn.getSN({
            site: me.getSite(),
            sfc: req.SFC
          },
            function (data) {
              me.setModel({
                site: req.SITE,
                user: me.getUser(),
                sfc: data.sfc,
                sfcQty: data.sfcQty,
                item: data.item,
                itemDesc: data.itemDesc,
                select: true
              });
            },
            me.showMessage
          )
          oView.byId("sn").focus();
        } else {
          me.setModel({
            site: req.SITE,
            user: me.getUser(),
            sfc: '',
            sfcQty: '',
            item: '',
            itemDesc: '',
            select: false
          });
          oView.byId("sfc").focus();
        }
      },
      // 檢查 sn 欄位
      checkSN: function (oEvent) {
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
        string = string.replace(/[^\w\-]/g, ""); // 不能 - 以外符號

        if (symbol) {
          string = string.replace(/[/\\?\\*\\,]/g, "");
        }

        oSource.setValue(string);
      },
      retrieve: function () {
        var me = this;
        var oData = this.getData();
        let oView = this.getView();
        me.isEmpty([oData.sfc], ['sn.label1']);

        $sn.getSN({
          site: me.getSite(),
          sfc: oData.sfc
        },
          function (data) {
            oData.sfcQty = data.sfcQty
            oData.item = data.item
            oData.itemDesc = data.itemDesc
            oData.select = true
            oView.byId("sn").focus();
            me.refresh()
          },
          me.showMessage
        )
      },
      // sn submit
      snSubmit: function (oEvent) {
        var me = this;
        var oData = me.getData();
        let oView = this.getView();
        oView.byId("newSn").focus();
      },
      // 清除
      clear: function (oEvent) {
        var me = this;
        var oData = me.getData();
        me.confirmMessage(
          me.getI18N().getText('g.clear.check'),
          function () {
            me.doClear();
          },
          null
        );
      },
      // 清除
      doClear: function () {
        var me = this;
        var oData = me.getData();
        this.clearData(oData, []);
        me.refresh();
      },
      // 儲存
      save: function () {
        let oData = this.getData()
        let i18n = this.getI18N()
        let me = this
        let oView = this.getView();
        if (!oData.sn) {
          // 檢查是否填寫 原始SN
          this.error(i18n.getText("sn.warning5"))
        } else if (!oData.newSn) {
          // 檢查是否填寫 更換SN
          this.error(i18n.getText("sn.warning7"))
        } else if(oData.sn.substring(0,3)=="UPP" && oData.newSn.substring(0,4) !="5703") {
          this.error(i18n.getText("sn.warning8"))
        } else if(oData.sn.substring(0,3)!="UPP" && oData.newSn.substring(0,4) =="5703") {
          this.error(i18n.getText("sn.warning8"))
        } else if(oData.sn.substring(0,3)!="LOW" && oData.newSn.substring(0,4) =="5704") {
          this.error(i18n.getText("sn.warning9"))
        } else if(oData.sn.substring(0,3)=="LOW" && oData.newSn.substring(0,4) !="5704") {
          this.error(i18n.getText("sn.warning9"))
        } else{
                $sn.saveSN({
                    site: oData.site,
                    sfc: oData.sfc,
                    sn: oData.sn,
                    user: oData.user,
                    newSn: oData.newSn,
                    snType: '0'
                  },
                    function () {
                      oData.sn = ""
                      oData.newSn = ""
                      oView.byId("sn").focus();
                      me.refresh()
                      me.messageBox({
                        key: "sn.warning6",
                        type: "SUCCESS"
                      })
                    },
                    me.showMessage)
        }
      }
    });
  }
);
