var packCheckOutApi = function (url) {
    this.url = url;
};

packCheckOutApi.prototype = new ajax();

packCheckOutApi.prototype.check = function (data, success, fail) {
    this.post(`/packCheckOut/check`, data, 'html', success, fail);
};

packCheckOutApi.prototype.checkOut = function (data, success, fail) {
    this.post(`/packCheckOut/checkOut`, data, 'json', success, fail);
};




/**
 * 取得活動維護規則
 */
packCheckOutApi.prototype.activityOption = function (activity, success, fail) {
    this.get('/activity/option?activity=' + activity, 'json', success, fail)
}