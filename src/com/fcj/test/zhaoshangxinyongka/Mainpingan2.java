package com.fcj.test.zhaoshangxinyongka;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by dormi on 2017/10/19.
 */
public class Mainpingan2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int num = in.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 2; i < num; i++){
                if (isZhi(i)){
                    list.add(i);
                }
            }

            int sum = 0;
            for (int i = 0; i < list.size(); i++){
                int temp = num - list.get(i);
                if (list.contains(temp) && temp <= num / 2){
                    sum++;
                }
            }

            System.out.println(sum);

        }
    }

    public static boolean isZhi(int num){

        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }

        return true;

    }
}
