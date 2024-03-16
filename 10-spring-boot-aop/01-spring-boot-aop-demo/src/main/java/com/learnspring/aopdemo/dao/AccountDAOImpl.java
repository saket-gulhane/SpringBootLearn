package com.learnspring.aopdemo.dao;

import com.learnspring.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    @Override
    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() + " : Doing my db work, add account");
    }

    @Override
    public boolean doWork() {
        System.out.println("Doing work in method: doWork()");
        return false;
    }
}
