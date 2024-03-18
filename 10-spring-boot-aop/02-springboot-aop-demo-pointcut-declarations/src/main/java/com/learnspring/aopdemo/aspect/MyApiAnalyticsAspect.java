package com.learnspring.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.learnspring.aopdemo.aspect.AopExpressions.forDaoPackageNoGetSet()")
    public void performAnalytics() {
        System.out.println("\n====>> perform analytics");
    }
}
