(function (global, factory) {
  global.$sfcRelease = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();


  // 工單清單
  let getSOList = function (data, success, fail) {
    api.post(`/so/release/list`, data, 'json', success, fail);
  };

  // 工單細節
  let getSO = function (data, success, fail) {
    api.post(`/so/retrieve`, data, 'json', success, fail);
  };

  // 工單核發
  let releaseSO = function (data, success, fail) {
    api.post(`/so/release`, data, 'json', success, fail);
  };

  return {
    getSOList,
    getSO,
    releaseSO
  };
});
