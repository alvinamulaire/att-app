var css = function () {};

css.prototype = new css();

css.prototype.include = function () {
    jQuery.sap.includeStyleSheet(
        jQuery.sap.getModulePath('att') + '/css/bootstrap.css?_' + new Date().getTime()
    );
    jQuery.sap.includeStyleSheet(
        jQuery.sap.getModulePath('att') + '/css/style.css?_' + new Date().getTime()
    );
};
