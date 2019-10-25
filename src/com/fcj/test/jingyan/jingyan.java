package com.fcj.test.jingyan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dormi on 2017/10/9.
 */
public class jingyan {

    public static void main(String[] args){
        solution();
    }

    public static void solution() {


        //1. 对数组做操作
        String[] strs = new String[7];
        Integer[] ss1 = new Integer[7];
        ss1[0]=5;
        ss1[1]=2;
        ss1[2]=8;
        ss1[3]=1;
        ss1[4]=1;
        ss1[5]=10;
        ss1[6]=1;

        int[] ss2 = new int[7];

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;

                return s1.compareTo(s2);
            }
        });

        Arrays.sort(ss1, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int n : ss1){
            System.out.println(n);
        }

        //不能是原始数据类
//        Arrays.sort(ss2, new Comparator<int>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });


        //2. 对集合做处理
        ArrayList<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(3456);
        list.add(8);
        list.add(345);
        list.add(12);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });

        for (int n : list){
            System.out.println(n);
        }

    }
}
