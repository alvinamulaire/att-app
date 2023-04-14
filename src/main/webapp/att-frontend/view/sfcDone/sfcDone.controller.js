sap.ui.define([
    'fw/core/BaseController',
    'sap/ui/model/json/JSONModel',
    'sap/m/MessageBox',
    'att/view/sfcDone/sfcDoneApi',
    'sap/ui/export/Spreadsheet',
    'sap/base/util/UriParameters'
], function (BaseController,
             JSONModel,
             MessageBox,
             api,
             Spreadsheet,
             UriParameters
) {
    'use strict'
    return BaseController.extend('att.view.sfcDone.sfcDone', {
        onInit: function (oEvent) {
            this.attachPatternMatched('sfcDone', this.onRouteMatched)
        },
        onRouteMatched: function (oEvent) {
            var p = window.location.hash.split('?')[1]
            var a = UriParameters.fromQuery(`?${p}`).getAll('SFC')
            if (a[0] == '') {
                a = []
            }
            var req = oEvent.getParameter('arguments')['?req']
            var me = this
            this.getView().setModel(
                new JSONModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    activity: req.ACTIVITY_ID,
                    operation: req.OPERATION,
                    resource: req.RESOURCE,
                    qty: req.QUANTITY ? req.QUANTITY : '',
                    sfcList: a,
                    operationDesc: '',
                    resourceDesc: '',
                    table: []
                })
            )

            var oView = me.getView()
            var oData = this.getData()
            if (!oData.operation) {
                oView.setBlocked(true)
                me.error('sfcDone.error1')
            }
            if (!oData.resource) {
                oView.setBlocked(true)
                me.error('sfcDone.error2')
            }

            this.api = new sfcDoneApi(this.getWebApi())
            me.api.sfcDoneInfo(oData, function (res) {
                oData.operationDesc = res.operationDesc
                oData.resourceDesc = res.resourceDesc
                oData.table = res.zVwSfcDoneList

                if (oData.sfcList.length === 1) {
                    oData.table[0].qty = oData.qty
                } else {
                    oData.table.forEach((el) => {
                        el.qty = ''
                    })
                }

                me.refresh()
            }, me.showMessage)
            me.refresh()
        },
        sfcDone: function () {
            var me = this
            var oData = this.getData()
            var i18n = me.getI18N()

            me.api.sfcDone(oData.table, function (res) {
                new activity(me.getWebApi()).activityOption(oData.activity,
                    function (optionList) {
                        optionList.forEach(option => {
                            if (option.execUnitOption === 'EXPORT_EXCEL' && option.setting === 'Y') {
                                me.export(res)
                                me.refresh()
                            }
                        })
                    },
                    me.showMessage)
                oData.table = []
                MessageBox.success(i18n.getText('sfcDone.success'))
                me.refresh()
            }, me.showMessage)
        },
        //匯出excel
        export: function (data) {
            var I18N = this.getI18N()
            var cols = []
            var fileName = 'INV-' + moment().format('YYYYMMDDHHmmsssss')
            data.forEach(x => {
                x.fileName = fileName
            })
            // 入庫單號
            cols.push({
                label: I18N.getText('sfcDone.sfcDoneId'),
                property: 'fileName',
                width: '25'
            })
            // 物料編號
            cols.push({
                label: I18N.getText('sfcDone.item'),
                property: 'item',
                width: '25'
            })
            // 物料說明
            cols.push({
                label: I18N.getText('sfcDone.itemDesc'),
                property: 'itemDesc',
                width: '25'
            })
            // 現場訂單
            cols.push({
                label: I18N.getText('sfcDone.shoporder'),
                property: 'shopOrder',
                width: '25'
            })
            // SFC
            cols.push({
                label: I18N.getText('sfcDone.sfc'),
                property: 'sfc',
                width: '25'
            })
            // 入庫數量
            cols.push({
                label: I18N.getText('sfcDone.invQty'),
                property: 'qty',
                width: '25',
                type: sap.ui.export.EdmType.Number
            })
            // BATCHNUMBER
            cols.push({
                label: I18N.getText('sfcDone.batchNumber'),
                property: 'batchNumber',
                width: '25'
            })
            // 生產等級
            cols.push({
                label: I18N.getText('sfcDone.productRank'),
                property: 'productRank',
                width: '25'
            })
            var oSettings = {
                workbook: {
                    columns: cols
                },
                dataSource: data,
                fileName: fileName + '.xlsx'
            }
            var oSheet = new Spreadsheet(oSettings)
            oSheet.build().finally(oSheet.destroy)
        }
    })
})