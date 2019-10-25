package com.fcj.duoxiancheng.mythread;

import com.fcj.duoxiancheng.test.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dormi on 2017/10/23.
 */
public class MyList {
    public List list = new ArrayList();

    synchronized public void add(String username){
        System.out.println(Thread.currentThread().getName() + "执行了");
        list.add(username);
    }
}
