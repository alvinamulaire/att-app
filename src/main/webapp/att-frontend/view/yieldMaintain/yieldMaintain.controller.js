sap.ui.define(
  [
    "fw/core/BaseController",
    "fw/fragment/TableSelectDialog",
    "sap/ui/unified/MenuItem",
    "att/view/yieldMaintain/yieldMaintainApi",
  ],
  function (BaseController, TableSelectDialog, MenuItem) {
    "use strict";

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.yieldMaintain.yieldMaintain", {
      onInit: function () {
        this.attachPatternMatched("yieldMaintain", this.onRouteMatched);
      },
      onRouteMatched: function () {
        this.setModel({
          site: this.getSite(),
          item: "",
          routing: "",
          routingVer: "",
          tableInfo: [],
          excelData: [],
          routingTypeName: {
            U: "生產途程",
            G: "可組態",
            N: "不合格途程",
            C: "特殊途程",
            D: "品質矯正指示功能途程",
            S: "SFC特定的途程",
            H: "現場訂單特定途程",
            M: "樣本途程"
          },
          filter: ""
        });

        // 檢查螢幕寬度, 調整欄位尺寸
        let oTable = this.byId("table")
        let cols = oTable.getColumns()
        let screenWidth = window.innerWidth
        if (screenWidth > "1200") {
          cols[7].setWidth("7%")
          cols[8].setWidth("7%")
        }
      },
      // 開窗
      openDialog: function (oEvent) {
        let me = this;
        let oSource = oEvent.getSource();
        let id = oSource.sId.split("__xmlview1--")[1];
        let oData = this.getData();
        let i18n = this.getI18N()

        switch (id) {
          // 物料
          case "item":
            $yieldMaintain.getItem(
              oData,
              function (data) {
                new TableSelectDialog().open(oSource, data, function (data) {
                  oData.item = data.item
                });
              },
              me.showMessage
            )
            break;

          // 途程
          case "routing":
            if (!oData.item) {
              this.error(i18n.getText("att.yieldMaintain.warning3"))

            } else {
              $yieldMaintain.getRouting(
                oData,
                function (data) {
                  data.forEach(item => {
                    for (let key in oData.routingTypeName) {
                      if (item.routerType === key) {
                        item.routingType = oData.routingTypeName[key]
                      }
                    }
                  })

                  new TableSelectDialog().open(oSource, data, function (data) {
                    oData.routing = data.router
                    oData.routingVer = data.routerRevision
                  });
                },
                me.showMessage
              )
            }
            break;
        }
      },
      // 檢索
      search: function () {
        let me = this;
        let oData = this.getData();
        let itemSource = this.byId("item")
        let routingSource = this.byId("routing")
        let i18n = this.getI18N()
        let oTable = this.byId("table")
        let cols = oTable.getColumns()
        let addNewMenuItemArray = [cols[0], cols[4]]

        // 添加 無 清除 filter, sort, group
        addNewMenuItemArray.forEach(element => {
          let menuItem = new MenuItem({
            text: "無",
            select: function (oEvent) {
              let oTable = me.byId("table")
              let cols = oTable.getColumns()

              // 清除 group col
              oTable.setGroupBy()
              oTable.getBinding().sort(null);

              cols.forEach(item => {
                item.filter("")
                item.setFilterValue("");
                item.setFiltered(false);
                item.setSorted(false);
              })
            }
          });
          let menu = element.getMenu()
          let items = menu.getItems()
          let check = items.some(e => e.mProperties.text == "無")

          if (!check) {
            menu.addItem(menuItem)
          }
        })

        if (!oData.item) {
          this.error(i18n.getText("att.yieldMaintain.warning1"))
        } else {

          $yieldMaintain.searchLists({
            site: oData.site,
            item: oData.item,
            router: oData.routing
          },
            function (data) {
              // 轉換途程類型
              data.forEach(item => {
                for (let key in oData.routingTypeName) {
                  if (item.routerType == key) {
                    item.routerTypeName = oData.routingTypeName[key]
                  }
                }
              })
              oData.tableInfo = data

              me.refresh()

              if (!oTable.getEnableGrouping()) {
                oTable.setEnableGrouping(true)
              }
            },
            me.showMessage
          )
          itemSource.setEditable(false)
          routingSource.setEditable(false)
        }
      },
      // 清除
      clear: function () {
        let oData = this.getData();
        let me = this;
        let oTable = this.byId("table")
        let cols = oTable.getColumns()

        if (oData.item) {
          this.messageBox(
            {
              key: 'att.yieldMaintain.warning2',
              type: 'warning'
            },
            function () {
              me.clearData(oData)
              me.byId("item").setEditable(true)
              me.byId("routing").setEditable(true)

              // 清除 sort, filter, group
              oTable.setEnableGrouping(false)
              // 清除 group col
              oTable.setGroupBy()
              cols.forEach(item => {
                item.setSorted(false);
                item.setFilterValue("");
                item.setFiltered(false);
              })
              me.refresh();
            }
          )
        }

        this.refresh();
      },
      // 檢查物料欄位
      checkItem: function () {
        let newVal = this.byId("item").getValue()
        let oData = this.getData()
        oData.item = newVal
      },
      // 檢查途程欄位
      checkRouting: function () {
        let oData = this.getData()
        let newVal = this.byId("routing").getValue()
        oData.routing = newVal
      },
      // 匯入 excel
      uploadExcel: function (oEvent) {
        let me = this
        let i18n = this.getI18N()
        let oData = this.getData()
        let file = oEvent.getParameter("files") && oEvent.getParameter("files")[0];
        oData.excelData = []

        if (file && window.FileReader) {
          // 檔案閱讀器讀取 excel 檔案
          let reader = new FileReader();

          reader.onload = function (event) {
            // 檔案內容
            let data = event.target.result;
            // fw-api 已經引用, new Excel JS
            let workbook = new ExcelJS.Workbook()

            // Load Excel
            workbook.xlsx
              .load(data)
              .then(function () {
                // 取得 sheet
                let worksheet = workbook.getWorksheet('YIELD');
                if (!worksheet) {
                  me.error('att.yieldMaintain.warning4');
                }

                // 取得每一列資料
                worksheet.eachRow({
                  includeEmpty: true
                },
                  function (row, rowNumber) {
                    if (rowNumber > 2) {
                      // 判斷值是否為數字
                      if (row.values[4] && isNaN(row.values[4])) {
                        me.error(i18n.getText("att.yieldMaintain.warning5", [row.values[1], row.values[3]]))
                      } else if (row.values[5] && isNaN(row.values[5])) {
                        me.error(i18n.getText("att.yieldMaintain.warning6", [row.values[1], row.values[3]]))
                      } else {
                        oData.excelData.push(
                          {
                            router: row.values[1],
                            routerVer: row.values[2],
                            operation: row.values[3],
                            planYield: row.values[4],
                            stdLabor: row.values[5]
                          }
                        )
                      }
                    }
                  }
                )
                // 取得物料                  
                let itemRow = worksheet.getRow(1)
                oData.item = itemRow.values[2]

                // 上傳系統
                $yieldMaintain.uploadExcel({
                  site: oData.site,
                  item: oData.item,
                  detailInfoList: oData.excelData
                },
                  function () {
                    me.search()
                    me.messageBox({
                      key: "att.yieldMaintain.success1",
                      type: "SUCCESS"
                    })
                  },
                  me.showMessage
                )
              })
          };
          // read & execute onload
          reader.readAsArrayBuffer(file);
        }
      },
      // 匯出 excel
      exportExcel: function () {
        let me = this
        let oData = this.getData()
        let i18n = this.getI18N()

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
        // 粗外框
        let thick_border = {
          top: { style: 'medium' },
          left: { style: 'medium' },
          bottom: { style: 'medium' },
          right: { style: 'medium' }
        }
        // 填充背景顏色
        let fill = {
          // 橘色
          orange: {
            fgColor: { argb: 'FF9D6F' },
            bgColor: { argb: '000000' },
            type: 'pattern',
            pattern: 'solid',
          },
          // 淺橘
          lightOrange: {
            fgColor: { argb: 'FFDAC8' },
            bgColor: { argb: '000000' },
            type: 'pattern',
            pattern: 'solid',
          },
          // 淺灰
          grey: {
            fgColor: { argb: 'BEBEBE' },
            bgColor: { argb: '000000' },
            type: 'pattern',
            pattern: 'solid',
          },
        }
        // 字體: 新細明體
        const MingLiu = i18n.getText('att.yieldMaintain.excelFont');
        // 建立 excel 物件
        let wb = new ExcelJS.Workbook();
        // 新增工作表
        let ws = wb.addWorksheet(i18n.getText('YIELD'), {
          // 不顯示網格
          views: [{ showGridLines: false }],
          // 預設寬度
          properties: { defaultColWidth: 23 }
        });
        // 合併儲存格標題
        ws.mergeCells('B1:E1');

        // 取得標題路徑
        let titleItem = ws.getCell('A1');
        let item = ws.getCell('B1');
        let titleCol1 = ws.getCell('A2');
        let titleCol2 = ws.getCell('B2');
        let titleCol3 = ws.getCell('C2');
        let titleCol4 = ws.getCell('D2');
        let titleCol5 = ws.getCell('E2');
        // 設定標題文字
        titleItem.value = i18n.getText('att.yieldMaintain.excelCol1');
        item.value = oData.item
        titleCol1.value = i18n.getText('att.yieldMaintain.excelCol2');
        titleCol2.value = i18n.getText('att.yieldMaintain.excelCol3');
        titleCol3.value = i18n.getText('att.yieldMaintain.excelCol4');
        titleCol4.value = i18n.getText('att.yieldMaintain.excelCol5');
        titleCol5.value = i18n.getText('att.yieldMaintain.excelCol6');

        // 設定物料樣式
        [titleItem, item].forEach(item => {
          item.fill = fill.orange
          item.border = thin_border
        })
        // 設定標題欄位樣式
        let colArray = [titleCol1, titleCol2, titleCol3, titleCol4, titleCol5]
        colArray.forEach(item => {
          item.fill = fill.lightOrange
          item.border = thin_border
        })

        // 新增 row 資料
        oData.tableInfo.forEach(item => {
          ws.addRow([item.router, item.routerRevision, item.operation, item.planYield, item.stdLabor])
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
            row.eachCell({
              includeEmpty: true
            },
              function (cell, colNumber) {
                cell.border = thin_border
              });
          }
        });

        // 匯出 excel
        doExport(oData.item + "_YIELD");

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
