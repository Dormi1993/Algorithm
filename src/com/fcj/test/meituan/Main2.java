package com.fcj.test.meituan;

import java.util.*;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main2 {

    static Stack<Integer> stack = new Stack<>();

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();

        while (n > 0){
            String str = in.nextLine();
            if (str.charAt(1) == 'o'){

                pop();

            } else if (str.charAt(1) == 'u'){
                String[] s = str.split(" ");

                int num = Integer.parseInt(s[1]);
                push(num);

            } else if (str.charAt(1) == 'e'){
                back();
            }
        }

    }

    public static void pop(){
        if (stack.isEmpty()){
            System.out.println("Invalid");
        } else {
            stack.pop();
        }
    }

    public static void push(int num){
        stack.push(num);
    }

    public static void back(){
        if (stack.isEmpty()){
            System.out.println("Invalid");
        } else {
            List<Integer> list = new ArrayList<>();
            for (int n : stack){
                list.add(n);
            }

            Collections.sort(list);

            System.out.println(list.get(list.size() / 2));
        }

    }
}

