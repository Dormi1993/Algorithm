package com.fcj.test.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int N = in.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++){
                nums[i] = in.nextInt();
            }
            int K = in.nextInt();

            System.out.println(back(N, nums, K));
        }

    }

    public static int back(int len, int[] nums, int K){

        for (int i = len; i > 0; i--){
            int index = len - 1;

            while (index >= 0 && (i - index) <= 1){
                if ((get(i, index, nums) % K) == 0){
                    return i;
                }
                index--;

            }

        }

        return 0;

    }

    public static int get(int len, int end, int[] nums){
        int sum = 0;
        for (int i = end; i > end - len; i--){
            sum += nums[i];
        }

        return sum;
    }

}

