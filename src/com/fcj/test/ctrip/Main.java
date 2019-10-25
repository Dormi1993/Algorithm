package com.fcj.test.ctrip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by dormi on 2017/4/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int index = 0;
        int result = 1;

        for (int i = 2; i < n; i++){
            index = i;
            sum += i;
            map.put(i, i);
            if (sum >= n){
                break;
            }
        }

        int diff = sum - n;

        if (diff == 0){
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                result *= entry.getValue();
            }
        } else if (diff == 1){
            map.remove(2);
            map.put(index, map.get(index) + 1);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                result *= entry.getValue();
            }
        } else {
            map.remove(diff);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                result *= entry.getValue();
            }
        }

        System.out.println(result);

    }

}
