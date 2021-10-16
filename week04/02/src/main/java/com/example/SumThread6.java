package com.example;

import java.util.concurrent.CountDownLatch;

public class SumThread6 {


    private int result;

    public void sum(CountDownLatch countDownLatch) {
        this.result = fibo(36);
        countDownLatch.countDown();
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
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int result = 0;
        long start = System.currentTimeMillis();
        SumThread6 sumThread6 = new SumThread6();
        Thread t = new Thread(() ->{
            sumThread6.sum(countDownLatch);
        });
        t.start();
        countDownLatch.await();
        result = sumThread6.getResult();
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
