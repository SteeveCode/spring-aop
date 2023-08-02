package com.brexson.learnspringaop.aop.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect{
    private Logger logger = LoggerFactory.getLogger(getClass());
    // Pointcut - Where/When should the logic be applied?
    // execution(* PACKAGE.*.*(..))
    //  ....*.*.* wildcard means any ...package.class.method
    @Before("execution(* com.brexson.learnspringaop.aop.*.*.*(..))") //WHEN
    public void logMethodCall(JoinPoint joinPoint){
    //  Logic - What logic should be applied?
        logger.info("Before Aspect - {} Method is called with arguments: {}", joinPoint, joinPoint.getArgs()); // WHAT
    }
    @After("execution(* com.brexson.learnspringaop.aop.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed",  joinPoint);
    }

    @AfterThrowing(
            pointcut = "execution(* com.brexson.learnspringaop.aop.*.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}"
                ,  joinPoint, exception);
    }

    @AfterReturning(
            pointcut ="execution(* com.brexson.learnspringaop.aop.*.*.*(..))",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint,
                                                      Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}"
                ,  joinPoint, resultValue);
    }
}