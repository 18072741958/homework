package com.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SumThread8 {


    private int result;

    public void sum(CyclicBarrier cyclicBarrier) throws BrokenBarrierException, InterruptedException {
        this.result = fibo(36);
        cyclicBarrier.await();
    }

    public int getResult(){
        return result;
    }

    public static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        int result = 0;
        long start = System.currentTimeMillis();
        SumThread8 sumThread8 = new SumThread8();
        Thread t = new Thread(() ->{
            try {
                sumThread8.sum(cyclicBarrier);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t.start();
        cyclicBarrier.await();
        result = sumThread8.getResult();
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
