package com.fcj.test.JianzhiOffer;

import java.util.*;
import com.fcj.test.publicClass.ListNode;

/**
 * Created by dormi on 2017/3/28.
 */
public class Solution {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);

        for (int i = 0, j = 0; j < popA.length;){
            //stack.push(pushA[i]);
            if (stack.peek() == popA[j]){
                stack.pop();
                j++;
            } else {
                i++;
                if (i >= pushA.length){
                    break;
                }
                stack.push(pushA[i]);

            }
        }

        return stack.isEmpty();

    }

    /*
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while(pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while(pCur!=null){
            if(pCur.random!=null)
                pCur.next.random = pCur.random.next;
            pCur = pCur.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        //拆分链表
        while(pCur!=null){
            pCur.next = pCur.next.next;
            if(cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;
    }*/

//    public RandomListNode Clone(RandomListNode pHead){
//
//        if (pHead == null){
//            return null;
//        }
//
//        Hashtable<RandomListNode, RandomListNode> table = new Hashtable<>();
//
//        RandomListNode head = pHead;
//
//        RandomListNode headNew = new RandomListNode(head.label);
//        RandomListNode curr = headNew;
//        table.put(head, curr);
//        table.put(null, null);
//
//        while (true){
//            head = head.next;
//            if (head != null){
//
//                RandomListNode temp = new RandomListNode(head.label);
//                curr.next = temp;
//                curr = temp;
//                table.put(head, curr);
//            } else {
//                break;
//            }
//        }
//
//        curr.next = null;
//
//        RandomListNode p = headNew;
//        head = pHead;
//
//        while (head != null){
//            p.random = table.get(head.random);
//            head = head.next;
//            p = p.next;
//        }
//
//        return headNew;
//
//    }

    public RandomListNode Clone(RandomListNode pHead){

        if (pHead == null){
            return null;
        }

        RandomListNode head1 = pHead;

        RandomListNode head2 = new RandomListNode(head1.label);
        RandomListNode phead2 = head2;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head1, head2);
        head1 = head1.next;

        while (head1 != null){
            int temp = head1.label;
            RandomListNode nodeTemp = new RandomListNode(temp);
            map.put(head1, nodeTemp);

            head2.next = nodeTemp;
            head2 = nodeTemp;

            head1 = head1.next;

        }
        head2.next = null;

        head1 = pHead;
        head2 = phead2;
        while (head1 != null){
            RandomListNode temp = head1.random;
            if (temp == null){
                head2.random = null;
            } else {
                head2.random = map.get(temp);
            }
            head1 = head1.next;
            head2 = head2.next;

        }

        return phead2;
    }


    /**
     * 书上面试题12
     */
    public void Print1ToMaxOfNDigits(int n){

//        StringBuffer stringBuffer = new StringBuffer();

        char[] nums = new char[n];

        for (int i = 0; i < 10; i++){
            nums[0] = (char) ('0' + i);
            back(nums, n, 0);
        }


    }

    public void back(char[] nums, int n, int index){
        if (index == n - 1){
            printNum(nums);
            return;

        }

        for (int i = 0; i < 10; i++){
            nums[index + 1] = (char) ('0' + i);
            back(nums, n, index + 1);//不能是index++
        }
    }

    public void printNum(char[] chars){

        int len = chars.length;

        int index = 0;

        for (int i = 0; i < len; i++){
            if (chars[i] != '0'){
                break;
            }
            index++;
        }

        for (int i = index; i < len; i++){
            System.out.print(chars[i]);
        }
        System.out.println("");

//        int len = str.length();
//        int index = 0;
//
//        for (int i = 0; i < len; i++){
//            if (str.charAt(i) != '0'){
//                break;
//            }
//            index++;
//        }
//
//        String arr = str.substring(index, len);
//        System.out.println(arr);

    }

    /**
     * 面试题28
     */
