package com.fcj.test.ctrip;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by dormi on 2017/9/21.
 */
public class Main1 {
    static int findMinMis(int[] A) {

        Arrays.sort(A);
        HashSet<Integer> set = new HashSet<>();
        for (int num : A){
            set.add(num);
        }

        int len = A.length;
        int max = A[len - 1];

        for (int i = 1; i <= max; i++){
            if (!set.contains(i)){
                return i;
            }
        }

        return max + 1;


    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _A_size = 0;
        _A_size = Integer.parseInt(in.nextLine().trim());
        int[] _A = new int[_A_size];
        int _A_item;
        for(int _A_i = 0; _A_i < _A_size; _A_i++) {
            _A_item = Integer.parseInt(in.nextLine().trim());
            _A[_A_i] = _A_item;
        }

        res = findMinMis(_A);
        System.out.println(String.valueOf(res));

    }
}
