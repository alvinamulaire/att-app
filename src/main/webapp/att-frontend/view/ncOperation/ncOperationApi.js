(function (global, factory) {
  global.$ncOperation = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();

  // 工單類型
  let get = function (data, success, fail) {
    api.get(`/data/field/info?site=${data.site}&dataField=ERP-ORDERTYPE`, 'json', success, fail);
  }

  // SFC 資訊
  let getSfc = function (data, success, fail) {
    api.post(`/nc/sfc/info`, data, 'json', success, fail);
  }

  // 取得 欄位 資訊
  let getCols = function (data, success, fail) {
    api.post(`/nc/column/info`, data, 'json', success, fail);
  }

  // 儲存 
  let save = function (data, success, fail) {
    api.post(`/nc/save`, data, 'html', success, fail);
  }


  return {
    getSfc,
    getCols,
    save
  };
});
