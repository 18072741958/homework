package com.example.shardingspherereadwrite.po;

public class TestPo{
    private Integer id;

    private String name;

    public TestPo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestPo(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}