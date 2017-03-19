package com.fcj.test.Huawei;

import java.util.Scanner;

/**
 * Created by dormi on 2017/3/15.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String str1 = sc.nextLine();
            StringBuffer stringBuffer = new StringBuffer();
            String str = str1.toLowerCase();
            int len = str.length();
            for (int i = 0; i < len; i++){
                if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A'){
                    stringBuffer.append(str.charAt(i));
                } else if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a'){
                    stringBuffer.append(str.charAt(i));
                }
            }
            System.out.println(stringBuffer.toString());
        }

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String a = sc.nextLine();
//            int len = a.length();
//            if (len <= 8){
//                System.out.print(a);
//                for (int i = len; i < 8; i++){
//                    System.out.print("0");
//
//                }
//                System.out.println("");
//            } else {
//                int count = len / 8;
//                int mod = len % 8;
//                for (int i = 0; i < count; i++){
//                    System.out.println(a.substring(8 * i, 8 * i + 8));
//                }
//                if (mod > 0){
//                    System.out.print(a.substring(8 * count, 8 * count + mod));
//                    for (int j = mod; j < 8; j++){
//
//                        System.out.print("0");
//                    }
//                }
//                System.out.println("");
//            }
//
//        }
//
//        String b = "12345678";
//        String c = b.substring(4);
//        System.out.println(c);

    }
}
