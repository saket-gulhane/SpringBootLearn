package com.learnspring.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements  MembershipDAO{

    @Override
    public boolean addSilly(){
        System.out.println(getClass() + " : Doing my db work, add membership account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : Sleep!");

    }
}
