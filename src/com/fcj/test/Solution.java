package com.fcj.test;

import com.fcj.test.publicClass.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Administrator on 2017/2/18 0018.
 */
public class Solution {

    /**
     * 1. Two Sum
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i ++){
            for (int j = i + 1; j < nums.length; j ++){
                if ((nums[i] + nums[j]) == target){
                    int[] arr = {i, j};
                    return arr;
                }
            }
        }
        return null;

//        int[] result = new int[2];
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i])) {
//                result[1] = i + 1;
//                result[0] = map.get(target - nums[i]);
//                return result;
//            }
//            map.put(nums[i], i + 1);
//        }
//        return result;
    }


    /**
     * 2. Add Two Numbers
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {//carry != 0的情况别忘了
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;//因为head是指向了最开始的ListNode(0)的，所以要return head.next
    }

/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1==null && l2==null){
            return carry == 0? null : new ListNode(carry);
        }
        if(l1==null && l2!=null){
            l1 = new ListNode(0);
        }
        if(l2==null && l1!=null){
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + carry;
        ListNode curr = new ListNode(sum % 10);
        curr.next = helper(l1.next, l2.next, sum / 10);
        return curr;
    }*/

    /**
     *3. Longest Substring Without Repeating Characters
     */
    public int lengthOfLongestSubstring(String s) {

//        if (s.length()==0) return 0;
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max=0;
//        for (int i=0, j=0; i<s.length(); ++i){
//            if (map.containsKey(s.charAt(i))){
//                j = Math.max(j,map.get(s.charAt(i))+1);
//            }
//            map.put(s.charAt(i),i);
//            max = Math.max(max,i-j+1);
//        }
//        return max;
//    }

        if (s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            if (hashMap.containsKey(s.charAt(i))){
                j = Math.max(j, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;

    }

    /**
     * 7. Reverse Integer
     *
     */
    public int reverse(int x){
        int result = 0;
        int newresult = 0;

        while (x != 0){
            int temp = x % 10;
            newresult = result * 10 + temp;
            if ((newresult - temp) / 10 != result){
                return 0;
            }
            result = newresult;
            x /= 10;
        }

        return result;
    }

    /**
     *9. Palindrome Number
     */
    public boolean isPalindrome(int x) {

        if (x<0 || (x!=0 && x%10==0))
            return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

//        if (x < 0 || (x != 0 && x % 10 == 0)){
//            return false;
//        }
//        int a = x;
//        int result = 0;
//        int newresult = 0;
//        while (x != 0){
//            int temp = x % 10;
//            newresult = result * 10 + temp;
//            if ((newresult - temp) / 10 != result){
//                return false;
//            }
//            x /= 10;
//            result = newresult;
//        }
//        if (a == result){
//            return true;
//        } else {
//            return false;
//        }

    public int romanToInt(String s){
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int len = s.length();
        int result = hashMap.get(s.charAt(len - 1));
        for (int i = len - 1; i >= 1; i--){
            if (hashMap.get(s.charAt(i - 1)) >= hashMap.get(s.charAt(i))){
                result += hashMap.get(s.charAt(i - 1));
            } else {
                result -= hashMap.get(s.charAt(i - 1));
            }
        }

        return result;

    }

    /**
     * 14. Longest Common Prefix
     */
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0)
            return "";

        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;

//        if (strs.length == 0){
//            return "";
//        }
//
//        for (String tem : strs){
//            if (tem == ""){
//                return "";
//            }
//        }
//
//
//
//        if (strs.length == 1){
//            return strs[0];
//        }
//
//        int max = findMax(strs[0], strs[1]);
//        for (int i = 2; i < strs.length; i++){
//
//            int temp = findMax(strs[0], strs[i]);
//            if (temp < max){
//                max = temp;
//            }
//
//        }
//
//        return strs[0].substring(0, max);

    }

    public int findMax(String a, String b){
        int len = Math.min(a.length(), b.length());
        int max = 0;
        for (int i = 0; i < len; i++){
            if (a.charAt(i) == b.charAt(i)){
                max++;
            } else {
                break;
            }
        }
        return max;
    }


    /**
     * 20. Valid Parentheses 使用了Stack
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (char tem : s.toCharArray()){

            if (tem == '('){
                stack.push(')');
            } else if (tem == '{'){
                stack.push('}');
            } else if (tem == '['){
                stack.push(']');
            } else {
                if (stack.isEmpty() || tem != stack.pop()){
                    return false;
                }
            }

        }

        return stack.isEmpty();

    }

    /**
     * 21. Merge Two Sorted Lists
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode prev = head;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            }
            if (l1.val > l2.val){
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }

        if (l1 == null){
            prev.next = l2;
        }
        if (l2 == null){
            prev.next = l1;
        }

        System.out.println("ha");

        return head.next;


    }

}
