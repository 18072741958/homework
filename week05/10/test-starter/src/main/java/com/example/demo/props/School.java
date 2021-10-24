package com.example.demo.props;

public class School {

    private StudentProperties student;

    public School() {
    }

    public School(StudentProperties student) {
        this.student = student;
    }

    public void println(){
        System.out.println(student);
    }
}
