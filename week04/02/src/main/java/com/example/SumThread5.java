package com.example;

public class SumThread5 {

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
        SumThread5 sumThread5 = new SumThread5();
        Thread t = new Thread(() ->{
            sumThread5.sum();
        });
        t.start();
        synchronized (sumThread5){
            sumThread5.wait(100);
        }
        result = sumThread5.getResult();
        System.out.println("异步计算结果为："+ result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


}
