sap.ui.define(
    [
        'fw/core/BaseController',
        'att/view/equipmentKanban/fragment/setting',
        'att/view/equipmentKanban/equipmentKanbanApi'
    ],
    function (BaseController, setting) {
        'use strict'
        return BaseController.extend('att.view.equipmentKanban.equipmentKanban', {
            onInit: function () {
                this.attachPatternMatched('equipmentKanban', this.onRouteMatched)
            },
            onRouteMatched: function (oEvent) {
                let i18N = this.getI18N()
                let req = oEvent.getParameter('arguments')['?req']

                this.setModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    activity: req.ACTIVITY_ID,
                    updatedTime: '',        // 資料更新時間
                    refreshFrequency: '',   // 更新頻率
                    listChangeTime: '',     // 清單變更時間
                    workCenter: '',
                    workCenterDesc: '',
                    kanbanType: '',         // 看板類型
                    resourceTotalQty: '',   // 機台總數
                    avgMonthEfficiency: '',     // 本月 - 效率
                    avgMonthYield: '',          // 本月 - 良率
                    avgMonthUtilizationRate: '',    // 本月 - 稼動率
                    avgMonthOee: '',                // 本月 - OEE
                    avgDayEfficiency: '',   // 本日 - 效率
                    avgDayYield: '',        // 本日 - 良率
                    avgDayUtilizationRate: '',      // 本日 - 稼動率
                    avgDayOee: '',                  // 本日 - OEE
                    pieData: [],            // 狀態資訊
                    tableList: [],
                    tableShowList: [],
                    totalPages: '',   // 總頁數
                    currentPage: 1,   // 當前頁數
                    pageCount: '',    // 一頁 幾 row
                    statusInfo: {     // 狀態 顏色, 文字 資訊
                        0: { color: '#FFFFFF', name: i18N.getText('resourceStatus.0'), engDesc: 'UnKnown' },
                        1: { color: '#27BE27', name: i18N.getText('resourceStatus.1'), engDesc: 'Productive' },
                        2: { color: '#F1F102', name: i18N.getText('resourceStatus.2'), engDesc: 'StandBy' },
                        3: { color: '#E8743B', name: i18N.getText('resourceStatus.3'), engDesc: 'Engineering' },
                        4: { color: '#0070C0', name: i18N.getText('resourceStatus.4'), engDesc: 'Scheduled Down' },
                        5: { color: '#FF0000', name: i18N.getText('resourceStatus.5'), engDesc: 'Unscheduled Down' },
                        6: { color: '#C6E0B4', name: i18N.getText('resourceStatus.6'), engDesc: 'Non-scheduled' },
                        301: { color: '#945ECF', name: i18N.getText('resourceStatus.301'), engDesc: 'Enabled' },
                        302: { color: '#888888', name: i18N.getText('resourceStatus.302'), engDesc: 'Disabled' },
                        303: { color: '#F4B084', name: i18N.getText('resourceStatus.303'), engDesc: 'Hold' },
                        'P01': { color: '#FF33CC', name: i18N.getText('resourceStatus.P01'), engDesc: 'Repair' },
                        'HOLD_YLD_RATE_R': { color: '#F4B084', name: i18N.getText('resourceStatus.HOLD_YLD_RATE_R'), engDesc: 'Hold Yield Rate' },
                        'HOLD_CONSEC_NC_R': { color: '#F4B084', name: i18N.getText('resourceStatus.HOLD_CONSEC_NC_R'), engDesc: 'Hold Consec NC' },
                        'HOLD_SPC_VIOL_R': { color: '#F4B084', name: i18N.getText('resourceStatus.HOLD_SPC_VIOL_R'), engDesc: 'Hold SPC Viol' },
                        'HOLD_SPC_WARN_R': { color: '#F4B084', name: i18N.getText('resourceStatus.HOLD_SPC_WARN_R'), engDesc: 'Hold SPC Warn' }
                    },
                })

                // 圓餅圖 配置
                this.byId('vizFramePie').setVizProperties({
                    title: { visible: false },
                    // 圖形區
                    plotArea: {
                        // 資料標籤
                        dataLabel: {
                            visible: true,
                            style: {
                                color: '#ffffff',
                                fontSize: '16px'
                            }
                        }
                    },
                    // feed
                    legend: {
                        // feed 標籤
                        label: {
                            // 顏色, 字體大小
                            style: {
                                color: '#ffffff',
                                fontSize: '18px'
                            }
                        },
                        hoverShadow: { color: 'none' },
                        hoverSelectedShadow: { color: 'none' }
                    },
                    // feed 群組
                    legendGroup: {
                        // 位置布局
                        layout: {
                            position: 'right',
                            alignment: 'center'
                        }
                    }
                })

                let cardArr = ['glassCard', 'glassCard2', 'glassCard3']
                cardArr.forEach(element => {
                    this.byId(element).addStyleClass('glassEffectBlue')
                })

                // 取得 table 的 row 數量
                this.getTableRowCount('table')
                this.refresh()
            },
            // 取得所有 page api
            getPageInfo: function (data) {
                let me = this
                let oData = this.getData()
                oData.workCenter = data.workCenter

                oData.updatedTime = moment().format('YYYY/MM/DD hh:mm:ss')
                me.getWorkCenterInfo()
                me.getResourceStatusInfo()
                me.getMonthEfficiency()
                me.getDayEfficiency()
                me.getTableInfo()
            },
            // 刷新 page
            updatePage: function () {
                let me = this
                let oData = this.getData()

                let update = setInterval(() => {
                    me.getPageInfo()
                }, oData.refreshFrequency * 60 * 1000)
            },
            // 工作中心 api
            getWorkCenterInfo: function () {
                let me = this
                let oData = this.getData()

                $equipmentKanban.getWorkCenterInfo(
                    {
                        'site': oData.site,
                        'workCenter': oData.workCenter
                    },
                    function (res) {
                        oData.workCenterDesc = res.workCenterDesc
                        oData.targetMonthEfficiency = res.targetMonthEfficiency
                            ? res.targetMonthEfficiency + '%'
                            : ''
                        oData.targetMonthYield = res.targetMonthYield
                            ? res.targetMonthYield + '%'
                            : ''
                        oData.targetMonthUtilizationRate = res.targetMonthUtilizationRate
                            ? res.targetMonthUtilizationRate + '%'
                            : ''
                        oData.targetMonthOee = res.targetMonthOee ? res.targetMonthOee + '%' : ''
                        oData.targetDayEfficiency = res.targetDayEfficiency
                            ? res.targetDayEfficiency + '%'
                            : ''
                        oData.targetDayYield = res.targetDayYield ? res.targetDayYield + '%' : ''
                        oData.targetDayUtilizationRate = res.targetDayUtilizationRate
                            ? res.targetDayUtilizationRate + '%'
                            : ''
                        oData.targetDayOee = res.targetDayOee ? res.targetDayOee + '%' : ''
                        me.refresh()
                    },
                    me.showMessage
                )
            },
            // 設備狀態 api
            getResourceStatusInfo: function () {
                let me = this
                let i18N = this.getI18N()
                let oData = this.getData()
                let colorPalette = []

                $equipmentKanban.getResourceStatusInfo(
                    {
                        'site': oData.site,
                        'workCenter': oData.workCenter
                    },
                    function (res) {
                        oData.pieData = res.statusInfoList ? res.statusInfoList : []
                        oData.resourceTotalQty = res.resourceTotalQty

                        if (res.statusInfoList && res.statusInfoList.length != 0) {
                            res.statusInfoList.forEach(element => {
                                let color = oData.statusInfo[element.status].color
                                element.statusName = oData.statusInfo[element.status].name
                                colorPalette.push(color)
                            })
                        }
                        me.refresh()
                    },
                    me.showMessage
                )
                // 設置 狀態顏色
                this.byId('vizFramePie').setVizProperties({
                    plotArea: { colorPalette: colorPalette }
                })
            },
            // 本月平均 api
            getMonthEfficiency: function () {
                let me = this
                let i18N = this.getI18N()
                let oData = this.getData()
                let idArray = [
                    'avgMonthEfficiency',
                    'avgMonthYield',
                    'avgMonthUtilizationRate',
                    'avgMonthOee'
                ]
                let arr = []

                $equipmentKanban.getMonthEfficiency(
                    {
                        'site': oData.site,
                        'workCenter': oData.workCenter,
                        'attributeList': oData.attributeList
                    },
                    function (res) {
                        idArray.forEach(id => {
                            for (let key in res) {
                                if (id == key) {
                                    me.byId(id).setPercentage(Number(res[key]))
                                    arr.push({
                                        id: id,
                                        value: Number(res[key])
                                    })
                                }
                            }
                        })
                        me.changePercentageText(arr)
                        me.refresh()
                    },
                    me.showMessage
                )
            },
            // 本日平均 api
            getDayEfficiency: function () {
                let me = this
                let i18N = this.getI18N()
                let oData = this.getData()
                let idArray = [
                    'avgDayEfficiency',
                    'avgDayYield',
                    'avgDayUtilizationRate',
                    'avgDayOee']
                let arr = []

                $equipmentKanban.getDayEfficiency(
                    {
                        'site': oData.site,
                        'workCenter': oData.workCenter,
                        'attributeList': oData.attributeList
                    },
                    function (res) {
                        idArray.forEach(id => {
                            for (let key in res) {
                                if (id == key) {
                                    me.byId(id).setPercentage(Number(res[key]))
                                    arr.push({
                                        id: id,
                                        value: Number(res[key])
                                    })
                                }
                            }
                        })
                        me.changePercentageText(arr)
                        me.refresh()
                    },
                    me.showMessage
                )
            },
            // 本日綜合效率 table api
            getTableInfo: function () {
                let me = this
                let oData = this.getData()

                $equipmentKanban.getResourceEfficiency(
                    {
                        'site': oData.site,
                        'workCenter': oData.workCenter,
                        'attributeList': oData.attributeList
                    },
                    function (res) {
                        // 取得 狀態顏色
                        res.forEach(row => {
                            row.iconColor = oData.statusInfo[row.status].color
                            row.statusDesc = oData.statusInfo[row.status].name
                            if (row.status == 302) {
                                row.efficiency = 'NA'
                                row.yield = 'NA'
                                row.utilizationRate = 'NA'
                                row.oee = 'NA'
                                row.uph = 'NA'
                                row.hpu = 'NA'
                            }
                        })
                        oData.tableList = res
                        oData.totalPages = Math.ceil(oData.tableList.length / oData.pageCount)
                        oData.tableShowList = oData.tableList.slice(0, oData.pageCount)

                        me.refresh()
                    },
                    me.showMessage
                )
            },
            // 換頁
            changePage: function (oEvent) {
                let oData = this.getData()
                let oSource = oEvent.getSource()
                let id = oSource.getId()

                // 下一頁
                if (id.includes('next')) {
                    if (oData.totalPages > oData.currentPage) {
                        oData.tableShowList = oData.tableList.slice(oData.currentPage * oData.pageCount, oData.currentPage * oData.pageCount + oData.pageCount)
                        oData.currentPage++
                    }
                }
                // 前一頁
                if (id.includes('previous')) {
                    if (oData.currentPage > 1) {
                        oData.currentPage--
                        let startIndex = oData.currentPage - 1
                        oData.tableShowList = oData.tableList.slice(startIndex * oData.pageCount, startIndex * oData.pageCount + oData.pageCount)
                    }
                }
                this.refresh()
            },
            // 翻牌效果
            flipEffect: function () {
                let oTable = this.byId('table')
                let rows = oTable.getItems()

                rows.forEach(element => {
                    element.addStyleClass('flipEffect')
                })
                // _ 秒後 清除效果
                setTimeout(() => {
                    rows.forEach(element => {
                        element.removeStyleClass('flipEffect')
                    })
                }, 2000)
            },
            // 計算 table 為幾行
            getTableRowCount: function () {
                let oData = this.getData()
                let oTable = this.byId('table')
                let pageFooter = this.byId('pageContent')
                let sHeight = $(document).height()
                let sTop = $('#' + oTable.getId()).offset().top
                let pageHeight = $('#' + pageFooter.getId()).height()
                let tableHeader = 42
                let rowHeight = 33.47

                // 減掉 標題行 & 底部
                let h = sHeight - sTop - tableHeader - pageHeight

                oData.pageCount = Math.trunc(h / rowHeight)
            },
            changePercentageText: function (arr) {
                let me = this

                setTimeout(function () {
                    arr.forEach((el) => {
                        let id = me.byId(el.id).getId()
                        if (el.value == -1) {
                            el.value = 'NA'
                        } else {
                            el.value = el.value + '%'
                        }

                        $('#' + id)
                            .children('div[class="sapSuiteRMCVerticalAlignmentContainer sapSuiteRMCAlignCenter"]')
                            .children('div[class="sapSuiteRMCInnerContainer"]')
                            .children('div[class="sapSuiteRMCInsideLabel sapSuiteRMCFont sapSuiteRMCNeutralTextColor"]')
                            .text(el.value)
                    })
                }, 500)
            },
            changeText: function (text) {
                if (text == -1) {
                    text = '0'
                }

                return text + "%"
            },
            // 設定看板 開窗
            setting: function () {
                let me = this
                let oData = this.getData()
                let array = [0, 1]      // 工作中心 給 0, 狀態 給 1

                array.forEach(element => {
                    // 取得工作中心
                    $equipmentKanban.getAttribute(
                        {
                            'site': oData.site,
                            'type': element,
                            'activity': oData.activity
                        },
                        function (res) {
                            // 工作中心 table
                            if (element == 0) oData.workCenterTable = res
                            // 狀態 table
                            if (element == 1) {
                                res.forEach(row => {
                                    row.chiDesc = oData.statusInfo[row.status].name
                                })
                                oData.statusTable = res
                            }
                        },
                        me.showMessage
                    )
                })
                new setting().open(me)
            },
            // 刷新 table
            updateTable: function () {
                let me = this
                let oData = this.getData()
                let startIndex = oData.currentPage * oData.pageCount

                if (oData.updateTable) clearInterval(oData.updateTable)

                oData.updateTable = setInterval(() => {
                    if (oData.currentPage < oData.totalPages) {
                        oData.tableShowList = oData.tableList.slice(startIndex, startIndex + oData.pageCount)
                        oData.currentPage++
                    } else {
                        oData.currentPage = 1
                        oData.tableShowList = oData.tableList.slice(0, oData.pageCount)
                    }
                    me.refresh()
                    me.flipEffect()
                }, oData.listChangeTime * 60 * 1000)
            },
            // 刷新 工作中心
            refreshPage: function () {
                let me = this
                let oData = this.getData()
                oData.currentIndex = 0

                // 清除先前的計時
                if (oData.update) clearInterval(oData.update)

                oData.update = setInterval(() => {
                    let loop = oData.refreshLists.length
                    let req

                    if (oData.refreshFrequency) {
                        oData.currentIndex = oData.currentIndex + 1 >= loop ? 0 : oData.currentIndex + 1
                        req = oData.refreshLists[oData.currentIndex]

                        me.getPageInfo(req)
                        if (oData.totalPages > 1) me.updateTable()
                    } else clearInterval(oData.update)

                }, oData.refreshFrequency * 60 * 1000)
            },
        });
    }
);