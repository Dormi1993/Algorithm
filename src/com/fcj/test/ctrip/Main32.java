package com.fcj.test.ctrip;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by dormi on 2017/4/11.
 */
public class Main32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums1 = new int[n];
            for (int i = 0; i < n; i++) {
                nums1[i] = in.nextInt();
            }

            int m = in.nextInt();
            int[] nums2 = new int[m];
            for (int i = 0; i < m; i++) {
                nums2[i] = in.nextInt();
            }

            System.out.println(findMedian(nums1, nums2));
        }
    }

    public static double findMedian(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int size = len1 + len2;
        if ((size & 1) == 1)
            return findKth(nums1, 0, len1, nums2, 0, len2, size / 2 + 1);
        else
            return (findKth(nums1, 0, len1, nums2, 0, len2, size / 2) + findKth(nums1, 0, len1, nums2, 0, len2, size / 2 + 1)) / 2;
    }

    public static double findKth(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2, int k) {
        if (len1 - start1 > len2 - start2) {

            return findKth(nums2, start2, len2, nums1, start1, len1, k);
        }
        if (len1 - start1 == 0) {

            return nums2[k - 1];
        }
        if (k == 1) {

            return Math.min(nums1[start1], nums2[start2]);
        }
        int p1 = start1 + Math.min(len1 - start1, k / 2);
        int p2 = start2 + k - p1 + start1;
        if (nums1[p1 - 1] < nums2[p2 - 1]) {

            return findKth(nums1, p1, len1, nums2, start2, len2, k - p1 + start1);
        } else if (nums1[p1 - 1] > nums2[p2 - 1]) {

            return findKth(nums1, start1, len1, nums2, p2, len2, k - p2 + start2);
        } else {

            return nums1[p1 - 1];
        }

    }

}
