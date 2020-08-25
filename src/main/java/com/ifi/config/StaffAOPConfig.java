package com.ifi.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Configuration
public class StaffAOPConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.ifi.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info(" Allowed execution for {}", joinPoint);
    }

    @After("execution(* com.ifi.service.*.*(..))")
    public void afterReturn() {
        logger.info("afterReturn");
    }

    @Around("target(com.ifi.service.StaffService)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Join Point {}", joinPoint);
        Instant start = Instant.now();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        logger.info("Total Turnaround time: {}", timeElapsed);
    }

}
