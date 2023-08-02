package com.brexson.learnspringaop.aop.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect{
    private Logger logger = LoggerFactory.getLogger(getClass());
    // Pointcut - Where/When should the logic be applied?
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.brexson.learnspringaop.aop.*.*.*(..))") // ....*.*.* wildcard means ...package.class.method
    public void logMethodCall(JoinPoint joinPoint){
    //  Logic - What logic should be applied?
        logger.info("Before Aspect - Method is called - {}", joinPoint);
    }
}