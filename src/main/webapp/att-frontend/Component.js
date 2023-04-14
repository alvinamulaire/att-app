sap.ui.define(
    ['sap/ui/core/UIComponent', 'att/core/setCss', 'fw/core/setting', 'fw/core/buildObj'],
    function (UIComponent) {
        'use strict';
        return UIComponent.extend('att.Component', {
            metadata: {
                manifest: 'json'
            },
            init: function () {
                var me = this;
                UIComponent.prototype.init.apply(this, arguments);
                //設定語系
                new setting().setLocale(this);
                // Set Css
                new setting().css();
                new css().include();
                me.getRouter().initialize();
            }
        });
    }
);
