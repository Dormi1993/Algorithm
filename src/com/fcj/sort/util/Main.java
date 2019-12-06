package com.fcj.sort.util;

/**
 * Created by Administrator on 2017/3/16 0016.
 */
public class Main {
    public static void main(String[] args){

//        int[] nums = new int[]{4,2,5,2,6,1};

        /*求逆序数
        int[] nums = new int[]{2,1,4,5};
        for (int num : nums){
            System.out.print(num + " ");
        }



        System.out.println("=====");
        Sortfcj sortfcj = new Sortfcj();
        sortfcj.mergeSortni(nums, 0, nums.length - 1, new int[nums.length]);
        for (int num : nums){
            System.out.print(num + " ");
        }

        System.out.println("+++");

        System.out.println(sortfcj.numQuan);*/

//        int[] nums = new int[]{1,3};
//        int a = Sortfcj.binarySearch(nums, 0, nums.length - 1, 3);
//        System.out.println(a);

        jicheng jicheng = new jicheng();
        jicheng.test01();


//        int[] arrs2 = new int[]{2, 4, 5, 12, 23};
//        int[] arrs = new int[]{23};
//
//        int result2 = Sortfcj.binarySearch(arrs2, 0, 4, 12);
//        int result = Sortfcj.binarySearch(arrs,23);
//
//        System.out.println(result2);
//        System.out.println(result);
//
//
//        //快速排序
//        int[] arrs3 = new int[]{4,2,5,1,23,12};
//        int len = arrs3.length;
//        int mid = (0 + len - 1) >> 1;
//
//        for (int num : arrs3){
//            System.out.print(num + " ");
//        }
//
//        Sortfcj.mergeSort(arrs3, 0, len - 1, new int[len]);
//
//        System.out.println("------");
//        for (int num :arrs3){
//            System.out.print(num + " ");
//        }



/*        //下面两行取得下标为0、mid、len - 1三数的中位数，放入第0位
        Sortfcj.findMedian(arrs3, 0, len - 1);
        Sortfcj.swapRef(arrs3, 0, mid);

        System.out.println( "\n" + "-------");
        Sortfcj.quickSort(arrs3, 0, len - 1);
        for (int num : arrs3){
            System.out.print(num + " ");
        }*/

        /*
        System.out.println("\n" + "-----");
        int[] nums = new int[]{5, 2, 9, 1, 6};
        int len1 = nums.length;
        int mid = (0 + len1 - 1) >> 1;
        Sortfcj.findMedian(nums, 0, 4);
        for (int num : nums){
            System.out.println(num);
        }
        System.out.println("++++++");
        Sortfcj.swapRef(nums, 0, mid);

//        System.out.println(nums[mid]);
//        int a = Sortfcj.findMedian(nums,0, 4);
//        System.out.println(nums[mid]);
//
//        System.out.println(a + "+++");

//        Sortfcj.jiaohuan(nums, 0, 3);
        for (int num : nums){
            System.out.println(num);
        }*/

        int[] nums = new int[]{3,2,1,6,3,2,3,8};

        for (int n : nums) {
            System.out.println(n);
        }
        System.out.println("++++++");
        Sortfcj sortfcj = new Sortfcj();
        sortfcj.merge02(nums, 0, nums.length - 1, new int[nums.length]);

        for (int n : nums) {
            System.out.println(n);
        }

    }
}
