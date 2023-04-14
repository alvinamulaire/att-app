(function (global, factory) {
  global.$clampStart = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();


  // SFC 開窗
  let getSFC = function (data, success, fail) {
    api.get(`/sfc/in/queue/info?site=${data.site}&operation=${data.operation}`, 'json', success, fail);
  }

  // 取得 作業,資源說明
  let getInfo = function (data, success, fail) {
    api.post(`/tool/opAndRes/info`, data, 'json', success, fail);
  }

  // 刷 SFC
  let scanSFC = function (data, success, fail) {
    api.post(`/tool/scan/sfc`, data, 'json', success, fail);
  }

  // 刷 SN, 工具編號
  let scanSNTooL = function (data, success, fail) {
    api.post(`/tool/scan`, data, 'json', success, fail);
  }

  // 刪除 SN
  let deleteSNTool = function (data, success, fail) {
    api.post(`/tool/del`, data, 'json', success, fail);
  }

  // 開始
  let start = function (data, success, fail) {
    api.post(`/tool/start`, data, 'html', success, fail);
  }

  return {
    getSFC,
    getInfo,
    scanSFC,
    scanSNTooL,
    deleteSNTool,
    start
  };
});
