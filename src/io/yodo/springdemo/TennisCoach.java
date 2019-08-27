package io.yodo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${tennis.coach.name}")
    private String name;

    public TennisCoach() {
        System.out.println(">> TennisCoach default constructor");
    }

    @Override
    public String getDailyWorkout() {
        String fortune = fortuneService.getFortune();
        return "Do some backhand exercises.\n" + fortune;
    }

    @Override
    public String getGreeting() {
        return "Hello, I'm coach " + name;
    }

    @Autowired
    @Qualifier("randomFortuneService")
    public void anyOldMethodName(FortuneService fortuneService) {
        System.out.println(">> Setting fortuneService");
        this.fortuneService = fortuneService;
    }
}
