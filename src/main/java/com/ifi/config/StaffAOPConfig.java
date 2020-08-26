package com.ifi.config;

import com.ifi.model.Staff;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

//@Aspect
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
    public void logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.info("Join Point {}", joinPoint);
        Instant start = Instant.now();
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
//        long timeElapsed = Duration.between(start, end).toMillis();
//        logger.info("Total Turnaround time: {}", timeElapsed);
    }

}
