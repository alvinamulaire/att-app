sap.ui.define([
    'fw/core/BaseController',
    'sap/ui/model/json/JSONModel',
    'sap/m/MessageBox',
    'att/view/tlSn/tlSnApi'
], function (BaseController,
    JSONModel,
    MessageBox,
    api) {
    'use strict';
    return BaseController.extend('att.view.tlSn.tlSn', {
        onInit: function (oEvent) {
            this.getView().setModel(
                new JSONModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    activity: '',
                    sfc: '',
                    shopOrder: '',
                    item: '',
                    qty: '',
                    snType: '',
                    itemDes: '',
                    canCoding: false
                })
            );
            this.attachPatternMatched('tlSn', this.onRouteMatched);
        },
        back: function () {
            var me = this,
                oData = me.getData(),
                oRouter = me.getRouter();
            sap.ui.getCore().setModel(new JSONModel({
                'back': 'Y'
            }), 'turnBack');
            window.history.back();
        },
        onRouteMatched: function (oEvent) {
            var req = oEvent.getParameter('arguments')['?req'];
            var me = this;
            var oData = me.getData();
            oData.activity = req.ACTIVITY_ID;
            var back = false;
            if (req) {
                if ("Y" == req['back']) {
                    back = true;
                }
            }
            oData.back = back;
            var me = this;
            this.api = new tlSnApi(this.getWebApi());

            if (req.SFC) {
                oData.sfc = req.SFC
                this.retrieve()
            }

            me.refresh();
        },
        // 清除
        doClear: function () {
            var me = this;
            var oData = me.getData();
            this.clearData(oData, []);
            me.refresh();
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
        reprint: function () {
            var oData = this.getData();
            this.navTo('print', ['back', 'ACTIVITY_ID'], ['Y', oData.activity])
        },
        coding: function () {
            var me = this;
            var oData = this.getData();
            var oView = me.getView();
            var i18n = me.getI18N();

            me.api.tlCreateSn(oData, function (res) {
                MessageBox.success(i18n.getText('tlSn.success', res.join(',\n')));
                me.doClear();
            }, me.showMessage);
        },
        retrieve: function () {
            var me = this;
            var oData = this.getData();
            me.isEmpty([oData.sfc], ['tlSn.sfc']);

            me.api.tlSnInfo(oData, function (res) {
                oData.shopOrder = res.shopOrder;
                oData.item = res.item;
                oData.qty = res.sfcQty;
                oData.snType = res.snType;
                oData.itemDes = res.itemDesc;
                oData.canCoding = true;
                me.refresh();
            }, me.showMessage);
        }
    });
});