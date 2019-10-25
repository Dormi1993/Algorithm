package com.fcj.duoxiancheng.mythread;

/**
 * Created by dormi on 2017/10/23.
 */
public class MyThreadAP87 implements Runnable {

    private MyList list;

    public MyThreadAP87(MyList list){
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            list.add("threadA" + (i+1));
        }
    }
}
