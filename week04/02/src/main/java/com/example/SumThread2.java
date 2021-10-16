package com.example;

public class SumThread2 {

    private int result;

    public void sum() {
        this.result = fibo(36);
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
        long start = System.currentTimeMillis();
        final SumThread2 sumThread2 = new SumThread2();
        Thread t = new Thread(() -> {
            sumThread2.sum();
        });
        t.start();
        Thread.sleep(200);
        System.out.println("异步计算结果为："+ sumThread2.getResult());
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }

}
