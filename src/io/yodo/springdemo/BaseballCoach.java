package io.yodo.springdemo;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return fortuneService.getFortune() + "\nDo batting practice";
    }

    @Override
    public String getGreeting() {
        return "Howdie boy!";
    }
}
