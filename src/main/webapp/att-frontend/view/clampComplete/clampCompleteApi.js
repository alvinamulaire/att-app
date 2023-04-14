(function (global, factory) {
  global.$clampComplete = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();

  // 取得 作業,資源說明
  let getDesc = function (data, success, fail) {
    api.post(`/tool/opAndRes/info`, data, 'json', success, fail);
  }

  // 刷 SFC
  let scanSFC = function (data, success, fail) {
    api.post(`/tool/scan/sfc`, data, 'json', success, fail);
  }

  // 完成
  let complete = function (data, success, fail) {
    api.post(`/tool/complete`, data, 'html', success, fail);
  }

  return {
    getDesc,
    scanSFC,
    complete,
  };
});
