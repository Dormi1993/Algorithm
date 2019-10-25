package com.fcj.test.nowcoder;

import java.util.Scanner;

/**
 * Created by dormi on 2017/3/23.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {//注意while处理多个case
            boolean aa = false;
            int num = in.nextInt();
            String str = String.valueOf(num);
            int len = str.length();


            for (int i = 1; i <= len - 1; i++){
                String str1 = str.substring(0, i);
                String str2 = str.substring(i, len);

                if (mult(str1) == mult(str2)){
                    aa = true;
                    break;
                }

            }

            if (aa){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public static int mult(String str){
        int result = 1;
        for (char a : str.toCharArray()){
            result *= (a - '0');
        }
        return result;
    }
}
