package com.att.service;

import org.quartz.JobExecutionContext;

public interface IqcService {

    void read( JobExecutionContext jobExecutionContext );

    void write( JobExecutionContext jobExecutionContext );
}
