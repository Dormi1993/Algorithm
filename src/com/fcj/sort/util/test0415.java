package com.fcj.sort.util;

/**
 * Created by dormi on 2018/4/15.
 */
public class test0415 {

    public static void main(String args[]) {
        demoException();
    }

    public static void demoException() {
        try {
//            double f = 2 / 0;
//            System.out.println(f);
            int k = 2 / 1;
            if (k == 2) {
                throw new Exception("我故意的");
            } else {
                k /= 0;
            }
        } catch (Exception e) {
            System.out.println("发生错误了" + e.getMessage());
        } finally {
            System.out.println("条条大路通罗马通Finally");
        }
    }

    public void test01() {

        System.out.println("jjjjj");
    }

    public void test02(){

    }
}
