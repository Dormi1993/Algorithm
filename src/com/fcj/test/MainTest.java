package com.fcj.test;

import com.fcj.test.publicClass.ListNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2017/2/18 0018.
 */
public class MainTest {
    public static void main(String[] args) {

//        Random random = new Random(4);
//        for (int i = 0; i < 10; i++){
////            Math.random()产生0~1的小数
////            System.out.println(Math.random());
//            double num = (double) (random.nextInt(40) + 184) / 100;
//            System.out.println(String.format("%.2f", num));
//        }

//        try {
//
////            String content = "This 啦is the ha哈1234content to write into file啦";
//
//            File file = new File("/Users/dormi/research/graduationProject/projects/FDoctorWeb/filefcj01.txt");
//
//            // if file doesnt exists, then create it
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//
//            FileWriter fw = new FileWriter(file.getAbsoluteFile());
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            long start = 1375315200;
//            long diff = 1375401600 - start;
//            long num = start;
//            int count = 0;
//            System.out.println(diff);
//            StringBuffer sb = new StringBuffer();
//
//            Random random = new Random(4);
//
//            while (count < 30) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 190) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//
//            while (count < 70) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(4) + 188) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//            while (count < 110) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(8) + 190) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//            while (count < 130) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 192) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//            while (count < 180) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 194) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//
//            while (count < 230) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 196) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//            while (count < 250) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 194) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//            while (count < 300) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 192) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//            while (count < 350) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(4) + 194) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//
//            while (count < 430) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 192) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//
//            while (count < 480) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 194) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//
//
//            while (count < 502) {
//                random.nextInt();
//                double ran = (double) (random.nextInt(6) + 195) / 100;
//                sb.append("[").append(num).append("000").append(",").append(String.format("%.2f", ran))
//                        .append("],");
//                num += diff;
//                count++;
//            }
//            System.out.println(num);
//
////            bw.write(content);
//            bw.write(String.valueOf(sb));
//            bw.close();
//
//            System.out.println("Done");
//            System.out.println((1418601600-1375315200)/diff);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * 1. Two Sum
         */
//        int nums[] = {4, 2, 11, 7, 15};
//        int target = 9;
//
//        Solution solution = new Solution();
//        int[] result = solution.twoSum(nums, target);
//        for (int i = 0; i < result.length; i++){
//            System.out.println(result[i]);
//        }

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
//        String s = "abccgef";
//        Solution solution = new Solution();
//        int aa = solution.lengthOfLongestSubstring(s);
//
//
//        System.out.println(aa);

        /**
         * 4.
         */
//        Solution solution = new Solution();
//        Double result = solution.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
//        System.out.println(result);
//        String s = "gtg";
//        System.out.println(s.substring(1,5));

//        StringBuffer stringBuffer = new StringBuffer(s);
//        System.out.println(s.equals(stringBuffer.reverse().toString()));

        /**
         * 5.
         */
//        Solution solution = new Solution();
//        int result = solution.binarySearch(new int[]{1,5,6,8,10}, 5);
//        System.out.println(result);

        /**
         * 6.
         */
//        Solution solution = new Solution();
//        String result = solution.convert("PAYPALISHIRING", 3);
//        System.out.println(result);


        /**
         * 7.
         */
//        int num = -234;
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
////        String[] arr = {"leets", "leetCode", "leed"};
//        String[] arr = {"dg", "df", "gg"};
////        String[] arr = {"", "b"};
//        String result = solution.longestCommonPrefix(arr);
//        System.out.println(result);
//
//        String aa = "grsag";
//        String bb = "gr";
//        int index = aa.indexOf(bb);
//        System.out.println(index);


//        String a = "abcdef";
//        System.out.println(a.substring(0, 2));

        /**
         * 17.
         */
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);




