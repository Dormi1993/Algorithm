package com.fcj.test.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int N = in.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++){
                nums[i] = in.nextInt();
            }

            Arrays.sort(nums);
            Arrays.sort(nums);

            int sum = 0;
            for (int i = 1; i < N; i++){
                sum += nums[i];
            }
            if (nums[0] > sum){
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }

    }

}

