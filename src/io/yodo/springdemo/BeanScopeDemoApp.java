package io.yodo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctxt = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach aCoach = ctxt.getBean("sensei", Coach.class);
        Coach bCoach = ctxt.getBean("sensei", Coach.class);

        if (aCoach == bCoach) {
            System.out.println("Same same");
        } else {
            System.out.println("But different");
        }

        Coach aProtoCoach = ctxt.getBean("tennisCoach", Coach.class);
        Coach bProtoCoach = ctxt.getBean("tennisCoach", Coach.class);

        if (aProtoCoach == bProtoCoach) {
            System.out.println("A tennisCoach is a tennisCoach");
        } else {
            System.out.println("A tennisCoach is not a tennisCoach");
        }

        ctxt.close();
    }
}
