sap.ui.define(
  [
    'fw/core/BaseController',
    'att/view/productionKanban/fragment/kanbanSetting',
    'att/view/productionKanban/productionKanbanApi'
  ],
  function (BaseController, kanbanSetting) {
    'use strict'
    return BaseController.extend('att.view.productionKanban.productionKanban', {
      onInit: function () {
        this.attachPatternMatched('productionKanban', this.onRouteMatched)
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
          refreshLists: '',       // 循環更新的資料
          item: '',
          itemDesc: '',
          kanbanType: '',         // 看板類型
          monthWipUpper: '',      // 上限 KPI
          monthWipLower: '',      // 下限 KPI
          totalInQty: '',         // 在製生產數
          totalInReworkQty: '',     // 在製重工數
          monthWipRework: '',       // 在製重工數 KPI
          totalInHoldQty: '',       // 在製保留數
          monthWipHold: '',         // 在製保留數 KPI
          monthlyActualProductionQty: '',     // 月 實際生產
          monthlyActualProductionKpi: '',     // 月 實際生產 KPI
          monthlyAchievementRate: '',         // 月 達成率
          monthAchievementRate: '',           // 月 達成率 KPI
          monthlyThruYield: '',               // 月 直通良率
          monthFpy: '',                       // 月 直通良率 KPI
          monthlyYield: '',           // 月 良率
          monthYield: '',             // 月 良率 KPI
          monthlyQtyScrapped: '',     // 月 報廢數
          monthScrap: '',             // 月 報廢數 KPI
          monthlyReworkRate: '',      // 月 重工率
          monthReworkRate: '',        // 月 重工率 KPI
          monthlyReworkQty: '',       // 月 重工數
          monthRework: '',            // 月 重工數 KPI
          actualProductionQty: '',       // 日 實際生產
          actualProductionKpi: '',       // 日 實際生產 KPI
          achievementRate: '',           // 日 達成率
          dayAchievementRate: '',        // 日 達成率 KPI
          thruYield: '',       // 日 直通良率
          dayFpy: '',          // 日 直通良率 KPI
          yield: '',           // 日 良率
          dayYield: '',        // 日 良率 KPI
          qtyScrapped: '',     // 日 報廢數
          dayScrap: '',        // 日 報廢數 KPI
          reworkRate: '',      // 日 重工率
          dayReworkRate: '',   // 日 重工率 KPI
          reworkQty: '',       // 日 重工數
          dayRework: '',       // 日 重工數 KPI
          colData: [],         // 狀態資訊
          currentIndex: 1,     // 當前 page data 參數
        })

        // 圖型 配置
        this.byId('vizFrameCol').setVizProperties({
          categoryAxis: {
            title: { visible: false },
            label: { style: { color: '#ffffff' } }
          },
          valueAxis: { title: { visible: false, } },
          title: { style: { color: '#ffffff' } },
          // 圖形區
          plotArea: {
            // 柱狀上的資料標籤
            dataLabel: {
              visible: true,
              style: { color: '#ffffff', fontSize: '16px' }
            },
            // 個別資料的設定, 顏色, 文字
            dataPointStyle: {
              rules: [
                // 在製
                {
                  dataContext: [{ MeasureNamesDimension: 'inQtyStr' }],
                  properties: { color: '#2828FF' },
                  displayName: i18N.getText('productionKanban.label17')
                },
                // 良品
                {
                  dataContext: [{ MeasureNamesDimension: 'qtyCompletedStr' }],
                  properties: { color: '#00BB00' },
                  displayName: i18N.getText('productionKanban.label18')
                },
                // 不良
                {
                  dataContext: [{ MeasureNamesDimension: 'qtyScrappedStr' }],
                  properties: { color: '#FF0000' },
                  displayName: i18N.getText('productionKanban.label19')
                }
              ]
            }
          },
          // feed
          legend: {
            // feed 標籤
            label: {
              // 顏色, 字體大小
              style: { color: '#ffffff', }
            },
            hoverShadow: { color: 'none' },
            hoverSelectedShadow: { color: 'none' }
          },
          // feed 群組
          legendGroup: {
            layout: { // 位置布局
              position: 'right',
              alignment: 'center'
            }
          }
        })
        this.refresh()
      },
      // 開窗 看板設定
      setting: function () {
        let me = this
        let oData = this.getData()

        $productionKanban.getAttribute(
          {
            'site': oData.site,
            'type': 2,  // 物料+途程給 2
            'activity': oData.activity
          },
          function (res) {
            // 設定 物料 table
            oData.itemTable = res || []
          },
          me.showMessage
        )
        new kanbanSetting().open(me)
      },
      // 取得 所有 資訊
      getPageInfo: function (req) {
        let me = this
        let i18N = this.getI18N()
        let oData = this.getData()
        let title = `${req.router} / ${req.routerRevision}`

        oData.item = req.item
        oData.itemDesc = req.itemDesc
        req.site = oData.site

        $productionKanban.getKanbanInfo(
          req,
          function (res) {
            oData.updatedTime = moment().format('YYYY/MM/DD hh:mm:ss')
            oData.colData = res.routerList
            Object.assign(oData, res)

            // 設定 圖表 title
            me.byId('vizFrameCol').setVizProperties({
              title: { text: title }
            })
            // 檢查數值
            me.check()
          },
          me.showMessage
        )
      },
      // 判斷 大於小於, 數值添加 , 
      check: function () {
        let me = this
        let oData = this.getData()
        let dotArray = [
          'monthWipUpper', 'monthWipLower', 'totalInQty',   // 上下限 KPI
          'totalInReworkQty', 'monthWipRework',             // 在製重工
          'totalInHoldQty', 'monthWipHold',                 // 在製保留
          'monthlyActualProductionQty', 'monthlyActualProductionKpi',
          'monthlyQtyScrapped', 'monthScrap',     // 報廢數
          'monthlyReworkQty', 'monthRework',      // 重工數 
          'actualProductionQty', 'actualProductionKpi',   // 實際生產
          'qtyScrapped', 'dayScrap',
          'reworkQty', 'dayRework',
          'actualProductionQty', 'actualProductionKpi',
        ]
        let percentageArray = [
          'monthlyAchievementRate', 'monthAchievementRate', // 本月 達成率
          'monthlyThruYield', 'monthFpy',       // 直通良率
          'monthlyYield', 'monthYield',         // 良率
          'monthlyReworkRate', 'monthReworkRate',   // 重工率
          'achievementRate', 'dayAchievementRate',    // 本日 達成率
          'thruYield', 'dayFpy',
          'yield', 'dayYield',
          'reworkRate', 'dayReworkRate',
        ]
        // [比對值, KPI, id]
        let checkGreaterThanKpi = [
          ['totalInQty', 'monthWipUpper', 'monthWipLower', 'text1'],
          ['totalInReworkQty', 'monthWipRework', 'text2'],
          ['totalInHoldQty', 'monthWipHold', 'text3'],
          ['monthlyQtyScrapped', 'monthScrap', 'text8'],
          ['monthlyReworkRate', 'monthReworkRate', 'text9'],
          ['monthlyReworkQty', 'monthRework', 'text10'],
          ['qtyScrapped', 'dayScrap', 'text15'],
          ['reworkRate', 'dayReworkRate', 'text16'],
          ['reworkQty', 'dayRework', 'text17'],
        ]
        // [比對值, KPI, id]
        let checkLowerThanKpi = [
          ['monthlyActualProductionQty', 'monthlyActualProductionKpi', 'text4'],
          ['monthlyAchievementRate', 'monthAchievementRate', 'text5'],
          ['monthlyThruYield', 'monthFpy', 'text6'],
          ['monthlyYield', 'monthYield', 'text7'],
          ['actualProductionQty', 'actualProductionKpi', 'text11'],
          ['achievementRate', 'dayAchievementRate', 'text12'],
          ['thruYield', 'dayFpy', 'text13'],
          ['yield', 'dayYield', 'text14'],
        ]
        // 大於 KPI
        checkGreaterThanKpi.forEach(element => {
          let id = element[3] ? element[3] : element[2]
          let value = Number(oData[element[0]])
          let kpi = Number(oData[element[1]])
          let kpi2 = oData[element[2]] ? Number(oData[element[2]]) : ''

          if (element.length == 4) {
            // 在製生產數
            if (kpi < value || kpi2 > value) me.setRedBackground(id)
          } else {
            if (value > kpi) me.setRedBackground(id)
          }
        })
        // 小於 KPI
        checkLowerThanKpi.forEach(element => {
          let value = Number(oData[element[0]])
          let kpi = Number(oData[element[1]])
          if (value < kpi) me.setRedBackground(element[2])
        })
        // 千位數字加 , 
        dotArray.forEach(element => {
          oData[element] = oData[element] ? Number(oData[element]).toLocaleString() : ''
        })
        // 百分比 四捨五入至小數點後兩位
        percentageArray.forEach(element => {
          oData[element] = oData[element] ? Number(oData[element]).toFixed(2) + '%' : ''
        })
        this.refresh()
      },
      // 設置 紅色警示
      setRedBackground: function (id) {
        let me = this
        me.byId(id).addStyleClass('redBackground')
        me.refresh()
      },
      // 刷新
      refreshPage: function () {
        let me = this
        let oData = this.getData()
        oData.currentIndex = 0

        if (oData.update) clearInterval(oData.update)

        oData.update = setInterval(() => {
          let loop = oData.refreshLists.length
          let req

          if (oData.refreshFrequency) {
            oData.currentIndex = oData.currentIndex + 1 >= loop ? 0 : oData.currentIndex + 1
            req = oData.refreshLists[oData.currentIndex]

            me.getPageInfo(req)
          } else clearInterval(oData.update)

        }, oData.refreshFrequency * 60 * 1000)
      },
    });
  }
);