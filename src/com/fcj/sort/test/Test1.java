package com.fcj.sort.test;

import com.fcj.sort.util.Sortfcj;

/**
 * Created by dormi on 2017/1/2.
 */
public class Test1 {

    public static void main(String[] args){

        int brr[] = {2,5,3,6,1,10,4};
        int len = 8;
        int[] arr = new int[len];
//        for (int b : arr){
//            int t = (int) (Math.random()*1000);
//            b = t;//这种方法没有用，因为这只是改变了b的值，和arr的值无关
//        }
        for (int i = 0; i < len; i++){
            int t = (int) (Math.random()*1000);
            arr[i] = t;
        }

//        Sort.insertionSort(arr);//这是static方法

//        Sort insertSort = new Sort();
//        insertSort.insertionSort(arr);

//        Sort.shellsort(arr);


//        Sort.heapsort(arr);

//        Sortfcj.bubbleSort(arr);

        Sortfcj sortfcj = new Sortfcj();
        sortfcj.quickSort(arr, 0, 7);



        for (int aa : arr){
            System.out.println(aa);
        }
    }
}
