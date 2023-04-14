(function (global, factory) {
    global.$ncReport = factory()
})(this, function () {
    'use strict'

    let api = $setApi.getAjax()

    let operation = function (site, user, success, fail) {
        api.get(`/operation/current/list?site=${site}&user=${user}`, 'json', success, fail)
    }

    let item = function (site, success, fail) {
        api.get(`/nc/report/item/info?site=${site}`, 'json', success, fail)
    }

    let shopOrder = function (data, success, fail) {
        api.post(`/nc/report/shop/order/info`, data, 'json', success, fail)
    }

    let ncCode = function (site, success, fail) {
        api.get(`/ncCode/list?site=${site}`, 'json', success, fail)
    }

    let retrieve = function (data, success, fail) {
        api.post(`/nc/report/retrieve`, data, 'json', success, fail)
    }

    let userName = function (site, user, success, fail) {
        api.get(`/nc/report/user/name?site=${site}&user=${user}`, 'text', success, fail)
    }

    let update = function (data, success, fail) {
        api.post(`/nc/report/update/reason`, data, 'html', success, fail)
    }

    return {
        operation,
        item,
        shopOrder,
        ncCode,
        retrieve,
        userName,
        update
    }
})
