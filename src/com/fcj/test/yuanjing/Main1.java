package com.fcj.test.yuanjing;

import java.util.Scanner;

/**
 * Created by dormi on 2017/9/4.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {//注意while处理多个case
            String str = in.next();
            char[] chars = str.toCharArray();

            int len = chars.length;

            int[] nums = new int[128];

            int index = 0;

            for (int i = 0; i < len; i++){

                int temp = chars[i];
                if (nums[temp] == 0){
                    index++;
                    nums[temp]++;
                }

            }

            System.out.println(index);
        }
    }
}
