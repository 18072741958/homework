package com.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class SumThread7 {


    private int result;

    public void sum(Thread t) {
        this.result = fibo(36);
        LockSupport.unpark(t);;
    }

    public int getResult(){
        return result;
    }

    public static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


    public static void main(String[] args) throws InterruptedException {
        int result = 0;
        long start = System.currentTimeMillis();
        SumThread7 sumThread7 = new SumThread7();
        Thread mainThread = Thread.currentThread();
        Thread t = new Thread(() ->{
            sumThread7.sum(mainThread);
        });
        t.start();
        LockSupport.park();
        result = sumThread7.getResult();
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
