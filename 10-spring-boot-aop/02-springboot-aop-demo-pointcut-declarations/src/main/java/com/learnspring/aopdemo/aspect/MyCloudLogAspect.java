package com.learnspring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
    @Before("com.learnspring.aopdemo.aspect.AopExpressions.forDaoPackageNoGetSet()")
    public void logToCloud() {
        System.out.println("\n====>> log to cloud");
    }
}
