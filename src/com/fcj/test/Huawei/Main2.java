package com.fcj.test.Huawei;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by dormi on 2017/3/17.
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int len = str.length();
//
//        Map<Character, Integer> map = new HashMap<Character, Integer>();
//        map.put('A', 10);
//        map.put('B', 11);
//        map.put('C', 12);
//        map.put('D', 13);
//        map.put('E', 14);
//        map.put('F', 15);

//        String a = Integer.toHexString(13);
//        System.out.println(a);
//        int b = Integer.parseInt("C", 16);
//        System.out.println(b);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++){
//            if (Integer.parseInt(String.valueOf(str.charAt(i)), 16) >= 0 &&
//                    Integer.parseInt(String.valueOf(str.charAt(i)), 16) <= 15){
//                stack.push(Integer.valueOf(str.charAt(i)));
//            } else {
//                int right = stack.pop();
//                int left = stack.pop();
//                int result = back(left, right, str.charAt(i));
//                stack.push(result);
//            }

            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*'
                    || str.charAt(i) == '/'){
                int right = stack.pop();
                int left = stack.pop();
                int result = back(left, right, str.charAt(i));
                stack.push(result);
            } else {

                stack.push(Integer.parseInt(String.valueOf(str.charAt(i)), 16));

            }
        }

        System.out.println(stack.pop());





    }

    public static int back(int a, int b, char c){
        if (c == '+') {

            return a + b;
        } else if (c == '-'){
            return a - b;
        } else if (c == '*'){
            return a * b;
        } else {
            return a / b;
        }
    }

}

