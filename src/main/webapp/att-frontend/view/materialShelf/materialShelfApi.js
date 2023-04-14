(function (global, factory) {
  global.$materialShelf = factory();
})(this, function () {
  'use strict';

  let api = $setApi.getAjax();

  // 檢索料架
  let searchRack = function (data, success, fail) {
    api.post(`/production/rack/info`, data, 'json', success, fail);
  }

  // 上架
  let RackOn = function (data, success, fail) {
    api.post(`/production/rack/on`, data, 'html', success, fail);
  };

  // 下架
  let RackOff = function (data, success, fail) {
    api.post(`/production/rack/off`, data, 'html', success, fail);
  };

  return {
    searchRack,
    RackOn,
    RackOff
  };
});
