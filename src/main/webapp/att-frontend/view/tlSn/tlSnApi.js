var tlSnApi = function (url) {
    this.url = url;
};

tlSnApi.prototype = new ajax();

tlSnApi.prototype.tlSnInfo = function (data, success, fail) {
    this.post(`/tl/sn/info`, data, 'json', success, fail);
};

tlSnApi.prototype.tlCreateSn = function (data, success, fail) {
    this.post('/tl/sn/createSn', data, 'json', success, fail);
};
