package com.fcj.test;

import com.fcj.test.publicClass.ListNode;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/2/18 0018.
 */
public class MainTest {
    public static void main(String[] args){

        /**
         * 1. Two Sum
         */
/*        int nums[] = {4, 2, 11, 7, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        for (int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }*/

        /**
         * 2. Add Two Numbers
         */
//        MainTest mainTest = new MainTest();
//        ListNode l1 = mainTest.create(new int[] {1, 4, 3});
//        ListNode l2 = mainTest.create(new int[] {5, 6, 4});
//
//        Solution solution = new Solution();
//        ListNode hh = solution.addTwoNumbers(l1, l2);
//        mainTest.print(hh);

        /**
         * 3.
         */
//        String s = "a";
//        Solution solution = new Solution();
//        int aa = solution.lengthOfLongestSubstring(s);
//        System.out.println(aa);


        /**
         * 7.
         */
//        int num = 234;
//        Solution solution = new Solution();
//        System.out.println(solution.reverse(num));

        /**
         * 13. Roman to Integer
         */
//        Solution solution = new Solution();
//        int aa = solution.romanToInt("XLIV");
//        System.out.println(aa);

        /**
         * 14. Longest Common Prefix
         */

//        Solution solution = new Solution();
//        String[] arr = {"leets", "leetCode", "leed"};
//        String[] arr = {"", "b"};
//        String result = solution.longestCommonPrefix(arr);
//        System.out.println(result);


//        String a = "abcdef";
//        System.out.println(a.substring(0, 2));

        /**
         * 20. Valid Parentheses
         */
//        Solution solution = new Solution();
//        String arr = "([])";
//        boolean result = solution.isValid(arr);
//        System.out.println(result);

        /**
         * 21. Merge Two Sorted Lists
         */
//        MainTest mainTest = new MainTest();
//        ListNode l1 = mainTest.create(new int[] {1, 3, 4});
//        ListNode l2 = mainTest.create(new int[] {2, 5, 7});
//
////        mainTest.print(l2);
//
//        Solution solution = new Solution();
//        ListNode hh = solution.mergeTwoLists(l1, l2);
//        mainTest.print(hh);

        /**
         * 26. Remove Duplicates from Sorted Array
         */
//        Solution solution = new Solution();
//        int result = solution.removeDuplicates(new int[]{1, 1, 3, 3, 3, 5, 5});
//        System.out.println(result);

        /**
         * 28. Implement strStr()
         */
//        Solution solution = new Solution();
//        int num = solution.strStr("abcdefg", "cd");
//        System.out.println(num);
//
//        System.out.println("abc" == "abc");
//
//        String a = "abc";
//        String b = "abc";
//
//        String c = new String("haha");
//        String d = new String("haha");
//
//        System.out.println(a == b);
//        System.out.println(c == d);

//        Solution solution = new Solution();
//        int num = solution.searchInsert(new int[]{2, 4, 5, 7}, 9);
//        System.out.println(num);


//        Solution solution = new Solution();
//
////        System.out.println(solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
//        int num = solution.lengthOfLastWord("lad ");
//        System.out.println(num);

//        String s = "gagh";
//        int num = s.lastIndexOf(" ");
//        System.out.println(num);

//        int nums[] = solution.plusOne(new int[]{9,9,9,9});
//        for (int num : nums){
//            System.out.print(num);
//        }

        Solution solution = new Solution();
        String s = solution.addBinary("1011001", "1011");
        System.out.println(s);




    }

    /**
     * 2. Add Two Numbers
     * @param arr
     * @return
     */
    /**
     * 根据一个数组，创建链表
     *
     * @param arr
     * @return
     */
    public ListNode create(int[] arr){
        //判断输入是否合法
        if (arr == null || arr.length == 0){
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        for (int i : arr){
            ListNode cur = new ListNode(i);
            if (head == null){
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
        }
        return head;
    }

    /**
     * 打印一个链表
     * @param head
     */
    public void print(ListNode head){
        ListNode p = head;
        while (p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.print("null");
    }
}
