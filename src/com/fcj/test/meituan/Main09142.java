package com.fcj.test.meituan;

import java.util.Scanner;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main09142 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            if (nums[0] == 0){
                int index = 0;
                for (int i = 1; i < n; i++){
                    if (nums[i] != 0){
                        index = i;
                        break;
                    }
                }

                String s;
                int a = index;
                for (int i = index; i < n; i++){
                    if (nums[i] == 0){
                        a = index;
                        break;
                    }
                }

                if (a == index){
                    System.out.println("Alice");
                }
            } else if (nums[0] == 1){
                int index = 0;
                for (int i = 1; i < n; i++){
                    if (nums[i] != 1){
                        index = i;
                        break;
                    }
                }

                int a = index;
                for (int i = index; i < n; i++){
                    if (nums[i] == 1){
                        a = index;
                        break;
                    }
                }

                if (a == index){
                    System.out.println("Bob");
                }
            } else {
                System.out.println("Alice");

            }

        }

    }

}

