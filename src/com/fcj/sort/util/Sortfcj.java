package com.fcj.sort.util;

/**
 * Created by dormi on 2017/1/2.
 */
public class Sortfcj {


    /**
     * 冒泡排序by dormi
     * @param a
     */
    public static void bubbleSort(int a[]){

        int temp;
        for (int i = 0; i < a.length - 1; i++){
            for (int j = 0; j <a.length - i -1; j++){
                if (a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


    /**
     * 快速排序by dormi
     * @param s
     * @param l
     * @param r
     * @return
     */
    public int adjustArray(int[] s, int l, int r){//返回调整后基准数的位置

//        swap(s[l], s[(l + r) / 2]);

//        Sortfcj sortfcj = new Sortfcj();
//        int hh = sortfcj.findMedian(s, l, r);

        int ha = findMedian(s, l, r);
        swap(s[l], ha);//swap没有用

        int i = l, j = r;
        int x = s[l];
        while (i < j){
            while (i < j && x <= s[j])//这里的i < j是需要的
                j--;
            if (i < j){
                s[i] = s[j];
                i++;
            }

            while (i < j && x > s[i])
                i++;
            if (i < j){
                s[j] = s[i];
                j--;
            }

        }

        s[i] = x;
        return i;
    }

    public int findMedian(int s[], int left, int right){

        int center = (left + right) / 2;
        if (s[center] < s[left]){
            swap(s[center], s[left]);
        }
        if (s[right] < s[left]){
            swap(s[right], s[left]);
        }
        if (s[right] < s[center]){
            swap(s[right], s[center]);
        }

        return s[center];
    }

    public void swap(int a, int b){
        int temp = a;
        a = b;
        b = a;
    }

    public void quickSort(int s[], int l, int r){
        if (l < r){
            int i = adjustArray(s, l, r);
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }


    /**
     * 插入排序by dormi
     * @param a
     */
    public void insertionSort(int a[]){

        int j;
        for (int i = 1; i < a.length; i++){

            int temp = a[i];
            for (j = i; j > 0 && temp < a[j-1]; j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
        }

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

    //希尔排序
    public static void shellsort(int a[]){

        int j = 0;

        for (int gap = a.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < a.length; i++){
                int tmp = a[i];
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap){
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }

        }
    }

    //堆排序
    private static int leftChild(int i){
        return 2 * i + 1;
    }

    private static void percDown(int[] a, int i, int n){
        int child;
        int tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child){
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

    public static void heapsort(int[] a){
        for (int i = a.length/2; i >= 0; i--){
            percDown(a, i, a.length);
        }
        for (int i = a.length - 1; i > 0; i--){
            swapReferences(a, 0, i);
            percDown(a, 0, i);
        }
    }

    public static void swapReferences( int [ ] a, int index1, int index2 )
    {
        int tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

//    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
//    {
//        AnyType tmp = a[ index1 ];
//        a[ index1 ] = a[ index2 ];
//        a[ index2 ] = tmp;
//    }

    //快速排序
    public static int quickGet(int[] a, int l, int r){

        int i = l, j = r;
        int temp = a[l];

        while (i < j){

            while (i < j && a[j] >= temp){
                j--;
            }
            if (i < j){
                a[i] = a[j];
                i++;
            }

            while (i < j && a[i] < temp){
                i++;
            }
            if (i < j){
                a[j] = a[i];
                j--;
            }


        }
        a[i] = temp;
        return i;


    }

    public static void quick(int[] a, int l, int r){
        if (l < r){
            int i = quickGet(a, l, r);
            quick(a, l, i - 1);
            quick(a, i + 1, r);
        }
    }

    /**
     * 二分查找法
     * @param arrs
     * @param x
     * @return
     */
    public static int binarySearch(int[] arrs, int x){

        int len = arrs.length;
        int min = 0;
        int max = len - 1;

        while (min  <= max){
            int mid = (min + max) / 2;
            if (arrs[mid] == x){
                return mid;
            } else if (arrs[mid] < x){
                min = mid + 1;//这里一定要有+1
            } else {
                max = mid - 1;//这里一定要有-1
            }
        }

        return -1;

    }

}
