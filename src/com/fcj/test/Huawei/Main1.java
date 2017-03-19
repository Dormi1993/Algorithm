package com.fcj.test.Huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dormi on 2017/3/17.
 */
public class Main1 {
    public static void main(String[] args) {
        int result = 0;

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
//        sc.nextLine();//重要，如果输入n是用nextInt的话，这步过滤掉输入n之后的回车符号
        String[] strings = new String[n];


        for (int i = 0; i < n; i++){
            strings[i] = sc.nextLine();
        }

        int[] arrs = new int[5];
        for (String str : strings){
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == '1'){
                    arrs[j]++;
                }
            }
        }

//        List<String> list = new LinkedList<>();
//
//        while (sc.hasNext()){
//            list.add(sc.nextLine());
//        }

        Arrays.sort(arrs);
        result = arrs[0];
        System.out.println(result);

    }
}
