package com.fcj.test.zhaoshangxinyongka;

import java.util.*;

/**
 * Created by dormi on 2017/9/13.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int m = in.nextInt();

            int[] nums = new int[m];

            int max = 0;
            int sum = 0;
            int index = -1;
            for (int i = 0; i < m; i++){
                nums[i] = in.nextInt();
                sum += nums[i];
                if (max < nums[i]){
                    index = i;
                    max = nums[i];
                }
            }

            if (sum - max < max){
                if (index % 2 == 0){
                    if (back(index) % 2 == 1){
                        System.out.println("false");
                    }
                } else {
                    System.out.println("true");

                }
            } else {
                System.out.println("true");

            }

        }
    }

    public static int back(int num){
        int sum = 0;
        while (num > 1){
            sum++;
            num  = num >> 1;
        }

        return sum;
    }

}
