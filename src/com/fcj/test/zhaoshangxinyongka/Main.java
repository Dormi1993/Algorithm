package com.fcj.test.zhaoshangxinyongka;

import java.util.*;

/**
 * Created by dormi on 2017/9/13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int mul = min(a, b);
            int temp = mul;
            int index = 2;
            int sum = 0;

            while (temp <= n) {
                sum++;
                temp = mul * index;
                index++;
            }

            System.out.println(sum);
        }
    }

    public static int min(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        for (int i = b; i <= a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }

        return -1;
    }
}