        /**
         * 19
         */
//        MainTest mainTest = new MainTest();
//        ListNode l1 = mainTest.create(new int[] {1, 3, 4, 6, 8, 9});
//        mainTest.print(l1);
//
//        System.out.println(" ");
//
//        Solution solution = new Solution();
//        ListNode ha = solution.removeNthFromEnd(l1,6);
//        mainTest.print(ha);
//        Solution solution = new Solution();
//        List a = solution.fourSum(new int[]{0,0,0,0}, 0);
//        Iterator it = a.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

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

//        Solution solution = new Solution();
//        String s = solution.addBinary("1011", "1011001");
//        String A = "34";
//        System.out.println(s);
//        System.out.println(A);


//        Solution solution = new Solution();
//        int aa = solution.binarySearch(new int[]{1,2,5,7,8,9}, 8);
//        System.out.println(aa);

        //华为
//        int n = 8;
//        int[] arrs = new int[n];
//        Solution.chansheng(arrs, n);
//        Solution solution = new Solution();
//        System.out.println("排序之前：");
//        solution.print(arrs);
//        System.out.println("");
//        System.out.println("排序之后：");
//        solution.sort(arrs);
//        solution.print(arrs);


//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()){
//            int count = sc.nextInt();
//            Set<Integer> set = new TreeSet<Integer>();
//            for (int i = 0; i < count; i++){
//                int num = sc.nextInt();
//
//                set.add(num);
//            }
//            for (int arr : set){
//                System.out.println(arr);
//            }
//        }

        //28
//        Solution solution = new Solution();
//        int num = solution.strStr("mississippi","issip");
//        System.out.println(num);

        //29
//        Solution solution = new Solution();
//        int a = solution.divide1(-2147483648, -1);
//        System.out.println(a);

        //31
//        Solution solution = new Solution();
//        int[] nums = new int[]{12,43,7};
////        int[] nums = new int[]{1,5,1};
//        solution.nextPermutation(nums);
//        for (int num : nums){
//            System.out.println(num);
//        }


        /**
         * 33.
         */
//        Solution solution = new Solution();
//        int result = solution.search(new int[]{4,5,6,7,0,1,2},0);
//        System.out.println(result);

        /**
         * 34.
         */
//        Solution solution = new Solution();
//        int[] result = solution.searchRange(new int[]{5,7,7,8,8,8,10,20},8);
//        for (int num : result){
//            System.out.println(num);
//
//        }
        /**
         * 35.
         */
//        Solution solution = new Solution();
//        int a = solution.searchInsert2(new int[]{1,3,5,7}, 0);
//        System.out.println(a);


        /**
         * 38.
         */

//        Solution solution = new Solution();
//        String a = solution.countAndSay(4);
//        System.out.println(a);

//        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        System.out.printf("%s\n", a);

//        int a = 4;
//        if ((a & 0x1) == 1){
//            System.out.println("ha");
//        }

        /**
         * 43.
         */
//        Solution solution = new Solution();
//        String str = solution.multiply("123", "2");
//        System.out.println(str);
        /**
         * 46.
         */
//        Solution solution = new Solution();
//        List list = solution.permute(new int[]{1,2,3});
//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

        /**
         * 47.
         */
//        boolean[] a = new boolean[3];
//
//        for (boolean as : a){
//            System.out.println(as);
//        }


    }

    static List<List<String>> queenList = new ArrayList<>();

    public static void bulid(int[] nums) {
        List<String> tempList = new ArrayList<>();

        String[] strs = new String[nums.length];
        for (int j = 0; j < strs.length; j++) {
            strs[j] = ".";
        }

        for (int i = 0; i < nums.length; i++) {

            strs[i] = "Q";
//            tempList.addAll(Arrays.asList(strs));
            tempList.add(String.valueOf(strs));

            strs[i] = ".";
        }


        queenList.add(new ArrayList<>(tempList));
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
    public static ListNode create(int[] arr) {
        //判断输入是否合法
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        for (int i : arr) {
            ListNode cur = new ListNode(i);
            if (head == null) {
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
     *
     * @param head
     */
    public void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.print("null");
    }

    public static void print(int num, Object obj) {
        System.out.println(String.format("%d + %s", num, obj.toString()));
    }


}
