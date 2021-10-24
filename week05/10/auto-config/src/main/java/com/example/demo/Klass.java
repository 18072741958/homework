package com.example.demo;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Klass {

    private List<String> students = new ArrayList<String>(){{
        add("zs");
        add("ls");
    }};

    public List<String> getStudents() {
        return students;
    }


    public Klass(){}

    public Klass(List<String> students) {
        this.students = students;
    }

    public void dong(){
        System.out.println(this.getStudents());
    }
}
