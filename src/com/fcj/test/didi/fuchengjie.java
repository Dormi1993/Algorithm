package com.fcj.test.didi;

import java.util.ArrayList;
import java.util.Scanner;
public class fuchengjie{
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);  
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        while(scan.hasNextInt())  
        {  
            list.add(scan.nextInt());
        }  

        int len = list.size();
        int[] nums = new int[len];
        int index = 0;

        for (int num : list){
            nums[index++] = num;
        }

	int K = nums[len - 1];
        System.out.println(K);
	

    }
}
