package com.fcj.test.alibaba;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by dormi on 2017/4/26.
 */
public class Main2 {
        private static String pattern = "^-?[0-9]+";

        public static void main(String[] args) {

            ArrayList<Integer> inputs = new ArrayList<Integer>();
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            if (line != null && !line.isEmpty()) {
                int res = resolve(line.trim());
                System.out.println(String.valueOf(res));
            }
        }

        // write your code here
        public static int resolve(String expr) {
            int[] stack = new int[16];
            int top = -1;
            String[] datas = expr.split(" ");

            for (int i = 0; i < datas.length; i++) {
                if (Pattern.matches(pattern, datas[i])) {
                    if (top == 15) {
                        return -2;
                    }
                    top++;
                    stack[top] = Integer.parseInt(datas[i]);
                } else {
                    switch (datas[i]) {
                        case "^":
                            if (top == -1) {
                                return -1;
                            }
                            stack[top]++;
                            break;
                        case "+":
                            if (top < 1) {
                                return -1;
                            }
                            int a = stack[top];
                            top--;
                            stack[top] += a;
                            break;
                        case "*":
                            if (top < 1) {
                                return -1;
                            }
                            int b = stack[top];
                            top--;
                            stack[top] *= b;
                            break;
                    }
                }
            }
            if (top < 0) {
                return -1;
            }
            return stack[top];
        }
}
