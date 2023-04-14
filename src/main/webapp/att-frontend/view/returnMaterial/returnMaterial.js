var returnApi = function (url) {
    this.url = url;
};

returnApi.prototype = new ajax();

returnApi.prototype.info = function (data, success, fail) {
    this.post(`/return/material/info`, data, 'json', success, fail);
};

returnApi.prototype.getItem = function (site, item, success, fail) {
    this.get(`/return/material/item?site=${site}&item=${item}`, 'json', success, fail);
};

returnApi.prototype.getShopOrder = function (site, shopOrder, success, fail) {
    this.get(`/return/material/shopOrder?site=${site}&shopOrder=${shopOrder}`, 'json', success, fail);
};

returnApi.prototype.getAssyData = function (site, dataField, success, fail) {
    this.get(`/return/material/assyData?site=${site}&dataField=${dataField}`, 'json', success, fail);
};

returnApi.prototype.getStorage = function (site, success, fail) {
    this.get(`/return/material/storage?site=${site}`, 'json', success, fail);
};

returnApi.prototype.returnMaterial = function (data, success, fail) {
    this.post(`/return/material`, data, 'html', success, fail);
};
