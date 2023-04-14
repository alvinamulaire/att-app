(function (global, factory) {
  global.$packing = factory();
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
  let searchContainerNo = function (data, success, fail) {
    api.post(`/packaging/retrieve`, data, 'json', success, fail);
  }

  // 開啟箱號(棧板) & 重量 & 出貨日期更新
  let openContainerNo = function (data, success, fail) {
    api.post(`/packaging/upd/master`, data, 'html', success, fail);
  }

  // 裝箱 - 刷 SFC
  let scanSFC = function (data, success, fail) {
    api.post(`/packaging/scan/sfc`, data, 'json', success, fail);
  }

  // 裝箱 - 刷 SN
  let scanSN = function (data, success, fail) {
    api.post(`/packaging/scan/sn`, data, 'json', success, fail);
  }

  // 刪除 - SN 或 箱號
  let deleteSN = function (data, success, fail) {
    api.post(`/packaging/del/detail`, data, 'json', success, fail);
  }

  // 裝箱 - 完成前檢查
  let preCheck = function (data, success, fail) {
    api.post(`/packaging/pre/complete/carton`, data, 'json', success, fail);
  }

  // 裝箱 - 完成
  let complete = function (data, success, fail) {
    api.post(`/packaging/complete/carton`, data, 'html', success, fail);
  }

  // 容器 檢索
  let scanContainer = function (data, success, fail) {
    api.post(`/packaging/container/info`, data, 'json', success, fail);
  }

  return {
    getContainerNo,
    openContainerNo,
    getContainer,
    scanSFC,
    scanSN,
    searchContainerNo,
    deleteSN,
    preCheck,
    complete,
    scanContainer,
  };
});
