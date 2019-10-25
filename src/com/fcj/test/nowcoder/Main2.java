package com.fcj.test.nowcoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by dormi on 2017/3/23.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            char[] chars = sc.nextLine().toCharArray();
            Arrays.sort(chars);
            set.add(String.valueOf(chars));
        }
        System.out.println(set.size());
//        if (set.size() == n){
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }



    }
}
