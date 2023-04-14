sap.ui.define(
    [
        'fw/core/BaseController',
        'fw/fragment/TableSelectDialog',
        'fw/fragment/SelectDialog',
        'att/view/packagingProd/packagingProd'
    ],
    function(BaseController, TableSelectDialog, SelectDialog) {
        'use strict';
        return BaseController.extend('att.view.packagingProd.packagingProd', {
            onInit: function(oEvent) {
                var me = this;
                this.attachPatternMatched('packagingProd', me.onRouteMatched);
            },
            onRouteMatched: function(oEvent) {
                var me = this;
                var req = oEvent.getParameter('arguments')['?req'];
                var oData = me.setModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    item: '',
                    table: [],
                    rowCnt: 0
                });
            },
            // 物料開窗
            itemDialog: function(oEvent) {
                var me = this,
                    i18n = this.getI18N(),
                    oData = this.getData();

                $packagingProd.getItem(
                    oData.site,
                    function(res) {
                        new TableSelectDialog().open(
                            oEvent.getSource(),
                            res.map((el) => {
                                el.current = el.currentRevision == 'true' ? 'Y' : '';
                                el.itemType = i18n.getText('item.type.' + el.itemType);
                                return el;
                            }),
                            function() {
                                oData.table = [];
                                oData.rowCnt = 0;
                                me.refresh();
                            }
                        );
                    },
                    me.showMessage
                );
            },
            itemChange: function(oEvent) {
                var me = this,
                    oData = this.getData();

                oData.table = [];
                oData.rowCnt = 0;
                me.refresh();
            },
            // 檢驗項目開窗
            qcPlanItemDialog: function(oEvent) {
                var me = this,
                    i18n = this.getI18N(),
                    oData = this.getData();

                var index = oEvent.getSource().
                    getBindingInfo('value').
                    binding.
                    oContext.
                    sPath.
                    split('/')[2];

                $packagingProd.getQcPlanItem(
                    {site: oData.site},
                    function(res) {
                        let array = [];
                        res.forEach(element => {
                            if (element.itemType == 1) {
                                array.push(element);
                            }
                        });
                        new TableSelectDialog().open(
                            // 僅顯示計量
                            oEvent.getSource(),
                            array.map((el) => {
                                el.itemType = i18n.getText(
                                    'packaging.product.qc.item.type.' + el.itemType
                                );
                                return el;
                            }),
                            function(data) {
                                oData.table[index].qcPlanBo = data.handle;
                                oData.table[index].qcItemDesc = data.qcItemDesc;
                                oData.table[index].itemType = data.itemType;
                                oData.table[index].remark = data.remark;
                                oData.table[index].qcItemSid = data.qcItemSid;
                            }
                        );
                    },
                    me.showMessage
                );
            },
            doTable: function(oEvent) {
                var me = this,
                    oTable = this.byId('table'),
                    oData = this.getData(),
                    i18n = this.getI18N(),
                    indices = oTable.getSelectedIndices(),
                    key = oEvent.getSource().data('key');

                if (key == 'new') {
                    oData.table.push({});
                } else if (key == 'delete') {
                    if (indices.length > 0) {
                        indices.reverse().forEach(function(index) {
                            oData.table.splice(index, 1);
                        });
                    }
                    oTable.clearSelection();
                }

                me.setRowCnt();

                me.setSeq(oData.table, 'seq');
                me.refresh();
            },
            retrieve: function() {
                var me = this,
                    i18n = this.getI18N(),
                    oData = this.getData();

                if (me.strIsNullEmpty(oData.item)) {
                    me.error('packaging.product.error3');
                }

                $packagingProd.retrieve(
                    {
                        site: oData.site,
                        item: oData.item
                    },
                    function(res) {
                        if (res.length == 0) {
                            oData.table = [];
                            me.setRowCnt();
                            me.refresh();
                            me.error('packaging.product.error2');
                        }

                        oData.table = res.map((el) => {
                            if (!me.strIsNullEmpty(el.itemType)) {
                                el.itemType = i18n.getText(
                                    'packaging.product.qc.item.type.' + el.itemType
                                );
                            }
                            return el;
                        });

                        me.setSeq(oData.table, 'seq');
                        me.setRowCnt();
                        me.refresh();
                    },
                    me.showMessage
                );
            },
            save: function() {
                var me = this,
                    i18n = this.getI18N(),
                    oData = this.getData();

                if (me.strIsNullEmpty(oData.item)) {
                    me.error('packaging.product.error3');
                }

                let data = oData.table.map((el) => {
                    const seq = el.seq;
                    if (me.strIsNullEmpty(el.qcItem)) {
                        me.error(i18n.getText('packaging.product.error6', [seq]));
                    }

                    return {
                        site: oData.site,
                        item: oData.item,
                        qcPlanBo: el.qcPlanBo,
                        qcItemSid: el.qcItemSid,
                        user: oData.user
                    };
                });

                me.checkListRepeat(data, 'qcItemSid', 'packaging.product.error7');

                let request = {
                    site: oData.site,
                    item: oData.item,
                    productRequestList: data
                };

                $packagingProd.save(
                    request,
                    function() {
                        me.messageBox({
                            key: 'g.save.success',
                            type: 'success'
                        });
                    },
                    me.showMessage
                );
            },
            clear: function() {
                var me = this,
                    oData = this.getData();

                me.messageBox(
                    {
                        key: 'g.clear.check',
                        type: 'CONFIRM'
                    },
                    function() {
                        me.clearData(oData, []);
                        oData.rowCnt = 0;
                        me.refresh();
                    }
                );
            },
            clearQcItemInfo: function(index) {
                var me = this,
                    oData = this.getData();

                oData.table[index].qcItem = '';
                oData.table[index].qcItemDesc = '';
                oData.table[index].itemType = '';
                oData.table[index].minValue = '';
                oData.table[index].maxValue = '';
                oData.table[index].remark = '';

                me.refresh();
            },
            setRowCnt: function() {
                var me = this,
                    oData = this.getData();

                oData.rowCnt = oData.table.length;
                if (oData.rowCnt > 8) {
                    oData.rowCnt = 8;
                }
            }
        });
    }
);
