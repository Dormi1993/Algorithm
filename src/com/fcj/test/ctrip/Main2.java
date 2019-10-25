package com.fcj.test.ctrip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dormi on 2017/4/11.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();

            int[] nums = new int[256];
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < str.length(); i++){
                if (nums[str.charAt(i)] == 0){
                    sb.append(str.charAt(i));
                    nums[str.charAt(i)]++;
                }
            }

            System.out.println(String.valueOf(sb));
        }
    }

}
