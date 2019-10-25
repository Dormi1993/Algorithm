package com.fcj.test.meililianhe;

import java.util.Scanner;

/**
 * Created by dormi on 2017/9/23.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){//注意while处理多个case
            int year;
            int mouth;
            int day = 0;
            int days;
            int time = 0;

            year = in.nextInt();
            mouth = in.nextInt();
            days = in.nextInt();

            for (int i = 1; i <mouth; i++) {

                switch (i) {
                    //下面是大月
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: {
                        day = 31;
                        break;
                    }
                    //下面是小月
                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        day = 30;
                        break;
                    }
                    //这是特殊的
                    case 2: {

                        if ((year % 100 == 0 && year%400==0) || (year % 100 !=0 &&year % 4 == 0)) {
                            day = 29;
                        } else {
                            day = 28;
                        }
                    }
                    default:
                        break;
                }
                time += day;
            }
            System.out.println(time + days);
        }
    }


}
