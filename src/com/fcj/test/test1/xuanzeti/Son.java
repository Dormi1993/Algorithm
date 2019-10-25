package com.fcj.test.test1.xuanzeti;

/**
 * Created by dormi on 2017/9/24.
 */
public class Son extends Father{
    public String SStr1 = "Son1";
    protected String SStr2 = "Son2";
    private String SStr3 = "Son3";

    public Son() {
        System.out.println("Son constructor be called");
    }

    {
        System.out.println("Son common block be called");
    }

    static {
        System.out.println("Son static block be called");
    }



    public static void main(String[] args) {
        new Son();
        System.out.println();
        new Son();
    }

}
