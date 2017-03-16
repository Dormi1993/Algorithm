package com.fcj.sort.test;

/**
 * Created by Administrator on 2017/3/5 0005.
 */
public class TestSingleton {
    String name = null;
//
//    private TestSingleton() {
//    }
//
//    private static volatile TestSingleton instance = null;
//
//    public static TestSingleton getInstance() {
//        if (instance == null) {
//            synchronized (TestSingleton.class) {
//                if (instance == null) {
//                    instance = new TestSingleton();
//                }
//            }
//        }
//        return instance;
//    }

    private static class LazyHolder {
        private static TestSingleton INSTANCE = null;
        static {
            INSTANCE = new TestSingleton();
        }
    }
    private TestSingleton (){}
    public static final TestSingleton getInstance() {
        System.out.println("ha");
        return LazyHolder.INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("the name is " + name);
    }
}
