package io.yodo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(WorkoutConfig.class);
        Coach aCoach = ctxt.getBean("swimCoach", Coach.class);

        System.out.println(aCoach.getGreeting());

        System.out.println(aCoach.getDailyWorkout());

        ctxt.close();
    }
}
