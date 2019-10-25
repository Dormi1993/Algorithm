package com.fcj.test.xiaohongshu;

import java.util.*;

/**
 * Created by dormi on 2017/9/28.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {//注意while处理多个case
            String str = in.nextLine();

            String[] strs = str.split("RED");
            StringBuffer sb = new StringBuffer();
            for (String s : strs){
                sb.append(s);
            }

            String ss = String.valueOf(sb);

            int index = 0;
            String max = "0";
            int flag = -1;
            for (int i = 0; i < ss.length(); i++){
                if (ss.charAt(i) >= 'A' && ss.charAt(i) <= 'Z'){
                    continue;
                } else {
                    flag = 0;
                    int t = i;
                    for (int j = i + 1; j < ss.length(); j++){
                        if (ss.charAt(j) >= '0' && ss.charAt(j) <= '9'){
                            t++;
                        } else {
                            break;
                        }
                    }
                    if (back(ss.substring(i, t + 1), max)){
                        max = ss.substring(i, t + 1);
                    }
                }
            }

            if (flag == -1){
                System.out.println(-1);
            } else {
                System.out.println(max);
            }

        }
    }


    public static boolean back(String str1, String str2){
        String str1s = quling(str1);
        String str2s = quling(str2);

        if (str1s.length() > str2s.length()){
            return true;
        } else if (str1s.length() < str2s.length()){
            return false;
        } else {
            if (str1.compareTo(str2s) > 0){
                return true;
            } else {
                return false;
            }
        }
    }

    public static String quling(String str){
        int index = 0;
        while (index < str.length() && str.charAt(index) == '0'){
            index++;
        }

        return (index == str.length()) ? "0" : str.substring(index, str.length());
    }
}
