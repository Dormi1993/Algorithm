package com.fcj.duoxiancheng.test;

import com.fcj.duoxiancheng.mythread.MyThread;

/**
 * Created by dormi on 2017/10/22.
 */
public class Test {
    public static void main(String[] args) {

        try {
            MyThread myThread = new MyThread();
            myThread.setName("myHa");
            myThread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class ss{
        public static void getss(){

        }

    }

    public class nss{
        public void getnss(){

        }
    }
}
