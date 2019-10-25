package com.fcj.test.meituan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main0914 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }

            int result = 0;
            for (int i = 0; i < n - 1; i++){
                for (int j = i + 1; j < n; j++){

                    StringBuffer sb = new StringBuffer();
                    sb.append(nums[i]);
                    sb.append(nums[j]);

                    int len = sb.length();
                    int[] temp = new int[len];

                    for (int v = 0; v < len; v++){

                        temp[v] = Integer.parseInt(String.valueOf(sb.charAt(v)));
                    }

                    if (divide(temp, len, 7)){
                        result++;
                    }

                    StringBuffer sb2 = new StringBuffer();
                    sb2.append(nums[j]);
                    sb2.append(nums[i]);

                    int[] temp2 = new int[len];

                    for (int v = 0; v < len; v++){

                        temp2[v] = Integer.parseInt(String.valueOf(sb2.charAt(v)));
                    }

                    if (divide(temp2, len, 7)){
                        result++;
                    }

//
//                    int len = sb.length();
//
//                    if (isValid(String.valueOf(sb))){
//                        result++;
//                    }
//
//                    StringBuffer sb2 = new StringBuffer();
//                    sb2.append(nums[j]);
//                    sb2.append(nums[i]);
//
//                    if (isValid(String.valueOf(sb2))){
//                        result++;
//                    }
//                    sb.insert(0, nums[j]).substring(0, len);
                }
            }

            System.out.println(result);
        }

    }

    public static boolean divide(int a[], int l, int n)
    {
        int q,p=0;
        q=a[p++];
        while(p<l)                               // l是数的位数
        {
            while(q<n)                           //取a[]的高位直到取出的数高于或等于n
            {
                q=q*10+a[p++];
                if(p>=l)
                    break;
            }
            if(q>=n)
                q%=n;                             //取余之后保存q留作后面运算
        }
        q%=n;               //特殊情况如果位数为1
        if(q==0)
            return true;  //成功返回1
        return false;
    }

    public static boolean isValid(String str){
        if (Integer.parseInt(str) % 7 == 0){
            return true;
        }

        return false;
    }


}

