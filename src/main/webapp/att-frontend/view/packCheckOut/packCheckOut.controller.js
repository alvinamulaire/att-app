sap.ui.define([
    'fw/core/BaseController',
    'sap/ui/model/json/JSONModel',
    'sap/m/MessageBox',
    'att/view/packCheckOut/packCheckOutApi',
    'fw/custom/excelConfig'
], function (BaseController,
    JSONModel,
    MessageBox,
    api,
    excelConfig) {
    'use strict';
    return BaseController.extend('att.view.packCheckOut.packCheckOut', {
        onInit: function (oEvent) {
            this.attachPatternMatched('packCheckOut', this.onRouteMatched);
        },
        //匯出 inv excel
        exportInv: function (data) {
            var me = this;
            var I18N = this.getI18N();
            var fileName = 'INV-' + moment().format('YYYYMMDDHHmmsssss');
            var config = new excelConfig();
            //工作表名稱
            config
                .init('sheet1', [{ xSplit: 1, ySplit: 1 }])
                //設定每一格寬度
                .setWidth(20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20)
                //設定表格A開始、不設定表名、表id:table、顯示總和列、表頭、資料設定、自訂加總欄位
                .setTable(
                    'A',
                    null,
                    'table',
                    false,
                    [
                        //入庫單號
                        { name: I18N.getText('sfcDone.sfcDoneId') },
                        //物料編號
                        { name: I18N.getText('sfcDone.item') },
                        //物料說明
                        { name: I18N.getText('sfcDone.itemDesc') },
                        //現場訂單
                        { name: I18N.getText('sfcDone.shoporder') },
                        //SFC
                        { name: I18N.getText('sfcDone.sfc') },
                        //入庫數量
                        { name: I18N.getText('sfcDone.invQty') },
                        //BATCHNUMBER
                        { name: I18N.getText('sfcDone.batchNumber') },
                        //生產等級
                        { name: I18N.getText('sfcDone.productRank') }
                    ],
                    data.map((x) => [
                        fileName,
                        x.item,
                        x.itemDesc,
                        x.shopOrder,
                        x.sfc,
                        x.qtyInWork,
                        x.batchNumber,
                        x.productRank
                    ])
                )
                //設定匯出檔案名稱
                .exportExcle(fileName);
        },
        //匯出excel
        export: function (data) {
            var me = this;
            var I18N = this.getI18N();
            var config = new excelConfig();
            //工作表名稱
            config
                .init('sheet1', [{ xSplit: 1, ySplit: 1 }])
                //設定每一格寬度
                .setWidth(20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20)
                //設定表格A開始、不設定表名、表id:table、顯示總和列、表頭、資料設定、自訂加總欄位
                .setTable(
                    'A',
                    null,
                    'table',
                    false,
                    [
                        //物料編號
                        { name: I18N.getText('packCheckOut.excel.item') },
                        //物料說明
                        { name: I18N.getText('packCheckOut.excel.itemDes') },
                        //現場訂單
                        { name: I18N.getText('packCheckOut.excel.shoporder') },
                        //SFC
                        { name: I18N.getText('packCheckOut.excel.sfc') },
                        //數量
                        { name: I18N.getText('packCheckOut.excel.qty') },
                        //棧板編號
                        { name: I18N.getText('packCheckOut.excel.pallet') },
                        //箱號
                        { name: I18N.getText('packCheckOut.excel.carton') },
                        //製造日期
                        { name: I18N.getText('packCheckOut.excel.mdfDate') },
                        //保存期限
                        { name: I18N.getText('packCheckOut.excel.expDate') }
                    ],
                    data.map((x) => [
                        x.item,
                        x.itemDesc,
                        x.shopOrder,
                        x.sfc,
                        x.qty,
                        x.pallet,
                        x.carton,
                        x.mfgDate,
                        x.expDate
                    ])
                )
                //設定匯出檔案名稱
                .exportExcle('PACK-' + moment().format('YYYYMMDDHHmmsssss'));
        },
        checkOut: function () {
            var me = this;
            var oData = this.getData();
            var oView = me.getView();
            var i18n = me.getI18N();
            var oTable = me.byId('table');
            if (oData.table.length == 0) {
                if (oData.type == 'C') {
                    me.error('packCheckOut.error1');
                } else {
                    me.error('packCheckOut.error2');
                }
            }

            oData.table.forEach(x => {
                x.type = oData.type;
                x.site = oData.site;
                x.user = oData.user;
                x.operation = oData.operation;
                x.activity = oData.activity;
                return x;
            })

            me.api.checkOut(oData.table, function (res) {
                me.export(res.packCheckOutResponseList);
                new activity(me.getWebApi()).activityOption(oData.activity,
                    function (optionList) {
                        optionList.forEach(option => {
                            if (option.execUnitOption === "EXPORT_INV_EXCEL" && option.setting === 'Y') {
                                me.exportInv(res.zVwSfcDoneList);
                                me.refresh();
                            }
                        });
                    },
                    me.showMessage);
                me.doClear();
                MessageBox.success(i18n.getText('packCheckOut.success'));
            }, me.showMessage);
        },
        noSubmit: function () {
            var me = this;
            var oData = this.getData();

            if (oData.type == 'C') {
                //箱號
                me.isEmpty([oData.carton], ['packCheckOut.carton.no']);

                oData.table.forEach(x => {
                    if (x.carton == oData.carton) {
                        me.error('packCheckOut.error3');
                    }
                })

                me.api.check(oData, function (res) {
                    oData.table.push({ "carton": oData.carton });
                    oData.carton = '';
                    me.refresh();
                }, me.showMessage);
            } else {
                //棧板編號
                me.isEmpty([oData.pallet], ['packCheckOut.pallet.no']);

                oData.table.forEach(x => {
                    if (x.pallet == oData.pallet) {
                        me.error('packCheckOut.error4');
                    }
                })

                me.api.check(oData, function (res) {
                    oData.table.push({ "pallet": oData.pallet });
                    oData.pallet = '';
                    me.refresh();
                }, me.showMessage);
            }


        },
        tableSelectRemove: function () {
            var me = this;
            var oData = this.getData();

            var oTable = me.byId('table');
            var indexs = oTable.getSelectedIndices();

            if (indexs.length == 0) {
                me.error('packCheckOut.error6');
            }

            indexs = indexs.reverse();

            indexs.forEach(x => {
                oData.table.splice(x, 1);
            });

            oTable.clearSelection();

            me.refresh();
        },
        // 清除
        doClear: function () {
            var me = this;
            var oData = me.getData();
            this.clearData(oData, ['operation', 'type', 'title']);
            var oTable = me.byId('table');
            oTable.clearSelection();
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
        onRouteMatched: function (oEvent) {
            var req = oEvent.getParameter('arguments')['?req'];
            var me = this;
            var i18n = me.getI18N();
            this.getView().setModel(
                new JSONModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    activity: req.ACTIVITY_ID,
                    operation: req.OPERATION,
                    type: 'P',
                    pallet: '',
                    carton: '',
                    title: i18n.getText('packCheckOut.title.2'),
                    table: []
                })
            );
            var oData = this.getData();
            this.api = new packCheckOutApi(this.getWebApi());
            var oView = me.getView();
            if (!oData.operation) {
                oView.setBlocked(true);
                me.error('packCheckOut.error5');
            }

            me.api.activityOption(oData.activity, (res) => {
                for (const act of res) {
                    switch (act.execUnitOption) {
                        case 'PACK_COMPLETE':
                            //是否為箱號出站
                            if (act.setting == 'Y') {

                                oData.type = 'C'
                            } else {

                                oData.type = 'P'
                            }
                            break;
                    }
                }
            }, this.showMessage);

            switch (oData.type) {
                case 'C':
                    //箱
                    oData.title = i18n.getText('packCheckOut.title.1');
                    break;
                case 'P':
                    //棧板
                    oData.title = i18n.getText('packCheckOut.title.2');
                    break;
            }

            me.refresh();
        }
    });
});