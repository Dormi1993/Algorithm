package com.fcj.test.Huawei;

import java.util.*;

/**
 * Created by dormi on 2017/8/18.
 */
public class Main08 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int num = sc.nextInt();
            int a = back(num);
            System.out.println(a);
        }

    }

    public static int back(int num){
        List<Character> list = new ArrayList<>();
        String str = String.valueOf(num);
        for (int i = str.length() - 1; i >= 0; i--){
            if (!list.contains(str.charAt(i))){
                list.add(str.charAt(i));
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int n : list){
            sb.append(n - 48);
        }

        return Integer.parseInt(String.valueOf(sb));
    }
}
