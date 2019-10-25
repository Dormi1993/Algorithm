package com.fcj.test.didi;

import java.util.Scanner;

/**
 * Created by dormi on 2017/9/10.
 */
public class Main091022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case

            int n = in.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int result = 0;
            int index = 0;
            if (a[0] == 0) {
                result++;
            }
            for (int i = 1; i < n; i++) {

                //要先在外面这个循环判断是否为0
                if (a[i] == 0) {
                    result++;
                    index = i + 1;
                    continue;
                }
                int temp = 0;
                for (int j = i;j >= index; j--) {
                    temp = temp ^ a[j];
                    if (temp == 0) {
                        result++;
                        index = i + 1;
                    }
                }
            }
            System.out.println(result);

//            int n = in.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++){
//                nums[i] = in.nextInt();
//            }
//
//            int sum = 0;
//            int index = 0;
//
//            for (int i = 0; i < n; i++){
//
//                int result = 0;
//
//                for (int j = i; j >= index; j--){
//                    if (nums[j] == 0){
//                        sum++;
//                        index = j + 1;
//                        break;
//                    }
//
//                    result ^= nums[j];
//                    if (result == 0){
//                        sum++;
//                        index = i + 1;
//                        break;
//                    }
//                }
//            }
//
//            System.out.println(sum);

        }
    }
}

//4
//3 0 2 2

