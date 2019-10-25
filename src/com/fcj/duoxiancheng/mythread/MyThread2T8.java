package com.fcj.duoxiancheng.mythread;

/**
 * Created by dormi on 2017/10/23.
 */
public class MyThread2T8 extends Thread {
    @Override
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName() + " begin = " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " end = " + System.currentTimeMillis());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
