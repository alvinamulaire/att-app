package com.att.config;

import com.att.idat.Idat;
import com.sap.me.frame.AppStartupListener;
import com.sap.me.frame.Utils;
import com.visiprise.frame.service.ConfigurationLoaderInterface;
import com.visiprise.frame.service.ServiceActivationException;
import com.visiprise.frame.service.XmlConfigurationLoader;
import com.visiprise.frame.utils.AppRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

public class AttExtAppStartUpListener extends AppStartupListener {

    @Autowired
    private Idat idat;

    @Override
    public void contextInitialized( ServletContextEvent event ) {
        super.contextInitialized(event);
        WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
        ConfigurationLoaderInterface loader = (ConfigurationLoaderInterface) event.getServletContext().getAttribute("com.sap.me.serviceloader");

        if (loader != null) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            try {
                ((XmlConfigurationLoader) loader).loadConfiguration("hook/service-config.xml", classLoader);
                ((XmlConfigurationLoader) loader).loadConfiguration("service/service-config.xml", classLoader);
                ((XmlConfigurationLoader) loader).loadConfiguration("serviceext/service-config.xml", classLoader);
                ((XmlConfigurationLoader) loader).loadConfiguration("bundle/service-config.xml", classLoader);
            } catch (ServiceActivationException var5) {
                Utils.errorMsg("Service Activation Failed", var5);
                throw new AppRuntimeException(var5);
            }

            event.getServletContext().setAttribute("com.sap.me.serviceloader", loader);

            idat.run();
        }
    }
}
