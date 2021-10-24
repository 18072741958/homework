package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private School school;

    @Bean
    public void printInfo(){
        school.ding();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }



}
