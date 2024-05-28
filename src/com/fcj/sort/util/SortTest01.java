package com.fcj.sort.util;

import java.util.Arrays;

/**
 * Created by dormi on 2024/2/2.
 */
public class SortTest01 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,1,1,6,9,4};
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("========");

//        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        quickSort(nums, 0, nums.length - 1);

        Arrays.stream(nums).forEach(System.out::println);

    }

    public static void quickSort(int[] nums, int left ,int right) {
        if (left < right) {
            int i = adjustSort(nums, left, right);

            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    public static int adjustSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int x = nums[left];

        while (i < j) {
            while (i < j && nums[j] > x) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= x) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        nums[i] = x;// 不能忘

        return i;
    }

    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >> 1;

            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);

            merge(nums, left, mid, right, temp);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid;
        int m = mid + 1;
        int n = right;
        int k = 0;

        while (i <= j && m <= n) {
            if (nums[i] <= nums[m]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[m++];
            }
        }

        while (i <= j) {
            temp[k++] = nums[i++];
        }
        while (m <= n) {
            temp[k++] = nums[m++];
        }

        for (int num = 0; num < k; num++) {
            nums[left + num] = temp[num];
        }
    }
}
