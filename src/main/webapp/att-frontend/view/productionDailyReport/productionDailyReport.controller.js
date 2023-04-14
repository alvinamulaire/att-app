sap.ui.define(
  [
    "fw/core/BaseController",
    "fw/fragment/TableSelectDialog",
    "att/view/productionDailyReport/fragment/shopOrder",
    "att/view/productionDailyReport/fragment/productionProcess",
    "att/view/productionDailyReport/productionDailyReportApi",
  ],
  function (BaseController, TableSelectDialog, shopOrder, productionProcess) {
    "use strict";

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.productionDailyReport.productionDailyReport", {
      onInit: function () {
        this.attachPatternMatched("productionDailyReport", this.onRouteMatched);
      },
      onRouteMatched: function () {
        this.setModel({
          site: this.getSite(),
          startDate: moment().format('YYYY-MM-DD 00:00'),
          endDate: moment().format('YYYY-MM-DD 23:59'),
          item: "",
          itemList: [],
          operation: "",
          shopOrder: "",
          erpOperation: "",
          router: "", // 途程 後來捨棄不用
          production: [],   // 圖形資料
          table: [],
          shopOrderType: ""
        });

        // 產能狀況 圖表配置
        this.byId('performanceChart').setVizProperties({
          plotArea: {
            gap: { groupSpacing: 2 },         // 日期間間距
            colorPalette: ['#0000E3', '#00BB00', '#FF9224', '#FF0000']     // columns 顏色
          },
          // 測量值 軸
          valueAxis: {
            title: { visible: false, }   // 外部軸文字顯示
          },
        })
        // 產能效率 圖表配置
        this.byId("efficiencyChart").setVizProperties({
          plotArea: {
            dataLabel: { formatString: '0.00%' },
            colorPalette: ['#00BB00', '#FF0000', '#FF9224', '#0000E3']
          },
          // 測量值 軸
          valueAxis: {
            label: { formatString: '0%' },
            title: { visible: false, }   // 外部軸文字顯示
          },
        })
        // 圖表共用配置
        let array = ['performanceChart', 'efficiencyChart']
        array.forEach(chartId => {
          this.byId(chartId).setVizProperties({
            title: { visible: false },
            legendGroup: {      // 小標題群組
              layout: {
                position: 'bottom',   // 位置放下
                alignment: 'center'   // 居中
              }
            },
            // x 軸
            categoryAxis: {
              title: { visible: false }   // 外部軸文字顯示
            }
          })
        })

      },
      // 開窗
      openDialog: function (oEvent) {
        let me = this;
        let oData = this.getData();
        let oSource = oEvent.getSource();
        let id = oSource.getId()

        // 物料
        if (id.includes("item")) {
          $productionDailyReport.getItem(oData, (res) => {
            new TableSelectDialog().open(oSource, res, (data) => {
              me.refresh()
            });
          },
            me.showMessage
          )
        }
        // 作業站
        if (id.includes("operation")) {
          $productionDailyReport.getOperation(oData, (res) => {
            new TableSelectDialog().open(oSource, res, (data) => {
              oData.operation = data.operation
              me.refresh()
            });
          },
            me.showMessage
          )
        }
        // ERP 操作
        if (id.includes("erpOperation")) {
          $productionDailyReport.getErpOperation(oData, (res) => {
            let resData = []
            res.forEach(element => {
              resData.push({
                erpOperation: element
              })
            })
            new TableSelectDialog().open(oSource, resData, (data) => {
              oData.erpOperation = data.erpOperation
              me.refresh()
            });
          },
            me.showMessage
          )
        }
        // 工單號碼
        if (id.includes("shopOrder")) {
          // 取得工單類型
          $productionDailyReport.getShopOrderType(
            oData,
            (res) => {
              oData.auartOptions = [{ key: "", name: "" }],
                res.forEach(element => {
                  if (element.dataValue) {
                    oData.auartOptions.push({
                      key: element.dataValue,
                      name: element.dataTag
                    })
                  }
                });
            },
            me.showMessage
          )

          new shopOrder().open(me);
        }
      },
      // 檢索
      search: function () {
        let me = this
        let oData = this.getData()
        let i18n = this.getI18N()
        let dateRange = Date.parse(oData.endDate) - Date.parse(oData.startDate)
        let dayRange = moment(oData.endDate).diff(moment(oData.startDate), 'day') + 1

        this.isEmpty(
          [oData.startDate, oData.endDate],
          ['productionDailyReport.label36', 'productionDailyReport.label37']
        )
        // error : 日期結束不可大於開始
        if (moment(oData.startDate).isAfter(oData.endDate, 'second')) this.error(i18n.getText('productionDailyReport.warning1'))
        // error : 檢索條件至少一筆
        if (oData.itemList.length == 0 && !oData.operation && !oData.shopOrder && !oData.erpOperation) this.error(i18n.getText('g.warning2'))
        // error : 日期區間 超過七天
        if (dateRange / (24 * 60 * 60 * 1000) > 7) this.error(i18n.getText("productionDailyReport.warning4"))

        // 清空指定日期內的表格資料
        oData.production = []

        // 新增 圖形 資料結構
        for (let i = 0; i < dayRange; i++) {
          let date = moment(oData.startDate).add(i, 'd').format('YYYY/MM/DD')
          oData.production.push({
            date: date,
            totalStarted: "",
            totalRework: "",
            totalCompleted: "",
            totalScrapped: "",
            totalYield: "",
            totalscrapRate: "",
            totalreworkRate: "",
            totalthroughRate: ""
          })
        }

        $productionDailyReport.search(
          {
            "site": oData.site,
            "startDate": oData.startDate + ":00",
            "endDate": oData.endDate + ":59",
            "itemList": oData.itemList.map(element => element.item),
            "shopOrder": oData.shopOrder,
            "operation": oData.operation,
            "erpOperation": oData.erpOperation,
            "router": oData.router
          },
          (res) => {
            res.forEach(row => {
              row.yield = String(row.yield) + '%'
              row.scrapRate = String(row.scrapRate) + '%'
              row.throughRate = String(row.throughRate) + '%'
              row.reworkRate = String(row.reworkRate) + '%'

              oData.production.forEach(element => {
                if (element.date == row.date) {
                  // 投入數
                  element.totalStarted = Number(element.totalStarted) + Number(row.qtyStarted)
                  // 產出數
                  element.totalCompleted = Number(element.totalCompleted) + Number(row.qtyCompleted)
                  // 重工數
                  element.totalRework = Number(element.totalRework) + Number(row.qtyRework)
                  // 報廢數
                  element.totalScrapped = Number(element.totalScrapped) + Number(row.qtyScrapped)

                  // 每日良率
                  element.totalYield = (element.totalStarted - element.totalScrapped) / element.totalStarted
                  // 每日報廢率
                  element.totalScrapRate = element.totalScrapped / element.totalStarted
                  // 每日重工
                  element.totalReworkRate = element.totalRework / element.totalStarted
                  // 每日直通
                  element.totalThroughRate = (element.totalStarted - element.totalScrapped - element.totalRework) / element.totalStarted
                }
              })
            })
            oData.table = res

            me.refresh()
          },
          me.showMessage
        )
      },
      // 開窗 生產歷程
      producitonProcess: function (oEvent) {
        let me = this
        let oData = this.getData()
        let oSource = oEvent.getSource()
        let index = oSource.getParent().getBindingContext('undefined').sPath.split('/')[2]
        let startDateArray = oData.startDate.split(' ')
        let endDateArray = oData.endDate.split(' ')     // ['2022-03-55', '12:34']
        let date = oData.table[index].date.replace(/\//g, '-')

        $productionDailyReport.getDetail(
          {
            "site": oData.site,
            "startDate": startDateArray[0] == date ? `${date} ${startDateArray[1]}:00` : `${date} 00:00:00`,
            "endDate": endDateArray[0] == date ? `${date} ${endDateArray[1]}:00` : `${date} 23:59:59`,
            "shopOrder": oData.table[index].shopOrder,
            "operation": oData.table[index].operation,
            "router": oData.table[index].router,
            "routerRevision": oData.table[index].routerRevision
          }
          ,
          (res) => {
            oData.detailLists = res
            new productionProcess().open(me)
          },
          me.showMessage
        )
      },
      // 不良明細
      defectLoss: function (oEvent) {
        let me = this
        let i18n = this.getI18N()
        let oData = this.getData()
        let oSource = oEvent.getSource()
        let index = oSource.getParent().getBindingContext('undefined').sPath.split('/')[2]
        let date = oData.table[index].date.replace(/\//g, '-');
        let shopOrder = oData.table[index].shopOrder;
        let operation = oData.table[index].operation;
        window.open(window.location.href.split('#')[0] + `#ncReport?ACTIVITY_ID=Z_RM06&fromOtherReport=true&date=${date}&shopOrder=${shopOrder}&operation=${operation}`);
      },
      // 匯出
      export: function () {
        let i18n = this.getI18N()
        let oData = this.getData();

        //日報表為空值
        if (oData.table.length == 0) this.error(i18n.getText('productionDailyReport.warning5'))

        // 文字垂直置中
        let alignment = {
          vertical: 'middle',
          horizontal: 'center',
          wrapText: true
        };
        // 一般外框
        let thin_border = {
          top: { style: 'thin' },
          left: { style: 'thin' },
          bottom: { style: 'thin' },
          right: { style: 'thin' }
        }
        // 填充背景顏色
        let fill = {
          // 淺橘
          lightOrange: {
            fgColor: { argb: 'FFDAC8' },
            bgColor: { argb: '000000' },
            type: 'pattern',
            pattern: 'solid',
          },
        }
        // 字體: 新細明體
        const MingLiu = "新細明體"
        // 建立 excel 物件
        let wb = new ExcelJS.Workbook();
        // 新增工作表
        let ws = wb.addWorksheet(i18n.getText('productionDailyReport.title'), {
          // 是否顯示網格
          views: [{ showGridLines: true }],
          // 預設寬度
          properties: { defaultColWidth: 23 }
        });
        let letters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
        let colsTitles = [
          i18n.getText('g.date'),
          i18n.getText('productionDailyReport.label1'),
          i18n.getText('g.materialDesc'),
          i18n.getText('productionDailyReport.label15'),
          i18n.getText('productionDailyReport.label16'),
          i18n.getText('productionDailyReport.label17'),
          i18n.getText('productionDailyReport.label18'),
          i18n.getText('productionDailyReport.label19'),
          i18n.getText('productionDailyReport.label20'),
          i18n.getText('productionDailyReport.label21'),
          i18n.getText('productionDailyReport.label22'),
          i18n.getText('productionDailyReport.label23'),
          i18n.getText('productionDailyReport.label3'),
          i18n.getText('productionDailyReport.label24'),
          i18n.getText('productionDailyReport.label25'),
          i18n.getText('productionDailyReport.label26'),
          i18n.getText('productionDailyReport.label27'),
          i18n.getText('productionDailyReport.label28'),
          i18n.getText('productionDailyReport.label13'),
          i18n.getText('productionDailyReport.label29'),
          i18n.getText('productionDailyReport.label12'),
          i18n.getText('productionDailyReport.label30'),
          i18n.getText('productionDailyReport.label31'),
          i18n.getText('productionDailyReport.label32'),
          i18n.getText('productionDailyReport.label33'),
        ]

        // 資料區間
        let date = ws.getCell('A1');
        date.value = `${i18n.getText('productionDailyReport.label14')}: ${oData.startDate} ~ ${oData.endDate}`

        colsTitles.forEach((col, index) => {
          // 取得 cell 路徑
          let titlePath = ws.getCell(`${letters[index]}3`)
          // 設定標題文字
          titlePath.value = col
          // 設定樣式
          titlePath.fill = fill.lightOrange
          titlePath.border = thin_border
        })

        // 新增 row 資料
        oData.table.forEach(row => {
          var yieldRate = row.yield.replace('%', '') / 100
          var scrapRate = row.scrapRate.replace('%', '') / 100
          var throughRate = row.throughRate.replace('%', '') / 100
          var reworkRate = row.reworkRate.replace('%', '') / 100

          ws.addRow([
            row.date,
            row.item,
            row.itemDesc,
            row.shopOrderType,
            row.shopOrder,
            row.router,
            row.routerRevision,
            row.routerDesc,
            row.stepId,
            row.operation,
            row.operationDesc,
            row.isRework,
            row.erpOperation,
            row.qtyStarted,
            row.qtyCompleted,
            row.qtyScrapped,
            row.qtyRework,
            Number(yieldRate),
            Number(scrapRate),
            Number(throughRate),
            Number(reworkRate),
            row.laborH,
            row.laborM,
            row.uph,
            Number(row.hpu),
          ])
        })

        // 每 row 樣式設定
        ws.eachRow((row, rowNumber) => {
          if (rowNumber > 2) {
            row.alignment = alignment;
            row.font = {
              name: MingLiu,
              size: 12,
              bold: false
            };
            row.eachCell(
              {
                includeEmpty: true
              },
              function (cell, colNumber) {
                // 良率, 直通率 ... 轉為百分比數值
                if (17 < colNumber && colNumber < 22) cell.numFmt = '0.00%'
                // HPU 輸出格式轉為數值
                if (colNumber == 25) cell.numFmt = '0.00'

                cell.border = thin_border
              });
          }
        });

        // 匯出 excel
        doExport(oData.item + i18n.getText('productionDailyReport.title'));

        async function doExport(name) {
          const buffer = await wb.xlsx.writeBuffer();
          const fileType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
          const blob = new Blob([buffer], { type: fileType });
          saveAs(blob, name + '.xlsx');
        }
      },
      // 清除
      clear: function () {
        let me = this;
        let oData = this.getData();
        let excludes = []

        this.messageBox(
          {
            key: 'g.warning1',
            type: 'warning'
          },
          () => {
            me.clearData(oData, excludes)
            oData.startDate = moment().subtract(6, 'd').format('YYYY-MM-DD 00:00')
            oData.endDate = moment().format('YYYY-MM-DD 23:59')
            me.refresh()
          }
        )
      },
    });
  }
);
