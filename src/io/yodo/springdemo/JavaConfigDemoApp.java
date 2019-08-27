package io.yodo.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctxt = new AnnotationConfigApplicationContext(WorkoutConfig.class);

        Coach aCoach = ctxt.getBean("swimCoach", Coach.class);
        Coach bCoach = ctxt.getBean("baseballCoach", Coach.class);
        Coach abCoach = ctxt.getBean("baseballCoach", Coach.class);

        System.out.println(aCoach.getGreeting());
        System.out.println(aCoach.getDailyWorkout());

//        System.out.println(bCoach.getDailyWorkout());

        // @Bean annotated methods in the config class, 2 calls returns the same instance
        if (bCoach == abCoach) {
            System.out.println("Same same");
        } else {
            System.out.println("Different");
        }


        ctxt.close();
    }
}
