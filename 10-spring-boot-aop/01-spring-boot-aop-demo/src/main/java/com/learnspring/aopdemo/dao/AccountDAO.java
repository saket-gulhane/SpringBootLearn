package com.learnspring.aopdemo.dao;

import com.learnspring.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);
    boolean doWork();
}
