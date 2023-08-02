package com.brexson.learnspringaop.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class CommonPointcutConfig {
    @Pointcut("execution(* com.brexson.learnspringaop.aop.*.*.*(..))")
    public void businessAndDataPackageConfig(){}
    @Pointcut("execution(* com.brexson.learnspringaop.aop.business.*.*(..))")
    public void businessPackageConfig(){}
    @Pointcut("execution(* com.brexson.learnspringaop.aop.data.*.*(..))")
    public void dataPackageConfig(){}
    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean(){}
}
