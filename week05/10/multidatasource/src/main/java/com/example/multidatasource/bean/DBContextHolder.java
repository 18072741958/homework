package com.example.multidatasource.bean;

import com.example.multidatasource.enums.DBTypeEnum;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private final static ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType){
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get(){
        return contextHolder.get();
    }

    public static void master(){
        set(DBTypeEnum.MASTAR);
        System.out.println("change master");
    }

    public static void slave(){
        int index = counter.getAndIncrement() % 2;
        if(counter.get() > 9999){
            counter.set(-1);
        }
        if(index == 0 ){
            set(DBTypeEnum.SLAVE1);
            System.out.println("change slave1");
        }else {
            set(DBTypeEnum.SLAVE2);
            System.out.println("change slave2");
        }
    }
}
