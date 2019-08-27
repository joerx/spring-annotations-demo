package io.yodo.springdemo;

import org.springframework.stereotype.Component;

public class SimpleFortuneService implements FortuneService {

    private int counter = 0;

    @Override
    public String getFortune() {
        counter += 1;
        return "Today is your lucky day ("+counter+")";
    }
}
