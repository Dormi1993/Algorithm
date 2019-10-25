package com.fcj.test.xiaohongshu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dormi on 2017/9/28.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int p = in.nextInt();

//            HashMap<Integer, Integer> map = new HashMap<>();
            int[] nums = new int[21];
            for (int i = 0; i < n; i++){
                int a = in.nextInt();
                int b = in.nextInt();

                nums[a] = b;
            }

            int sum = 0;

            sum += nums[5] * 5 + nums[10] * 10 + nums[20] * 20;

            int temp = 0;
            int max = 0;
            if (sum <= p){
                System.out.println(p - sum);
            } else {
                for (int i = 0; i <= nums[20]; i++){
                    for (int j = 0; j <= nums[10]; j++){
                        for (int k = 0; k <= nums[5]; k++){
                            temp = i * 20 + j * 10 + k * 5;
                            if (temp < p){
                                if (temp > max){
                                    max = temp;
                                }
                            }
                        }
                    }
                }

                System.out.println(p - max);
            }
        }
    }

}

//3 40
//5 2
//10 1
//20 1
