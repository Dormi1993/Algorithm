package com.fcj.test.Huawei;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dormi on 2017/3/17.
 */
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int len = str.length();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        for (int i = 0, j = 1; i < len - 2;){

            int lo = (str.charAt(i) <= 'F' && str.charAt(i) >= 'A')
                    ? map.get(str.charAt(i)) : str.charAt(i) - '0';
            int hi = (str.charAt(j) <= 'F' && str.charAt(j) >= 'A')
                    ? map.get(str.charAt(j)) : str.charAt(j) - '0';

            char x = str.charAt(j + 1);

//            str.charAt(j + 1) = Main2.Cal(lo, hi, x);


            i += 2;
            j += 2;

        }





    }

    public static int Cal(int a, int b, char x){

        if (x == '+'){
            return a + b;
        } else if (x == '-'){
            return a - b;
        } else {
            return a * b;
        }

    }
}

