package com.fcj.test.alibaba;

import java.util.Scanner;

/**
 * Created by dormi on 2017/4/26.
 */
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String str = sc.next();
            String pattern = sc.next();

            char[] strs = str.toCharArray();
            char[] patterns = pattern.toCharArray();

            System.out.println(match(strs, patterns, 0, 0));
        }


    }

    public static int match(char[] str, char[] pattern, int startS, int startP){

        if (str == null || pattern == null){
            return 0;
        }

        int i = startS;
        int j = startP;

        while (i < str.length && j < pattern.length && str[i] == pattern[j]){
            i++;
            j++;
        }

        int result = 1;

        if (i < str.length){
            if (pattern[j] != '?' && pattern[j] != '*'){
                result = 0;
            } else if (pattern[j] == '?'){
                i++;
                j++;
                result = match(str, pattern, i, j);
            } else if (pattern[j] == '*'){
                i++;
                while (i < str.length && pattern[j + 1] != str[i]){
                    i++;
                }
                if (i < str.length){
                    result = match(str, pattern, i, j + 1);
                }
            }

        }

        if (i == str.length && j < pattern.length || i < str.length && j == pattern.length){
            result = 0;
        }

        return result;



    }

}
