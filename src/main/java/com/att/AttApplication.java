package com.att;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = { "com.att", "com.fw" })
@EnableAsync
public class AttApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder builder ) {
        return builder.sources(AttApplication.class);
    }

    public static void main( String[] args ) {
        SpringApplication.run(AttApplication.class, args);
    }

}