package com.fcj.test.alibaba;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by dormi on 2017/4/26.
 */
public class Main1 {
    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {

        String[] strs = expr.split("\\s+");//匹配任意空白字符
        Stack<Integer> stack = new Stack<>();
        int len = strs.length;

        for (int i = 0; i < len; i++){
            if (strs[i].equals("+")){//不能用strs[i] == "+"
                if (stack.size() < 2){
                    return -1;
                } else {
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp1 + temp2);
                }
            } else if (strs[i].equals("*")){
                if (stack.size() < 2){
                    return -1;
                } else {
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp1 * temp2);
                }
            } else if (strs[i].equals("^")){
                if (stack.size() < 1){
                    return -1;
                } else {
                    int temp = stack.pop();
                    stack.push(temp + 1);
                }
            } else {
                if (stack.size() >= 16){
                    return -2;
                } else {
                    int temp = Integer.parseInt(strs[i]);
                    stack.push(temp);
                }

            }
        }

        return stack.peek();

        //2 3 4 * ^ 5 +
        /*
        String[] array = expr.split("\\s+");//"\\s+"匹配任意空白字符
        Stack stack = new Stack();
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i].equals("+")){
                count--;
                int temp1 = 0;
                if (count >= 0){
                    temp1 = (int)stack.pop();
                } else {
                    return -1;
                }
                count--;
                int temp2 = 0;
                if (count >= 0){
                    temp2 = (int)stack.pop();
                }else {
                    return -1;
                }
                count++;
                stack.push(temp1+temp2);
            }else if (array[i].equals("*")){
                count--;
                int temp1 = 0;
                if (count >= 0){
                    temp1 = (int)stack.pop();
                } else {
                    return -1;
                }
                count--;
                int temp2 = 0;
                if (count >= 0){
                    temp2 = (int)stack.pop();
                }else {
                    return -1;
                }
                count++;
                stack.push(temp1*temp2);
            }else if (array[i].equals("^")){
                count--;
                int temp = 0;
                if (count >= 0){
                    temp = (int)stack.pop();
                } else {
                    return -1;
                }
                temp += 1;
                count++;
                stack.push(temp);
            }else {
                int temp  = Integer.parseInt(array[i]);
                count++;
                if (count > 16){
                    return -2;
                }else {
                    stack.push(temp);
                }
            }

        }
        return (int)stack.pop();*/

    }
}
