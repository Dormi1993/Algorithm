package com.fcj.sort.demo;

/**
 * Created by dormi on 2017/2/18.
 */
public class ahh {

    public int reverse(int x){
//        int a = x;
//        x = (a > 0) ? a : (-a);
//        int[] nums = new int[100];
//        int zongshu = 0;
//
//        for (int i = 0;x > 0 ; i++){
//
//            nums[i] = x % 10;
//            x = x / 10;
//        }
//        for (int j = 0; j < nums.length; j++){
//            int chang = 0;
//            for (int temp : nums){
//                if (temp != 0){
//                    chang++;
//
//                }
//            }
//            zongshu = (int) (zongshu + nums[j] * Math.pow(10, (chang - 1 -j)));
//        }
//        return (a > 0) ? zongshu : (-zongshu);

        int result = 0;
        int newresult = 0;

        while (x != 0){
            int temp = x % 10;
            newresult = result * 10 + temp;
            if ((newresult - temp) / 10 != result){
                return 0;
            }
            result = newresult;
            x /= 10;
        }

        return result;

    }

    public boolean isPalindrome(int x) {
        int a = x;
        int result = 0;
        while (x != 0){
            int temp = x % 10;
            result = result * 10 + temp;
            x /= 10;
        }
        if (a == result){
            return true;
        } else {
            return false;
        }
    }
}
