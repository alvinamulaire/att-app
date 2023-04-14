(function (global, factory) {
  global.$sn = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();

  // sn 資訊
  let getSN = function (data, success, fail) {
    api.post(`/sn/info`, data, 'json', success, fail);
  };

  // sn 儲存
  let saveSN = function (data, success, fail) {
    api.post(`/sn/save`, data, 'html', success, fail);
  };

  return {
    getSN,
    saveSN
  };
});
