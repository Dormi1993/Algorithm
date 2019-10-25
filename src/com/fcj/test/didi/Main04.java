package com.fcj.test.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/27.
 */
public class Main04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        while (in.hasNext() && index < 4) {//注意while处理多个case
            list.add(in.next());
            index++;
        }

        in.nextLine();
//        int K = Integer.parseInt(in.nextLine());
        String K = in.nextLine();

//        String K = in.next();


        System.out.println(list);
        System.out.println(K);



//        int num = in.nextInt();
//
//        in.nextLine();
//
//        String s = in.nextLine();
//        System.out.println(num);
//        System.out.println(s);

//        int num = 0;
//        while (in.hasNextInt()){
//            num = in.nextInt();
//        }
//
//        in.nextLine();
//
//        String s = in.nextLine();
//        System.out.println(num);
//        System.out.println(s);

    }
}
