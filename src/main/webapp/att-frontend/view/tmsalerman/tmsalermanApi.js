(function (global, factory) {
  global.$tmsalerman = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();


  // 工單清單
  let getSO = function (data, success, fail) {
    api.post(`/shipping/shop/order/info`, data, 'json', success, fail);
  };
  // 棧板
  let getPallet = function (data, success, fail) {
    api.post(`/shipping/pallet/info`, data, 'json', success, fail);
  };
  // 箱號
  let getCarton = function (data, success, fail) {
    api.post(`/shipping/carton/info`, data, 'json', success, fail);
  };
  // SN
  let getSN = function (data, success, fail) {
    api.post(`/shipping/sn/info`, data, 'json', success, fail);
  };

  // 檢索
  let retrieve = function (data, success, fail) {
    api.post(`/shipping/retrieve`, data, 'json', success, fail);
  };

  // 取得 excel 模板
  let getExcel = function (data, success, fail) {
    api.post(`/shipping/read/excel`, data, 'text', success, fail);
  };

  return {
    getSO,
    getPallet,
    getCarton,
    getSN,
    retrieve,
    getExcel
  };
});
