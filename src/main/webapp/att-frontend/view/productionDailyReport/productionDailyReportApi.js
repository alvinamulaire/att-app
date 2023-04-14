(function (global, factory) {
  global.$productionDailyReport = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();


  // 物料 開窗
  let getItem = function (data, success, fail) {
    api.get(`/item/list/typeList?site=${data.site}&itemType=B,M`, 'json', success, fail);
  }
  // 作業 開窗
  let getOperation = function (data, success, fail) {
    api.get(`/operation/current/canRelease/list?site=${data.site}`, 'json', success, fail);
  }
  // ERP 開窗
  let getErpOperation = function (data, success, fail) {
    api.get(`/router/erpOperation/list?site=${data.site}`, 'json', success, fail);
  }
  // 工單類型
  let getShopOrderType = function (data, success, fail) {
    api.get(`/data/field/info?site=${data.site}&dataField=ERP-ORDERTYPE`, 'json', success, fail);
  }
  // 途程 開窗
  let getRouter = function (data, success, fail) {
    api.get(`/router/get?site=${data.site}`, 'json', success, fail);
  }

  // 工單 開窗
  let getShopOrder = function (data, success, fail) {
    api.post(`/so/custom/list`, data, 'json', success, fail);
  }

  // 檢索
  let search = function (data, success, fail) {
    api.post(`/report/production/date/info`, data, 'json', success, fail);
  }
  // 生產日報表 明細
  let getDetail = function (data, success, fail) {
    api.post(`/report/production/date/detail/info`, data, 'json', success, fail);
  }

  return {
    getItem,
    getOperation,
    getErpOperation,
    getShopOrderType,
    getRouter,
    getShopOrder,
    search,
    getDetail,
  };
});
