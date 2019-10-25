package com.fcj.test.didi;

import java.util.Scanner;

/**
 * Created by dormi on 2017/9/10.
 */
public class Main09102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int N = in.nextInt();
            System.out.println(getUgly(N));
        }
    }

    public static int getUgly(int index) {
        if (index < 1){
            return 0;
        }
        int[] nums = new int[index];
        nums[0] = 1;

        int t2 = 0;
        int t3 = 0;
        int t5 = 0;

        int n = 0;
        while (n < index - 1){
            //下面这三步别忘了
            while (nums[t2] * 2 <= nums[n]){
                t2++;
            }
            while (nums[t3] * 3 <= nums[n]){
                t3++;
            }
            while (nums[t5] * 5 <= nums[n]){
                t5++;
            }

            int min = minBack(nums[t2] * 2, nums[t3] * 3, nums[t5] * 5);
            if (min == nums[t2] * 2){
                nums[++n] = nums[t2] * 2;
                t2++;
            } else if (min == nums[t3] * 3){
                nums[++n] = nums[t3] * 3;
                t3++;
            } else if ((min == nums[t5] * 5)){
                nums[++n] = nums[t5] * 5;
                t5++;
            }
        }

        return nums[index - 1];

    }

    public static int minBack(int n2, int n3, int n5){
        int min = n2;
        if (n3 < min){
            min = n3;
        }

        if (n5 < min){
            min = n5;
        }

        return min;
    }
}
