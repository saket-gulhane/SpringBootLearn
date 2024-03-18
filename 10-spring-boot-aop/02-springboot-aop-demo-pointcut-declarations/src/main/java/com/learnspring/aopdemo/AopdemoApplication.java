package com.learnspring.aopdemo;

import com.learnspring.aopdemo.dao.AccountDAO;
import com.learnspring.aopdemo.dao.MembershipDAO;
import com.learnspring.aopdemo.service.TrafficFortuneServicempl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneServicempl theTrafficFortuneServiceImpl) {

        return runner -> {
//            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//            demoTheAfterReturnAdvice(theAccountDAO);
//            demoTheAfterThrowingAdvice(theAccountDAO);
//            demoTheAfterAdvice(theAccountDAO);
//            demoTheAroundAdvice(theTrafficFortuneServiceImpl);
//            demoTheAroundAdviceHandleException(theTrafficFortuneServiceImpl);
            demoTheAfterAdviceRethrowException(theTrafficFortuneServiceImpl);
        };
    }

    private void demoTheAfterAdviceRethrowException(TrafficFortuneServicempl theTrafficFortuneServiceImpl) {
        System.out.println("\nMain program: demoTheAfterAdviceRethrowException");

        System.out.println("calling getfortune()");

        boolean tripwire = true;

        String data = theTrafficFortuneServiceImpl.getFortune(tripwire);
        System.out.println("\nMy fortne is " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneServicempl theTrafficFortuneServiceImpl) {
        System.out.println("\nMain program: demoTheAroundAdviceHandleException");

        System.out.println("calling getfortune()");

        boolean tripwire = true;

        String data = theTrafficFortuneServiceImpl.getFortune(tripwire);
        System.out.println("\nMy fortne is " + data);
        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneServicempl theTrafficFortuneServiceImpl) {
        System.out.println("\nMain program: demoTheAroundAdvice");

        System.out.println("calling getfortune()");

        String data = theTrafficFortuneServiceImpl.getFortune();
        System.out.println("\nMy fortne is " + data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try {
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exe) {
            System.out.println("\n\nMain Program: .. caught Exception: " + exe);
        }
        System.out.println("----");

        System.out.println(theAccounts);
        System.out.println();
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try {
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception exe) {
            System.out.println("\n\nMain Program: .. caught Exception: " + exe);
        }
        System.out.println("----");

        System.out.println(theAccounts);
        System.out.println();
    }

    private void demoTheAfterReturnAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain program: demoTheAfterReturnAdvice");
        System.out.println("----");

        System.out.println(theAccounts);
        System.out.println();
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        Account myAccount = new Account();
        myAccount.setName("qqq");
        myAccount.setLevel("plat");
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

//        theAccountDAO.setName("foobar");
//        theAccountDAO.setServiceCode("qqq");
//
//        String name = theAccountDAO.getName();
//        String code = theAccountDAO.getServiceCode();

        theMembershipDAO.addSilly();
        theMembershipDAO.goToSleep();

    }

}
