package com.fcj.test.jingyan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dormi on 2024/5/28.
 */
public class Combinations {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> listOuter = new ArrayList<>();
        List<Integer> listInner = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            process(nums, 0, i, listOuter,listInner);
        }

        listOuter.forEach(System.out::println);

    }

    private static void process(int[] nums, int start, int size,
                         List<List<Integer>> listOuter, List<Integer> listInner) {
        if (listInner.size() == size){
            listOuter.add(new ArrayList<>(listInner));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            listInner.add(nums[i]);
            process(nums, i + 1, size, listOuter, listInner);
            listInner.remove(listInner.size() - 1);
        }

    }
}
