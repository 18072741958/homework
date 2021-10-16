package com.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SumThread10 {


    private int result;

    public Integer sum(){
        return fibo(36);
    }

    public int getResult(){
        return result;
    }

    public static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }


    public static void main(String[] args) {

        int result = 0;
        long start = System.currentTimeMillis();
        SumThread10 sumThread10 = new SumThread10();
        CompletableFuture<Integer> result1 = CompletableFuture.supplyAsync(()->{return sumThread10.sum();});
        try {
            result = result1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
