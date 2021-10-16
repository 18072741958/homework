package com.example;

public class SumThread3 {

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
        int result = 0;
        long start = System.currentTimeMillis();
        SumThread3 sumThread3 = new SumThread3();
        Thread t = new Thread(() ->{
                sumThread3.sum();
        });
        t.start();
        t.join();
        result = sumThread3.getResult();
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
