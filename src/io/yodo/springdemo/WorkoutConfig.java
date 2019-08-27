package io.yodo.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("io.yodo.springdemo")
@PropertySource("classpath:coaches.properties")
public class WorkoutConfig {

    // call to this method is intercepted, so the 2nd invocation will return the same instance, not create a new one
    @Bean
    public FortuneService simpleFortuneService() {
        return new SimpleFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(simpleFortuneService());
    }

    @Bean
    public Coach baseballCoach() {
        return new BaseballCoach(simpleFortuneService());
    }
}
