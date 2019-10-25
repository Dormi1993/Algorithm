package com.fcj.test.ctrip;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by dormi on 2017/4/11.
 */
public class Main31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums1 = new int[n];
            for (int i = 0; i < n; i++){
                nums1[i] = in.nextInt();
            }

            int m = in.nextInt();
            int[] nums2 = new int[m];
            for (int i = 0; i < m; i++){
                nums2[i] = in.nextInt();
            }

            int[] temp = new int[n + m];

            HashSet<Integer> set = new HashSet<>();

            back(nums1, nums2, temp, set);

            int index = -1;
            for (int i = n + m - 1; i >= 0; i--){
                if (temp[i] != 0){
                    index = i;
                    break;
                }
            }

            if ((index & 1) != 0){
                int mid = index >> 1;
                int n1 = temp[mid];
                int n2 = temp[mid + 1];

                double t = (n1 + n2) / 2.0;

                System.out.println(t);
            } else {
                System.out.println(temp[index >> 1]);
            }
        }
    }

    public static void back(int[] nums1, int[] nums2, int[] temp, HashSet<Integer> set){

        int len1 = nums1.length;
        int len2 = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < len1 && j < len2){
            if (!set.contains(nums1[i]) && !set.contains(nums2[j])){
                if (nums1[i] == nums2[j]){
                    temp[k++] = nums1[i++];
                    j++;
                } else if (nums1[i] < nums2[j]){
                    temp[k++] = nums1[i++];
                } else {
                    temp[k++] = nums2[j++];
                }
            } else if (!set.contains(nums1[i])){
                j++;
            } else {
                i++;
            }

        }

        while (i < len1){
            if (!set.contains(nums1[i])){

                temp[k++] = nums1[i++];
            }
        }

        while (j < len2){
            if (!set.contains(nums2[j])){

                temp[k++] = nums2[j++];
            }
        }
    }

}
