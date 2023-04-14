(function (global, factory) {
  global.$clampOff = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();


  // 資源開窗
  let getResource = function (data, success, fail) {
    api.get(`/resource/operation/list?site=${data.site}&operation=${data.operation}`, 'json', success, fail);
  }

  // 作業開窗
  let getOperation = function (data, success, fail) {
    api.get(`/operation/current/list?site=${data.site}&user=${data.user}`, 'json', success, fail);
  }

  // 下機
  let off = function (data, success, fail) {
    api.post(`/tool/off`, data, 'html', success, fail);
  }

  // 刷 資源
  let scanResource = function (data, success, fail) {
    api.post(`/tool/scan/resource`, data, 'json', success, fail);
  }

  // 取得 作業,資源說明
  let getDesc = function (data, success, fail) {
    api.post(`/tool/opAndRes/info`, data, 'json', success, fail);
  }


  return {
    getResource,
    getOperation,
    off,
    scanResource,
    getDesc
  };
});
