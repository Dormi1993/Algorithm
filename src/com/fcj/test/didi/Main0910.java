package com.fcj.test.didi;

import java.util.*;

/**
 * Created by dormi on 2017/9/10.
 */
public class Main0910 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            int sum = 0;
            int init = 100111;
            int num = init;

            int index = 0;

            for (int i = 0; i < n; i++){

                if (nums[i] == 0){
                    if (index == 1 || index == 0){
                        sum++;
                        index = 0;
                        num = init;
                        continue;
                    } else {
                        sum += index / 2;
                        sum++;
                        index = 0;
                        num = init;
                        continue;
                    }
                }

                if (num == nums[i] && i < n - 1){
                    index++;
                } else if ((num == nums[i]) && (i == n - 1)){
                    index++;
                    sum += index / 2;
                } else {
                    sum += index / 2;
                    num = nums[i];
                    index = 1;
                }
            }

            System.out.println(sum);
        }
    }
}

//4
//3 0 2 2

