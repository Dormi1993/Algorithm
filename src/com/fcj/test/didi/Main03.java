package com.fcj.test.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>();
//        while (in.hasNextInt()) {//注意while处理多个case
//
//            list.add(in.nextInt());
//        }

        ArrayList<String> list = new ArrayList<>();

        list.add(in.next());

//        String K = in.next();//或者下面这种

//        in.nextLine();//后面是nextLine的话，要加这个去掉回车符
        String K = in.nextLine();

//        int temp = Integer.parseInt(K);//但如果第二行是数字的话，不行，因为会被放入上面的while中
        //另外你第二行输入的不是数字，在这儿转换时候也会出问题的

        int len = list.size();


        System.out.println(list);
        System.out.println(K);

//        System.out.println(temp);


    }



}

//-23 17 -7 11 -2 1 -34
//45 67 33 21
