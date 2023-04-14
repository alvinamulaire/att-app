sap.ui.define(
    [
        'fw/core/BaseController',
        'fw/fragment/TableSelectDialog',
        'fw/fragment/MultiTableSelectDialog',
        'att/view/ncReport/fragment/cancel',
        'att/view/ncReport/ncReportApi'
    ],
    function (BaseController, TableSelectDialog, MultiTableSelectDialog, cancel) {
        'use strict'

        return BaseController.extend('att.view.ncReport.ncReport', {
            onInit: function () {
                this.attachPatternMatched('ncReport', this.onRouteMatched)
            },
            onRouteMatched: function (oEvent) {
                let req = oEvent.getParameter('arguments')['?req']
                this.setModel({
                    site: this.getSite(),
                    user: this.getUser(),
                    operationList: [],
                    itemList: [],
                    ncList: [],
                    shopOrder: '',
                    operationNcInfoList: [],
                    ncInfoList: [],
                    table: [],
                    startDate: moment().subtract(6, 'days').format('YYYY-MM-DD 00:00'),
                    endDate: moment().format('YYYY/MM/DD 23:59'),
                    hiddenTop: false,
                    panelHeight: 0
                })

                this.setVizFrame1()
                this.setVizFrame2()
                if (req.fromOtherReport) {
                    this.fromOtherReport(req)
                }
            },
            fromOtherReport: function (req) {
                let me = this, oData = me.getData()
                if (req.operation) {
                    oData.operationList.push({ operation: req.operation })
                }
                if (req.shopOrder) {
                    oData.shopOrder = req.shopOrder
                }
                if (req.date) {
                    oData.startDate = req.date + ' 00:00'
                    oData.endDate = req.date + ' 23:59'
                }
                me.retrieve()
            },
            operationDialog: function (oEvent) {
                let me = this,
                    oData = me.getData()

                $ncReport.operation(oData.site, oData.user, function (res) {
                    new MultiTableSelectDialog().openDialog(oEvent.getSource(), res)
                }, me.showMessage)
            },
            itemDialog: function (oEvent) {
                let me = this,
                    oData = me.getData()

                $ncReport.item(oData.site, function (res) {
                    new MultiTableSelectDialog().openDialog(oEvent.getSource(), res)
                }, me.showMessage)
            },
            ncDialog: function (oEvent) {
                let me = this,
                    oData = me.getData()

                $ncReport.ncCode(oData.site, function (res) {
                    new MultiTableSelectDialog().openDialog(oEvent.getSource(), res)
                }, me.showMessage)
            },
            shopOrderDialog: function (oEvent) {
                let me = this,
                    oData = me.getData(),
                    data = {
                        site: oData.site,
                        startDateTime: oData.startDate + ':00',
                        endDateTime: oData.endDate + ':00'
                    }

                $ncReport.shopOrder(data, function (res) {
                    new TableSelectDialog().open(oEvent.getSource(), res)
                }, me.showMessage)
            },
            retrieve: function (oEvent) {
                let me = this,
                    oData = me.getData(),
                    oCancel = me.byId('isCancelledSelect'),
                    oCategory = me.byId('ncCategorySelect'),
                    i18n = this.getI18N()
                let dateRange = Date.parse(oData.endDate) - Date.parse(oData.startDate)

                // error : 日期區間 超過七天
                if (dateRange / (24 * 60 * 60 * 1000) > 7) this.error(i18n.getText("nc.report.error5"))

                if (moment(oData.startDate)
                    .isAfter(oData.endDate)) {
                    this.error('nc.report.error2')
                }

                let isCancelled = oCancel.getSelectedKey(),
                    category = oCategory.getSelectedKey()

                if (oData.operationList.length == 0 && oData.itemList.length == 0 &&
                    oData.ncList.length == 0 && me.strIsNullEmpty(oData.shopOrder) &&
                    me.strIsNullEmpty(isCancelled) && me.strIsNullEmpty(category)) {
                    me.error('nc.report.error1')
                }

                let data = {
                    site: oData.site,
                    shopOrder: oData.shopOrder,
                    itemList: oData.itemList.map(el => el.item),
                    operationList: oData.operationList.map(el => el.operation),
                    ncCodeList: oData.ncList.map(el => el.ncCode),
                    ncCategory: category,
                    isCancelled: isCancelled,
                    startDateTime: oData.startDate.replaceAll('/', '-') + ':00',
                    endDateTime: oData.endDate.replaceAll('/', '-') + ':00'
                }

                $ncReport.retrieve(data, function (res) {
                    oData.table = res.sfcNcDataInfoList
                    oData.operationNcInfoList = res.operationNcInfoList
                    oData.ncInfoList = res.ncInfoList
                    me.refresh()
                }, me.showMessage)

                me.setTableRowCountAuto('table')
            },
            cancelDialog: function (oEvent) {
                new cancel().open(oEvent, this)
            },
            toUpperCase: function (text) {
                if (text) {
                    return text.toUpperCase()
                }
                return text
            },
            // 匯出
            export: function () {
                let me = this
                let i18n = this.getI18N()
                let oData = this.getData()

                if (oData.table.length == 0) {
                    this.error('nc.report.error4')
                }

                // 文字垂直置中
                let alignment = {
                    vertical: 'middle',
                    horizontal: 'center',
                    wrapText: true
                }
                // 一般外框
                let thin_border = {
                    top: { style: 'thin' },
                    left: { style: 'thin' },
                    bottom: { style: 'thin' },
                    right: { style: 'thin' }
                }
                // 背景顏色
                let fill = {
                    fgColor: { argb: 'FFE66F' },
                    bgColor: { argb: '000000' },
                    type: 'pattern',
                    pattern: 'solid'
                }
                // 字體: 新細明體
                const fontName = 'Microsoft YaHei'

                let wb = new ExcelJS.Workbook()
                let ws = wb.addWorksheet('Sheet1', {
                    views: [{ showGridLines: true }],
                    properties: { defaultColWidth: 23 }
                })

                ws.addRow([i18n.getText('nc.report.label35') + ': ' + oData.startDate + ' ~ ' + oData.endDate])
                // 新增資料
                ws.addTable({
                    name: 'table',
                    ref: 'A3',
                    headerRow: true,
                    columns: [
                        {
                            name: i18n.getText('nc.report.label12'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label13'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label2'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label14'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label15'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label16'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label3'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label17'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label18'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label5'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label19'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label20'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label21'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label22'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label23'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label24'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label25'),
                            filterButton: true
                        }, {
                            name: i18n.getText('nc.report.label6'),
                            filterButton: true
                        }
                    ],
                    rows: oData.table.map(el => {
                        return [
                            el.date,
                            el.time,
                            el.item,
                            el.itemDesc,
                            el.shopOrder,
                            el.shopOrderErpType,
                            el.operation,
                            el.operationDesc,
                            el.sfc,
                            el.ncCode,
                            el.ncCodeDesc,
                            el.actionCode,
                            el.actionCodeDesc,
                            Number(el.ncQty),
                            el.comments,
                            el.user,
                            el.userName,
                            el.isCancelled
                        ]
                    })
                })

                ws._rows[2]._cells.forEach(cell => {
                    cell.fill = fill
                })

                for (let i = 3; i < ws._rows.length; i++) {
                    ws._rows[i]._cells.forEach((cell, j) => {
                        if (j == 13) {
                            cell.numFmt = '0.00'
                        }
                    })
                }

                ws.getRow(3).alignment = alignment

                // 每 row 樣式設定
                ws.eachRow((row, index) => {
                    row.font = {
                        name: fontName,
                        size: 12,
                        bold: false
                    }
                    row.eachCell(
                        {
                            includeEmpty: true
                        },
                        function (cell) {
                            cell.border = thin_border
                        })
                })

                // 匯出 excel
                doExport(i18n.getText('nc.report.label1') + '-' + moment().format('YYYY/MM/DD'))

                async function doExport(name) {
                    const buffer = await wb.xlsx.writeBuffer()
                    const fileType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
                    const blob = new Blob([buffer], { type: fileType })
                    saveAs(blob, name + '.xlsx')
                }
            },
            // 清除
            clear: function () {
                let me = this,
                    oData = this.getData(),
                    excludes = ['hiddenTop', 'panelHeight']

                this.messageBox(
                    {
                        key: 'g.warning1',
                        type: 'warning'
                    },
                    function () {
                        me.clearData(oData, excludes)

                        oData.startDate = moment().subtract(6, 'd').format('YYYY-MM-DD 00:00')
                        oData.endDate = moment().format('YYYY/MM/DD 23:59')
                        me.refresh()
                    }
                )
            },
            expandChart: function (oEvent) {
                let me = this,
                    oData = this.getData(),
                    parameter = {
                        customHeight: 0
                    }

                var panelId = this.byId('chartPanel').getId(),
                    panelHeight = $('#' + panelId).height(),
                    panelHeaderHeight = $('#' + panelId + ':first-child').height()

                if (oData.panelHeight == 0) {
                    oData.panelHeight = panelHeight - panelHeaderHeight
                }

                oData.hiddenTop = !oData.hiddenTop

                if (oData.hiddenTop) {
                    parameter.customHeight = oData.panelHeight
                } else {
                    parameter.customHeight = oData.panelHeight * -1
                }
                me.setTableRowCountAuto('table', parameter)
            },
            // 直方圖設定
            setVizFrame1: function () {
                var me = this,
                    I18N = this.getI18N()

                // chart配置
                var vizProperties = {
                    plotArea: {
                        dataLabel: {
                            visible: true,
                            style: {
                                color: '#000000'
                            }
                        },
                        dataPointStyle: {
                            rules: [
                                // 重工
                                {
                                    dataContext: [{ MeasureNamesDimension: 'reworkQty' }],
                                    properties: {
                                        color: 'sapUiChartPaletteSequentialHue2Light2'
                                    },
                                    displayName: I18N.getText('nc.report.label28')
                                },
                                // 報廢
                                {
                                    dataContext: [{ MeasureNamesDimension: 'scrapQty' }],
                                    properties: {
                                        color: 'sapUiChartPaletteSemanticBad'
                                    },
                                    displayName: I18N.getText('nc.report.label29')
                                }
                            ]
                        }
                    },
                    categoryAxis: {
                        visible: true,
                        title: {
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#000000'
                            }
                        }
                    },
                    valueAxis: {
                        visible: true,
                        title: {
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#000000'
                            }
                        }
                    },
                    legend: {
                        visible: true,
                        drawingEffect: 'glossy',
                        title: {
                            text: 'legend',
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#000000'
                            }
                        },
                        hoverShadow: {
                            color: '#ADADAD'
                        },
                        hoverSelectedShadow: {
                            color: '#E0E0E0'
                        }
                    },
                    title: {
                        visible: true,
                        text: I18N.getText('ne.report.label26'),
                        style: {
                            color: '#000000'
                        }
                    },
                    interaction: {
                        syncValueAxis: false
                    }
                }
                this.byId('viz1').setVizType('column')
                this.byId('viz1').setVizProperties(vizProperties)
            },
            setVizFrame2: function () {
                var me = this,
                    I18N = this.getI18N()

                // chart配置
                var vizProperties = {
                    plotArea: {
                        dataLabel: {
                            visible: true,
                            style: {
                                color: '#000000'
                            }
                        },
                        dataPointStyle: {
                            rules: [
                                // 不良數量
                                {
                                    dataContext: [{ MeasureNamesDimension: 'ncQty' }],
                                    properties: {
                                        color: 'sapUiChartPaletteSemanticBad'
                                    },
                                    displayName: I18N.getText('nc.report.label30')
                                }
                            ]
                        },
                        lineRenderer: function (oMark) {
                            oMark.graphic.color = '#FF5151'
                        }
                    },
                    categoryAxis: {
                        visible: true,
                        title: {
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#000000'
                            }
                        }
                    },
                    valueAxis: {
                        visible: true,
                        title: {
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#000000'
                            }
                        }
                    },
                    legend: {
                        visible: true,
                        drawingEffect: 'glossy',
                        title: {
                            text: 'legend',
                            visible: false
                        },
                        label: {
                            style: {
                                color: '#000000'
                            }
                        },
                        hoverShadow: {
                            color: '#ADADAD'
                        },
                        hoverSelectedShadow: {
                            color: '#E0E0E0'
                        }
                    },
                    title: {
                        visible: true,
                        text: I18N.getText('ne.report.label27'),
                        style: {
                            color: '#000000'
                        }
                    },
                    interaction: {
                        syncValueAxis: false
                    }
                }
                this.byId('viz2').setVizType('line')
                this.byId('viz2').setVizProperties(vizProperties)
            }
        })
    }
)
