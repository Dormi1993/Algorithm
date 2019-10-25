package com.fcj.test.yuanjing;

import java.util.*;

/**
 * Created by dormi on 2017/8/27.
 */
public class Main {
    public static void main(String[] args){
        int[] nums = new int[]{3,1,2,3,4,3,4,4,4,5,2,5,5,5,5};
        int[] nums2 = new int[]{0,1,1,2,2,4,4,4,3,3,3,5,5,5,5};
//        int a = back(nums);//没有数字的频数是一样的
//        System.out.println(a);

//        Set<Integer> set = back2(nums2);//有些数字的频数是一样的
//        System.out.println(set);
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//        HashMap<Integer, Integer> map = new HashMap<>();//这个key遍历应该是随机的
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(3,3);
        map.put(1,1);
        map.put(2,2);
        map.put(5,5);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }

//        TreeSet<Integer> set = new TreeSet<>();
//        set.addAll(Arrays.asList(2,3,1,5,14,19,34));
//
//        System.out.println(set);
//
//        int a = set.lower(17);
//        int b = set.ceiling(17);
//        System.out.println(a);
//        System.out.println(b);
    }

    public static int back(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : map.values()){
            if (set.size() < 2){
                set.add(num);
            } else {
                if (set.first() < num){
                    set.pollFirst();
                    set.add(num);
                }
            }
        }

        int temp = set.first();
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == temp){
                result = entry.getKey();
            }
        }

        return result;
    }

    public static Set<Integer> back2(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : map.values()){
            set.add(num);
        }

        set.pollLast();
        int temp = set.last();

        Set<Integer> set2 = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == temp){
                set2.add(entry.getKey());
            }
        }

        return set2;
    }
}
