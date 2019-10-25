package com.fcj.test.xiaohongshu;

import java.util.Scanner;

/**
 * Created by dormi on 2017/9/28.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {//注意while处理多个case
            String str = in.nextLine();
            String[] strs = str.split(" ");
            int len = strs[0].length();
            String ss = strs[0];
            int k = Integer.parseInt(strs[1]);

            int m = len / (2 * k);
            int yu = len % (2 * k);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < m; i++){
                sb.append(reverse(ss.substring(i * 2 * k, i * 2 * k + k)));
                sb.append(ss.substring(i * 2 * k + k, i * 2 * k + 2 * k));
            }

            if (yu > k){
                sb.append(reverse(ss.substring(m * 2 * k, m * 2 * k + k)));
                sb.append(ss.substring(m * 2 * k + k));
            } else {
                sb.append(reverse(ss.substring(m * 2 * k)));
            }

            System.out.println(String.valueOf(sb));
        }
    }
//    abcdefg 2

    public static String reverse(String str){

        return new StringBuffer(str).reverse().toString();
    }



}
