package com.fcj.test;

import com.fcj.test.JianzhiOffer.TreeNode;
import com.fcj.test.publicClass.ListNode;


import java.util.*;


/**
 * Created by Administrator on 2017/2/18 0018.
 */
public class Solution {

    /**
     * 1. Two Sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {




/*        //也正确
        for (int i = 0; i < nums.length - 1; i ++){
            for (int j = i + 1; j < nums.length; j ++){
                if ((nums[i] + nums[j]) == target){
//                    int[] arr = {i, j};
//                    return arr;
                    return new int[]{i, j};
                }
            }
        }
        return null;*/

        //网上答案
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


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i) {
                return new int[]{i, map.get(result)};
            }
        }
        return null;

    }


    /**
     * 2. Add Two Numbers
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
/*        ListNode prev = new ListNode(0);
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
        return head.next;//因为head是指向了最开始的ListNode(0)的，所以要return head.next*/

        ListNode head = null;
        ListNode prev = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;

    }


    /**
     * 3. Longest Substring Without Repeating Characters
     */
    public int lengthOfLongestSubstring1(String s) {

        int max = 0;

        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }

        return max;


//        if (s.length() == 0){
//            return 0;
//        }
//        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
//        int max = 0;
//        for (int i = 0, j = 0; i < s.length(); i++){
//            if (hashMap.containsKey(s.charAt(i))){
//                j = Math.max(j, hashMap.get(s.charAt(i)) + 1);
//            }
//            hashMap.put(s.charAt(i), i);
//            max = Math.max(max, i - j + 1);
//        }
//        return max;

    }


    /**
     * 4. Median of Two Sorted Arrays
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int sum = m + n;

        if (m == 0 && n == 0) {
            return 0;
        }

        int[] arrs = new int[sum];
        for (int i = 0, j = 0, k = 0; i < m || j < n; ) {
            if (i < m && j < n) {
                arrs[k++] = (nums1[i] <= nums2[j]) ? nums1[i++] : nums2[j++];
            } else if (i < m) {
                arrs[k++] = nums1[i++];
            } else {
                arrs[k++] = nums2[j++];
            }


        }
        if (sum % 2 == 0) {
            return (arrs[sum / 2] + arrs[sum / 2 - 1]) / 2.0;
        } else {
            return arrs[sum / 2];
        }

    }

    /**
     * 5. Longest Palindromic Substring
     *
     * @param s
     * @return
     */
    //这方法肯定不行啊
    public String longestPalindrome(String s) {


        int max = 0;
        int nums[] = new int[2];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                String str = s.substring(i, j + 1);
                StringBuffer stringBuffer = new StringBuffer(str);
                if (str.equals(stringBuffer.reverse().toString()) && str.length() > max) {
                    max = str.length();
                    nums[0] = i;
                    nums[1] = j + 1;
                }
            }
        }

        return s.substring(nums[0], nums[1]);

    }

    /**
     * 6. ZigZag Conversion
     */
    public String convert(String s, int numRows) {

        if (s.length() == 0) {
            return "";
        }
        if (numRows == 0) {
            return "numRows输入错误";
        }
        if (numRows == 1) {
            return s;
        }


        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j % (2 * numRows - 2) == i || j % (2 * numRows - 2) == (2 * numRows - 2 - i)) {
                    stringBuffer.append(s.charAt(j));
                }
            }

        }
        return String.valueOf(stringBuffer);

    }

    public String convert2(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    /**
     * 7. Reverse Integer
     */
    public int reverse(int x) {
//        int result = 0;
//        int newresult = 0;
//
//        while (x != 0){
//            int temp = x % 10;
//            newresult = result * 10 + temp;
//            if ((newresult - temp) / 10 != result){
//                return 0;
//            }
//            result = newresult;
//            x /= 10;
//        }
//
//        return result;

//        StringBuffer stringBuffer = new StringBuffer("AGGG");
//        stringBuffer.reverse();


        int temp = x;

        String s = String.valueOf((x >= 0) ? x : (-x));
        StringBuffer sb = new StringBuffer(s);
        String s1 = String.valueOf(sb.reverse());
        int result = Integer.parseInt(s1);
        if (x >= 0) {
            return result;
        } else {
            return -result;
        }


    }

    /**
     * 9. Palindrome Number
     */
    public boolean isPalindrome(int x) {

        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }


    /**
     * 13. Roman to Integer
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
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
        for (int i = len - 1; i >= 1; i--) {
            if (hashMap.get(s.charAt(i - 1)) >= hashMap.get(s.charAt(i))) {
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

        for (String arr : strs) {
            if (arr.equals("")) {
                return "";
            }
        }
        if (strs.length == 1) {
            return strs[0];
        }


        String str = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int max = 0;
            for (int j = 0; j < str.length() && j < strs[i].length(); j++) {
                if (str.charAt(j) == strs[i].charAt(j)) {
                    max = j + 1;
                } else {
                    break;
                }
            }
            str = str.substring(0, max);
        }
        return str;


//        if(strs == null || strs.length == 0)
//            return "";
//
//        String pre = strs[0];
//        int i = 1;
//        while(i < strs.length){
//            while(strs[i].indexOf(pre) != 0)
//                pre = pre.substring(0,pre.length()-1);
//            i++;
//        }
//        return pre;


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

    public int findMax(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                max++;
            } else {
                break;
            }
        }
        return max;
    }

    /**
     * 15.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();

        int lo = 0, lm = 0, sum = 0;
        for (int index = 0; index < nums.length - 2; index++) {
            if (index == 0 || nums[index] != nums[index - 1]) {
                lo = index + 1;
                lm = nums.length - 1;
                sum = 0 - nums[index];
                while (lo < lm) {
                    if (nums[lo] + nums[lm] == sum) {
                        list.add(Arrays.asList(nums[index], nums[lo], nums[lm]));
                        while (lo < lm && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < lm && nums[lm] == nums[lm - 1]) {
                            lm--;
                        }
                        lo++;
                        lm--;
                    } else if (nums[lo] + nums[lm] < sum) {
                        lo++;
                    } else {
                        lm--;
                    }
                }
            }
        }

        return list;

//        List<List<Integer>> list = new LinkedList();
//        List<Integer> listIn = new LinkedList<Integer>();
//
//        int target = 0;
//        int value = 0;
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        for (int i = 0; i < nums.length; i++){
//            if (! map.containsKey(nums[i])){
//                map.put(nums[i], value);
//                value++;
//            }
//        }
//
//        for (int i = 0; i < nums.length - 2; i++){
//            for (int j = i + 1; j < nums.length - 1; j++){
//                target = 0 - nums[i] - nums[j];
//                if (map.containsKey(target) && map.get(target) > j){
//                    listIn.add(nums[i]);
//                    listIn.add(nums[j]);
//                    listIn.add(target);
//                    list.add(listIn);
//                }
//            }
//        }
//
//        return list;

    }

    /**
     * 16. 3Sum Closest
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];
        int temp = 0;
        int cha = Math.abs(sum - target);
        int len = nums.length;
        int index = 1;

        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                temp = nums[i] + nums[j] + nums[k];
                index = (temp - target >= 0) ? 1 : -1;

                if (cha > Math.abs(temp - target)) {
                    cha = Math.abs(temp - target);
                    sum = temp;
                }

                if (index > 0) {
                    k--;
                } else {
                    j++;
                }

            }
        }

        return sum;
    }

    /**
     * 17. Letter Combinations of a Phone Number
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

//        List<String> list = new ArrayList<>();
//
//        StringBuffer stringBuffer = new StringBuffer();
//
//
//        Map<Integer, String> map = new HashMap<Integer, String>();
//        map.put(2, "abc");
//        map.put(3, "def");
//        map.put(4, "ghi");
//
//        Integer key;
//        String val;
//
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()){
//            Map.Entry entry = (Map.Entry) it.next();
//            key = (Integer) entry.getKey();
//            val = (String) entry.getValue();
//            System.out.println(key + " " + val);
//        }
//
//        int num = 0;
//        String value;
//        for (int i = 0; i < digits.length(); i++){
//            num = digits.charAt(i) - '0';
//            value = map.get(num);
//
//        }

        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;

    }

    /**
     * 19.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = head;

        if (curr.next == null) {
            return null;
        }

        int j = 0;

        while (curr.next != null) {
            curr = curr.next;
            j++;
            if (j > n) {
                prev = prev.next;
            }
        }
        if (j == n - 1) {
            return head.next;
        } else {
            prev.next = prev.next.next;
            return head;
        }
    }


    /**
     * 18. 4Sum
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList();
        List<Integer> listin = new LinkedList();

        int len = nums.length;
        int result = 0;
        int lo = 0;
        int lm = 0;

        for (int i = 0; i < len - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < len - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        result = target - nums[i] - nums[j];
                        lo = j + 1;
                        lm = len - 1;
                        while (lo < lm) {
                            if (nums[lo] + nums[lm] == result) {
                                list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[lm]));

                                while (lo < lm && nums[lo] == nums[lo + 1]) {
                                    lo++;
                                }
                                while (lo < lm && nums[lm] == nums[lm - 1]) {
                                    lm--;
                                }
                                lo++;
                                lm--;
                            } else if (nums[lo] + nums[lm] < result) {
                                lo++;
                            } else {
                                lm--;
                            }
                        }
                    }

                }

            }

        }

        return list;


    }

    /**
     * 20. Valid Parentheses 使用了Stack
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (char tem : s.toCharArray()) {

            if (tem == '(') {
                stack.push(')');
            } else if (tem == '{') {
                stack.push('}');
            } else if (tem == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || tem != stack.pop()) {
                    return false;
                }
            }

        }

        return stack.isEmpty();

    }

    /**
     * 21. Merge Two Sorted Lists 利用了递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
//
//            //错误
//        ListNode head = new ListNode(0);
//        ListNode prev = head;
//
//        while (l1.next != null && l2.next != null){
//
//            if (l1.val < l2.val){
//                prev.next = l1;
//                prev = l1;
//                l1 = l1.next;
//            }
//            if (l1.val > l2.val){
//                prev.next = l2;
//                prev = l2;
//                l2 = l2.next;
//            }
//        }
//
//        if (l1.next == null){
//            prev.next = l2;
//        }
//        if (l2.next == null){
//            prev.next = l1;
//        }
//
//        return head.next;


    }

    /**
     * 28. Implement strStr()
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // int index = 0;

        // index = haystack.indexOf(needle);
        // return index;
        int len1 = haystack.length();
        int len2 = needle.length();

        if (len1 == 0 && len2 == 0) {
            return 0;
        }
        if (len1 < len2) {
            return -1;
        }
        int index = -1;
        int num = 0;
        int temp = 0;
        int temp2 = 0;

        for (int i = 0; i < haystack.length(); i++) {
            temp = i;//不能放在第二个for循环里
            num = 0;//重要
            temp2 = i;
            for (int j = 0; j < needle.length(); j++) {

                if (temp2 >= len1) {
                    break;
                }
                if (haystack.charAt(temp2) != needle.charAt(j)) {
                    break;
                } else {
                    temp2++;
                    num++;
                }


            }
            if (num == needle.length()) {
                index = temp;
                break;
            }
        }

        return index;
    }


    /**
     * 27简单
     */

    /**
     * 28. Implement strStr()
     */


    /**
     * 29. Divide Two Integers
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE) { //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }


    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= target) {
                return i;
            }
            result = i + 1;

        }
        return result;
    }

    /**
     * 33.
     */
    public int search(int[] nums, int target) {
        // for (int i = 0; i < nums.length; i++){
        //     if (nums[i] == target){
        //         return i;
        //     }
        // }
        // return -1;
        int len = nums.length;
        int min = 0;
        int max = len - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (nums[mid] == target) {
                return mid;
            }
//            if (nums[min] == target){
//                return min;
//            }
//            if (nums[max] == target){
//                return max;
//            }
            if (nums[mid] >= nums[min]) {
                if (nums[min] <= target && target < nums[mid]) {//这里的等号不能落，否则会少项
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
//                break;不能有break
            } else {
                if (nums[mid] < target && target <= nums[max]) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }

        }
        return -1;
    }

    /**
     * 34.
     *
     * @param A
     * @param target
     * @return
     */
    public int[] searchRange(int[] A, int target) {

        int start = Solution.firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        //下面可以是target+1，虽然有可能没有，但找到的还是正确的
        return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    //actually this is the same as lower_bound in C++ STL.
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;//这里的high没有-1
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;//此方法并不是一般的二分查找，因为前面没有return，它的目的是为了return最后的low

    }

    /**
     * 36. Valid Sudoku
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<Character>();
            Set<Character> columns = new HashSet<Character>();
            Set<Character> cubes = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                int column = i % 3;
                int row = i / 3;
                int a = j % 3;
                int b = j / 3;
                if (board[3 * row + b][3 * column + a] != '.' && !cubes.add(board[3 * row + b][3 * column + a])) {
                    return false;
                }

            }
        }

        return true;


    }

    /**
     * 38. Count and Say
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        StringBuffer stringBuffer = new StringBuffer("1");
        if (n == 1) {
            return stringBuffer.toString();
        }
        int index = 1;

        while (index < n) {
            StringBuffer stringBuffer2 = new StringBuffer();

            String str = stringBuffer.toString();
            int len = str.length();
            char curr = str.charAt(0);
            int num = 1;

            for (int i = 1; i < len; i++) {
                if (str.charAt(i) == curr) {
                    num++;
                } else {
                    stringBuffer2.append(num).append(curr);
                    curr = str.charAt(i);
                    num = 1;
                }
            }
            stringBuffer2.append(num).append(curr);
            stringBuffer = stringBuffer2;
            index++;
        }

        return stringBuffer.toString();

//        StringBuilder curr=new StringBuilder("1");
//        StringBuilder prev;
//        int count;
//        char say;
//        for (int i=1;i<n;i++){
//            prev=curr;
//            curr=new StringBuilder();
//            count=1;
//            say=prev.charAt(0);
//
//            for (int j=1,len=prev.length();j<len;j++){
//                if (prev.charAt(j)!=say){
//                    curr.append(count).append(say);
//                    count=1;
//                    say=prev.charAt(j);
//                }
//                else count++;
//            }
//            curr.append(count).append(say);
//        }
//        return curr.toString();


    }

    /**
     * 43. Multiply Strings这里是大数问题
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] num = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p0 = i + j, p1 = i + j + 1;

                int sum = mul + num[p1];

                num[p0] = num[p0] + sum / 10;
                num[p1] = sum % 10;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int arr : num) {
            if (stringBuffer.length() == 0 && arr == 0) {
                continue;
            }
            stringBuffer.append(arr);
        }
//        if (num[0] == 0){
//            for (int i = 1; i < num.length; i++){
//                stringBuffer.append(num[i]);
//            }
//        } else {
//            for (int arr : num){
//                stringBuffer.append(arr);
//            }
//
//        }

        return (stringBuffer.length() == 0) ? "0" : stringBuffer.toString();
    }

    /**
     * 46. Permutations
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        back(list, new ArrayList(), nums);
        return list;
    }

    public void back(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(tempList);
//            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                back(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public int haha() {
        int x = 1211;
        String temp = String.valueOf(x);
        int len = temp.length();
        int c = x / 10;
        int result = 0;
        for (int i = 1; i < temp.length(); i++) {
            x = (int) (x - c * Math.pow(10, len - i));
            int num = 1;
            if (x < 10) {
                if (x == c) {
                    num++;
                }
            }
            if (x / 10 == c) {
                num++;

            }

            result = num * 10 + c;

            c = x / 10;
        }

        return result;
    }

    public int maxSubArray(int[] nums) {
//        //网上答案
//        int n = A.length;
//        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
//        dp[0] = A[0];
//        int max = dp[0];
//
//        for(int i = 1; i < n; i++){
//            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
//            max = Math.max(max, dp[i]);
//        }
//
//        return max;

        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            int max = sum;
            for (int j = i + 1; j < nums.length; j++) {

                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }

            }
            if (result < max) {
                result = max;
            }

        }

        return result;
    }

    public int lengthOfLastWord(String s) {

        String temp;
        temp = s.trim();
        int len = temp.length();
        if (len == 0) {
            return 0;
        }
        int index = temp.lastIndexOf(" ");
        if (index != -1) {
            return len - 1 - index;
        } else {
            return len;
        }


    }

    /**
     * 66. Plus One
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int sum = 0;
        int newsum;
        for (int temp : digits) {
            sum = sum * 10 + temp;
        }
        newsum = sum + 1;

//        char a = '3';
//        int b = a;
//        System.out.println(b);

        String str = String.valueOf(newsum);
        int len = str.length();
        int num[] = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = Integer.parseInt(str.charAt(i) + "");
        }
        return num;

    }

//    public String addBinary(String a, String b) {
//
//    }

    public int climbStairs(int n) {

//        if(n == 1){
//            return 1;
//        }
//        if(n == 2){
//            return 2;
//        }
//
//        int i = 1;
//        int num = 0;
//
////        while (n - 2 * i >= 1){
//        num = climbStairs(n - 2 * i) + climbStairs(n - 2 * i + 1);
////            i++;
////        }
//
//        return num;


//        int a = 1, b = 1;
//        while (n-- > 0)
//            a = (b += a) - a;
//        return a;

        // base cases
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode Head = head;
        ListNode prev = head;
        ListNode curr = head;

        if (head == null) {
            return null;
        }

        while (curr.next != null) {
            curr = curr.next;
            if (curr.val != prev.val) {
                prev.next = curr;
                prev = curr;
            }
        }
        prev.next = null;
        return Head;
    }

    //这个方法好，数组从后往前分享，这样的话，原来的数组值就不会变
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }


    //华为
    public void sort(int[] arrs) {

        int len = arrs.length;
        if (len <= 1) {
            return;
        }
        for (int j = len - 1; j > 0; j--) {
            if (arrs[j] == j)
                continue;
            Solution.swap_with_zero(arrs, arrs[j]);
            int max = arrs[0];
            for (int i = 1; i < j; i++) {
                if (arrs[i] > max) {
                    max = arrs[i];
                }
            }
            Solution.swap_with_zero(arrs, max);
        }


    }

    public static void chansheng(int[] rawArray, int n) {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();

        int count = 0;
        int rn = 0;

        for (; count < n; ) {//这里不能是<=，否则它会是一直continue
            rn = random.nextInt(n);
            if (set.contains(rn)) {
                continue;
            }
            set.add(rn);
            rawArray[count] = rn;
            count++;
        }
    }

    public void print(int[] arrs) {
        for (int num : arrs) {
            System.out.print(num + " ");
        }
    }

    public static void swap_with_zero(int[] array, int number) {
        int len = array.length;
        int zIndex = -1;
        int nIndex = -1;
        for (int i = 0; i < len; ++i) {
            if (array[i] == 0) {
                zIndex = i;
            }
            if (array[i] == number) {
                nIndex = i;
            }
        }
        int temp = array[zIndex];
        array[zIndex] = array[nIndex];
        array[nIndex] = temp;

    }

    public int findMost2ofNums(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Collection<Integer> collection = map.values();
        ArrayList<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);

        int k = list.get(list.size() - 2);
        int result = 0;


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == k) {
                result = entry.getKey();
            }
        }

        return result;
    }

    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if (s == null || len == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        Map<Character, Character> map = new HashMap<>();

        int max = 0;
        int temp = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!map.containsKey(chars[j])) {
                    temp++;
                    map.put(chars[j], chars[j]);
                } else {
                    break;
                }
            }

            if (temp > max) {
                max = temp;
            }
            temp = 0;
            map.clear();

        }

        return max;
    }

    public List<String> letterCombinations3(String digits) {

        int len = digits.length();

        LinkedList<String> list = new LinkedList<>();
//        List<String> list = new LinkedList<>();这样写下面的peek()就出不来

        if (len == 0 || digits == null) {

            return list;

        }

        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        list.add("");//这步一定要有
        for (int i = 0; i < len; i++) {
            int x = digits.charAt(i) - '0';
            while (list.peek().length() == i) {
                String temp = list.remove();
                for (char s : map[x].toCharArray()) {
                    list.add(temp + s);
                }

            }

        }

        return list;
    }

    public List<List<Integer>> fourSum12(int[] nums, int target) {

        List<List<Integer>> list = new ArrayList<>();

        int len = nums.length;

        if (nums == null || len < 4) {
            return list;
        }

        Arrays.sort(nums);

        int max = nums[len - 1];

        if (4 * nums[0] > target || 4 * max < target) {
            return list;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            int temp = nums[i];
            if (i > 0 && nums[i - 1] == temp) {
                continue;
            }
            if (temp + 3 * max < target) {
                continue;
            }
            if (4 * temp > target) {
                break;
            }
            if (4 * temp == target) {
                if (i + 3 < len && nums[i + 3] == temp) {
                    list.add(Arrays.asList(temp, temp, temp, temp));
                    break;
                }
            }

            threeSumForFourSum(nums, target - temp, i + 1, len - 1, list, temp);
        }

        return list;
    }

    public void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> fourSumList,
                                   int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> fourSumList,
                                 int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }


    public int strStr1(String haystack, String needle) {

        int lenH = haystack.length();
        int lenN = needle.length();

        for (int i = 0; i <= lenH - lenN; i++) {
            int index = 0;
            for (int j = i; j < lenN; j++) {
                if (needle.charAt(j) != haystack.charAt(i)) {
                    break;
                } else {
                    index++;
                }
            }
            if (index == lenN) {
                return i;
            }
        }

        return -1;
    }

    public int divide1(int dividend, int divisor) {

        if (divisor == 0) {

            return Integer.MAX_VALUE;
        }

//        //要先换成正数，否则-18除以4就变成0了
//        if (dividend == 0 || dividend < divisor) {
//            return 0;
//        }

        int sign = 1;
        //不管什么情况，建议都加括号以防万一
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        //要加long
//        long ldividend = (long) Math.abs(dividend);
//        long ldivisor = (long) Math.abs(dividend);
        long ldividend = (long) Math.abs((long) dividend);
        long ldivisor = (long) Math.abs((long) divisor);

        if (ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }

        long result = back(ldividend, ldivisor);

        if (result > Integer.MAX_VALUE) {
            return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
        }

        return (int) (sign == 1 ? result : (0 - result));
    }

    public long back(long dividend, long divisor) {

        if (dividend < divisor) {
            return 0;
        }

        long sum = divisor;
        long mul = 1;
        while (sum + sum <= dividend) {
            sum += sum;
            mul += mul;
        }

        return mul + back(dividend - sum, divisor);
    }


    public void nextPermutation(int[] num) {

        int len = num.length;

        if (len < 2) {
            return;
        }

        int index = len - 1;
        while (index > 0) {
            if (num[index - 1] < num[index]) {
                break;
            }
            index--;
        }

        if (index == 0) {
            reverse(num, 0, len - 1);
        } else {
            int val = num[index - 1];
            int indexN = index;
            while (indexN < len - 1) {
                if (num[indexN + 1] <= val) {
                    break;
                }
                indexN++;
            }
            swap(num, index - 1, indexN);
            reverse(num, index, len - 1);
        }
    }

    public void reverse(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end - start) >> 1;
        for (int i = 0; i <= mid; i++) {
            swap(num, start + i, end - i);
        }
    }

    public void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }

    public int searchInsert2(int[] nums, int target) {

        int len = nums.length;

        if (nums == null || len == 0) {
            return 0;
        }

        return back(nums, 0, len - 1, target);

    }

    public int back(int[] nums, int left, int right, int target) {

        if (left > right) {
            return left;
        }

//        if (left == right){
//            if (nums[left] == target){
//                return left;
//            } else if (nums[left] < target){
//                return left + 1;
//            } else {
//                if (left > 0){
//                    return left - 1;
//                } else {
//                    return 0;
//                }
//
//            }
//        }

        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return back(nums, left, mid - 1, target);
        } else {
            return back(nums, mid + 1, right, target);
        }
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public String getPermutation(int n, int k) {

        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }

//    public String getPermutation(int n, int k) {
//
//        List<List<Integer>> list = new LinkedList<>();
//
//        List<Integer> listTemp = new LinkedList<>();
//
//        List<Integer> listR = new LinkedList<>();
//
//        backP(n, k, list, listTemp);
//
//        listR = list.get(k - 1);
//
//        String result = "";
//
//        for (int num : listR){
//            result = result + num;
//        }
//
//        return result;
//
//    }

    public void backP(int n, int k, List<List<Integer>> list, List<Integer> listTemp) {

        if (listTemp.size() == n) {
            list.add(new LinkedList<>(listTemp));
            if (list.size() == k) {
                return;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (listTemp.contains(i)) {
                    continue;
                } else {
                    listTemp.add(i);
                    backP(n, k, list, listTemp);
                    listTemp.remove(listTemp.size() - 1);
                }

            }
        }

    }

    public boolean exist(char[][] board, String word) {

        int row = board.length;

        if (board == null || row == 0) {
            return false;
        }

//        boolean result = false;

        int column = board[0].length;
        boolean[][] flag = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
//                下面这样写是错的，因为result会被覆盖
//                result = existBack(board, word, i, j,0);
                if (existBack(board, flag, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;


    }

    public boolean existBack(char[][] board, boolean[][] flag, String word, int i, int j, int index) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
            return false;
        }

        if (flag[i][j] || board[i][j] != word.charAt(index)) {
//        if (board[i][j] != word.charAt(index)){
            return false;
        }

        flag[i][j] = true;
//        board[i][j] ^= 256;
        boolean exist = existBack(board, flag, word, i + 1, j, index + 1)
                || existBack(board, flag, word, i - 1, j, index + 1)
                || existBack(board, flag, word, i, j + 1, index + 1)
                || existBack(board, flag, word, i, j - 1, index + 1);
        flag[i][j] = false;
//        board[i][j] ^= 256;

        return exist;
    }


    public int removeDuplicates(int[] nums) {

        int len = nums.length;

        if (nums == null || len == 0) {
            return 0;
        }

        int index = 0;
        int n = 0;

        for (int i = 0; i < len; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                nums[index++] = nums[i];
                n = 1;
            } else if (n < 2 && nums[i] == nums[i - 1]) {
                nums[index++] = nums[i];
                n = 2;
            }
        }

        return index;

    }

    public boolean search22(int[] nums, int target) {

        int len = nums.length;

        if (nums == null || len == 0) {
            return false;
        }

        int left = 0;
        int right = len - 1;


        while (left <= right) {

            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            }


//            if (nums[mid] >= nums[left]){在可能有重复数字的时候，这样比较是不够的
//                if (target >= nums[left] && target < nums[mid]){
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            } else {
//                if (target > nums[mid] && target <= nums[right]){
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }

            if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left] || nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {//表示num[mid] == nums[left] == nums[right]
                right--;//也可以是left++;
            }
        }

        return false;

    }

    public ListNode deleteDuplicates2(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode head2 = new ListNode(0);
        ListNode prev = head2;

        ListNode curr = head;
//        ListNode temp = head;

        int index = 0;
        int tempNum = curr.val;

        while (curr != null) {
            if (curr.val == tempNum) {
                index++;
                curr = curr.next;
//                temp = temp.next;
            } else {
                if (index == 1) {
                    ListNode temp = new ListNode(tempNum);
                    prev.next = temp;
                    prev = prev.next;
                    tempNum = curr.val;
                    curr = curr.next;
                } else {
                    index = 1;
                    tempNum = curr.val;
                    curr = curr.next;
                }
            }
        }

        if (index == 1) {
            ListNode temp = new ListNode(tempNum);
            prev.next = temp;
        }

        return head2.next;

    }

    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode headLess = new ListNode(0);
        ListNode currLess = headLess;

        ListNode headGreater = new ListNode(0);
        ListNode currGreater = headGreater;

        ListNode head1 = head;

        while (head1 != null) {
            if (head1.val < x) {
                currLess.next = head1;
                currLess = currLess.next;
                head1 = head1.next;
            } else {
                currGreater.next = head1;
                currGreater = currGreater.next;
                head1 = head1.next;
            }
        }

        currGreater.next = null;
        currLess.next = headGreater.next;

        return headLess.next;
    }


    public List<Integer> grayCode(int n) {

        List<Integer> list = new ArrayList<>();

        if (n == 0) {
            return list;
        }

        List<List<Integer>> listOut = new ArrayList<>();
        List<Integer> listIn = new ArrayList<>();

        grayCodeBack(listOut, listIn, n, 0);

        for (List<Integer> list1 : listOut) {

            list.add(grayNum(list1));

        }

        return list;


    }

    public void grayCodeBack(List<List<Integer>> listOut, List<Integer> listIn, int n, int start) {

        if (listIn.size() == n) {
//            listOut.add(listIn);
            listOut.add(new ArrayList<>(listIn));
            return;
        }

        for (int i = start; i < n; i++) {
            listIn.add(0);
            grayCodeBack(listOut, listIn, n, i + 1);
            listIn.remove(listIn.size() - 1);
            listIn.add(1);
            grayCodeBack(listOut, listIn, n, i + 1);
            listIn.remove(listIn.size() - 1);

        }
    }

    public int grayNum(List<Integer> list) {

        int len = list.size();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += Math.pow(2, len - 1 - i) * list.get(i);
        }

        return sum;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }

        ListNode head1 = new ListNode(0);
        head1.next = head;
        ListNode headInit = head1;

        ListNode nodeBeforeM = new ListNode(0);
        ListNode nodeM = new ListNode(0);
        ListNode curr = new ListNode(0);
        ListNode prev = new ListNode(0);

        int index = 0;
        while (head1 != null) {
            if (index < m - 1) {
                head1 = head1.next;
                index++;
            } else if (index == m - 1) {
                nodeBeforeM = head1;
                head1 = head1.next;
                index++;
            } else if (index == m) {
                nodeM = head1;
                prev = nodeM;
                head1 = head1.next;
                curr = head1;
                index++;
            } else if (index < n) {
                head1 = head1.next;
                curr.next = prev;
                prev = curr;
                curr = head1;
                index++;
            } else if (index == n) {
                head1 = head1.next;
                curr.next = prev;
                prev = curr;
                curr = head1;
                index++;
            } else if (index > n) {
                break;
            }
        }

        nodeBeforeM.next = prev;
        nodeM.next = curr;

        return headInit.next;

    }

    public String replaceSpace(StringBuffer str) {
        int len = str.length();

        if (str == null || len == 0) {
            return "";//这里不是return null
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                index++;
            }
        }

        char[] chars = new char[len + index * 2];//应该是*2，不是*3
        int num = len + index * 2 - 1;//这里-1别忘了
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                chars[num--] = '0';
                chars[num--] = '2';
                chars[num--] = '%';
            } else {
                chars[num--] = str.charAt(i);
            }
        }

        return String.valueOf(chars);

    }

    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode != null) {
//            printListFromTailToHead(listNode.next);
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }

        return list;
    }

    public int minNumberInRotateArray(int[] array) {

        int len = array.length;
        if (array == null || len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            if (right - left == 1) {
                break;
            }
            int mid = (left + right) >> 1;

            if (array[mid] > array[left] || array[mid] > array[right]) {
                left = mid;
            } else if (array[mid] < array[left] || array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return array[left] > array[right] ? array[right] : array[left];
    }

    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        } else if (exponent > 0) {
            return back(base, exponent);
        } else {
            if (base > -0.00001 && base < 0.00001) {
                return 0.0;
            } else {
                return 1 / back(base, exponent * (-1));
            }
        }
    }

    public double back(double base, int exponent) {
        double temp = 1.0;
        while (exponent > 0) {
            temp *= base;
            exponent--;
        }
        return temp;
    }

    public void reOrderArray(int[] array) {
        int len = array.length;

        int[] nums = new int[len];

        int indexJi = 0;
        int indexOu = len - 1;
        for (int i = 0; i < len; i++) {
            if ((array[i] & 1) == 1) {
                nums[indexJi++] = array[i];
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if ((array[i] & 1) == 0) {
                nums[indexOu--] = array[i];
            }
        }

        for (int i = 0; i < len; i++) {
            array[i] = nums[i];
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        boolean result = false;
        if (root1.val == root2.val) {
            result = subBack(root1, root2);

        }

        if (!result) {
            result = HasSubtree(root1.left, root2);
        }

        if (!result) {
            result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    public boolean subBack(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null || root1.val != root2.val) {
            return false;
        }

        return subBack(root1.left, root2.left) && subBack(root1.right, root2.right);
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
//        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();

            list.add(temp.val);
//            queue.add(temp.left);这样会有误的
//            queue.add(temp.right);

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return list;
    }

    public boolean VerifySquenceOfBST(int[] sequence) {

        int len = sequence.length;

        if (sequence == null || len == 0) {
            return false;
        }

        return bstBack(sequence, 0, len - 1);

    }

    public boolean bstBack(int[] sequence, int start, int end) {

        if (start >= end) {
            return true;
        }

        int temp = sequence[end];
        int index = end;
        for (int i = start; i < end; i++) {
            if (sequence[i] < temp) {
                continue;
            } else {
                index = i;
                break;//别忘了
            }
        }

        for (int i = index; i <= end; i++) {
            if (sequence[i] < temp) {
                return false;
            }
        }

        return bstBack(sequence, start, index - 1) && bstBack(sequence, index, end - 1);//注意这里是end-1
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        ArrayList<Integer> listN = new ArrayList<>();

        findBack(root, list, listN, 0, target);

        return list;
    }

    public void findBack(TreeNode root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, int sum, int target) {
        if (root == null) {
            return;
        } else {
            sum += root.val;
            tempList.add(root.val);
        }

        if (root.right == null && root.left == null) {
            if (sum == target) {
                list.add(new ArrayList<>(tempList));
            }
            return;
        }


        if (root.left != null) {
            findBack(root.left, list, tempList, sum, target);
            tempList.remove(tempList.size() - 1);
        }

        if (root.right != null) {
            findBack(root.right, list, tempList, sum, target);
            tempList.remove(tempList.size() - 1);
        }
    }

    Set<String> set = new TreeSet<>();

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();

        if (str == null) {
            return list;
        }

        char[] chars = str.toCharArray();

        perBack(chars, 0, str.length());

        list.addAll(set);

        return list;
    }

    public void perBack(char[] chars, int start, int len) {

        if (start == len - 1) {
            set.add(String.valueOf(chars));
        }

        for (int i = start; i < len; i++) {
            char temp = chars[i];
            chars[i] = chars[start];
            chars[start] = temp;

            perBack(chars, start + 1, len);

            temp = chars[i];
            chars[i] = chars[start];
            chars[start] = temp;
        }
    }


    TreeNode head = null;
    TreeNode pHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }

        backConvert(pRootOfTree);

        return pHead;

    }

    public void backConvert(TreeNode root) {

        if (root == null) {
            return;
        }

        backConvert(root.left);

        if (head == null) {
            head = root;
            pHead = root;
        } else {
            head.right = root;
            root.left = head;
            head = root;
        }

        backConvert(root.right);
    }

    public ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode left = null;
        ListNode curr = head;
        ListNode right = curr;

        while (curr != null) {
            right = right.next;
            curr.next = left;
            left = curr;
            curr = right;
        }

        return left;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }
        }

        if (list1 != null) {//这儿是if，不是while
            curr.next = list1;
        }

        if (list2 != null) {//这儿是if，不是while
            curr.next = list2;
        }

        return head.next;
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackNew = new Stack<>();

        int len = pushA.length;

        if (len <= 0) {
            return false;
        }

        for (int i = len - 1; i > 0; i--) {
            stack.push(pushA[i]);
        }

        stackNew.push(pushA[0]);

        for (int i = 0; i < len; ) {
            if (popA[i] == stackNew.peek()) {
                stackNew.pop();
                i++;
            } else {
                if (!stack.isEmpty()) {

                    stackNew.push(stack.pop());
                } else {
                    return stackNew.isEmpty();
                }
            }
        }

        return stackNew.isEmpty();
    }

    //下面这样是错的，因为变成了先序遍历了
//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        if (root == null){
//           return list;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        PrintBack(list, queue, root);
//
//    }
//
//    public void PrintBack(ArrayList<Integer> list, Queue<TreeNode> queue, TreeNode root){
//        if (!queue.isEmpty() && root != null){
//            queue.add(root);
//            list.add(root.val);
//            PrintBack(list, queue, root.left);
//            PrintBack(list, queue, root.right);
//        }
//    }


    public int MoreThanHalfNum_Solution(int[] array) {

        Map<Integer, Integer> map = new HashMap<>();

        int len = array.length;

        for (int i = 0; i < len; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);//后面不是0，是1
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        int mid = len >> 1;

        int result = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > mid) {
                result = entry.getKey();
                break;
            }
        }

        return result;
    }

//    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//
//        int len = input.length;
//        ArrayList<Integer> list = new ArrayList<>();
//
//        if (len == 0 || k > len){
//            return list;
//        }
//
//        //下面一定是
//        TreeSet<Integer> set = new TreeSet<>();
//        for (int i = 0; i < len; i++){
//            if (i < k){
//                set.add(input[i]);
//            } else {
//                if (input[i] < set.last()){
//                    set.pollLast();
//                    set.add(input[i]);
//                }
//            }
//        }
//
////        for (int num : set){
////            list.add(num);
////        }
//
//        list.addAll(set);
//        return list;
//    }



    List<List<String>> queenList = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[] arrays = new int[n];

        for (int i = 0; i < n; i++) {
            arrays[i] = i;
        }

        NQback(arrays, 0, arrays.length - 1);

        return queenList;

    }

    public void NQback(int[] nums, int start, int end) {

        if (start == end) {
            if (ifLine(nums)) {
                bulid(nums);
            }
            return;
        }

        for (int i = start; i <= end; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            NQback(nums, start + 1, end);//不是i+1

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }

    public boolean ifLine(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) == Math.abs(nums[i] - nums[j])) {//应该是绝对值
                    return false;
                }
            }
        }
        int a = 0;

        return true;
    }

    public void bulid(int[] nums) {
        List<String> tempList = new ArrayList<>();

        String[] strs = new String[nums.length];
        for (int j = 0; j < strs.length; j++) {
            strs[j] = ".";
        }

        for (int i = 0; i < nums.length; i++) {

            strs[nums[i]] = "Q";//不是strs[i]
            String temp = "";
            for (String str : strs) {
                temp = temp + str;
            }
            tempList.add(temp);
            strs[nums[i]] = ".";
        }

        queenList.add(new ArrayList<>(tempList));
    }


    public String PrintMinNumber(int[] numbers) {

        int len = numbers.length;
        if (len == 0 || numbers == null) {
            return "";//不是null
        }

        String[] strs = new String[len];

        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;

                return s1.compareTo(s2);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str);
        }

        return String.valueOf(sb);

//        Collections.sort();//这是需要对list进行sort
//
//        Arrays.sort(numbers, new Comparator<int>() {//<>里面不能是primitive类型
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        int len = input.length;

        ArrayList<Integer> list = new ArrayList<>();

        if (len < 1 || input == null || len < k) {
            return list;
        }

        int left = 0;
        int right = len - 1;

        int index = Partition(input, left, right);
        while (index != (k - 1)) {
            if (index < k - 1) {
                left = index + 1;
                index = Partition(input, left, right);
            } else {
                right = index - 1;
                index = Partition(input, left, right);
            }
        }
//        int index;
//        while (true){
//            index = Partition(input, left, right);
//
//            if (index == k - 1){
//                break;
//            } else if (index > k - 1){
//                right = index - 1;
//            } else {
//                left = index + 1;
//            }
//
//        }

        for (int i = 0; i <= index; i++) {
            list.add(input[i]);
        }

        return list;

    }

    public int Partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;

        int x = nums[i];

        while (i < j) {
            while (i < j && nums[j] >= x) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];

            }

            while (i < j && nums[i] < x) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }

        nums[i] = x;
        return i;
    }

//    public String PrintMinNumber(int [] numbers) {
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int num : numbers){
//            list.add(num);
//        }
//
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                String str1 = o1 + "" + o2;
//                String str2 = o2 + "" + o1;
//                return str1.compareTo(str2);
//            }
//        });
//
//        StringBuffer sb = new StringBuffer();
//        for (int n : list){
//            sb.append(n);
//        }
//
//        return String.valueOf(sb);
//    }

    public int GetUglyNumber_Solution(int index) {

        if (index < 1) {
            return 0;
        }

        int[] nums = new int[index];

        nums[0] = 1;

        int t2 = 0, t3 = 0, t5 = 0;

        int add = 0;

        while (index - 1 > add) {
            while (nums[t2] * 2 <= nums[add]) {
                t2++;
            }

            while (nums[t3] * 3 <= nums[add]) {
                t3++;
            }

            while (nums[t5] * 5 <= nums[add]) {
                t5++;
            }

            int temp = uglyMin(nums[t2] * 2, nums[t3] * 3, nums[t5] * 5);

            if (temp == nums[t2] * 2) {
                nums[++add] = temp;
                t2++;
            } else if (temp == nums[t3] * 3) {
                nums[++add] = temp;
                t3++;
            } else {
                nums[++add] = temp;
                t5++;
            }

        }

        return nums[add];

    }

    public int uglyMin(int n1, int n2, int n3) {
        int min = n1;
        if (n2 < min) {
            min = n2;
        }
        if (n3 < min) {
            min = n3;
        }
        return min;
    }

    public int TreeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return depthBack(root);

    }

    public int depthBack(TreeNode node) {

        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = depthBack(node.left);
        }
        if (node.right != null) {
            right = depthBack(node.right);
        }

        return Math.max(left, right) + 1;
    }


    boolean result = true;

    public boolean IsBalanced_Solution(TreeNode root) {

//        if (root == null){//null时为true。。。
//            return false;
//        }

        balancedBack(root);
        return result;
    }

    public int balancedBack(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = balancedBack(root.left);
        int right = balancedBack(root.right);

        if (Math.abs(left - right) > 1) {
            result = false;
        }

        return (left > right) ? (left + 1) : (right + 1);
    }

    public int FindGreatestSumOfSubArray(int[] array) {

        int max = array[0];

        int sum = max;

        for (int i = 1; i < array.length; i++) {
            if (sum < 0) {
                sum = 0;
            }

            sum += array[i];

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }

    public boolean IsPopOrder23(int[] pushA, int[] popA) {

        int len = pushA.length;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        if (pushA == null || popA == null || len == 0) {
            return false;
        }

        for (int i = len - 1; i >= 0; i--) {
            stack2.push(popA[i]);
        }

        for (int i = 0; i < len; i++) {


            if (pushA[i] == stack2.peek()) {
                stack2.pop();
//                    continue;
            } else {
                stack1.push(pushA[i]);
            }

            while (!stack1.isEmpty() && stack1.peek() == stack2.peek()) {
                stack1.pop();
                stack2.pop();
            }


        }

        return stack1.isEmpty();
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int len = array.length;
        if (array == null || len == 0){
            return;
        }

        int res = array[0];
        for (int i = 1; i < len; i++){
            res ^= array[i];
        }

        int index = 0;
        while ((res & 1) == 0){
            index++;
            res = res >> 1;
        }

        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < len; i++){
            if (isOne(array[i], index)){
                list1.add(array[i]);
            } else {
                list0.add(array[i]);
            }
        }

        for (int i = 0; i < list0.size(); i++){
            num1[0] ^= list0.get(i);
        }

        for (int i = 0; i < list1.size(); i++){
            num2[0] ^= list1.get(i);
        }

    }

    public boolean isOne(int num, int index){
        while (index > 0){
            num = num >> 1;
            index--;
        }

        if ((num & 1) == 1){
            return true;
        } else {
            return false;
        }

    }

    public int maxLength(int[] arr, int k) {
        //这整个函数tm是错的
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);// important
        for(int i = 0;i < arr.length;i++){
            sum += arr[i];
            if(map.containsKey(sum-k)){
                len = Math.max(len, i - map.get(sum-k));
            }else {
                map.put(sum-k, i);
            }
        }
        return len;
    }


    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        if (n < 1){
            return list;
        }

        parentBack(list, "", 0, 0, n);
        return list;

//        String s = "as";
//        parentBack(list, s, 3, 5);
//        System.out.println(s);
//        return list;
    }

    public void parentBack(List<String> list, String s, int open, int close, int num){

        if (s.length() == 2 * num){
            list.add(s);
        }

        if (open < num){
            parentBack(list, s + "(", open + 1, close, num);
        }

        if (close < open){
            parentBack(list, s + ")", open, close + 1, num);
        }

//        list.add(sb);
//        sb = sb + "r";
//        list.add(sb);


    }

    public int[] searchRange11(int[] nums, int target) {

        int[] result = new int[2];

        int len = nums.length;

        if (nums == null || len == 0){
            return new int[]{-1, -1};
        }

        result[0] = findMin(nums, target, 0, len - 1);
        result[1] = findMax(nums, target, 0, len - 1);

        return result;

    }

    public int findMin(int[] nums, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target){
            if (mid == 0 || nums[mid - 1] != target){
                return mid;
            } else {
                return findMin(nums, target, left, mid - 1);
            }
        } else if (nums[mid] > target){
            return findMin(nums, target, left, mid - 1);
        } else {
            return findMin(nums, target, mid + 1, right);
        }
    }

    public int findMax(int[] nums, int target, int left, int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target){
            if (mid == nums.length - 1 || nums[mid + 1] != target){
                return mid;
            } else {
                return findMax(nums, target, mid + 1, right);
            }
        } else if (nums[mid] > target){
            return findMax(nums, target, left, mid - 1);
        } else {
            return findMax(nums, target, mid + 1, right);
        }
    }

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//
//
//    }
//
//    public double back(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2){
//
//
//    }

    public List<List<Integer>> threeSum12(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();


        int len = nums.length;

        if (nums == null || len == 0){
            return list;
        }

        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++){
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int temp = 0 - nums[i];

            int left = i + 1;
            int right = len - 1;

            while (left < right){
                if (nums[left] + nums[right] == temp){
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    //这两步别忘了
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < temp){
                    left++;
                } else {
                    right--;
                }
            }


        }

        return list;

    }

    public int threeSumClosest12(int[] nums, int target) {
        int len = nums.length;

        if (nums == null || len < 3){
            return -1;
        }

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < len - 2; i++){//len-2更能节约时间
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }

            // int temp = target - nums[i];

            int left = i + 1;
            int right = len - 1;

            while (left < right){
                int temp = nums[left] + nums[right] + nums[i];
                int diff = temp - target;

                if (Math.abs(diff) < min){
                    min = Math.abs(diff);
                    result = temp;
                }

                if (diff > 0){
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                } else if (diff < 0){
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                } else {
//                    break;这里不要break，直接return，这样就可以直接退出两个循环，结束程序了
                    return result;

                }
            }

        }

        return result;
    }

    public int lengthOfLongestSubstring12(String s) {
        int len = s.length();

        if (len == 0){
            return 0;
        }

        int max = 0;


        int start = 0;
        int index = 0;

        while (start < len){
            start = index;

            HashSet<Character> set = new HashSet<>();
            for (int i = start; i < len; i++){

                if (set.contains(s.charAt(i))){
                    for (int j = start; j < i; j++){
                        if (s.charAt(i) == s.charAt(j)){
                            index = j + 1;
                            break;
                        }
                    }
                    break;
                } else {
                    set.add(s.charAt(i));
                    if (i == len - 1){
                        return Math.max(max, set.size());
                    }
                }
            }

            if (set.size() > max){
                max = set.size();
            }

        }

        return max;

    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();

        int len = num.length;
        if (num == null || len == 0 || size < 1 || len < size){
            return list;
        }

        int[] max = new int[2];
        for (int i = 0; i < len - size + 1; i++){
            if (i == 0){
                max = getMax(i, size, num);
                list.add(max[0]);
            } else {
                if (i > max[1]){
                    max = getMax(i, size, num);
                    list.add(max[0]);
                } else {
                    if (num[i + size - 1] > max[0]){
                        max[0] = num[i + size - 1];
                        max[1] = i + size - 1;
                        list.add(max[0]);
                    } else {
                        list.add(max[0]);
                    }
                }
            }
        }

        return list;
    }

    public int[] getMax(int start, int size, int[] num){
        int[] max = new int[] {num[start], start};

        for (int i = start + 1; i < start + size; i++){
            if (num[i] > max[0]){
                max[0] = num[i];
                max[1] = i;
            }
        }

        return max;
    }

    public static void hh(){

    }
    public boolean IsPopOrder26(int [] pushA,int [] popA) {

        int len = pushA.length;
        if (len == 0){
            return false;
        }

        Stack<Integer> popStack = new Stack<>();
        Stack<Integer> pushStack = new Stack<>();

        for (int i = len - 1; i >= 0; i--){
            popStack.push(popA[i]);
        }

        for (int i = 0; i < len; i++){
            if (pushStack.isEmpty()){
                pushStack.push(pushA[i]);
                continue;
            }
            while (!pushStack.isEmpty() && pushStack.peek() == popStack.peek()){
                pushStack.pop();
                popStack.pop();

            }

            pushStack.push(pushA[i]);
        }

        while (!pushStack.isEmpty() && pushStack.peek() == popStack.peek()){
            pushStack.pop();
            popStack.pop();

        }

        return pushStack.isEmpty();


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int len = preorder.length;
        return back(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode back(int[] preorder, int[] inorder, int preLeft, int preRight,
                         int inLeft, int inRight){

        if (preLeft > preRight || inLeft > inRight){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preLeft]);
        int temp = node.val;
        int index = -1;

        for (int i = inLeft; i <= inRight; i++){
            if (temp == inorder[i]){
                index = i;
            }
        }

        node.left = back(preorder, inorder, preLeft + 1, index - inLeft + preLeft,
                inLeft, index - 1);
        node.right = back(preorder, inorder, index - inLeft + preLeft + 1, preRight,
                index + 1, inRight);

        return node;

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        Stack<List<Integer>> stack = new Stack<>();

        q1.add(root);

        while (!q1.isEmpty() || !q2.isEmpty()){
            List<Integer> listTemp = new ArrayList<>();
            if (!q1.isEmpty()){
                while (!q1.isEmpty()){
                    TreeNode temp = q1.remove();
                    if (temp != null){

                        listTemp.add(temp.val);
                        q2.add(temp.left);
                        q2.add(temp.right);
                    }

                }
                stack.push(new ArrayList<>(listTemp));

            } else {
                while (!q2.isEmpty()){
                    TreeNode temp = q2.remove();
                    if (temp != null){
                        listTemp.add(temp.val);
                        q1.add(temp.left);
                        q1.add(temp.right);
                    }

                }
                stack.push(new ArrayList<>(listTemp));
            }
        }

        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        list.remove(0);
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()){
            List<Integer> listTemp = new LinkedList<>();
            int len = q.size();
            for (int i = 0; i < len; i++){
                TreeNode temp = q.peek();
                if (temp.left != null){
                    q.add(temp.left);
                }
                if (temp.right != null){
                    q.add(temp.right);
                }
                listTemp.add(q.poll().val);
            }
//            list.add(listTemp);
//            list.add(new ArrayList<>(listTemp));
            list.add(new LinkedList<>(listTemp));
        }

        return list;
    }

    public List<List<Character>> zuhe(String str){
        char[] chars = str.toCharArray();
        List<List<Character>> list = new ArrayList<>();

        for (int i = 1; i <= str.length(); i++){
            List<Character> neiList = new ArrayList<>();

            zuheBack(chars, 0, i, list, neiList);
        }

        return list;
    }

    public void zuheBack(char[] chars, int start, int m, List<List<Character>> list,
                         List<Character> neiList){

        if (neiList.size() == m){
            list.add(new ArrayList<>(neiList));
            return;
        }

        if (start == chars.length){
            return;
        }

        for (int i = start; i < chars.length; i++){
            neiList.add(chars[i]);
            zuheBack(chars, i + 1, m, list, neiList);
            neiList.remove(neiList.size()-1);
        }
    }

    public int[] twoSumfcj(int[] nums, int target) {

        int[] result = new int[2];

        int len = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++){//不能是len-1
            int n = target - nums[i];

            if (map.containsKey(n)){
                result[0] = map.get(n);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }

        return result;

    }

    public ListNode addTwoNumbersfcj(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode head = listNode;

        ListNode h1 = l1;
        ListNode h2 = l2;

        int he = 0;
        int jin = 0;

        while (h1 != null && h2 != null){

            he = (h1.val + h2.val + jin) % 10;
            jin = (h1.val + h2.val + jin) / 10;

            listNode.next = new ListNode(he);
            listNode = listNode.next;

            h1 = h1.next;
            h2 = h2.next;

        }

        while (h1 != null){

            he = (h1.val + jin) % 10;
            jin = (h1.val + jin) / 10;

            listNode.next = new ListNode(he);
            listNode = listNode.next;


            h1 = h1.next;

        }

        while (h2 != null){

            he = (h2.val + jin) % 10;
            jin = (h2.val + jin) / 10;

            listNode.next = new ListNode(he);
            listNode = listNode.next;


            h2 = h2.next;

        }

        if (jin > 0){
            listNode.next = new ListNode(jin);

        }

        return head.next;

    }

    public int lengthOfLongestSubstringfcj(String s) {

        int len = s.length();
        if (s == null || len == 0){

            return 0;

        }

        int start = 0;
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++){
            //map.get(s.charAt(i)) >= start的作用是可能有"abba"这样的情况产生
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
                start = map.get(s.charAt(i)) + 1;

            }
            map.put(s.charAt(i), i);

            int temp = i - start + 1;
            max = (temp > max) ? temp : max;
        }

        return max;

    }

    int maxLen = 0;
    int start1;
    public String longestPalindromefcj(String s) {

        int len = s.length();
        if (len < 2){
            return s;
        }
        for (int i = 0; i < len; i++){
            lPalindrome(s, i, i);//针对len为奇数
            lPalindrome(s, i, i + 1);//针对len为偶数
        }

        return s.substring(start1, start1 + maxLen);

    }

    public void lPalindrome(String s, int j, int k){
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }

        if (maxLen < k - j - 1){
            maxLen = k - j - 1;
            start1 = j + 1;
        }
    }

    public String convertfcj(String s, int numRows) {

        int len = s.length();
        if (len < 2 || numRows == 1){
            return s;
        }

        int temp = 2 * numRows - 2;
        int x = len / temp;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= x; i++){
            if (i * temp < len) {

                sb.append(s.charAt(i * temp));
            }
        }

        for (int j = 1; j < numRows - 1; j++){
            for (int i = 0; i <= x; i++){
                if ((j + i * temp) < len){
                    sb.append(s.charAt(j + i * temp));
                }

                if ((2 * numRows - 2 - j + i * temp) < len){
                    sb.append(s.charAt(2 * numRows - 2 - j + i * temp));
                }

            }
        }

        for (int i = 0; i <= x; i++){
            if ((numRows - 1 + i * temp) < len) {

                sb.append(s.charAt(numRows - 1 + i * temp));
            }
        }

        return sb.toString();

    }

    public String convertfcj2(String s, int numRows) {

        char[] c = s.toCharArray();

        int len = s.length();
        int start = 0;

        if (len < 1){
            return s;
        }

        StringBuffer[] sb = new StringBuffer[numRows];

        for (int i = 0; i < numRows; i++){
            sb[i] = new StringBuffer();
        }

        while (start < len){
            //往下
            for (int i = 0; i < numRows; i++){
                if (start < len){
                    sb[i].append(c[start++]);
                }
            }

            //往上
            for (int i = numRows - 2; i > 0; i--){
                if (start < len){
                    sb[i].append(c[start++]);
                }
            }
        }

        for (int i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }

        return sb[0].toString();

    }

    public int reversefcj(int x) {

        int num = 0;

        while (x != 0){

            /*
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
            */

            int yu = x % 10;
            x = x / 10;

            int temp = num * 10;
            if ((temp / 10) != num){
                return 0;
            }
            num = temp + yu;
            if ((num - yu) != temp){
                return 0;
            }

        }

        return num;

    }

    public int romanToIntfcj(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int len = s.length();

        if (len == 1){
            return hashMap.get(s.charAt(0));
        }

        //这种做法是错的，因为最后一位总是要先加上去的，第一位依然需要判断是加还是减
        int result = 0;
        for (int i = len - 1; i > 0; i--){
            if (hashMap.get(s.charAt(i-1)) >= hashMap.get(s.charAt(i))){
                result += hashMap.get(s.charAt(i));
            } else {
                result -= hashMap.get(s.charAt(i));
            }
        }

        result += hashMap.get(s.charAt(0));

        return result;

    }

    public boolean isValidfcj(String s) {

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        int len = chars.length;

        for (int i = 0; i < len; i++){
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '['){
                stack.push(chars[i]);
            } else {
                if (stack.size() == 0){
                    return false;
                }
                if (map.get(chars[i]) != stack.peek()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }


    }

    public ListNode mergeTwoListsfcj(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null){
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }

        while (l1 != null){
            curr.next = l1;
        }

        while (l2 != null){
            curr.next = l2;
        }

        return head.next;

    }

}
