(function (global, factory) {
  global.$productionKanban = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();

  // 物料 開窗
  let getItem = function (data, success, fail) {
    api.get(`/item/list?site=${data.site}&user=${data.user}`, 'json', success, fail);
  }
  // 途程 開窗
  let getRouter = function (data, success, fail) {
    api.get(`/router/get?site=${data.site}`, 'json', success, fail);
  }
  // 看板 資訊
  let getKanbanInfo = function (data, success, fail) {
    api.post(`/report/production/integrated/info`, data, 'json', success, fail);
  }
  // 儲存 設定 資訊
  let saveAttribute = function (data, success, fail) {
    api.post(`/kanban/save/attribute?site=${data.site}&user=${data.user}&activity=${data.activity}`, data.data, 'html', success, fail);
  }
  // 取得 設定 資訊
  let getAttribute = function (data, success, fail) {
    api.post(`/kanban/get/attribute`, data, 'json', success, fail);
  }

  return {
    getItem,
    getRouter,
    getKanbanInfo,
    saveAttribute,
    getAttribute
  };
});
