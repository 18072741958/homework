package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SumThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception{
        return sum();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public static void main(String[] args){
        int result = 0;
        long start = System.currentTimeMillis();
        FutureTask<Integer> futureTask = new FutureTask<>(new SumThread());
        new Thread(futureTask).start();
        try{
            result = futureTask.get();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
