sap.ui.define(['fw/core/BaseController'], function (BaseController) {
    'use strict';

    return BaseController.extend('att.app.App', {
        onInit: function () {
            $setApi.setUrl.call(this);
        }
    });
});
