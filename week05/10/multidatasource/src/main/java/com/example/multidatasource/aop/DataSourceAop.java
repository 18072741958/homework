package com.example.multidatasource.aop;

import com.example.multidatasource.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceAop {

    /**
     * 只讀
     */
    @Pointcut("!@annotation(com.example.multidatasource.annotation.Master)" +
    "&& (execution(* com.example.multidatasource.service..*.select*(..))" +
    "|| execution(* com.example.multidatasource.service..*.get*(..)))")
    public void readPointCut(){

    }

    /**
     * 寫
     */
    @Pointcut("@annotation(com.example.multidatasource.annotation.Master)" +
            "|| execution(* com.example.multidatasource.service..*.insert*(..))" +
            "|| execution(* com.example.multidatasource.service..*.update*(..))" +
            "|| execution(* com.example.multidatasource.service..*.delete*(..))" +
            "|| execution(* com.example.multidatasource.service..*.add*(..))")
    public void writePointCut(){

    }

    @Before("readPointCut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writePointCut()")
    public void write(){
        DBContextHolder.master();
    }
}
