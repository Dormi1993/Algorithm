package com.fcj.test.JianzhiOffer;

/**
 * Created by dormi on 2017/5/4.
 */
public class Test {
//    public static void main(String[] args) {
//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        operator(a, b);
//        System.out.println(a + "," + b);
//    }
//    public static void operator(StringBuffer x, StringBuffer y) {
//        x.append(y); y = x;
//    }

    public static void main(String[] args) {
        String a = new String("A");
        String b = new String("B");
        operator(a, b);
        System.out.println(a + "," + b);
    }
    public static void operator(String x, String y) {
        x = "aa"; y = x;
    }
}
