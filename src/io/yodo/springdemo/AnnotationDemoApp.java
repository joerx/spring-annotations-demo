package io.yodo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach aCoach = ctxt.getBean("sensei", Coach.class);

        System.out.println(aCoach.getGreeting());

        System.out.println(aCoach.getDailyWorkout());

        ctxt.close();
    }
}
