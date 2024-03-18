package com.learnspring.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServicempl implements TrafficFortuneService {

    @Override
    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic!!";

    }

    public String getFortune(boolean tripwire) {
        if (tripwire) {
            throw new RuntimeException("ERROR!!");
        }

        return getFortune();
    }
}
