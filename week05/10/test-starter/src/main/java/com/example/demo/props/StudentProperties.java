package com.example.demo.props;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="test")
public class StudentProperties {

    private int id = 0;

    private String name = "wy";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudentProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
