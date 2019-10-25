package com.fcj.duoxiancheng.test;

import com.fcj.duoxiancheng.mythread.*;

/**
 * Created by dormi on 2017/10/22.
 */
public class Test2 {
    public static void main(String[] args) {
//        MyRunnable runnable = new MyRunnable();
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(runnable);
//        Thread thread2 = new Thread(myThread);

//        MyThread2T8 myThread2T8 = new MyThread2T8();
//        myThread2T8.setName("ha");
//        System.out.println(" begin = " + System.currentTimeMillis());
//        myThread2T8.start();
//        System.out.println(" begin = " + System.currentTimeMillis());

        MyList list = new MyList();
        System.out.println(list.list.size());

        MyThreadAP87 threadAP87 = new MyThreadAP87(list);
        Thread thread = new Thread(threadAP87);
        thread.setName("aa");
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.list.size());

    }


}
