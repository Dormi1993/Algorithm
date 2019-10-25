package com.fcj.sort.test;

import com.fcj.sort.util.Sortfcj;

import java.util.Stack;

/**
 * Created by dormi on 2017/1/2.
 */
public class Test1 {

    public static void main(String[] args){

        System.out.println(add(56,122));


//        char num[] = new char[]{'1', '2', 'b'};
//        char num1[] = num;
//
//
//        num[2] = '4';
//        for (char a : num1){
//            System.out.println(a);
//        }
//
//        int c = 4;
//        int d = c;
//        c = 5;
//        System.out.println(d);

//        int brr[] = {2,5,3,6,1,10,4};
//        int len = 8;
//        int[] arr = new int[len];
//        for (int b : arr){
//            int t = (int) (Math.random()*1000);
//            b = t;//这种方法没有用，因为这只是改变了b的值，和arr的值无关
//        }
//        for (int i = 0; i < len; i++){
//            int t = (int) (Math.random()*1000);
//            arr[i] = t;
//        }

//        Sort.insertionSort(arr);//这是static方法

//        Sort insertSort = new Sort();
//        insertSort.insertionSort(arr);

//        Sort.shellsort(arr);


//        Sort.heapsort(arr);

//        Sortfcj.bubbleSort(arr);

//        Sortfcj sortfcj = new Sortfcj();








//        TestSingleton ts1 = TestSingleton.getInstance();
//        ts1.setName("jason");
//        TestSingleton ts2 = TestSingleton.getInstance();
//        ts2.setName("0539");
//
//        ts1.printInfo();
//        ts2.printInfo();
//
//        if(ts1 == ts2){
//            System.out.println("创建的是同一个实例");
//        }else{
//            System.out.println("创建的不是同一个实例");
//        }



    }

    public static int add(int a, int b){
        int sum = a ^ b;
        int carry = (a & b) << 1;

        while (carry != 0){
            a = sum;
            b = carry;

            sum = a ^ b;
            carry = (a & b) << 1;
        }

        return sum;
    }
}
