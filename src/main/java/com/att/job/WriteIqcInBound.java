package com.att.job;

import com.att.service.IqcService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class WriteIqcInBound extends QuartzJobBean {

    @Autowired
    private IqcService iqcService;

    @Override
    protected void executeInternal( JobExecutionContext jobExecutionContext ) throws JobExecutionException {
        iqcService.write(jobExecutionContext);
    }
}
