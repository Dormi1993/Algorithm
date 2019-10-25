package com.fcj.test.test1;

/**
 * Created by dormi on 2017/9/23.
 */
public interface Jiekou {
    void me1();
    default void me2(int num){};

    int me2();

}
