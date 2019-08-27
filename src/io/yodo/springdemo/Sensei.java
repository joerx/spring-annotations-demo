package io.yodo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Sensei implements Coach {

    private FortuneService fortuneService;

    @Value("${sensei.name}")
    private String name;

    private String[] workouts = new String[]{
            "Do 20 push ups!",
            "Do 30 lounges!",
            "How about 1 minute wall sit?",
            "Let's do 1 minute plank!"
    };

    @Autowired
    public Sensei(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        int idx = (int)(Math.random() * workouts.length);
        String workout = workouts[idx];

        String fortune = fortuneService.getFortune();

        return "\"" + fortune + "\"\n" + workout;
    }

    @Override
    public String getGreeting() {
        return "Hello, I am Sensei " + name;
    }

    @PostConstruct
    public void prepare() {
        System.out.println("Sensei says: Open the dojo");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Sensei says: Close the dojo");
    }
}
