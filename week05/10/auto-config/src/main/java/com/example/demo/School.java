package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class School{

    @Autowired
    private Klass class1;

    @Autowired
    private Student student100;

    public void ding() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }

    public School(Klass class1, Student student100) {
        this.class1 = class1;
        this.student100 = student100;
    }
}
