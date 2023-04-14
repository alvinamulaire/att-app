(function (global, factory) {
    global.$packagingProd = factory();
})(this, function () {
    'use strict';

    let api = $setApi.getAjax();

    let getItem = function (site, success, fail) {
        api.get(`/packaging/prod/item/get?site=${site}`, 'json', success, fail);
    };

    let getQcPlan = function (data, success, fail) {
        api.post(`/packaging/prod/qc/get`, data, 'json', success, fail);
    };

    let getQcPlanItem = function (data, success, fail) {
        api.post(`/packaging/prod/qc/item/get`, data, 'json', success, fail);
    };

    let retrieve = function (data, success, fail) {
        api.post(`/packaging/prod/retrieve`, data, 'json', success, fail);
    };

    let save = function (data, success, fail) {
        api.post(`/packaging/prod/save`, data, 'html', success, fail);
    };

    let del = function (data, success, fail) {
        api.post(`/packaging/prod/del`, data, 'html', success, fail);
    };

    return {
        getItem: getItem,
        getQcPlan: getQcPlan,
        getQcPlanItem: getQcPlanItem,
        retrieve: retrieve,
        save: save,
        del: del
    };
});
