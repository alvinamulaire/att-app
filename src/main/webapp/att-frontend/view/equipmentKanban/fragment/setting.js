sap.ui.define(
  [
    "sap/ui/base/Object",
    "sap/ui/core/Fragment",
    "sap/ui/model/json/JSONModel",
    "fw/fragment/TableSelectDialog",
    'att/view/equipmentKanban/equipmentKanbanApi'
  ],
  function (Object, Fragment, JSONModel, TableSelectDialog) {
    "use strict";

    return Object.extend("att.view.equipmentKanban.fragment.setting", {
      open: function (me) {
        this.me = me;
        let i18N = me.getI18N()
        let meData = me.getData()

        // fragment id, control/element id
        let dialog = Fragment.byId("setting", "settingDialog")

        // esc 關閉, dialog 並未清除, 開啟前先清除
        if (dialog) {
          dialog.destroy()
          dialog = null
        }

        // 取得 暫存資料
        let refreshFrequency = localStorage.getItem('refreshFrequency')
        let pageRefreshFrequency = localStorage.getItem('pageRefreshFrequency')
        let kanbanType = localStorage.getItem('kanbanType')

        if (!dialog) {
          Fragment.load(
            {
              name: "att.view.equipmentKanban.fragment.setting",
              type: "XML",
              controller: this,
              id: "setting",
            }).then((oDialog) => {

              this.dialog = oDialog;
              // 開窗 model
              oDialog.setModel(
                new JSONModel({
                  site: meData.site,
                  statusTable: meData.statusTable,
                  workCenterTable: meData.workCenterTable,
                  refreshFrequency: refreshFrequency || 10,
                  pageRefreshFrequency: pageRefreshFrequency || 2,
                  kanbanType: kanbanType == null ? true : JSON.parse(kanbanType),  // true 自動; false 手動
                  statusTypeOptions: [
                    { key: '0', name: i18N.getText('equipmentKanban.label30') }
                  ]
                }, "dialog")
              )
              // 開窗載入 i18n
              oDialog.setModel(me.getModel("i18n"), "i18n")
              oDialog.open()
            });
        }
        return this
      },
      // 關閉畫面
      close: function (oEvent) {
        this.dialog.destroy()
        this.dialog = ''
      },
      add: function (type) {
        let oData = this.dialog.getModel().getData()
        let dialog = Fragment.byId("setting", "settingDialog")
        let oModel = dialog.getModel()

        if (type == 0) oData.workCenterTable.push({})
        if (type == 1) oData.statusTable.push({ statusType: '0' })
        oModel.refresh()
      },
      minus: function (type) {
        let oData = this.dialog.getModel().getData()
        let dialog = Fragment.byId("setting", "settingDialog")
        let oModel = dialog.getModel()
        let tableId = type == 0 ? 'workCenterTable' : 'statusTable'
        let oTable = Fragment.byId("setting", tableId)
        let indices = oTable.getSelectedIndices()

        if (indices.length > 0) {
          indices.reverse().forEach((index) => {
            oData[tableId].splice(index, 1);
          });
        }
        oTable.clearSelection()
        oModel.refresh()
      },
      // 開窗
      openDialog: function (oEvent) {
        let me = this.me
        let i18n = me.getI18N()
        let dialog = Fragment.byId("setting", "settingDialog")
        let oModel = dialog.getModel()
        let oData = this.dialog.getModel().getData()
        let oSource = oEvent.getSource()
        let id = oSource.getId()
        let index = oSource.getBindingContext(undefined).getPath().split('/')[2]

        // 工作中心
        if (id.includes('workCenter')) {
          $equipmentKanban.getWorkCenter(oData, (res) => {
            new TableSelectDialog().open(oSource, res, (data) => {
              oData.workCenterTable[index].description = data.description
            })
          },
            me.showMessage
          )
        }
        // 狀態
        if (id.includes('status')) {
          let res = [
            { status: 0, engDesc: 'UnKnown', chiDesc: i18n.getText('resourceStatus.0') },
            { status: 1, engDesc: 'Productive', chiDesc: i18n.getText('resourceStatus.1') },
            { status: 2, engDesc: 'StandBy', chiDesc: i18n.getText('resourceStatus.2') },
            { status: 3, engDesc: 'Engineering', chiDesc: i18n.getText('resourceStatus.3') },
            { status: 4, engDesc: 'Scheduled Down', chiDesc: i18n.getText('resourceStatus.4') },
            { status: 5, engDesc: 'Unscheduled Down', chiDesc: i18n.getText('resourceStatus.5') },
            { status: 6, engDesc: 'Non-scheduled', chiDesc: i18n.getText('resourceStatus.6') },
            { status: 'P01', engDesc: 'Repair', chiDesc: i18n.getText('resourceStatus.P01') },
            { status: 301, engDesc: 'Enabled', chiDesc: i18n.getText('resourceStatus.301') },
            { status: 302, engDesc: 'Disabled', chiDesc: i18n.getText('resourceStatus.302') },
            { status: 303, engDesc: 'Hold', chiDesc: i18n.getText('resourceStatus.303') },
            { status: 'HOLD_YLD_RATE_R', engDesc: 'Hold Yield Rate', chiDesc: i18n.getText('resourceStatus.HOLD_YLD_RATE_R') },
            { status: 'HOLD_CONSEC_NC_R', engDesc: 'Hold Consec NC', chiDesc: i18n.getText('resourceStatus.HOLD_CONSEC_NC_R') },
            { status: 'HOLD_SPC_VIOL_R', engDesc: 'Hold SPC Viol', chiDesc: i18n.getText('HOLD_SPC_VIOL_R') },
            { status: 'HOLD_SPC_WARN_R', engDesc: 'Hold SPC Warn', chiDesc: i18n.getText('resourceStatus.HOLD_SPC_WARN_R') },
          ]
          new TableSelectDialog().open(oSource, res, (data) => {
            // 工程 或 保養 預設為 計畫性
            oData.statusTable[index].statusType = data.status == 3 || data.status == 4 ? '0' : '1'
            oData.statusTable[index].chiDesc = data.chiDesc
            oData.statusTable[index].status = data.status
          })
        }
        oModel.refresh()
      },
      // 暫停
      pause: function () {
        let me = this.me
        let meData = me.getData()
        let oData = this.dialog.getModel().getData()

        if (oData.kanbanType) {
          meData.refreshFrequency = ''
          meData.pageRefreshFrequency = ''
          if (meData.update) clearInterval(meData.update)
          if (meData.updateTable) clearInterval(meData.updateTable)
        }
        this.close()
      },
      // 啟動
      activate: function () {
        let me = this.me
        let meData = me.getData()
        let oData = this.dialog.getModel().getData()

        // error : 工作中心清單為空
        if (oData.workCenterTable.length == 0 || oData.workCenterTable.some(row => !row.workCenter)) me.error('equipmentKanban.warning1')
        // error : 設備狀態清單為空
        if (oData.statusTable.length == 0 || oData.statusTable.some(row => !String(row.status))) me.error('equipmentKanban.warning2')
        // error : 自動看板 刷新頻率, 清單頻率 為空
        if (oData.kanbanType) {
          me.isEmpty([oData.refreshFrequency, oData.pageRefreshFrequency], ['equipmentKanban.label23', 'equipmentKanban.label26'])
        }

        // 儲存 table
        $equipmentKanban.saveAttribute(
          {
            site: meData.site,
            user: meData.user,
            activity: meData.activity,
            data: [...oData.workCenterTable, ...oData.statusTable]
          },
          (res) => { },
          me.showMessage
        )

        meData.refreshFrequency = oData.refreshFrequency
        meData.listChangeTime = oData.pageRefreshFrequency
        meData.refreshLists = oData.workCenterTable
        meData.attributeList = oData.statusTable

        // 資料存入 localStorage
        localStorage.setItem('refreshFrequency', oData.refreshFrequency)
        localStorage.setItem('pageRefreshFrequency', oData.pageRefreshFrequency)
        localStorage.setItem('kanbanType', oData.kanbanType)

        me.getPageInfo(meData.refreshLists[0])
        // 若為自動看板 隨時更新
        if (oData.kanbanType) {
          me.refreshPage()
          me.updateTable()
        }

        this.close()
      },
      // 數字 卡控
      numberControl: function (oEvent) {
        var oSource = oEvent.getSource()
        var customDatas = oSource.getCustomData()
        var number = oSource.getValue()
        var max,
          negative,
          decimal,
          decimalMax,
          symbol
        if (customDatas) {
          customDatas.forEach(function (cData, index) {
            switch (cData.getKey().toUpperCase()) {
              case 'max'.toUpperCase():
                if (cData.getValue()) {
                  max = parseInt(cData.getValue())
                }
                break
              case 'negative'.toUpperCase():
                negative = cData.getValue() == 'true' ? true : false
                break
              case 'decimal'.toUpperCase():
                decimal = cData.getValue() == 'true' ? true : false
                break
              case 'decimalMax'.toUpperCase():
                if (cData.getValue()) {
                  decimalMax = parseInt(cData.getValue())
                }
                break
              case 'symbol'.toUpperCase():
                symbol = cData.getValue() == 'true' ? true : false
                break
            }
          })
        }

        number = number.replace(/^[0]/g, '') // 不能 0
        number = number.replace(/[A-Za-z]/g, '') // 不能英文
        number = number.replace(/[^\x00-\x80]/g, '') // 不能中文
        number = number.replace(/[^\d\\?\\*\\,\\/.-]/g, '') // 不能? * , . - /以外符號

        if (max > 0) number = number.substring(0, max)
        if (negative) number = number.replace(/-/g, '')
        if (decimal) number = number.replace(/\./g, '')
        if (symbol) number = number.replace(/[/\\?\\*\\,]/g, '')
        if (number.match(/\./g)) {
          var arr = number.split('.')
          number = arr[0] + '.' + arr[1].substring(0, decimalMax)
        }

        let n = number.split('-').filter(str => str !== '')
        if (n.length > 0) n = n[0]


        if (number.startsWith('-')) {
          number = '-' + n
        } else {
          number = n
        }

        oSource.setValue(number)
      },
    });
  }
);
