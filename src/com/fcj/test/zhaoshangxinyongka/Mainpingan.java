package com.fcj.test.zhaoshangxinyongka;

import java.util.*;

/**
 * Created by dormi on 2017/10/19.
 */
public class Mainpingan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();
            int n = num;
            while (true){
                n++;
                if (back(n)){
                    System.out.println(n);
                    break;
                }
            }
        }
    }

    public static boolean back(int num){
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();

        TreeSet<Character> set = new TreeSet<>();
        for (char c : chars){
            if (set.contains(c)){
                return false;
            } else {
                set.add(c);
            }
        }

        return true;
    }
}
