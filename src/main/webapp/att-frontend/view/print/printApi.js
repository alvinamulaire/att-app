var printApi = function (url) {
    this.url = url;
};

printApi.prototype = new ajax();


printApi.prototype.findSoReleaseDesc = function (site, success, fail) {
    this.get(`/shop/order/all/release?site=${site}`, 'json', success, fail);
};

printApi.prototype.print = function (data, success, fail) {
    this.post('/print/print', data, 'html', success, fail);
};

printApi.prototype.printInfo = function (data, success, fail) {
    this.post('/print/info', data, 'json', success, fail);
};

printApi.prototype.getContainer = function (data, success, fail) {
    this.post('/packaging/container', data, 'json', success, fail);
};

printApi.prototype.findContainNoList = function (data, success, fail) {
    this.post('/print/containNo', data, 'json', success, fail);
};

/**
 * 取得活動維護規則
 */
printApi.prototype.activityOption = function (activity, success, fail) {
    this.get('/activity/option?activity=' + activity, 'json', success, fail)
}