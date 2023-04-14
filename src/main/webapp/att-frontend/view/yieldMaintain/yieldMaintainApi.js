(function (global, factory) {
  global.$yieldMaintain = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();


  // 物料開窗
  let getItem = function (data, success, fail) {
    api.get(`/yield/item/get?site=${data.site}&item=${data.item}`, 'json', success, fail);
  };

  // 途程開窗
  let getRouting = function (data, success, fail) {
    api.get(`/yield/router/get?site=${data.site}&item=${data.item}&router=${data.routing}`, 'json', success, fail);
  };

  // 檢索
  let searchLists = function (data, success, fail) {
    api.post(`/yield/info`, data, 'json', success, fail);
  };

  // 匯入
  let uploadExcel = function (data, success, fail) {
    api.post(`/yield/import`, data, 'html', success, fail);
  };

  return {
    getItem,
    getRouting,
    searchLists,
    uploadExcel
  };
});
