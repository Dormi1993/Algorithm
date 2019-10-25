package com.fcj.test.test1.xuanzeti;

/**
 * Created by dormi on 2017/9/24.
 */
public class Test {
    public static Test t1 = new Test();

    {
        System.out.println("A");
    }

    static {
        System.out.println("B");
    }
}
