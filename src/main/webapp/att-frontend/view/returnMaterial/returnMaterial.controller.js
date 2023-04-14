sap.ui.define(
    [
        'fw/core/BaseController',
        'fw/fragment/TableSelectDialog',
        'fw/fragment/SelectDialog',
        'fw/custom/excelConfig',
        'att/view/returnMaterial/returnMaterial'
    ],
    function (BaseController, TableSelectDialog, SelectDialog, excelConfig) {
        'use strict';
        return BaseController.extend('att.view.returnMaterial.returnMaterial', {
            onInit: function (oEvent) {
                var me = this;
                this.attachPatternMatched('returnMaterial', me.onRouteMatched);
            },
            //檢索
            retrieve: function (oEvent, flag) {
                var me = this,
                    oData = me.getData();

                //需先選擇資源
                if (
                    !(
                        oData.item ||
                        oData.vendor ||
                        oData.shopOrder ||
                        oData.matDocNum ||
                        oData.batchNumber ||
                        oData.storage
                    )
                ) {
                    me.error('returnMaterial.error1');
                }

                var req = {
                    site: oData.site,
                    item: oData.item,
                    shopOrder: oData.shopOrder,
                    batchNumber: oData.batchNumber,
                    mch1Lifnr: oData.vendor,
                    matDocNum: oData.matDocNum,
                    storage: oData.storage
                };


                this.api.info(
                    req,
                    function (res) {
                        res.forEach((x) => {
                            x.itemitemRevision = x.item + '/' + x.itemRevision;
                            x.returnQty = x.qtyOnHand;
                        });
                        oData.reasonCode = '';
                        oData.wareHouse = '';
                        oData.table = me.sort(res, 'inventoryId');

                        me.refresh();
                        me.setTableRowCountAuto('table');
                        me.byId('table').selectAll();

                        if (flag != 'returnMaterial') {
                            if (oData.table.length == 0) {
                                me.error('returnMaterial.retrieve.null');
                            }
                        }
                    },
                    me.showMessage
                );
            },
            //退料
            returnMaterial: function (oEvent) {
                var me = this,
                    oData = me.getData(),
                    I18N = me.getI18N();

                var oTable = me.byId('table');
                var indices = oTable.getSelectedIndices();

                if (indices.length == 0) {
                    me.error('returnMaterial.error2');
                }

                var data = indices.map((index) => {
                    var obj = oData.table[index];

                    // error : 『{0}』上機中，不可執行退料
                    if (obj.resource) me.error(I18N.getText('returnMaterial.error8', obj.inventoryId));

                    if (!obj.returnQty || me.strIsNullEmpty(obj.returnQty)) {
                        me.error('returnMaterial.error5');
                    }

                    var iQty = Number(obj.returnQty);

                    if (iQty <= 0) {
                        me.error('returnMaterial.error6');
                    }

                    if (obj.qtyOnHand < iQty) {
                        me.error('returnMaterial.error7');
                    }
                    obj.site = oData.site;
                    return obj;
                });

                this.api.returnMaterial(
                    {
                        activity: oData.activity,
                        returnMaterialList: data
                    },
                    function (res) {
                        let fileName = 'RTN-' + moment().format('YYYYMMDDHHmmssSSS');
                        me._export(fileName);
                        me.retrieve(oEvent, 'returnMaterial');
                        me.messageBox({
                            key: I18N.getText('returnMaterial.success0', [fileName]),
                            type: 'SUCCESS'
                        });
                    },
                    me.showMessage
                );
            },
            _export: function (fileName) {
                var me = this,
                    oData = me.getData(),
                    I18N = me.getI18N(),
                    oTable = me.byId('table'),
                    config = new excelConfig();

                // 橫向 A4
                var wb = config.init('Sheet1', null, { paperSize: 9, orientation: 'landscape' });

                var ws = wb.getWs();

                ws.views = [{ state: 'frozen', xSplit: 7, ySplit: 1 }];

                ws.columns = [
                    {
                        header: I18N.getText('returnMaterial.excel.label1'),
                        key: 'no',
                        width: 30
                    },
                    {
                        header: I18N.getText('returnMaterial.item'),
                        key: 'item',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.itemDes'),
                        key: 'itemDesc',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.shoporder'),
                        key: 'shopOrder',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.originalQty'),
                        key: 'originalQty',
                        width: 10
                    },
                    {
                        header: I18N.getText('returnMaterial.qty'),
                        key: 'qtyOnHand',
                        width: 10
                    },
                    {
                        header: I18N.getText('returnMaterial.returnQty'),
                        key: 'returnQty',
                        width: 10
                    },
                    {
                        header: I18N.getText('returnMaterial.batchNumber'),
                        key: 'batchNumber',
                        width: 30
                    },
                    {
                        header: I18N.getText('returnMaterial.vendor'),
                        key: 'mch1Lifnr',
                        width: 25
                    },
                    {
                        header: I18N.getText('returnMaterial.excel.label5'),
                        key: 'vendorLot',
                        width: 25
                    },
                    {
                        header: I18N.getText('returnMaterial.file'),
                        key: 'matDocNum',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.manufactureDate'),
                        key: 'zbMfdate',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.validityPeriod'),
                        key: 'zbExpdate',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.excel.label2'),
                        key: 'centralStorageLocation',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.excel.label4'),
                        key: 'storage',
                        width: 20
                    },
                    {
                        header: I18N.getText('returnMaterial.excel.label3'),
                        key: 'inventoryId',
                        width: 30
                    }
                ];

                var indices = oTable.getSelectedIndices();
                var dataSource = [];

                indices.forEach((index) => {
                    let data = oData.table[index];
                    data.no = fileName;
                    dataSource.push(data);
                });

                ws.addRows(dataSource);

                ws.eachRow(function (row, rowNo) {
                    for (let i = 1; i < 17; i++) {
                        if (rowNo == 1) {
                            row.getCell(i).fill = {
                                type: 'pattern',
                                pattern: 'solid',
                                fgColor: { argb: 'FFFACD' },
                                bgColor: { argb: 'FFFACD' }
                            };

                            row.getCell(i).border = {
                                top: { style: 'thin' },
                                left: { style: 'thin' },
                                bottom: { style: 'thin' },
                                right: { style: 'thin' }
                            };
                        }

                        row.getCell(i).alignment = { vertical: 'middle', horizontal: 'center' };
                    }
                });

                wb.export(fileName);
            },
            //returnQty異動
            returnQtyLiveChange: function (oEvent) {
                var me = this;
                var oData = this.getData();
                let input = oEvent.getSource();
                input.setValue(
                    oEvent
                        .getParameter('newValue')
                        .toUpperCase()
                        .replace(/[^0-9.]/g, '')
                );
                me.refresh();
            },
            //物料開窗
            itemDialog: function (oEvent) {
                var me = this,
                    oData = me.getData();
                var oSource = oEvent.getSource(),
                    value = this.byId('item').getValue();

                this.api.getItem(
                    oData.site,
                    value,
                    function (res) {
                        oData.itemList = me.sort(res, 'item');
                        new SelectDialog().open(oSource, me, function () {
                        });
                        me.refresh();
                    },
                    me.showMessage
                );
            },
            //工單開窗
            shopOrderDialog: function (oEvent) {
                var me = this,
                    oData = me.getData();
                var oSource = oEvent.getSource(),
                    value = this.byId('shopOrder').getValue();

                this.api.getShopOrder(
                    oData.site,
                    value,
                    function (res) {
                        new TableSelectDialog().open(oSource, me.sort(res, 'shopOrder'), function () {
                        });
                        me.refresh();
                    },
                    me.showMessage
                );
            },
            //廠商開窗
            vendorDialog: function (oEvent) {
                var me = this,
                    oData = me.getData();
                var oSource = oEvent.getSource();

                this.api.getAssyData(
                    oData.site,
                    'MCH1-LIFNR',
                    function (res) {
                        oData.vendorList = me.sort(res, 'dataAttr');
                        new SelectDialog().open(oSource, me, function () {
                        });
                        me.refresh();
                    },
                    me.showMessage
                );
            },
            //文件開窗
            fileDialog: function (oEvent) {
                var me = this,
                    oData = me.getData();
                var oSource = oEvent.getSource();

                this.api.getAssyData(
                    oData.site,
                    'MAT_DOC_NUM',
                    function (res) {
                        oData.fileList = me.sort(res, 'dataAttr');
                        new SelectDialog().open(oSource, me, function () {
                        });
                        me.refresh();
                    },
                    me.showMessage
                );
            },
            //batchNumber開窗
            batchDialog: function (oEvent) {
                var me = this,
                    oData = me.getData();
                var oSource = oEvent.getSource();

                this.api.getAssyData(
                    oData.site,
                    'BATCH_NUMBER',
                    function (res) {
                        oData.batchNumberList = me.sort(res, 'dataAttr');
                        new SelectDialog().open(oSource, me, function () {
                        });
                        me.refresh();
                    },
                    me.showMessage
                );
            },
            //線邊倉號碼
            storageDialog: function (oEvent) {
                var me = this,
                    oData = me.getData();
                var oSource = oEvent.getSource();

                this.api.getStorage(
                    oData.site,
                    function (res) {
                        oData.storageList = me.sort(res, 'storage');
                        new SelectDialog().open(oSource, me, function () {
                        });
                        me.refresh();
                    },
                    me.showMessage
                );
            },
            //清除
            clear: function () {
                var me = this,
                    oData = me.getData();
                me.confirmMessage(me.getI18N().getText('g.clear.page'), () => {
                    me.clearData(oData, []);
                    me.refresh();
                });
            },
            onRouteMatched: function (oEvent) {
                var me = this;
                var req = oEvent.getParameter('arguments')['?req'];
                var oData = me.setModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    activity: req.ACTIVITY_ID,
                    item: '',
                    vendor: '',
                    shopOrder: '',
                    matDocNum: '',
                    batchNumber: '',
                    storage: '',
                    reasonCodeBo: '',
                    wareHouse: '',
                    reasonCode: '',
                    serialNo: '',
                    table: [],
                });

                this.api = new returnApi(me.getWebApi());
            }
        });
    }
);
