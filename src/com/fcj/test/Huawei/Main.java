package com.fcj.test.Huawei;

import java.util.Scanner;

/**
 * Created by dormi on 2017/3/15.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }

    }
}
