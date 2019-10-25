package com.fcj.test.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        String str = in.nextLine();
        String[] strs = str.split(" ");

        int K = in.nextInt();
//        in.close();有没有都可以？

        int len = strs.length;
        int[] nums = new int[len];
        int index = 0;

        for (String s : strs){
            nums[index++] = Integer.parseInt(s);
        }


        back(nums, 0, len - 1, K);

        System.out.println(nums[len - K]);

    }

    public static void back(int[] nums, int l, int r, int K){

        if (l < r){
            int index = adjustArray(nums, l, r);
            if (index == (nums.length - K)){
                return;
            } else if (index > (nums.length - K)){
                back(nums, l,index - 1, K);
            } else {
                back(nums, index + 1, r, K);
            }
//            back(nums, l, index - 1, K);
//            back(nums, index + 1, r, K);
        }
    }

    public static int adjustArray(int[] nums, int l, int r){
        int i = l, j = r;
        int x = nums[l];

        while (i < j){
            while (i < j && x <= nums[j]){
                j--;
            }
            if (i < j){
                nums[i] = nums[j];
                i++;
            }

            while (i < j && x > nums[i]){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = x;
        return i;
    }

}

//-23 17 -7 11 -2 1 -34
//45 67 33 21
