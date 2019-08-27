package io.yodo.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("randomFortuneService")
public class RandomFortuneService implements FortuneService {

    private String[] fortunes = new String[] {
            "Someone is looking up to you, don't let that person down.",
            "No snowflake in an avalanche ever feels responsible.",
            "Who cuts the grass on Walton's Mountain? - Lawn Boy."
    };

    private Random rand = new Random();

    @Override
    public String getFortune() {
        int idx = rand.nextInt(fortunes.length);
        return fortunes[idx];
    }
}
