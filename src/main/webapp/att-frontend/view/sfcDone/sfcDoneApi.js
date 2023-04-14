var sfcDoneApi = function (url) {
    this.url = url;
};

sfcDoneApi.prototype = new ajax();

sfcDoneApi.prototype.sfcDoneInfo = function (data, success, fail) {
    this.post(`/sfc/done/info`, data, 'json', success, fail);
};

sfcDoneApi.prototype.sfcDone = function (data, success, fail) {
    this.post('/sfc/done', data, 'json', success, fail);
};
