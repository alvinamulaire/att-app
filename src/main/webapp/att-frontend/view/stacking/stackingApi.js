(function (global, factory) {
  global.$stacking = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();


  // 容器開窗
  let getContainer = function (data, success, fail) {
    api.post(`/packaging/container`, data, 'json', success, fail);
  }

  // 新增箱號 & 棧板號
  let getContainerNo = function (data, success, fail) {
    api.post(`/packaging/create/number`, data, 'json', success, fail);
  }

  // 檢索箱號 & 棧板號
  let searchStackNo = function (data, success, fail) {
    api.post(`/packaging/retrieve`, data, 'json', success, fail);
  }

  // 開啟箱號(棧板) & 重量 & 出貨日期更新
  let openStackNo = function (data, success, fail) {
    api.post(`/packaging/upd/master`, data, 'html', success, fail);
  }

  // 刪除 - SN 或 箱號
  let deleteSN = function (data, success, fail) {
    api.post(`/packaging/del/detail`, data, 'json', success, fail);
  }

  // 棧板 - 刷入箱號
  let scanContainerNo = function (data, success, fail) {
    api.post(`/packaging/scan/carton`, data, 'json', success, fail);
  }

  // 棧板 - 完成前檢查
  let preCheck = function (data, success, fail) {
    api.post(`/packaging/pre/complete/pallet`, data, 'json', success, fail);
  }

  // 棧板 - 完成
  let complete = function (data, success, fail) {
    api.post(`/packaging/complete/pallet`, data, 'html', success, fail);
  }

  return {
    getContainer,
    getContainerNo,
    searchStackNo,
    openStackNo,
    deleteSN,
    scanContainerNo,
    preCheck,
    complete
  };
});
