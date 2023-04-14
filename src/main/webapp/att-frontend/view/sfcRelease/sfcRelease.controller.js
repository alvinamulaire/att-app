sap.ui.define(
  [
    "fw/core/BaseController",
    "fw/fragment/TableSelectDialog",
    "att/view/sfcRelease/fragment/releasedLists",
    "att/view/sfcRelease/sfcReleaseApi",
  ],
  function (BaseController, TableSelectDialog, releasedLists) {
    "use strict";

    /**
     * BaseController不在個別的專案各自維護，統一維護在FW
     */
    return BaseController.extend("att.view.sfcRelease.sfcRelease", {
      onInit: function () {
        this.attachPatternMatched("sfcRelease", this.onRouteMatched);
      },
      onRouteMatched: function (oEvent) {
        let req = oEvent.getParameter('arguments')['?req']

        this.setModel({
          site: this.getSite(),
          activity: req.ACTIVITY_ID,
          printRunCard: true,
          releasedSFCLists: [],
          releaseAmt: "",     // 此次核發數量
          shopOrder: "",      // 工單
          router: "",         // 途程
          routerVer: "",      // 途程版本
          bom: "",            // 物料表
          bomVer: "",         // 物料表版本
          plannedItem: "",    // 物料
          itemVer: "",        // 物料版本
          itemDesc: null,     // 物料描述
          qtyToBuild: "",     // 製造數量
          releaseQty: "",     // 可核發數量        
          plannedStartDateStr: "",   // 計畫開始
          plannedCompDateStr: "",    // 計畫結束
          lotSize: "",         // 標準批量
          status: "",          // 工單狀態
          statusName: "",      // 工單狀態名稱
          partRev: null,       // 版次
          build: null,         // BUILD
          productType: null,   // 機種
          iso: null,           // 文管編號
          auartValue: ""       // ERP訂單類型
        });

        let oData = this.getData()
        let me = this
        // 列印流程卡規則
        new activity(this.getWebApi()).activityOption(oData.activity,
          function (res) {
            res.forEach(element => {
              if (element.execUnitOption === "RUNCARD") {
                oData.printRunCard = element.setting === "N" ? false : true
                me.refresh()
              }
            });
          },
          this.showMessage)
      },
      // 開窗
      openDialog: function (oEvent) {
        let me = this;
        let oSource = oEvent.getSource();
        let oData = this.getData();

        $sfcRelease.getSOList({
          "site": oData.site,
          "so": oData.shopOrder
        },
          function (data) {
            new TableSelectDialog().open(oSource, data, function (data) {
              oData.shopOrder = data.shopOrder
            });
          },
          me.showMessage
        )
      },
      // 檢索
      search: function () {
        let me = this;
        let oData = this.getData();
        let orderSource = this.byId("shopOrder")
        let i18n = this.getI18N()
        let shopOrderStatusName = {
          501: "可核發",
          502: "保留",
          503: "完成",
          504: "已關閉"
        }

        if (!oData.shopOrder) {
          this.error(i18n.getText("att.sfcRelease.warning1"))
        } else {

          $sfcRelease.getSO({
            "site": oData.site,
            "so": oData.shopOrder
          },
            function (data) {
              oData.router = data.router
              oData.routerVer = data.routerVer
              oData.bom = data.bom
              oData.bomVer = data.bomVer
              oData.qtyToBuild = data.qtyToBuild
              oData.releaseQty = new Decimal(data.releaseQty)
              oData.releaseAmt = new Decimal(data.releaseQty)
              oData.plannedStartDateStr = data.plannedStartDateStr
              oData.plannedCompDateStr = data.plannedCompDateStr
              oData.plannedItem = data.plannedItem
              oData.lotSize = data.lotSize
              oData.itemVer = data.itemVer
              oData.itemDesc = data.itemDesc
              oData.status = data.status
              oData.partRev = data.partRev
              oData.build = data.build
              oData.productType = data.productType
              oData.iso = data.iso
              oData.auartValue = data.auartValue

              for (let key in shopOrderStatusName) {
                if (key === data.status) {
                  oData.statusName = shopOrderStatusName[key]
                }
              }

              me.refresh()
            },
            me.showMessage)

          orderSource.setEditable(false)
        }
      },
      // 清除任務
      clear: function () {
        let oData = this.getData();
        let me = this;
        let excludes = ["printRunCard"]

        if (oData.shopOrder) {
          this.messageBox(
            {
              key: 'att.sfcRelease.warning2',
              type: 'warning'
            },
            () => {
              me.clearData(oData, excludes)
              me.byId("shopOrder").setEditable(true)
              me.refresh();
            }
          )
        }
      },
      // 檢查訂單更動
      checkOrder: function () {
        let newVal = this.byId("shopOrder").getValue()
        let oData = this.getData()
        oData.shopOrder = newVal
      },
      // 檢查此次核發數量
      checkAmount: function () {
        let newVal = this.byId("releaseAmt").getValue()
        let oData = this.getData()
        oData.releaseAmt = newVal
      },
      // 核發
      releaseSfc: function () {
        let me = this
        let oData = this.getData()
        let i18n = this.getI18N()
        let releaseValue = this.byId("releaseAmt").getValue()
        let regex = /^[0-9]+$/;
        let orderSource = this.byId("shopOrder")
        let availableQty = oData.releaseQty
        let releaseQty = oData.releaseAmt

        // 未檢索卡控
        if (orderSource.getEditable()) {
          this.error(i18n.getText("att.sfcRelease.warning11"))
          // 非整數, 未填寫卡控
        } else if (!oData.releaseAmt && !releaseValue.match(regex)) {
          this.error(i18n.getText("att.sfcRelease.warning3"))
        } else {
          $sfcRelease.releaseSO({
            site: oData.site,
            shopOrder: oData.shopOrder,
            router: oData.router,
            routerVer: oData.routerVer,
            bom: oData.bom,
            bomVer: oData.bomVer,
            releaseQty: oData.releaseAmt,
            plannedItem: oData.plannedItem,
            itemVer: oData.itemVer,
            lotSize: oData.lotSize,
            printRunCard: oData.printRunCard
          },
            function (data) {
              oData.releasedSFCLists = data
              new releasedLists().open(me)

              oData.releaseQty = new Decimal(availableQty - releaseQty)
              oData.releaseAmt = new Decimal(availableQty - releaseQty)
              me.refresh()
            },
            me.showMessage
          )
        }
      }
    });
  }
);
