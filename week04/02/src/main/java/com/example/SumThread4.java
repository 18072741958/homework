package com.example;

public class SumThread4 {

    private int result;

    public void sum() {
        synchronized (this){
            this.result = fibo(36);
            this.notify();
        }
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
        SumThread4 sumThread4 = new SumThread4();
        Thread t = new Thread(() ->{
            sumThread4.sum();
        });
        t.start();
        synchronized (sumThread4){
            sumThread4.wait();
        }
        result = sumThread4.getResult();
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
