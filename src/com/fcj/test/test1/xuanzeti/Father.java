package com.fcj.test.test1.xuanzeti;

/**
 * Created by dormi on 2017/9/24.
 */
public class Father {
    public String fStr1 = "father1";
    protected String fStr2 = "father2";
    private String fStr3 = "father3";

    {
        System.out.println("Father common block be called");
    }

    static {
        System.out.println("Father static block be called");
    }

    public Father() {
        System.out.println("Father constructor be called");
    }

}