//    public ArrayList<String> Permutation(String str) {
//
//
//    }

    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        int len = array.length;
        int half = len >> 1;

        for (int i = 0; i < len; i++){
            if (map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }

            if (map.get(array[i]) > half){
                result = array[i];
                break;
            }
        }

        return result;


    }

    //先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
    // 排序规则如下：
    // 若ab > ba 则 a > b，
    // 若ab < ba 则 a < b，
    // 若ab = ba 则 a = b；
    public String PrintMinNumber(int [] numbers) {

        int len = numbers.length;
        String[] strings = new String[len];
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < len; i++){

            strings[i] = String.valueOf(numbers[i]);

        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });


        for (String str : strings){
            sb.append(str);
        }

        return String.valueOf(sb);

    }

    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        int[] n = new int[2];
        int index = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++){
            if (map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                n[index++] = entry.getKey();
            }
        }

        num1[0] = n[0];
        num2[0] = n[1];
    }

    public ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {

        ArrayList<Integer> list = new ArrayList<>();

        Set<Integer> set = new HashSet<Integer>();
        int len = array.length;
        int div;
        int mul = array[len - 2] * array[len - 1];

        int[] pro = new int[2];


        for (int i = 0; i < len; i++){
            set.add(array[i]);
        }

        for (int i = 0; i < len; i++){
            div = sum - array[i];

            if (set.contains(div) && div != array[i]){

                int temp = array[i] * div;
                if (temp < mul){
                    pro[0] = array[i];
                    pro[1] = div;
                }


            }
        }

        Arrays.sort(pro);

        if (pro[0] == 0 && pro[1] == 0){
            return list;
        } else {

            list.add(pro[0]);
            list.add(pro[1]);
        }

        return list;
    }

    public String LeftRotateString1(String str,int n) {

        int len = str.length();

        if (str == null || len == 0){
            return null;
        }

        int index = n % len;

        String strgai = str.substring(0, index);

        StringBuffer sb = new StringBuffer(str);

        sb.append(strgai);

        String result = String.valueOf(sb).substring(index, len + index);

        return result;

    }





    public String ReverseSentence1(String str) {

        int len = str.length();

        char[] chars = str.toCharArray();
        int index = 0;

        for (char a : chars){
            if (a == ' '){
                index++;
            }
        }

        if (index == 0){
            return str;
        }

        int[] nums = new int[index];

        for (int i = 0, j = 0; i < len; i++){
            if (chars[i] == ' '){
                nums[j++] = i;
            }
        }

        StringBuffer sb = new StringBuffer(str.substring(nums[index - 1] + 1, len));


        if (index == 1){
            sb.append(' ').append(str.substring(0, nums[0]));

            return String.valueOf(sb);
        }

//        int r = nums[index - 1];
//        int l = nums[index - 2];

        for (int r = index - 1, l = index -2; l >= 0; r--, l--){
            sb.append(' ').append(str.substring((nums[l]) + 1, nums[r]));
        }
        sb.append(' ').append(str.substring(0, nums[0]));

        return String.valueOf(sb);

    }


    public boolean isContinuous1(int [] numbers) {

        int len = numbers.length;
        //boolean flag = false;

        if (len != 5){
            return false;
        }

        Arrays.sort(numbers);
        int min = numbers[0];
        int max = numbers[4];
        int index = 0;

        if (min < 0 || max > 13){
            return false;
        }

        for (int i = 0; i < len; i++){
            if (numbers[i] == 0){
                index++;
            } else if (i <= 3){
                if (numbers[i] == numbers[i + 1]){
                    return false;
                }
            }
        }

        min = numbers[index];

        if (max - min > 4){
            return false;
        } else {
            return true;
        }
    }

    public boolean match(char[] str, char[] pattern){

        if (str == null || pattern == null){
            return false;
        }

        int strIndex = 0;
        int patternIndex = 0;

        return back(str, strIndex, pattern, patternIndex);

    }

    public boolean back(char[] str, int strIndex, char[] pattern, int patternIndex){

        if (str.length == strIndex && pattern.length == patternIndex){
            return true;
        }

        if (str.length != strIndex && pattern.length == patternIndex){

            return false;
        }

        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*'){

            if (str.length != strIndex && str[strIndex] == pattern[patternIndex] ||
                    str.length != strIndex && pattern[patternIndex] == '.'){

                return back(str, strIndex, pattern, patternIndex + 2) ||
                        back(str, strIndex + 1, pattern, patternIndex);

            } else {
                return back(str, strIndex, pattern, patternIndex + 2);
            }
        }

        if (strIndex != str.length && str[strIndex] == pattern[patternIndex] ||
                strIndex != str.length && pattern[patternIndex] == '.'){
                return back(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;

    }

    int[] table = new int[256];
    StringBuffer sb = new StringBuffer();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        table[ch]++;

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {

        char[] chars = sb.toString().toCharArray();

        for (char c : chars){
            if (table[c] == 1){
                return c;
            }
        }

        return '#';
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Hashtable<ListNode, ListNode> table = new Hashtable<>();


        ListNode head = pHead;

        if (head == null){
            return null;
        }

        while (head != null){
            if (!table.containsKey(head)){
                table.put(head, head);
                head = head.next;
            } else {
                break;
            }
        }

        return head;

    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null){
            return null;
        }

        if (pHead.next == null){
            return pHead;
        }

        ListNode prev = pHead;
        ListNode curr = pHead.next;

        while (curr != null){
            if (prev.val != curr.val){
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }

        prev.next = curr;

        return pHead;

    }

    public TreeLinkNode GetNext1(TreeLinkNode pNode)
    {

        if (pNode == null){
            return null;
        }

        if (pNode.right != null){
            TreeLinkNode p = pNode.right;
            while (p.left != null){
                p = p.left;
            }
            return p;
        } else {
            if (pNode.next.left == pNode){
                return pNode.next;
            } else {

                TreeLinkNode t = pNode;
                while (t.next != null && t.next.right == t){
                    t = t.next;
                }
                if (t.next == null){
                    return null;
                } else {
                    return t.next;
                }
            }
        }
    }


    boolean isSymmetrical1(TreeNode pRoot){

        if (pRoot == null){
            return true;
        }

        return isSy(pRoot.left, pRoot.right);
    }

    boolean isSy(TreeNode root1, TreeNode root2){

        if (root1 == null && root2 == null){

            return true;
        }

        if (root1 == null || root2 == null){
            return false;
        }

        if (root1.val != root2.val){
            return false;
        }

        return isSy(root1.left, root2.right)
                && isSy(root1.right, root2.left);
    }



    /*
    boolean isSymmetrical(TreeNode pRoot)
    {

        //这种方法不能用ArrayList<TreeNode>，因为即使是镜像对称的，两个相同结点还是不一样的
        ArrayList<Integer> listPre1 = new ArrayList<>();
        ArrayList<Integer> listIn1 = new ArrayList<>();
        ArrayList<Integer> listPre2 = new ArrayList<>();
        ArrayList<Integer> listIn2 = new ArrayList<>();

        backPre(listPre1, pRoot);
        backIn(listIn1, pRoot);

        Mirror(pRoot);

        backPre(listPre2, pRoot);
        backIn(listIn2, pRoot);

        return comp(listPre1, listPre2) && comp(listIn1, listIn2);


    }

    void Mirror(TreeNode root){
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    void backPre(ArrayList<Integer> list, TreeNode root){
        if (root != null){
            list.add(root.val);
            backPre(list, root.left);
            backPre(list, root.right);
        } else {
            list.add(null);
        }

    }

    void backIn(ArrayList<Integer> list, TreeNode root){
        if (root != null){

            backIn(list, root.left);
            list.add(root.val);
            backIn(list, root.right);
        } else {
            list.add(null);
        }

    }

    boolean comp(ArrayList<Integer> list1, ArrayList<Integer> list2){
        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i) != list2.get(i)){
                return false;
            }
        }

        return true;
    }*/


    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);

            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }

        }

        return list;
    }

    public ArrayList<ArrayList<Integer> > Print3(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (pRoot == null){
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            ArrayList<Integer> listTemp = new ArrayList<>();

            if (!stack1.isEmpty()){

                while (!stack1.isEmpty()){
                    TreeNode temp = stack1.pop();
                    listTemp.add(temp.val);

                    if (temp.left != null){
                        stack2.push(temp.left);
                    }
                    if (temp.right != null){
                        stack2.push(temp.right);
                    }

                }

                list.add(listTemp);
            } else {
                while (!stack2.isEmpty()){
                    TreeNode temp = stack2.pop();
                    listTemp.add(temp.val);

                    if (temp.right != null){
                        stack1.push(temp.right);
                    }
                    if (temp.left != null){
                        stack1.push(temp.left);
                    }

                }
                list.add(listTemp);

            }



        }

        return list;

    }

    ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        if (pRoot == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(pRoot);
        int curr = 1;
        int next = 0;

        while (!queue.isEmpty()){

            TreeNode node = queue.remove();
            curr--;
            tempList.add(node.val);

            if (node.left != null){
                queue.add(node.left);
                next++;
            }
            if (node.right != null){
                queue.add(node.right);
                next++;
            }

            if (curr == 0){

                list.add(new ArrayList<>(tempList));
//                tempList = null;
                tempList.clear();//不能用null，要用clear

                curr = next;
                next = 0;
            }
        }

        return list;
    }

    public TreeNode gonggong(TreeNode root, TreeNode node1, TreeNode node2){

        if (root == null){
            return null;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (find(root, stack1, node1) && find(root, stack2, node2)){
            return getBack(stack1, stack2);
        } else {
            return null;
        }

    }

    public boolean find(TreeNode root, Stack<TreeNode> stack, TreeNode target){

        if (root == null){
            return false;
        }

        stack.push(root);
        if (root == target){
            return true;
        }

        boolean result = find(root.left, stack, target) || find(root.right, stack, target);

        if (result){
            return true;
        }

        stack.pop();
        return false;

    }

    public TreeNode getBack(Stack<TreeNode> stack1, Stack<TreeNode> stack2){
        TreeNode temp = new TreeNode(0);
        for (int i = 0; i < stack1.size(); i++){
            if (stack1.get(i) != stack2.get(i)){
                break;
            } else {
                temp = stack1.get(i);
            }
        }

        return temp;
    }

    int index = -1;
    String Serialize(TreeNode root) {

        StringBuffer sb = new StringBuffer();

        if (root == null){
            sb.append("$,");
            return sb.toString();
        }

        //sb.append(root.val + ',')//不能是这样，否则int和char都变成数字了
        sb.append(root.val + ",");


        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));

        return sb.toString();

    }

    TreeNode Deserialize(String str) {

        index++;

        if (str == null){
            return null;
        }

        String[] strs = str.split(",");
        TreeNode node;

        int len = strs.length;

        if (len <= index){
            return null;
        }

        if (!strs[index].equals("$")){
            node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        } else {
            node = null;
        }

        return node;

    }


    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {

        list.add(num);

    }

    public Double GetMedian() {

        int[] nums = new int[list.size()];

        for (int i = 0; i < list.size(); i++){

            nums[i] = list.get(i);
        }

        int len = nums.length;
        quickfcj(nums, 0, len - 1);


        int a = (len - 1) >> 1;
        int b = len >> 1;

        double mid = (nums[a] + nums[b]) / 2.0;

        return mid;
    }

    public void quickfcj(int[] nums, int start, int end){

        if (start < end){
            int index = Partition(nums, start, end);
            quickfcj(nums, start, index - 1);
            quickfcj(nums, index + 1, end);
        }
    }

    public int Partition(int[] nums, int start, int end){

        int i = start, j = end;
        int temp = nums[i];

        while (i < j){
            while (i < j && nums[j] >= temp){
                j--;
            }
            if (i < j){
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < temp){
                i++;
            }
            if (i < j){
                nums[j--] = nums[i];
            }
        }

        nums[i] = temp;
        return i;

    }


    public int minNumberInRotateArray(int [] array) {

        int len = array.length;

        if (array == null || len == 0){
            return 0;
        }

        return backXuan(0, len - 1, array);
    }

    public int backXuan(int start, int end, int[] nums){

        int mid = (start + end) >> 1;
        if (end - start == 1){
            return Math.min(nums[start], nums[end]);
        }
        if (nums[mid] < nums[start] || nums[mid] < nums[end]){
            return backXuan(start, mid, nums);
        } else {
            return backXuan(mid, end, nums);
        }
    }

    public boolean Find(int target, int [][] array) {

        int row = array.length;
        int col = array[0].length;

        if (array == null || row == 0 || col == 0){
            return false;
        }

        for (int i = 0, j = col - 1; i < row && j >= 0;){
            if (array[i][j] == target){
                return true;
            } else if (array[i][j] > target){
                j--;
            } else {
                i++;
            }
        }

        return false;

    }


    public String replaceSpace(StringBuffer str) {

        String s = str.toString();
        int len = s.length();

        if (s == null || len == 0){
            return "";
        }

        char[] strs = s.toCharArray();
        int num = 0;
        for (char a : strs){
            if (a == ' '){
                num++;
            }
        }

        char[] chars = new char[len + num * 2];

        for (int i = len + num * 2 - 1, j = len - 1; i >= 0;){
            if (strs[j] == ' '){
                chars[i--] = '0';
                chars[i--] = '2';
                chars[i--] = '%';
                j--;
            } else {
                chars[i--] = strs[j--];
            }
        }

        String result = String.valueOf(chars);
        return result;
    }


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        int len = pre.length;

        if (pre == null || in == null || len == 0){
            return null;
        }

        //TreeNode node = new TreeNode(0);这是多余的这样写

        TreeNode node = back(pre, in, 0, len - 1, 0, len - 1);

        return node;
    }

    public TreeNode back(int[] pre, int[] in, int startPre, int endPre, int startIn, int endIn){

        if (startPre > endPre || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        int index = 0;
        for (int i = startIn; i <= endIn; i++){
            if (in[i] != pre[startPre]){

                continue;
            } else {
                index = i;
                break;
            }
        }
        root.left = back(pre, in, startPre + 1, startPre + index - startIn, startIn, index - 1);
        root.right = back(pre, in , startPre + index - startIn + 1, endPre, index + 1, endIn);


        return root;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }


    /*
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        int len = input.length;

        if (input == null || len == 0 || k == 0 || len < k){
            return list;
        }

        int start = 0;
        int end = len - 1;

        int index = backAdjust(input, start, end);
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = backAdjust(input, start, end);
            } else {
                start = index + 1;
                index = backAdjust(input, start, end);
            }
        }

        for (int i = 0; i < k; i++){
            list.add(input[i]);
        }

        return list;
    }

    public int backAdjust(int[] nums, int start, int end){
        int i = start;
        int j = end;
        int x = nums[i];

        while (i < j){

            while (i < j && nums[j] >= x){
                j--;
            }
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < x){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = x;
        return i;
    }*/

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        int len = input.length;
        if (k < 1 || len < k){
            return list;
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < len; i++){
            if (set.size() < k){
                set.add(input[i]);
            } else {
                if (input[i] < set.last()){

                    set.pollLast();
                    set.add(input[i]);

                }
            }
        }

        for (int num : set){
            list.add(num);
        }

        return list;

    }

    int index1 = 0;
    public int InversePairs(int [] array) {

        int len = array.length;

        if (array == null || len == 0){
            return 0;
        }

        int[] temp = new int[len];

        backSort(array, temp, 0, len - 1);

        return index1;

    }

    public void backSort(int[] array, int[] temp, int start, int end){

        if (start < end){
            int mid = (start + end) >> 1;
            backSort(array, temp, start, mid);
            backSort(array, temp, mid + 1, end);

            backMerge(array, temp, start, mid, end);
        }

    }

    public void backMerge(int[] array, int[] temp, int start, int mid, int end){

        int i = start, j = mid;
        int m = mid + 1, n = end;

        int k = temp.length - 1;

        while (j >= i && n >= m){
            if (array[j] > array[n]){
                temp[k--] = array[j--];
                index1 = (index1 + n - m + 1) % 1000000007;
            } else {
                temp[k--] = array[n--];

            }
        }

        while (j >= i){
            temp[k--] = array[j--];
        }

        while (n >= m){
            temp[k--] = array[n--];
        }

        for (int v = 0; v <= temp.length - k - 2; v++){
            array[v + start] = temp[v + k + 1];
        }
    }


    public int GetNumberOfK(int [] array , int k) {
        int len = array.length;
        if (array == null || len == 0){
            return 0;
        }


        int left = firstK(array, 0, len - 1, k);
        int right = lastK(array, 0, len - 1, k);

        if (left == -1 || right == -1){
            return 0;
        }

        return right - left + 1;

    }

    public int firstK(int[] array, int start, int end, int k){

        if (start > end){
            return -1;
        }

        int mid = (start + end) >> 1;
        if (array[mid] == k){
            if (mid == 0 || array[mid - 1] != k){
                return mid;
            } else {
                return firstK(array, start, mid - 1, k);
            }
        } else if(array[mid] > k){
            return firstK(array, start, mid - 1, k);
        } else {
            return firstK(array, mid + 1, end, k);
        }
    }

    public int lastK(int[] array, int start, int end, int k){

        if (start > end){
            return -1;
        }

        int mid = (start + end) >> 1;
        if (array[mid] == k){
            if (mid == array.length - 1 || array[mid + 1] != k){
                return mid;
            } else {
                return lastK(array, mid + 1, end, k);
            }
        } else if(array[mid] > k){
            return lastK(array, start, mid - 1, k);
        } else {
            return lastK(array, mid + 1, end, k);
        }
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        int len = array.length;

        if (array == null || len < 4){
            return;
        }

        int result = array[0];

        for (int i = 1; i < len; i++){
            result ^= array[i];
        }

        int index = findFirst(result);

        for (int num : array){
            if (isBit(num, index)){
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }

        /*
        int pp = 1;
        while (index > 1){

            pp = pp << 1;
            index--;
        }

        int num00 = 0;
        int num11 = 0;
        for (int num : array){
//            if (pp & num == 0){这样是错的，因为==的优先级更高
            if ((pp & num) == 0){
                num00++;
            } else {
                num11++;
            }
        }

        int[] nums0 = new int[num00];
        int[] nums1 = new int[num11];

        for (int i = 0, j = 0, k = 0; i < len; i++){
            if ((pp & array[i]) == 0){
                nums0[j++] = array[i];
            } else {
                nums1[k++] = array[i];
            }
        }

        for (int num : nums0){
            num1[0] ^= num;
        }

        for (int num : nums1){
            num2[0] ^= num;
        }
        */


    }

    public int findFirst(int num){

        int index = 1;

        while ((num & 1) == 0){
            num = num >> 1;
            //不能写成num >> 1;因为这个不是表达式
            index++;
        }

        return index;
    }

    public boolean isBit(int num, int index){

        num = num >> (index - 1);

        if ((num & 1) == 1){
            return true;
        } else {
            return false;
        }
    }


    public ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {

        ArrayList<Integer> list = new ArrayList<>();

        int len = array.length;

        if (array == null || len == 0){
            return list;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[2];

        for (int num : array){
            map.put(num, num);
        }

        boolean flag = false;
        int mul = 0;
        for (int num : array){

            int sub = sum - num;
            if (map.containsKey(sub) && sub != num){//需要考虑sub 等于 num的情况
                int temp = num * sub;
                if (!flag){
                    nums[0] = num;
                    nums[1] = sub;
                    mul = temp;
                    flag = true;
                } else {
                    //其实这里不用考虑，因为求乘积最小的话，第一对满足条件的肯定就是答案，因为第一队相隔的最远
                    if (temp < mul){
                        nums[0] = num;
                        nums[1] = sub;
                        mul = temp;
                    }
                }

            }
        }

        Arrays.sort(nums);
        if (flag){
            list.add(nums[0]);
            list.add(nums[1]);
        }

        return list;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        ArrayList<Integer> list = new ArrayList<>();

        int len = array.length;

        if (array == null || len == 0){

            return list;
        }

        int[] nums = new int[2];

        int ahead = 0;
        int behind = len - 1;
        boolean flag = false;

        while (ahead < behind){
            int res = array[ahead] + array[behind];

            if (res == sum){
                nums[0] = array[ahead];
                nums[1] = array[behind];
                flag = true;
                break;
            } else if (res > sum){
                behind--;
            } else {
                ahead++;
            }
        }

        if (flag){
            list.add(nums[0]);
            list.add(nums[1]);
        }

        return list;
    }



    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (sum <= 0){
            return list;
        }

        int left = 1;
        int right = 2;
        int add = left + right;


        while (left <= sum / 2){

            if (add == sum){
                list.add(backAdd(left, right));
            }

            while (add > sum && left <= sum / 2){
                add -= left;
                left++;
                if (add == sum){
                    list.add(backAdd(left, right));
                }
            }

            right++;
            add += right;
        }

        /*
        while (left <= sum / 2){

            if (backSum(left, right) == sum){
                list.add(backAdd(left, right));
//                list.add(new ArrayList<>(backAdd(left, right)));
                right++;
            } else if (backSum(left, right) < sum){
                right++;
            } else {
                left++;
            }
        }*/

        return list;
    }

    public int backSum(int left, int right){
        return (left + right) * (right - left + 1) / 2;
    }

    public ArrayList<Integer> backAdd(int left, int right){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++){
            list.add(i);
        }

        return list;
    }


    public String LeftRotateString(String str,int n) {

        int len = str.length();

        if (str == null || len == 0){
            return "";
        }

        int num = n % len;

        String str1 = str.substring(0, num);
        String str2 = str.substring(num, len);

        StringBuffer sb = new StringBuffer(str2);

        sb.append(str1);

        return String.valueOf(sb);
    }

    public String ReverseSentence(String str) {

        int len = str.length();

        if (str == null || len == 0){
            return "";
        }

        String[] strs = str.split("\\s+");
        int lens = strs.length;

        //这个很重要，因为原来的str可能都是空格
        if (lens == 0){
            return str;
        }

        StringBuffer sb = new StringBuffer();

        for (int i = lens - 1; i >= 0; i--){

            sb.append(strs[i]).append(" ");
        }

        String result = String.valueOf(sb);
        result = result.trim();

        return result;
    }


    public boolean isContinuous(int [] numbers) {

        int len = numbers.length;

        if (numbers == null || len != 5){
            return false;
        }

        int num0 = 0;
        for (int num : numbers){
            if (num == 0){
                num0++;
            }
        }

        Arrays.sort(numbers);

        //下面这里判断是否在0-13是需要的
        int min = numbers[0];
        int max = numbers[4];
        if (min < 0 || max > 13){
            return false;
        }

        int sum = 0;
        for (int i = num0; i < len - 1; i++){
            if (numbers[i + 1] == numbers[i]){
                return false;
            }
            sum += numbers[i + 1] - numbers[i] - 1;
        }

        if (num0 >= sum){
            return true;
        } else {
            return false;
        }
    }


    public int LastRemaining_Solution(int n, int m) {

        if (n < 1 || m < 1){
            return -1;
        }

        int index = -1;

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++){
            list.add(i);
        }

        while (list.size() > 1){
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }

        return list.get(0);
    }

    /*
    public int Sum_Solution(int n) {

        //不能用循环，也不能用if，即不能用递归
        if (n < 1){
            return -1;
        }

        return back(n);
    }

    public int back(int n){

        if (n == 1){
            return 1;
        }

        return back(n - 1) + n;
    }*/
    public int Sum_Solution(int n){

        int sum = n;

        boolean result = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);

        return sum;

    }

    public int Add(int num1,int num2) {

        try {
            if (num1 < 0){

                throw new InterruptedException("gasdg");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sum = 0;
        int carry = 0;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        }
        while (num2 != 0);

        return sum;

    }

    public int StrToInt(String str) {

        int len = str.length();
        if (str == null || len == 0){
            return 0;
        }

        int flag = 1;
        int index = 0;
        int num = 0;

        //(str.charAt(0) == '+' || str.charAt(0) == '-')最外面的括号一定要有，
        //&&在前还是在后会不一样，保险起见加括号
//        if (str.charAt(0) == '+' || str.charAt(0) == '-' && len == 1){
        if (len == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')){
            return 0;
        }

        if (str.charAt(0) == '+' || str.charAt(0) == '-'){
            flag = (str.charAt(0) == '+') ? 1 : -1;
            index++;
        }

        for (int i = index; i < len; i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){

                num = 10 * num + str.charAt(i) - '0';
            } else {
                return 0;
            }
        }

        return num * flag;



    }


    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null){
            return null;
        }

        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }

            return node;
        }

        if (pNode.next == null){
            return null;
        } else if (pNode == pNode.next.left){
            return pNode.next;
        } else {
            TreeLinkNode node1 = pNode.next;
            while (node1.next != null){
                if (node1 == node1.next.left){
                    break;
                } else {
                    node1 = node1.next;
                }
            }
            return node1.next;
        }

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }

        return isS(pRoot.left, pRoot.right);
    }

    boolean isS(TreeNode root1, TreeNode root2){

        if (root1 == null && root2 == null){
            return true;
        }

        if (root1 == null || root2 == null){
            return false;
        }

        if (root1.val == root2.val){
            return isS(root1.left, root2.right) && isS(root1.right, root2.left);
        } else {
            return false;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);

            if (node.left != null){
                queue.add(node.left);
            }

            if (node.right != null){
                queue.add(node.right);
            }
        }

        return list;
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> listN = new ArrayList<>();

        if (pRoot == null){
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(pRoot);

        while (!stack1.isEmpty() || !stack2.isEmpty()){

            if (!stack1.isEmpty()){

                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    listN.add(node.val);

                    if (node.left != null){
                        stack2.push(node.left);
                    }

                    if (node.right != null){
                        stack2.push(node.right);
                    }
                }

                list.add(new ArrayList<>(listN));
                listN = new ArrayList<>();
            }



            if (!stack2.isEmpty()){
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    listN.add(node.val);

                    if (node.right != null){
                        stack1.push(node.right);
                    }

                    if (node.left != null){
                        stack1.push(node.left);
                    }
                }

                list.add(new ArrayList<>(listN));
                listN = new ArrayList<>();



            }



        }

        return list;

    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {

        int n = length;
        duplication[0] = -1;

        if (numbers == null || n <= 1){

            return false;
        }

        int[] nums = new int[n];

        for (int num : numbers){
            nums[num]++;
        }

        boolean result = false;

        for (int i = 0; i < n; i++){

            if (nums[i] > 1){
                duplication[0] = i;
                result = true;
                break;
            }
        }

        return result;
    }

    public int[] multiply(int[] A) {

        int len = A.length;

        if (A == null || len == 0){
            return null;
        }

        int[] forward = new int[len];
        int[] backward = new int[len];

        int[] B = new int[len];

        forward[0] = 1;
        backward[0] = 1;

        for (int i = 1; i < len; i++){
            forward[i] = A[i - 1] * forward[i - 1];
            backward[i] = A[len - i] * backward[i - 1];
        }

        for (int i = 0; i < len; i++){
            B[i] = forward[i] * backward[len - i - 1];
        }

        return B;
    }

    public boolean match1(char[] str, char[] pattern)
    {
        if (str == null || pattern == null){
            return false;
        }

        return matchBack(str, 0, pattern, 0);
    }

    public boolean matchBack(char[] str, int indexS, char[] pattern, int indexP){

        int lenS = str.length;
        int lenP = pattern.length;

        if (indexS == lenS && indexP == lenP){
            return true;
        }

        if (indexS != lenS && indexP == lenP){
            return false;
        }

        //indexP都还没有到最后
        if (indexP < lenP - 1 && pattern[indexP + 1] == '*'){
            if (indexS != lenS && str[indexS] == pattern[indexP] ||
                    indexS != lenS && pattern[indexP] == '.'){
                return matchBack(str, indexS + 1, pattern, indexP + 2)
                        || matchBack(str, indexS + 1, pattern, indexP)
                        || matchBack(str, indexS, pattern, indexP + 2);
            } else {
                return matchBack(str, indexS, pattern, indexP + 2);
            }
        }

        if (indexS != lenS && str[indexS] == pattern[indexP] ||
                indexS != lenS && pattern[indexP] == '.'){
            return matchBack(str, indexS + 1, pattern, indexP + 1);
        }

        return false;

    }

    ArrayList<Integer> list21 = new ArrayList<>();
    public void Insert1(Integer num) {

        list21.add(num);
    }

    public Double GetMedian1() {

        int len = list21.size();

        int[] nums = new int[len];

        for (int i = 0; i < len; i++){
            nums[i] = list21.get(i);
        }


        int a = (len - 1) >> 1;
        int b = len >> 1;

        int aBack = back(nums, a);
        int bBack = back(nums, b);


        return (aBack + bBack) / 2.0;
    }

    public int back(int[] nums, int index){

        int len = nums.length;

        int start = 0;
        int end = len - 1;

        int indexBack = Partition1(nums, start, end);

        while (index != indexBack){
            if (index < indexBack){
                end = indexBack - 1;
                indexBack = Partition1(nums, start, end);
            } else {
                start = indexBack + 1;
                indexBack = Partition1(nums, start, end);
            }
        }

        return nums[index];
    }

    public int Partition1(int[] nums, int start, int end){

        int i = start, j = end;
        int temp = nums[i];

        while (i < j){
            while (i < j && temp < nums[j]){
                j--;
            }
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            while (i < j && temp > nums[i]){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }

        nums[i] = temp;
        return i;
    }

    public TreeLinkNode GetNextfcj(TreeLinkNode pNode)
    {
        if (pNode == null){
            return null;
        }

        if (pNode.right != null){
            TreeLinkNode temp = pNode.right;
            while (temp.left != null){
                temp = temp.left;
            }

            return temp;
        }

        if (pNode.next == null){
            return null;
        } else if (pNode.next.left == pNode){
            return pNode.next;
        } else {
            TreeLinkNode temp = pNode.next;
//            while (temp.next.left != temp){//这样是不行的，要先考虑temp.next是否是为null
//                temp = temp.next;
//            }
//            return temp.next;
            while (temp.next != null){
                if (temp.next.left != temp){
                    temp = temp.next;
                } else {
                    break;
                }
            }
            return temp.next;
        }

    }

    public ArrayList<Integer> PrintFromTopToBottomfcj(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.remove();
            list.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);
            }

            if (temp.right != null){
                queue.add(temp.right);
            }

        }

        return list;
    }

}
