package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainClass {

    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestBean1 testBean1 = (TestBean1) applicationContext.getBean("testBean1");
        System.out.println(testBean1.toString()
        );

        TestBean2 testBean2 = (TestBean2) applicationContext.getBean("testBean2");
        System.out.println(testBean1.toString());

    }
}
