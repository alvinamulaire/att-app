sap.ui.define(
    [
        'fw/core/BaseController',
        'fw/fragment/TableSelectDialog',
        'att/view/stacking/fragment/stacking',
        'att/view/stacking/stackingApi'
    ],
    function (BaseController, TableSelectDialog, stacking) {
        'use strict'

        /**
         * BaseController不在個別的專案各自維護，統一維護在FW
         */
        return BaseController.extend('att.view.stacking.stacking', {
            onInit: function () {
                this.attachPatternMatched('stacking', this.onRouteMatched)
            },
            onRouteMatched: function (oEvent) {
                let me = this
                let i18n = this.getI18N()
                let oView = this.getView()
                let req = oEvent.getParameter('arguments')['?req']

                if (!req.OPERATION) {
                    oView.setBlocked(true)
                    this.error(i18n.getText('packing.warning8'))
                }
                if (!req.RESOURCE) {
                    oView.setBlocked(true)
                    this.error(i18n.getText('packing.warning9'))
                }

                this.setModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    operation: req.OPERATION,
                    resource: req.RESOURCE,
                    containerType: 'P',
                    shippingDateRule: false,  // 運送規則
                    shippingDate: '',         // 運送日期
                    affixRule: false,         // 前後綴規則
                    printerRule: [],
                    activity: req.ACTIVITY_ID,
                    container: '',              // 容器
                    containerDesc: '',          // 容器說明
                    containerNo: '',            // 箱號
                    stackNo: '',          // 棧板編號
                    stackStatus: '',      // 棧板狀態
                    stackStatusName: '',  // 棧板狀態名稱
                    printer: '',          // 標籤機
                    stackedQty: 0,            // 裝棧數
                    maxQty: 0,                // 滿棧數
                    prefix: '',
                    suffix: '',
                    stackingList: [],
                    stackStatusDesc: {
                        0: '開啟',
                        1: '關閉',
                        2: '出站'
                    },
                    firstRow: 0
                })

                let oData = this.getData()
                // 取得活動 出貨日期, 前綴後綴 規則
                new activity(this.getWebApi()).activityOption(oData.activity,
                    function (res) {
                        res.forEach(element => {
                            if (element.execUnitOption === 'USE_SHIPPING_DATE' && element.setting === 'Y') {
                                oData.shippingDateRule = true
                                me.refresh()
                            }
                            if (element.execUnitOption === 'IS_PREFIX_LIMIT' && element.setting === 'Y') {
                                oData.affixRule = true
                                me.refresh()
                            }
                            if (element.execUnitOption === 'PRINTER_NAME') {
                                let printerArray = element.setting.split('|')
                                printerArray.forEach(element => {
                                    oData.printerRule.push({
                                        printerName: element
                                    })
                                })

                                me.refresh()
                            }
                        })
                    },
                    this.showMessage
                )
            },
            // 開窗
            openDialog: function (oEvent) {
                let me = this
                let oSource = oEvent.getSource()
                let id = oSource.sId.split('__xmlview1--')[1]
                let oData = this.getData()

                switch (id) {
                    // 容器
                    case 'container':
                        $stacking.getContainer({
                            site: oData.site,
                            containerType: oData.containerType
                        },
                            (res) => {
                                new TableSelectDialog().open(oSource, res, function (res) {
                                    oData.container = res.name            // 容器
                                    oData.containerDesc = res.description // 容器說明
                                    oData.maxQty = res.packingMaxQty   // 滿棧數

                                    me.refresh()
                                })
                            },
                            me.showMessage
                        )
                        break
                    // 標籤機
                    case 'printer':
                        new TableSelectDialog().open(oSource, oData.printerRule, (res) => {
                            oData.printer = res.printerName
                            me.refresh()
                        })
                        break
                }
            },
            // 檢索
            search: function () {
                let me = this
                let oData = this.getData()

                this.isEmpty([
                    oData.container,
                    oData.stackNo
                ], [
                    'stacking.label5',
                    'stacking.label7'
                ])

                $stacking.searchStackNo({
                    site: oData.site,
                    containerType: oData.containerType,
                    containerNo: oData.stackNo,
                    user: oData.user,
                    prefix: oData.affixRule === true ? 'Y' : 'N'
                },
                    (res) => {
                        oData.container = res.master.containerName       // 容器
                        oData.containerDesc = res.master.containerDesc   // 容器說明
                        oData.stackStatus = res.master.status    // 棧板狀態
                        oData.stackStatusName = oData.stackStatusDesc[res.master.status]
                        oData.shippingDate = res.master.shippingDate   // 出貨日期
                        oData.maxQty = res.master.maxQty  // 滿棧數
                        oData.stackedQty = res.packedQty   // 裝棧數
                        oData.prefix = res.prefixList.join('、')     // 前綴
                        oData.suffix = res.suffixList.join('、')     // 後綴

                        res.detail.forEach((element, index) => {
                            element.index = index + 1
                        })
                        oData.stackingList = res.detail  // 裝棧清單

                        me.byId('table').clearSelection()
                        me.byId('container').setEditable(false)
                        me.byId('boxNo').setEditable(false)
                        me.refresh()
                    },
                    me.showMessage
                )

                me.setTableRowCountAuto('table')
            },
            // 新增棧板號
            createStackNo: function () {
                let oData = this.getData()
                let me = this

                this.isEmpty([
                    oData.container,
                    oData.printer
                ], [
                    'stacking.label5',
                    'stacking.label9'
                ])
                this.messageBox({
                    key: 'stacking.warning5',
                    type: 'WARNING'
                },
                    () => {
                        $stacking.getContainerNo(
                            {
                                site: oData.site,
                                containerType: oData.containerType,  // 容器類型 C:箱號 P:棧板
                                containerName: oData.container,      // 容器
                                maxQty: oData.maxQty,            // 滿棧數
                                printName: oData.printer,       // 標籤機，棧板才會用到
                                activity: oData.activity,       // 活動名稱，棧板才會用到
                                user: oData.user
                            },
                            (res) => {
                                me.updateStackNo()

                                oData.stackNo = res.containerNo   // 棧板編號
                                oData.stackStatus = res.status    // 棧板狀態
                                oData.stackStatusName = oData.stackStatusDesc[res.status]

                                me.byId('container').setEditable(false)
                                me.byId('boxNo').setEditable(false)
                                me.refresh()
                            },
                            me.showMessage
                        )
                    }
                )
            },
            // 更新棧板時 刪除相關資訊
            updateStackNo: function () {
                let oData = this.getData()
                let excludes = [
                    'container',  // 容器
                    'containerDesc',  // 容器說明
                    'printer',   // 標籤機
                    'maxQty',    // 滿棧數
                    'stackNo',     // 棧板號
                    'operation',
                    'resource',
                    'containerType',
                    'shippingDateRule',
                    'affixRule',
                    'printerRule',
                    'stackStatusDesc'
                ]

                this.clearData(oData, excludes)
                oData.firstRow = 0
            },
            // 開啟棧板
            openStack: function () {
                let me = this
                let oData = this.getData()
                oData.stackStatus = '0'

                this.isEmpty(oData.stackNo, 'stacking.label7')

                $stacking.openStackNo({
                    site: oData.site,
                    user: oData.user,
                    containerType: oData.containerType,
                    containerNo: oData.stackNo,   // 棧板號
                    status: oData.stackStatus,     // 開啟箱號(棧板)時才給
                    weight: '',
                    shippingDate: oData.shippingDate  // 出貨日期，彈出出貨日期畫面時才給
                },
                    () => {
                        oData.stackStatusName = oData.stackStatusDesc[0]
                        me.refresh()
                    },
                    me.showMessage
                )
            },
            // 清除
            clear: function () {
                let oData = this.getData()
                let me = this
                let excludes = [
                    'operation',
                    'resource',
                    'containerType',
                    'shippingDateRule',
                    'affixRule',
                    'printerRule',
                    'stackStatusDesc'
                ]

                this.messageBox(
                    {
                        key: 'stacking.warning4',
                        type: 'warning'
                    },
                    () => {
                        me.clearData(oData, excludes)
                        me.byId('container').setEditable(true)
                        me.byId('boxNo').setEditable(true)
                        oData.firstRow = 0
                        me.refresh()
                    }
                )
            },
            // 標籤補印
            print: function () {
                let oData = this.getData()
                // 傳多個參數 陣列相對應 index back = Y; activity = 資料
                this.navTo('print', ['back', 'ACTIVITY_ID'], ['Y', oData.activity])
            },
            // 刷 棧板號
            scanStackNo: function (oEvent) {
                let me = this
                let oData = this.getData()
                oData.stackNo = oData.stackNo.trim()

                $stacking.searchStackNo({
                    site: oData.site,
                    containerType: oData.containerType,
                    containerNo: oData.stackNo,
                    user: oData.user,
                    prefix: oData.affixRule === true ? 'Y' : 'N'
                },
                    (res) => {
                        me.updateStackNo()

                        oData.container = res.master.containerName       // 容器
                        oData.containerDesc = res.master.containerDesc   // 容器說明
                        oData.stackStatus = res.master.status    // 棧板狀態
                        oData.stackStatusName = oData.stackStatusDesc[res.master.status]
                        oData.shippingDate = res.master.shippingDate   // 出貨日期
                        oData.maxQty = res.master.maxQty  // 滿棧數
                        oData.stackedQty = res.packedQty   // 裝棧數
                        oData.prefix = res.prefixList.join('、')     // 前綴
                        oData.suffix = res.suffixList.join('、')     // 後綴

                        res.detail.forEach((element, index) => {
                            element.index = index + 1
                        })
                        oData.stackingList = res.detail  // 裝棧清單

                        me.byId('table').clearSelection()
                        me.refresh()
                    },
                    me.showMessage
                )

                me.setTableRowCountAuto('table')
            },
            // 刷 箱號
            scanContainerNo: function () {
                let me = this
                let oData = this.getData()
                let i18n = this.getI18N()
                let noDuplicateBox = true
                oData.containerNo = oData.containerNo.trim()

                this.isEmpty(oData.containerNo, 'stacking.label11')

                oData.stackingList.forEach(element => {
                    if (element.cartonNo === oData.containerNo) {
                        this.error(i18n.getText('stacking.warning8'))
                        noDuplicateBox = false
                    }
                })

                if (noDuplicateBox) {
                    $stacking.scanContainerNo({
                        site: oData.site,
                        operation: oData.operation,
                        containerNo: oData.stackNo,   // 棧板號
                        cartonNo: oData.containerNo,    // 箱號
                        user: oData.user,
                        prefix: oData.affixRule === true ? 'Y' : 'N'
                    },
                        (res) => {
                            oData.prefix = res.prefixList.join('、')     // 前綴
                            oData.suffix = res.suffixList.join('、')     // 後綴
                            oData.stackedQty = res.packedQty             // 裝棧數

                            res.detail.forEach((element, index) => {
                                element.index = index + 1
                            })
                            oData.stackingList = res.detail         // 裝棧清單
                            oData.containerNo = ''
                            oData.firstRow = oData.stackingList.length

                            me.refresh()
                            me.byId('containerNo').focus()
                        },
                        me.showMessage
                    )

                    me.setTableRowCountAuto('table')
                }
            },
            // table - 刪除
            minus: function () {
                let me = this
                let i18n = this.getI18N()
                let oData = this.getData()
                let oTable = this.byId('table')
                let selectArray = oTable.getSelectedIndices()

                if (selectArray.length == 0) {
                    this.error(i18n.getText('stacking.warning3'))
                } else {
                    let selectedList = []

                    selectArray.forEach(element => {
                        selectedList.push({
                            sfc: '',   // 裝箱刪除才給SFC
                            sn: '',      // 裝箱刪除才給SN
                            cartonNo: oData.stackingList[element].cartonNo   // 棧板刪除才給箱號
                        })
                    })

                    $stacking.deleteSN({
                        site: oData.site,
                        detailInfoList: selectedList,
                        containerType: oData.containerType,
                        containerNo: oData.stackNo,           // 棧板號
                        user: oData.user,
                        prefix: oData.affixRule === true ? 'Y' : 'N'     // 是否前後綴
                    },
                        (res) => {
                            oData.prefix = res.prefixList.join('、')     // 前綴
                            oData.suffix = res.suffixList.join('、')     // 後綴
                            oData.stackedQty = res.packedQty       // 裝棧數

                            res.detail.forEach((element, index) => {
                                element.index = index + 1
                            })
                            oData.stackingList = res.detail
                            oData.firstRow = oData.stackingList.length

                            me.byId('table').clearSelection()
                            me.refresh()
                        },
                        me.showMessage
                    )
                }
            },
            // 完成
            finish: function () {
                let me = this
                let oData = this.getData()

                this.isEmpty([
                    oData.container,
                    oData.stackNo
                ], [
                    'stacking.label5',
                    'stacking.label7'
                ])

                // 完成前檢查
                $stacking.preCheck({
                    site: oData.site,
                    containerNo: oData.stackNo,  // 棧板號
                    user: oData.user
                },
                    (res) => { // res 尾數棧 true or false
                        if (res) {
                            this.messageBox({   // 尾數箱提示
                                key: 'stacking.warning6',
                                type: 'WARNING'
                            },
                                //確認尾數箱, 執行上傳
                                function (res) {
                                    me.update(true)
                                },
                                me.showMessage
                            )
                        } else {
                            me.update(false)
                        }
                    },
                    me.showMessage
                )
            },
            // 完成存入主檔
            update: function (mantissa) {
                let me = this
                let oData = this.getData()

                $stacking.complete({
                    site: oData.site,
                    containerNo: oData.stackNo,  // 棧板號
                    mantissa: mantissa,
                    user: oData.user
                },
                    () => {
                        if (oData.shippingDateRule) {
                            oData.stackStatus = '1'
                            oData.stackStatusName = oData.stackStatusDesc[1]
                            new stacking().open(me)
                        } else {
                            oData.stackStatus = '1'
                            oData.stackStatusName = oData.stackStatusDesc[1]
                            me.refresh()
                        }
                    },
                    me.showMessage
                )
            },
        })
    }
)
