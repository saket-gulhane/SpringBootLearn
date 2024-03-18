package com.learnspring.aopdemo.aspect;

import com.learnspring.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.learnspring.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception exe) {
            System.out.println(exe.getMessage());
            throw exe;
        }
        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("\n====>>> duration: " + duration / 1000 + " seconds");

        return result;
    }

    @After("execution(* com.learnspring.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.learnspring.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExe"
    )
    public void afterTrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExe) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n=====>>> The Exception : " + theExe);
    }


    @AfterReturning(
            pointcut = "execution(* com.learnspring.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFIndAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> Result is: " + result);

        convertAccountNameToUpperCase(result);

        System.out.println("\n=====>>> Result is: " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for (Account temp : result) {
            String name = temp.getName().toUpperCase();
            temp.setName(name);
        }
    }

    @Before("com.learnspring.aopdemo.aspect.AopExpressions.forDaoPackageNoGetSet()")
    public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
        System.out.println("\n====>> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) theJointPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = theJointPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }

    }


}
