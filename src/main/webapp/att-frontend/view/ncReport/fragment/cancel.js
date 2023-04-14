sap.ui.define(
    [
        'sap/ui/base/Object',
        'sap/ui/core/Fragment',
        'sap/ui/model/json/JSONModel',
        'att/view/ncReport/ncReportApi'
    ],
    function (Object, Fragment, JSONModel) {
        'use strict'
        return Object.extend('att.view.ncReport.fragment.cancel', {
            //開啟畫面
            open: function (event, me) {
                this.me = me
                this.oSource = event.getSource()
                let that = this,
                    i18n = me.getI18N(),
                    meData = me.getData(),
                    dialog = Fragment.byId('cancel', 'cancel'),
                    model = new JSONModel({
                        user: meData.user,
                        name: '',
                        cancelReason: '',
                        date: moment().format('YYYY-MM-DD HH:mm:ss')
                    })

                if (dialog) {
                    dialog.destroy()
                    dialog = undefined
                    this.dialog = null
                }

                if (!dialog) {
                    Fragment.load({
                        name: 'att.view.ncReport.fragment.cancel',
                        type: 'XML',
                        controller: this,
                        id: 'cancel'
                    }).then((oDialog) => {
                        that.dialog = oDialog
                        // 開窗 model
                        oDialog.setModel(model)
                        // 開窗載入 i18n
                        oDialog.setModel(me.getModel('i18n'), 'i18n')

                        let oModel = oDialog.getModel(),
                            oData = oModel.getData(),
                            index = this.oSource.getBindingInfo('text')
                                .binding
                                .oContext
                                .sPath
                                .split('/')[2],
                            data = meData.table[index]
                        oData.cancelReason = data.cancelledReason

                        $ncReport.userName(meData.site, meData.user, function (res) {
                            oData.name = res
                            oModel.refresh()
                        }, me.showMessage)
                        oDialog.open()
                    })
                }

                return this
            },
            confirm: function (oEvent) {
                let me = this.me,
                    that = this,
                    meData = me.getData(),
                    oData = this.dialog.getModel().getData(),
                    index = this.oSource.getBindingInfo('text')
                        .binding
                        .oContext
                        .sPath
                        .split('/')[2],
                    data = meData.table[index],
                    oCancel = Fragment.byId('cancel', 'isCancelledSelect')

                if (me.strIsNullEmpty(oData.cancelReason)) {
                    me.error('nc.report.error3')
                }

                $ncReport.update({
                    site: meData.site,
                    user: meData.user,
                    sid: data.sid,
                    isCancelled: oCancel.getSelectedKey(),
                    reason: oData.cancelReason,
                    executeTime: oData.date
                }, function (res) {
                    that.dialog.destroy()
                    that.dialog = null
                    me.retrieve()
                }, me.showMessage)
            },
            // 關閉開窗
            close: function (oEvent) {
                this.dialog.destroy()
                this.dialog = null
            }
        })
    }
)
