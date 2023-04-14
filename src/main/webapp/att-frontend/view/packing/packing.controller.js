sap.ui.define(
    [
        'fw/core/BaseController',
        'fw/fragment/TableSelectDialog',
        'att/view/packing/fragment/packing',
        'att/view/packing/packingApi'
    ],
    function (BaseController, TableSelectDialog, packing) {
        'use strict'

        /**
         * BaseController不在個別的專案各自維護，統一維護在FW
         */
        return BaseController.extend('att.view.packing.packing', {
            onInit: function () {
                this.attachPatternMatched('packing', this.onRouteMatched)
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
                    activity: req.ACTIVITY_ID,
                    containerType: 'C',
                    containerWeightRule: false,
                    affixRule: false,
                    printerRule: [],
                    container: '',              // 容器
                    containerDesc: '',          // 容器說明
                    containerNo: '',            // 箱號
                    containerStatus: '',        // 箱號狀態
                    containerStatusName: '',    // 箱號狀態名稱
                    containerWeight: '',        // 箱號重量
                    printer: '',                // 標籤機
                    sfc: '',
                    batch_no: '',
                    sn: '',
                    sfcPackedQty: '',          // sfc 已包裝數量
                    sfcQty: '',                // SFC 總數
                    packedQty: '',             // 裝箱數
                    maxQty: '',                // 滿箱數
                    prefix: '',
                    suffix: '',
                    packingList: [],
                    containerStatusDesc: {
                        0: '開啟',
                        1: '關閉',
                        2: '出站'
                    },
                    firstRow: 0,
                    containerNoFlag: false,     // 檢查箱號是否檢索
                })

                let oData = this.getData()

                // 取得活動 箱號重量, 前綴後綴 規則
                new activity(this.getWebApi()).activityOption(oData.activity,
                    function (res) {
                        res.forEach(element => {
                            let execUnitOption = element.execUnitOption
                            let setting = element.setting

                            //  是否啟用前後綴包裝限制
                            if (execUnitOption === 'IS_PREFIX_LIMIT' && setting === 'Y') oData.affixRule = true
                            // 是否執行箱號重量 & 箱號顯示方式
                            if (execUnitOption === 'USE_PACK_WEIGHT') oData.containerWeightRule = setting === 'Y' ? 'Y' : setting === 'U' ? 'U' : ''
                            // 標籤機名稱
                            if (execUnitOption === 'PRINTER_NAME') {
                                let printerArray = setting.split('|')
                                printerArray.forEach(element => {
                                    oData.printerRule.push({
                                        printerName: element
                                    })
                                })
                            }
                        })
                        me.refresh()
                    },
                    me.showMessage
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
                        $packing.getContainer({
                            site: oData.site,
                            containerType: oData.containerType
                        },
                            (res) => {
                                new TableSelectDialog().open(oSource, res, function (res) {
                                    oData.container = res.name            // 容器
                                    oData.containerDesc = res.description // 容器說明
                                    oData.maxQty = res.packingMaxQty      // 滿箱數

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
                    // 箱子重量
                    case 'containerWeight':
                        new packing().open(me)
                        break
                }
            },
            // 檢索 刷 箱號
            scanContainerNo: function () {
                let me = this
                let oData = this.getData()

                this.isEmpty(oData.containerNo, 'packing.label7')

                $packing.searchContainerNo(
                    {
                        site: oData.site,
                        containerType: oData.containerType,
                        containerNo: oData.containerNo,
                        prefix: oData.affixRule === true ? 'Y' : 'N',
                        user: oData.user
                    },
                    (res) => {
                        me.updateContainerNo()

                        oData.containerNoFlag = true
                        oData.container = res.master.containerName       // 容器
                        oData.containerDesc = res.master.containerDesc   // 容器說明
                        oData.containerWeight = res.master.weight    // 箱號重量
                        oData.containerStatus = res.master.status    // 箱號狀態
                        oData.containerStatusName = oData.containerStatusDesc[res.master.status]
                        oData.maxQty = res.master.maxQty  // 滿箱數
                        oData.packedQty = res.packedQty   // 裝箱數
                        oData.prefix = res.prefixList.join('、')     // 前綴
                        oData.suffix = res.suffixList.join('、')     // 後綴

                        res.detail.forEach((element, index) => {
                            element.index = index + 1
                        })
                        oData.packingList = res.detail          // 裝箱清單

                        me.byId('container').setEditable(false)
                        me.byId('boxNo').setEditable(false)
                        me.refresh()
                    },
                    me.showMessage
                )

                me.byId('table').clearSelection()
                me.setTableRowCountAuto('table')
            },
            // 新增箱號
            createContainerNo: function () {
                let me = this
                let oData = this.getData()
                this.isEmpty(oData.container, 'packing.label5')
                this.messageBox(
                    {
                        key: 'packing.warning3',
                        type: 'WARNING'
                    },
                    () => {
                        $packing.getContainerNo(
                            {
                                site: oData.site,
                                containerType: oData.containerType,  // 容器類型 C:箱號 P:棧板
                                containerName: oData.container,      // 容器
                                maxQty: oData.maxQty,                // 容器滿箱數
                                printName: '',      // 標籤機，棧板才會用到
                                activity: '',       // 活動名稱，棧板才會用到
                                user: oData.user
                            },
                            (res) => {
                                me.updateContainerNo()

                                oData.containerNoFlag = true
                                oData.containerNo = res.containerNo
                                oData.containerStatus = res.status
                                oData.containerStatusName = oData.containerStatusDesc[res.status]

                                me.byId('container').setEditable(false)
                                me.byId('boxNo').setEditable(false)
                                me.refresh()
                            },
                            me.showMessage
                        )
                    }
                )
            },
            // 開啟箱號
            openContainerNo: function () {
                let me = this
                let oData = this.getData()

                this.isEmpty(oData.containerNo, 'packing.label7')

                $packing.openContainerNo(
                    {
                        site: oData.site,
                        user: oData.user,
                        containerType: oData.containerType,
                        containerNo: oData.containerNo,
                        status: '0',     // 開啟箱號(棧板)時才給
                        weight: '',        // 重量，彈出重量畫面才給
                        shippingDate: ''   // 出貨日期，彈出出貨日期畫面時才給
                    },
                    () => {
                        oData.containerStatus = '0'
                        oData.containerStatusName = oData.containerStatusDesc[0]
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
                    'containerWeightRule',
                    'affixRule',
                    'printerRule',
                    'containerStatusDesc'
                ]

                this.messageBox(
                    {
                        key: 'packing.warning4',
                        type: 'WARNING'
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
            // 箱號更新 清除欄位資訊
            updateContainerNo: function () {
                let oData = this.getData()

                let excludes = [
                    'container',
                    'containerDesc',
                    'containerNo',
                    'maxQty',
                    'operation',
                    'resource',
                    'containerType',
                    'containerWeightRule',
                    'affixRule',
                    'printerRule',
                    'containerStatusDesc'
                ]
                this.clearData(oData, excludes) // 清除 除了容器相關資訊的所有畫面資訊
                oData.firstRow = 0
            },
            // 刷 SFC
            scanSFC: function () {
                let oData = this.getData()
                let me = this

                $packing.scanSFC({
                    site: oData.site,
                    sfc: oData.sfc,
                    operation: oData.operation,
                    user: oData.user,
                    containerType: oData.containerType,
                    containerName: oData.container,
                    containerNo: oData.containerNo
                },
                    (res) => {
                        oData.sfcPackedQty = res.sfcPackedQty  // SFC 已包裝數量
                        oData.sfcQty = res.sfcQty  // SFC 總數量

                        me.byId('batchNo').focus()
                        me.refresh()
                    },
                    me.showMessage
                )
            },
            // 刷 容器
            scanContainer: function () {
                let me = this
                let oData = this.getData()

                $packing.scanContainer(
                    {
                        "site": oData.site,
                        "name": oData.container,    // 容器
                        "containerType": oData.containerType
                    },
                    (res) => {
                        me.createContainerNo()
                    },
                    me.showMessage
                )
            },
            // 刷 batchNo
            scanBatchNo: function () {
                this.byId('sn').focus()
            },
            // 刷 SN
            scanSN: function () {
                let me = this
                let oData = this.getData()
                oData.sn = oData.sn.trim()

                this.isEmpty([
                    oData.sfc,
                    oData.batch_no,
                    oData.sn
                ], [
                    'packing.label20',
                    'packing.label12',
                    'packing.label14'
                ]
                )

                $packing.scanSN(
                    {
                        site: oData.site,
                        user: oData.user,
                        sfc: oData.sfc,
                        sn: oData.sn,
                        resource: oData.resource,
                        operation: oData.operation,
                        batchNo: oData.batch_no,
                        containerType: oData.containerType,
                        containerName: oData.container,
                        containerNo: oData.containerNo,
                        prefix: oData.affixRule === true ? 'Y' : 'N'
                    },
                    (res) => {
                        oData.sfcPackedQty = res.sfcPackedQty  // SFC 已包裝數
                        oData.packedQty = res.packedQty        // 裝箱數
                        oData.prefix = res.prefixList.join('、')     // 前綴
                        oData.suffix = res.suffixList.join('、')     // 後綴

                        res.detail.forEach((element, index) => {
                            element.index = index + 1
                        })
                        oData.packingList = res.detail
                        oData.sn = ''
                        oData.firstRow = oData.packingList.length

                        me.refresh()
                        me.byId('sn').focus()
                    },
                    me.showMessage
                )

                me.setTableRowCountAuto('table')
            },
            // table - 刪除
            minus: function () {
                let me = this
                let i18n = this.getI18N()
                let oData = this.getData()
                let oTable = this.byId('table')
                let selectArray = oTable.getSelectedIndices()

                if (selectArray.length == 0) {
                    this.error(i18n.getText('packing.warning5'))
                } else {
                    let selectedList = []

                    selectArray.forEach(element => {
                        selectedList.push({
                            sfc: oData.packingList[element].sfc,   // 裝箱刪除才給SFC
                            sn: oData.packingList[element].sn,      // 裝箱刪除才給SN
                            cartonNo: ''   // 棧板刪除才給箱號
                        })
                    })

                    $packing.deleteSN({
                        site: oData.site,
                        detailInfoList: selectedList,
                        containerType: oData.containerType,
                        containerNo: oData.containerNo,
                        user: oData.user,
                        prefix: oData.affixRule === true ? 'Y' : 'N',     // 是否前後綴
                        sfc: oData.sfc      // 當下 SFC
                    },
                        (res) => {
                            oData.sfcPackedQty = res.sfcPackedQty  // 已包裝數量
                            oData.packedQty = res.packedQty        // 裝箱數
                            oData.prefix = res.prefixList.join('、')     // 前綴
                            oData.suffix = res.suffixList.join('、')     // 後綴

                            res.detail.forEach((element, index) => {
                                element.index = index + 1
                            })
                            oData.packingList = res.detail
                            oData.firstRow = oData.packingList.length

                            oTable.clearSelection()
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
                    oData.containerNo,
                    oData.printer
                ], [
                    'packing.warning1',
                    'packing.warning2',
                    'packing.warning6'
                ])

                // 完成前檢查
                $packing.preCheck({
                    site: oData.site,
                    containerNo: oData.containerNo,
                    user: oData.user
                },
                    (res) => {  // 尾數箱 true or false
                        if (res) {
                            this.messageBox({   // 尾數箱提示
                                key: 'packing.warning7',
                                type: 'WARNING'
                            },
                                //確認尾數箱, 更新主檔
                                function () {
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
            // 完成存入主檔案
            update: function (mantissa) {
                let me = this
                let oData = this.getData()

                $packing.complete(
                    {
                        site: oData.site,
                        containerNo: oData.containerNo,
                        mantissa: mantissa,
                        user: oData.user,
                        printName: oData.printer
                    },
                    () => {
                        oData.containerStatus = '1'
                        oData.containerStatusName = oData.containerStatusDesc[1]
                        if (oData.containerWeightRule === 'Y') new packing().open(me)

                        me.refresh()
                    },
                    me.showMessage
                )
            },
            // 改變 SFC
            changeSFC: function () {
                let oData = this.getData()

                oData.batch_no = ''
                oData.sn = ''
                oData.sfcPackedQty = ''  // SFC 已包裝數量
                oData.sfcQty = ''   // SFC 總數量

                this.refresh()
            },
        })
    }
)
