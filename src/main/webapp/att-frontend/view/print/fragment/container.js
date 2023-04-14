sap.ui.define(['sap/ui/core/Fragment',
    'sap/ui/base/Object',
    'fw/fragment/TableSelectDialog']
    , function (Fragment, Object, TableSelectDialog) {
        'use strict';
        return Object.extend('att.view.print.fragment.container', {
            /**
             * 
             */
            showDialog: function (me, type) {
                this.me = me;
                var oData = me.getData();
                oData.type = type;
                var oView = me.getView();
                var i18n = me.getI18N();
                var dialog = Fragment.byId('containerDialog', 'containerDialog');
                if (dialog) {
                    //未關閉時銷毀
                    dialog.destroy();
                    dialog = null;
                }

                if (!this.dialog) {
                    this.dialog = sap.ui.xmlfragment(
                        'containerDialog',
                        'att.view.print.fragment.container',
                        this
                    );
                }
                me.oView.addDependent(this.dialog);
                this.dialog.setModel(me.getModel('i18n'), 'i18n');
                this.setTitle(i18n.getText('print.success'))
                this.dialog.open();

                oData.containerName = '';
                oData.containerTable = [];
                oData.closeStartDate = moment().day(moment().day() - 7).startOf('day').format('YYYY-MM-DD HH:mm:ss');
                oData.closeEndDate = moment().day(moment().day()).endOf('day').format('YYYY-MM-DD HH:mm:ss');

                me.refresh();
                return this;
            },
            search: function (oEvent) {
                var me = this.me;
                var oData = me.getData();
                var oSource = oEvent.getSource();
                var oView = me.getView();

                me.isEmpty([oData.containerName, oData.closeStartDate, oData.closeEndDate], ['print.container.name', 'print.close.carton.date', 'print.close.carton.date']);
                //時間檢查
                if (oData.closeStartDate && oData.closeEndDate && moment(oData.closeStartDate).isAfter(oData.closeEndDate)) {
                    me.error('print.error6');
                }
                var data = {
                    "site": oData.site,
                    "containerName": oData.containerName,
                    "closeDateStart": oData.closeStartDate,
                    "closeDateEnd": oData.closeEndDate
                }

                me.api.findContainNoList(data, function (res) {
                    oData.containerTable = [];
                    if (oData.type == "C") {
                        res.forEach(x => {
                            oData.containerTable.push({
                                "carton": x
                            })
                        });
                        me.refresh();
                    } else {
                        res.forEach(x => {
                            oData.containerTable.push({
                                "pallet": x
                            })
                        });
                        me.refresh();
                    }
                }, me.showMessage)

            },
            containerDialog: function (oEvent) {
                var me = this.me;
                var oData = me.getData();
                var oSource = oEvent.getSource();

                var data = {
                    "site": oData.site,
                    "containerType": oData.type,
                }

                me.api.getContainer(data, function (res) {
                    new TableSelectDialog().open(oSource, res, function (data) { });
                }, me.showMessage)

            },
            selectionChange: function (oEvent) {
                var me = this.me;
                var oData = me.getData();
                var rowIndex = oEvent.getParameter('rowIndex');
                var rowContext = oEvent.getParameter('rowContext');
                if (rowContext != null) {
                    var path = rowContext.getPath();
                    var data = this.me.getProperty(path);
                    if (oData.type == "C") {
                        oData.carton = data.carton;
                    } else {
                        oData.pallet = data.pallet;
                    }
                    this.dialog.close();
                }
                this.me.refresh();
            },
            close: function () {
                this.dialog.destroy();
                this.dialog = null;
            },
            clear: function () {
                var me = this.me;
                var oData = me.getData();
                oData.containerName = '';
                oData.containerTable = [];
                oData.closeStartDate = moment().day(moment().day() - 7).startOf('day').format('YYYY-MM-DD HH:mm:ss');
                oData.closeEndDate = moment().day(moment().day()).endOf('day').format('YYYY-MM-DD HH:mm:ss');
                this.me.refresh();
            },
            setTitle(value) {
                this.dialog.setTitle(value);
            }
        });
    }
);
