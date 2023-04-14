(function (global, factory) {
  global.$equipmentKanban = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();

  // 看板 資訊
  let getKanbanInfo = function (data, success, fail) {
    api.post(`/kanban/info`, data, 'json', success, fail);
  }
  // 工作中心 資訊
  let getWorkCenterInfo = function (data, success, fail) {
    api.post(`/kanban/work/center/info`, data, 'json', success, fail);
  }
  // 設備狀態 資訊
  let getResourceStatusInfo = function (data, success, fail) {
    api.post(`/kanban/resource/status/info`, data, 'json', success, fail);
  }
  // 本月平均 資訊
  let getMonthEfficiency = function (data, success, fail) {
    api.post(`/kanban/month/efficiency`, data, 'json', success, fail);
  }
  // 本日平均 資訊
  let getDayEfficiency = function (data, success, fail) {
    api.post(`/kanban/day/efficiency`, data, 'json', success, fail);
  }
  // 本日綜合 資訊
  let getResourceEfficiency = function (data, success, fail) {
    api.post(`/kanban/resource/efficiency`, data, 'json', success, fail);
  }
  // 工作中心開窗
  let getWorkCenter = function (data, success, fail) {
    api.get(`/workCenter/get?site=${data.site}`, 'json', success, fail);
  }
  // 取得 設定 資訊
  let getAttribute = function (data, success, fail) {
    api.post(`/kanban/get/attribute`, data, 'json', success, fail);
  }
  // 儲存 設定 資訊
  let saveAttribute = function (data, success, fail) {
    api.post(`/kanban/save/attribute?site=${data.site}&user=${data.user}&activity=${data.activity}`, data.data, 'html', success, fail);
  }

  return {
    getKanbanInfo,
    getWorkCenterInfo,
    getResourceStatusInfo,
    getMonthEfficiency,
    getDayEfficiency,
    getResourceEfficiency,
    getWorkCenter,
    getAttribute,
    saveAttribute
  };
});
