package com.fcj.test.alibaba;

import java.util.Scanner;

/**
 * Created by dormi on 2017/7/23.
 */
public class Mainha {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        int[] nums = new int[num];


        for (int i = 0; i < num; i++){
            nums[i] = Integer.parseInt(sc.nextLine());
        }

        int max = 0;
        for (int i = 0; i < num; i++){
            int[] temp = new int[num - i];
            for (int v = 0; v < num - i; v++){
                temp[v] = nums[v + i];
            }
            int r = num - i - InverseNumber(temp);

            max = (max < r) ? r : max;

        }

        System.out.println(max);

    }

    public static int InverseNumber(int[] MatrixOne){
        int Count=0;
        for(int i=1;i<MatrixOne.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                int a=MatrixOne[i];
                int b=MatrixOne[j];
                if(a<b)
                {
                    Count++;
                }
            }
        }
        return Count;
    }
}
