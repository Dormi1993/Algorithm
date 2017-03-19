package com.fcj.test;

import com.fcj.test.publicClass.ListNode;


import java.util.*;


import java.util.*;



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
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++){
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i){
                return new int[]{i, map.get(result)};
            }
        }
        return null;

    }


    /**
     * 2. Add Two Numbers
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
        while (l1 != null || l2 != null || carry != 0){
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
     *3. Longest Substring Without Repeating Characters
     */
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        if (s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
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
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int sum = m + n;

        if (m == 0 && n == 0){
            return 0;
        }

        int[] arrs = new int[sum];
        for (int i = 0, j = 0, k = 0; i < m || j < n;){
            if (i < m && j < n){
                arrs[k++] = (nums1[i] <= nums2[j]) ? nums1[i++] : nums2[j++];
            } else if (i < m){
                arrs[k++] = nums1[i++];
            } else {
                arrs[k++] = nums2[j++];
            }


        }
        if (sum % 2 == 0){
            return (arrs[sum / 2] + arrs[sum / 2 - 1]) / 2.0;
        } else {
            return arrs[sum / 2];
        }

    }

    /**
     * 5. Longest Palindromic Substring
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {


        int max = 0;
        int nums[] = new int[2];
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){

                String str = s.substring(i, j + 1);
                StringBuffer stringBuffer = new StringBuffer(str);
                if (str.equals(stringBuffer.reverse().toString()) && str.length() > max){
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

        if (s.length() == 0){
            return "";
        }
        if (numRows == 0){
            return "numRows输入错误";
        }
        if (numRows == 1){
            return s;
        }


        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < s.length(); j++){
                if (j % (2 * numRows - 2) == i || j % (2 * numRows - 2) == (2 * numRows - 2 - i)){
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
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    /**
     * 7. Reverse Integer
     *
     */
    public int reverse(int x){
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
        if (x >= 0){
            return result;
        } else {
            return -result;
        }


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


    /**
     * 13. Roman to Integer
     * @param s
     * @return
     */
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

        for (String arr : strs){
            if (arr.equals("")){
                return "";
            }
        }
        if (strs.length == 1){
            return strs[0];
        }


        String str = strs[0];

        for (int i = 1; i < strs.length; i++){
            int max = 0;
            for (int j = 0; j < str.length() && j < strs[i].length(); j++){
                if (str.charAt(j) == strs[i].charAt(j)){
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
     * 15.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new LinkedList<>();

        int lo = 0, lm = 0, sum = 0;
        for (int index = 0; index < nums.length - 2; index++){
            if (index == 0 || nums[index] != nums[index - 1]){
                lo = index + 1;
                lm = nums.length - 1;
                sum = 0 - nums[index];
                while(lo < lm){
                    if (nums[lo] + nums[lm] == sum){
                        list.add(Arrays.asList(nums[index], nums[lo], nums[lm]));
                        while (lo < lm && nums[lo] == nums[lo + 1]){
                            lo++;
                        }
                        while (lo < lm && nums[lm] == nums[lm - 1]){
                            lm--;
                        }
                        lo++;
                        lm--;
                    } else if (nums[lo] + nums[lm] < sum){
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

        for (int i = 0; i < len - 2; i++){
            int j = i + 1;
            int k = len - 1;
            while (j < k){
                temp = nums[i] + nums[j] + nums[k];
                index = (temp - target >= 0) ? 1 : -1;

                if (cha > Math.abs(temp - target)){
                    cha = Math.abs(temp - target);
                    sum = temp;
                }

                if (index > 0){
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
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;

    }

    /**
     * 19.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = head;

        if (curr.next == null){
            return null;
        }

        int j = 0;

        while (curr.next != null){
            curr = curr.next;
            j++;
            if (j > n){
                prev = prev.next;
            }
        }
        if (j == n - 1){
            return head.next;
        } else {
            prev.next = prev.next.next;
            return head;
        }
    }



    /**
     * 18. 4Sum
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

        for (int i = 0; i < len - 3; i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                for (int j = i + 1; j < len - 2; j++){
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])){
                        result = target - nums[i] - nums[j];
                        lo = j + 1;
                        lm = len - 1;
                        while (lo < lm){
                            if (nums[lo] + nums[lm] == result){
                                list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[lm]));

                                while (lo < lm && nums[lo] == nums[lo + 1]){
                                    lo++;
                                }
                                while (lo < lm && nums[lm] == nums[lm - 1]){
                                    lm--;
                                }
                                lo++;
                                lm--;
                            } else if (nums[lo] + nums[lm] < result){
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
     * 21. Merge Two Sorted Lists 利用了递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);
        if (l1.val < l2.val){
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

        if (len1 == 0 && len2 == 0){
            return 0;
        }
        if (len1 < len2){
            return -1;
        }
        int index = -1;
        int num = 0;
        int temp = 0;
        int temp2 = 0;

        for (int i = 0; i < haystack.length(); i++){
            temp = i;//不能放在第二个for循环里
            num = 0;//重要
            temp2 = i;
            for (int j = 0; j < needle.length(); j++){

                if (temp2 >= len1){
                    break;
                }
                if (haystack.charAt(temp2) != needle.charAt(j)){
                    break;
                } else {
                    temp2++;
                    num++;
                }


            }
            if (num == needle.length()){
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
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        long lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
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
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++){

            if (nums[i] >= target){
                return i;
            }
            result = i + 1;

        }
        return result;
    }

    /**
     *33.
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

        while (min <= max){
            int mid = (min + max) / 2;
            if (nums[mid] == target){
                return mid;
            }
//            if (nums[min] == target){
//                return min;
//            }
//            if (nums[max] == target){
//                return max;
//            }
            if (nums[mid] >= nums[min]){
                if (nums[min] <= target && target < nums[mid]){//这里的等号不能落，否则会少项
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
//                break;不能有break
            } else {
                if (nums[mid] < target && target <= nums[max]){
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
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++){
            Set<Character> rows = new HashSet<Character>();
            Set<Character> columns = new HashSet<Character>();
            Set<Character> cubes = new HashSet<Character>();
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.' && !rows.add(board[i][j])){
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])){
                    return false;
                }
                int column = i % 3;
                int row = i / 3;
                int a = j % 3;
                int b = j / 3;
                if (board[3 * row + b][3 * column + a] != '.' && !cubes.add(board[3 * row + b][3 * column + a])){
                    return false;
                }

            }
        }

        return true;


    }

    /**
     * 38. Count and Say
     * @param n
     * @return
     */
    public String countAndSay(int n) {

        StringBuffer stringBuffer = new StringBuffer("1");
        if (n == 1){
            return stringBuffer.toString();
        }
        int index = 1;

        while (index < n){
            StringBuffer stringBuffer2 = new StringBuffer();

            String str = stringBuffer.toString();
            int len = str.length();
            char curr = str.charAt(0);
            int num = 1;

            for (int i = 1; i < len; i++){
                if (str.charAt(i) == curr){
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

    public int haha(){
        int x = 1211;
        String temp = String.valueOf(x);
        int len = temp.length();
        int c = x / 10;
        int result = 0;
        for (int i = 1; i < temp.length(); i++){
            x = (int) (x - c * Math.pow(10, len - i));
            int num = 1;
            if (x < 10){
                if (x == c){
                    num++;
                }
            }
            if (x / 10 == c){
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
        for (int i = 0; i < nums.length; i++){
            int sum = nums[i];
            int max = sum;
            for (int j = i + 1; j < nums.length; j++){

                sum += nums[j];
                if (sum > max){
                    max = sum;
                }

            }
            if(result < max){
                result = max;
            }

        }

        return result;
    }

    public int lengthOfLastWord(String s) {

        String temp;
        temp = s.trim();
        int len = temp.length();
        if (len == 0){
            return 0;
        }
        int index = temp.lastIndexOf(" ");
        if (index != -1){
            return len - 1 - index;
        } else {
            return len;
        }


    }

    /**
     * 66. Plus One
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int sum = 0;
        int newsum;
        for (int temp : digits){
            sum = sum * 10 + temp;
        }
        newsum = sum + 1;

//        char a = '3';
//        int b = a;
//        System.out.println(b);

        String str = String.valueOf(newsum);
        int len = str.length();
        int num[] = new int[len];
        for (int i = 0; i < len; i++){
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
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for(int i=2; i<n; i++){
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

        if(head == null){
            return null;
        }

        while (curr.next != null){
            curr = curr.next;
            if (curr.val != prev.val){
                prev.next = curr;
                prev = curr;
            }
        }
        prev.next = null;
        return Head;
    }

    //这个方法好，数组从后往前分享，这样的话，原来的数组值就不会变
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n -1;
        while (i >= 0 && j >= 0){
            nums1[k--] = (nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j >= 0){
            nums1[k--] = nums2[j--];
        }

    }

    //二分查找法，这里有个问题是当数组为空时，会出错
    public int binarySearch(int[] arrs, int k){
        int start = 0;
        int end = arrs.length - 1;
        int mid = arrs.length / 2;
//        if (arrs[mid] == k){
//            return mid;
//        }

        //start <= mid < end
        while (start < end){//这里没有等号
            mid = (start + end) / 2;
            if (k < arrs[mid]){
                end = mid;//这里没有-1
            } else if (k > arrs[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //二分查找法递归
    public int binarySearch(int[] arrs, int start, int end, int k){

        int mid = (start + end) / 2;

        if (arrs[mid] == k){
            return mid;
        }
        if (start >= end){//这步判断一定要有，否则会一直递归下去
            return -1;
        } else if (k > arrs[mid]){
            return binarySearch(arrs, mid + 1, end, k);
        } else if (k < arrs[mid]){
            return binarySearch(arrs, start, mid - 1, k);
        }
        return -1;
    }


        //华为
    public void sort(int[] arrs){

        int len = arrs.length;
        if (len <= 1){
            return;
        }
        for (int j = len - 1; j >0; j--){
            if (arrs[j] == j)
                continue;
            Solution.swap_with_zero(arrs, arrs[j]);
            int max = arrs[0];
            for (int i = 1; i < j; i++){
                if (arrs[i] > max){
                    max = arrs[i];
                }
            }
            Solution.swap_with_zero(arrs, max);
        }


    }

    public static void chansheng(int[] rawArray, int n){
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();

        int count = 0;
        int rn = 0;

        for (;count < n;){//这里不能是<=，否则它会是一直continue
            rn = random.nextInt(n);
            if (set.contains(rn)){
                continue;
            }
            set.add(rn);
            rawArray[count] = rn;
            count++;
        }
    }

    public void print(int[] arrs){
        for (int num : arrs){
            System.out.print(num + " ");
        }
    }

    public static void swap_with_zero(int[] array, int number){
        int len = array.length;
        int zIndex = -1;
        int nIndex = -1;
        for(int i = 0; i < len; ++i){
            if(array[i] == 0){
                zIndex = i;
            }
            if(array[i] == number){
                nIndex = i;
            }
        }
        int temp = array[zIndex];
        array[zIndex] = array[nIndex];
        array[nIndex] = temp;

    }



}
