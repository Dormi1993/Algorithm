package com.fcj.sort.util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by dormi on 2017/1/2.
 */
public class Sortfcj {


    /**
     * 冒泡排序by dormi
     *
     * @param
     */
//    public static void bubbleSort(int[] a){
//        int temp = 0;
//        for (int i = 0; i < a.length - 1; i++){
//            for (int j = 0; j < a.length -1 - i; j++){
//                if (a[j] > a[j + 1]){
//                    temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                }
//            }
//        }
//    }
    public static void bubbleSort(int num[]) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
    }
//    public static void bubbleSort(int a[]){
//
//        int temp;
//        for (int i = 0; i < a.length - 1; i++){
//            for (int j = 0; j <a.length - i -1; j++){
//                if (a[j] > a[j + 1]){
//                    temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                }
//            }
//        }
//    }

    /**
     * 简单选择排序by dormi
     *
     * @param a
     */
//    public static void selectSort(int[] a){
//        for (int i = 0; i < a.length - 1; i++){
//            int min = i;
//            for (int j = i + 1; j < a.length; j++){
//                if (a[j] < a[min]){
//                    min = j;
//                }
//            }
//
//            if (min != i){
//                int temp = a[min];
//                a[min] = a[i];
//                a[i] = temp;
//            }
//        }
//    }
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    /**
     * 插入排序by dormi
     *
     * @param a
     */
    public static void insertionSort(int a[]) {

        for (int i = 1; i < a.length; i++) {
            int j;
            int temp = a[i];
            for (j = i; j > 0 && temp < a[j - 1]; j--) {
                a[j] = a[j - 1];

            }
            a[j] = temp;
        }

//        int j;
//        for (int i = 1; i < a.length; i++){
//            int temp = a[i];
//            for (j = i; j > 0 && temp < a[j - 1]; j--){
//                a[j] = a[j - 1];
//            }
//            a[j] = temp;
//        }

//        int j;
//
//        for (int i = 1; i < a.length; i++){
//            int tmp = a[i];
//            for (j = i; j > 0 && tmp < a[j-1]; j--){
//                a[j] = a[j-1];
//            }
//            a[j] = tmp;
//        }
    }


    /**
     * 快速排序by dormi
     *
     * @param s
     * @param l
     * @param r
     * @return
     */
    public static int adjustArray(int[] s, int l, int r) {//返回调整后基准数的位置

//        swap(s[l], s[(l + r) / 2]);

//        Sortfcj sortfcj = new Sortfcj();
//        int hh = sortfcj.findMedian(s, l, r);

        //int ha = findMedian(s, l, r);
        //swap(s[l], ha);//swap没有用

        int i = l, j = r;
        int x = s[l];
        while (i < j) {
            while (i < j && x <= s[j])//这里的i < j是需要的
                j--;
            if (i < j) {
                s[i] = s[j];
                i++;
            }

            while (i < j && x > s[i])
                i++;
            if (i < j) {
                s[j] = s[i];
                j--;
            }

        }

        s[i] = x;
        return i;
    }

    public static int adjust2(int[] nums, int l, int r) {
        int i = l, j = r;
        int x = nums[l];

        while (i < j) {
            while (i < j && x <= nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && x > nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = x;//这步不能忘，因为最后还有一个坑需要填
        return i;
    }

    public static void quickha(int[] nums, int l, int r) {
        if (l < r) {
            int x = adjust2(nums, l, r);
            quickha(nums, l, x - 1);
            quickha(nums, x + 1, r);
        }
    }

    public static int findMedian(int s[], int left, int right) {

        int center = (left + right) / 2;
        if (s[center] < s[left]) {
//            swap(s[center], s[left]);不能用swap，因为这个只进行了值传递
            swapRef(s, center, left);//这个是引用传递
        }
        if (s[right] < s[left]) {
//            swap(s[right], s[left]);
            swapRef(s, right, left);

        }
        if (s[right] < s[center]) {
//            swap(s[right], s[center]);
            swapRef(s, right, center);

        }

        return s[center];
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = a;
    }

    public static void swapRef(int[] arrs, int a, int b) {
        int temp = arrs[a];
        arrs[a] = arrs[b];
        arrs[b] = temp;

    }

    public static void quickSort(int s[], int l, int r) {
        if (l < r) {
            int i = adjustArray(s, l, r);
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    public static void jiaohuan(int[] arrs, int l, int mid) {
        int temp = arrs[l];
        arrs[l] = arrs[mid];
        arrs[mid] = temp;
    }


    public static void quickSort02(int[] arrays, int left, int right) {
        if (left < right) {
            int index = partition(arrays, left, right);
            quickSort02(arrays, left, index - 1);
            quickSort02(arrays, index + 1, right);
        }
    }

    public static int partition(int[] arrays, int left, int right) {
        int temp = arrays[left];
        while (left < right) {
            while (left < right && arrays[right] >= temp) {
                right--;
            }
            if (left < right) {
                arrays[left++] = arrays[right];
            }

            while (left < right && arrays[left] < temp) {
                left++;
            }
            if (left < right) {
                arrays[right--] = arrays[left];
            }
        }

        arrays[left] = temp;
        return left;

    }

    /**
     * 归并排序
     */

    public static void mergeArray(int[] nums, int left, int mid, int right, int[] temp) {

        int i = left, j = mid + 1;
        int m = mid, n = right;
        int k = 0;

        while (i <= m && j <= n) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }

        }

        while (i <= m) {
            temp[k++] = nums[i++];
        }

        while (j <= n) {
            temp[k++] = nums[j++];
        }

        for (int v = 0; v < k; v++) {
            nums[v + left] = temp[v];
        }


    }

    public static void mergeSort(int[] nums, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) >> 1;

            //归并和快排不一样，这里一定是mid，而快排就是mid-1了，
            // 因为归并需要用上mid这个数，不然的话就缺数了
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            //例子：2和3，如果是mid-1，则为（2，1）和（3，3），正确的是（2，2）和（3，3）


            mergeArray(nums, left, mid, right, temp);

        }


    }


    public void merge02(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) >> 1;
            merge02(nums, left, mid, tmp);
            merge02(nums, mid + 1, right, tmp);

            merge02ha(nums, left, right, mid, tmp);
        }
    }

    private void merge02ha(int[] nums, int left, int right, int mid, int[] tmp) {
        int i = left;
        int j = mid;
        int m = mid + 1;
        int n = right;

        int k = 0;

        while (i <= j && m <= n) {
            // 检查处于右边的俩指针，有利于在求逆序数中更方便
            if (nums[j] > nums[n]) {
                tmp[k++] = nums[j--];
            } else {
                tmp[k++] = nums[n--];
            }
        }

        while (i <= j) {
            tmp[k++] = nums[j--];
        }
        while (m <= n) {
            tmp[k++] = nums[n--];
        }

        for (int v = 0; v < k; v++) {
            nums[left + v] = tmp[k - 1 - v];
        }
    }


    //希尔排序
    public static void shellsort(int a[]) {

        int j = 0;

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }

        }
    }

    //堆排序
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void percDown(int[] a, int i, int n) {
        int child;
        int tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child] < a[child + 1])
                child++;
            if (tmp < a[child])
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    public static void heapsort(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }

    public static void swapReferences(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

//    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
//    {
//        AnyType tmp = a[ index1 ];
//        a[ index1 ] = a[ index2 ];
//        a[ index2 ] = tmp;
//    }


    /**
     * 二分查找法循环
     *
     * @param arrs
     * @param x
     * @return
     */
    public static int binarySearch(int[] arrs, int x) {

        int len = arrs.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arrs[mid] == x) {
                return mid;
            } else if (arrs[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

//        int len = arrs.length;
//        int left = 0;
//        int right = len - 1;
//
//        while (left <= right){
//            int mid = (left + right) >> 1;
//            if (arrs[mid] == x){
//                return mid;
//            } else if (arrs[mid] < x){
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//
//        return -1;


//        int len = arrs.length;
//        int min = 0;
//        int max = len - 1;
//
//        while (min <= max){//这里的二分查找法有误，应该是对的
//            int mid = (min + max) / 2;
//            if (arrs[mid] == x){
//                return mid;
//            } else if (arrs[mid] < x){
//                min = mid + 1;//这里一定要有+1
//            } else {
//                max = mid - 1;//这里一定要有-1
//            }
//        }
//
//        return -1;

    }

    //二分法递归方法
    public static int binarySearch(int[] arrs, int start, int end, int k) {


        /*
        //下面这是错误的，因为要先看arrs[mid]是否为k，因为start和end相等也有可能
        if (start >= end){
            return -1;
        }

        int mid = (start + end) >> 1;
        if (arrs[mid] == k){
            return mid;
        } else if (arrs[mid] > k) {
            return binarySearch(arrs, start, mid - 1, k);

        } else {
            return binarySearch(arrs, mid + 1, end, k);
        }*/


        //下面这是正确的
//        int mid = (start + end) >> 1;
//
//        if (arrs[mid] == k){
//            return mid;
//        }
//
//        if (start >= end){
//            return -1;
//        } else if (arrs[mid] > k) {
//            return binarySearch(arrs, start, mid - 1, k);
//
//        } else {
//            return binarySearch(arrs, mid + 1, end, k);
//        }


        //这是正确的
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        if (arrs[mid] == k) {
            return mid;
        } else if (arrs[mid] > k) {
            return binarySearch(arrs, start, mid - 1, k);
        } else {
            return binarySearch(arrs, mid + 1, end, k);
        }


    }


    int numQuan = 0;

    public void mergeArrayni(int[] nums, int left, int mid, int right, int[] temp) {

        int i = left, j = mid + 1;
        int m = mid, n = right;
        int k = 0;

        while (i <= m && j <= n) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                numQuan += mid - i + 1;
            }

        }

        while (i <= m) {
            temp[k++] = nums[i++];
        }

        while (j <= n) {
            temp[k++] = nums[j++];
        }

        for (int v = 0; v < k; v++) {
            nums[v + left] = temp[v];
        }


    }

    public void mergeSortni(int[] nums, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) >> 1;

            //归并和快排不一样，这里一定是mid，而快排就是mid-1了，
            // 因为归并需要用上mid这个数，不然的话就缺数了
            mergeSortni(nums, left, mid, temp);
            mergeSortni(nums, mid + 1, right, temp);
            //例子：2和3，如果是mid-1，则为（2，1）和（3，3），正确的是（2，2）和（3，3）


            mergeArrayni(nums, left, mid, right, temp);

        }


    }

    public static void main(String[] args) {
        int[][] test = new int[3][2];
        test[0][0] = 1;
        test[0][1] = 100;
        test[1][0] = 20;
        test[1][1] = 10;
        int[][] result = merge(test);

        System.out.println("hhh");

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[][]{};
        }

        int length = intervals.length;
        if (length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        return intervals;

    }

}
