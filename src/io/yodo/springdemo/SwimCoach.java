package io.yodo.springdemo;


import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${swim.coach.name}")
    private String name;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return fortuneService.getFortune() + "\nDo a smooth 100m freestyle";
    }

    @Override
    public String getGreeting() {
        return "Hello, I'm " + name + ", your swim coach";
    }
}
