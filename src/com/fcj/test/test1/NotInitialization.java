package com.fcj.test.test1;

/**
 * Created by dormi on 2017/9/24.
 */
public class NotInitialization {
    public static void main(String[] args){
//        System.out.println(SubClass.value);
        SuperClass subClass = new SubClass();
    }
}
