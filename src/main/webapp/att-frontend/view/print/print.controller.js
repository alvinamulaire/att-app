sap.ui.define([
    'fw/core/BaseController',
    'sap/ui/model/json/JSONModel',
    'sap/m/MessageBox',
    'att/view/print/printApi',
    'fw/fragment/TableSelectDialog',
    'att/view/print/fragment/container'
], function (BaseController,
    JSONModel,
    MessageBox,
    api,
    TableSelectDialog,
    container) {
    'use strict';
    return BaseController.extend('att.view.print.print', {
        onInit: function (oEvent) {
            this.attachPatternMatched('print', this.onRouteMatched);
        },
        // 類型變更
        labelChange: function (oEvent) {
            var me = this;
            var oData = me.getData();
            this.clearData(oData, ['back', 'labelType', 'printerList', 'labelTypeList']);
            me.refresh();
        },
        // 清除
        doClear: function (oEvent) {
            var me = this;
            var oData = me.getData();
            this.clearData(oData, ['back', 'printerList', 'labelTypeList']);
            oData.labelType = '1';
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
        print: function () {
            var me = this;
            var oData = this.getData();
            var oView = me.getView();
            var i18n = me.getI18N();

            me.isEmpty([oData.printer], ['print.printer']);

            var oTable = me.byId('table');
            var indices = oTable.getSelectedIndices();

            if (indices.length == 0) {
                me.error('print.error2');
            }

            var data = indices.map((index) => {
                var obj = oData.table[index];
                obj.site = oData.site;
                obj.user = oData.user;
                obj.printer = oData.printer;
                obj.labelType = oData.labelType;
                obj.activity = oData.activity;
                return obj;
            });

            me.api.print(data, function (res) {
                MessageBox.success(i18n.getText('print.success'));
            }, me.showMessage);
        },
        retrieve: function () {
            var me = this;
            var oData = this.getData();

            switch (oData.labelType) {
                case null:
                case '':
                    break;
                case '0':
                    //焊接碼
                    if (oData.tlSn || oData.sfc || oData.shopOrder) {
                        break;
                    }
                case '1':
                    //箱號
                    if (oData.carton || oData.pallet || oData.sfc || oData.shopOrder) {
                        break;
                    }
                case '2':
                    //棧板
                    if (oData.pallet || oData.sfc || oData.shopOrder) {
                        break;
                    }
                default:
                    me.error('print.error1');
                    break;
            }

            me.api.printInfo(oData, function (res) {
                oData.table = me.setSeq(res, 'seq');
                me.refresh();
                if (res.length == 0) {
                    me.error('print.error3');
                }

            }, me.showMessage);
        },
        printerDialog: function (oEvent) {
            var me = this;
            var oData = this.getData();
            var oSource = oEvent.getSource();

            new TableSelectDialog().open(oSource, oData.printerList, function (data) { });

        },
        shopOrderDialog: function (oEvent) {
            var me = this;
            var oData = this.getData();
            var oSource = oEvent.getSource();

            me.api.findSoReleaseDesc(oData.site, function (res) {
                new TableSelectDialog().open(oSource, res, function (data) { });
            }, me.showMessage);

        },
        cartonDialog: function (oEvent) {
            var me = this;
            var oData = this.getData();
            var oSource = oEvent.getSource();

            new container().showDialog(this, "C");
        },
        palletDialog: function (oEvent) {
            var me = this;
            var oData = this.getData();
            var oSource = oEvent.getSource();

            new container().showDialog(this, "P")
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
            var back = false;
            if (req) {
                if ("Y" == req['back']) {
                    back = true;
                }
            }
            this.getView().setModel(
                new JSONModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    activity: req.ACTIVITY_ID,
                    back: back,
                    tlSn: '',
                    sfc: '',
                    shopOrder: '',
                    labelType: '1',
                    printer: '',
                    printerList: [],
                    labelTypeList: []
                })
            );
            var me = this;
            var oData = this.getData();
            var i18n = me.getI18N();
            this.api = new printApi(this.getWebApi());

            //標籤類型
            oData.labelTypeList.push({
                key: '1',
                text: i18n.getText('print.carton')
            }, {
                key: '2',
                text: i18n.getText('print.pallet')
            }, {
                key: '0',
                text: i18n.getText('print.tlSn')
            });


            me.api.activityOption(oData.activity, (res) => {
                for (const act of res) {
                    switch (act.execUnitOption) {
                        case 'PRINTER_NAME':
                            //標籤機
                            var printerList = act.setting.split('|');
                            printerList.forEach(x => {
                                oData.printerList.push({
                                    printer: x
                                })
                            });
                            break;
                    }
                }
            }, this.showMessage);

            me.refresh();
        }
    });
});