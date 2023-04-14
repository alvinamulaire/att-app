package com.att.config;

import com.fw.mes.me.sevice.ScheduledService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitJobMethodComponent implements InitializingBean {

    @Autowired
    private ScheduledService scheduledService;

    @Override
    public void afterPropertiesSet() throws Exception {
        String contextRoot = "manufacturing-app";

        // 取得Job底下所有Class
        scheduledService.insertJobMethod(contextRoot);
        // 啟動Job
        scheduledService.startUp(contextRoot);
    }
}
