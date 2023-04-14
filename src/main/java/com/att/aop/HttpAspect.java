package com.att.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fw.exception.BaseException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Order(-1)
@Component
public class HttpAspect {

    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Pointcut("execution(public * com..*Controller.*(..))")
    public void inControllerLayer() {
    }

    @Before("inControllerLayer()")
    public void doBefore( JoinPoint joinPoint ) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logger.info("URI: {}", request.getRequestURI());
        if (request.getRequestURI().endsWith("upload")) {
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(joinPoint.getArgs());
            logger.info("Request:{}", json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @AfterReturning(value = "inControllerLayer()", returning = "returnData")
    public void doAfterRunning( JoinPoint joinPoint, Object returnData ) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(returnData);
            logger.info("Status:{} - Response:{}", 200, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @AfterThrowing(value = "inControllerLayer()", throwing = "baseException")
    public void doAfterThrowing( JoinPoint joinPoint, BaseException baseException ) {
        String errorMsg = baseException.getErrorMsg();
        logger.info("Status:{} - Response:{}", 403, "[" + errorMsg + "]");
    }

    @AfterThrowing(value = "inControllerLayer()", throwing = "exception")
    public void doAfterServerErrorThrowing( JoinPoint joinPoint, Exception exception ) {
        String errorMsg = "500:" + exception.getMessage();
        logger.error("Status:{} - Response:{}", 500, "[" + errorMsg + "]", exception);
    }
}