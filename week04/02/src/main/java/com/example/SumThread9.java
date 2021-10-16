package com.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SumThread9 {


    private int result;

    public void sum(Condition condition) throws BrokenBarrierException, InterruptedException {
        this.result = fibo(36);
        condition.signal();
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

        final Lock lock  = new ReentrantLock();
        final Condition done = lock.newCondition();
        int result = 0;
        long start = System.currentTimeMillis();
        SumThread9 sumThread9 = new SumThread9();
        Thread t = new Thread(() ->{
            try {
                sumThread9.sum(done);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t.start();
        lock.lock();
        done.await();
        result = sumThread9.getResult();
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
