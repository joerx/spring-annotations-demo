package io.yodo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Value("track.coach.name")
    private String name;

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        String fortune = fortuneService.getFortune();
        String workout = "Run an easy 5k";
        return fortune + "\n" + workout;
    }

    @Override
    public String getGreeting() {
        return "Hello, I am coach " + name;
    }
}
