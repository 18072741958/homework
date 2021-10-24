package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Klass.class)
@EnableConfigurationProperties(Student.class)
public class SchoolAutoConfiguration {

    @Autowired
    private Klass class1;

    @Autowired
    private Student student100;

    @Bean
    public School getSchool(){
        return new School(class1,student100);
    }
}
