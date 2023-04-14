sap.ui.define(
  [
    "sap/ui/base/Object",
    "sap/ui/core/Fragment",
    "sap/ui/model/json/JSONModel",
    "att/view/productionDailyReport/productionDailyReportApi",
  ],
  function (Object, Fragment, JSONModel) {
    "use strict";

    return Object.extend("att.view.productionDailyReport.fragment.productionProcess", {
      //開啟畫面
      open: function (me) {
        this.me = me;
        let meData = me.getData()

        // fragment id, control/element id
        let dialog = Fragment.byId("productionProcess", "productionProcessDialog");

        // esc 關閉, dialog 並未清除, 開啟前先清除
        if (dialog) {
          dialog.destroy();
          dialog = null;
        }

        if (!dialog) {
          Fragment.load(
            {
              name: "att.view.productionDailyReport.fragment.productionProcess",
              type: "XML",
              controller: this,
              id: "productionProcess",
            }).then((oDialog) => {

              this.dialog = oDialog;
              // 開窗 model
              oDialog.setModel(
                new JSONModel({
                  detailLists: meData.detailLists,
                  startDate: meData.startDate,
                  endDate: meData.endDate
                }, "dialog")
              )
              // 開窗載入 i18n
              oDialog.setModel(me.getModel("i18n"), "i18n")
              oDialog.open()
            });
        }

        return this;
      },
      // 關閉畫面
      close: function (oEvent) {
        oEvent.getSource().getParent().destroy();
        this.dialog = "";
      },
      // 匯出 excel
      export: function () {
        let me = this.me
        let dialog = Fragment.byId("productionProcess", "productionProcessDialog");
        let oData = dialog.getModel().getData()
        let oModel = dialog.getModel()
        let i18n = me.getI18N()

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
        let ws = wb.addWorksheet(i18n.getText('productionDailyReport.label42'), {
          // 不顯示網格
          views: [{ showGridLines: true }],
          // 預設寬度
          properties: { defaultColWidth: 23 }
        });
        let letters = 'ABCDEFGHIJKLMNO'
        let colsTitles = [
          i18n.getText('g.sfc'),
          i18n.getText('productionDailyReport.label43'),
          // i18n.getText('productionDailyReport.label44'),
          i18n.getText('g.workCenter'),
          i18n.getText('g.workCenterDesc'),
          i18n.getText('g.operation'),
          i18n.getText('g.operationDesc'),
          i18n.getText('productionDailyReport.label45'),
          i18n.getText('productionDailyReport.label46'),
          i18n.getText('productionDailyReport.label47'),
          i18n.getText('productionDailyReport.label48'),
          i18n.getText('productionDailyReport.label49'),
          i18n.getText('productionDailyReport.label50'),
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
        oData.detailLists.forEach(row => {
          ws.addRow([
            row.sfc,
            row.actionCodeDesc,
            row.workCenter,
            row.workCenterDesc,
            row.operation,
            row.operationDesc,
            row.resrce,
            row.resrceDesc,
            row.dateTimeStr,
            row.userId,
            row.qty,
            row.parentSfc,
          ])
        })

        // 每 row 樣式設定
        ws.eachRow(function (row, rowNumber) {
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
                cell.border = thin_border
              });
          }
        });

        // 匯出 excel
        doExport(i18n.getText('productionDailyReport.label42'));

        async function doExport(name) {
          const buffer = await wb.xlsx.writeBuffer();
          const fileType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
          const blob = new Blob([buffer], { type: fileType });
          saveAs(blob, name + '.xlsx');
        }
      },
    });
  }
);
