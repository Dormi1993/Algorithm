package com.fcj.test.JianzhiOffer;

import java.util.*;

/**
 * Created by dormi on 2017/3/28.
 */
public class MainTest {
    public static void main(String[] args){

        ArrayList<String> list = new ArrayList<>();
//        System.out.println(list.size());
//
//        list.add("");
//        System.out.println(list.size());
//
//        list.add("df");
//        System.out.println(list.size());
//
//        for (String s : list){
//            System.out.println(s);
//        }

//        list.add(23);
//        list.add(1);
//        list.add(5);
//
//        for (int num : list){
//            System.out.print(num + " ");
//        }
//        System.out.println("++++++");
//
//        Collections.sort(list);
//        for (int num : list){
//            System.out.print(num + " ");
//        }


//        String str = "sgwea";
//        String str1 = str.substring(1,3);
//        int str2 = str.indexOf("gaw");
//
//        System.out.println(str1 + " " + str2);
        Solution solution = new Solution();
        solution.Insert1(2);
        solution.Insert1(4);
        solution.Insert1(1);
        solution.Insert1(9);
        solution.Insert1(12);

        double a = solution.GetMedian1();
        System.out.println(a);



//        char[] str = new char[]{'a','a','a'};
//        char[] pattern = new char[]{'a','b','*','a'};
//        boolean a = solution.match1(str, pattern);
//        System.out.println(a);
//        int a = solution.LastRemaining_Solution(5,3);
//        System.out.println(a);

//        int a = solution.Add(-4, 8);
//        int a = solution.StrToInt("-324");
//        System.out.println(a);
//        int a = solution.Sum_Solution(100);
//        System.out.println(a);

//        int[] nums = new int[]{3,0,8,6,0};
//        int[] nums = new int[]{1,0,1,0,0};
//        boolean a = solution.isContinuous(nums);
//        System.out.println(a);
//        String str = solution.ReverseSentence("    ");
//        System.out.println(str);
//        ArrayList<ArrayList<Integer>> list = solution.FindContinuousSequence(15);
//        for (ArrayList<Integer> a : list){
//            System.out.println(a);
//        }
//        int[] nums = new int[]{1,2,4,7,11,15};
//        ArrayList<Integer> list = solution.FindNumbersWithSum(nums, 11);
//        for (int num:list
//             ) {
//            System.out.println(num);
//        }
//        int[] nums = new int[]{2,4,3,6,3,2,5,5};
//
//        int[] num1 = new int[1];
//        int[] num2 = new int[1];
//        solution.FindNumsAppearOnce(nums, num1, num2);
//        System.out.println(num1[0]);
//        System.out.println(num2[0]);
//        int nums1[] = new int[]{1,2,3,4,5};
//        int nums2[] = new int[]{4,5,3,2,1};
//        int nums3[] = new int[]{4,3,5,1,2};
//        boolean a = solution.IsPopOrder(nums1, nums3);
//        System.out.println(a);


//        solution.printNum(new char[]{'0','0','3','4'});
//        System.out.println("");
//        char a = '0' + 3;
//        System.out.println(a);

//        solution.Print1ToMaxOfNDigits(2);

//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        map.put(1, 3);
//        map.put(2, 5);
//        map.put(3, 5);
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + " "+ entry.getValue());
//        }

//        if (map.containsKey(2)){
//            System.out.println(map.get(2));
//            map.put(2, map.get(2) + 1);
//            System.out.println(map.get(2));
//        }

//        StringBuffer sb = new StringBuffer();
//
//        sb.append(3).append(234);
//        System.out.println(sb);

//        TreeNode root = MainTest.create();
//        preOrder(root);
//        Solution solution = new Solution();
//        TreeNode a = solution.gonggong(root, root.left.left.right, root.left.right.left);
//        System.out.println(a.val);

//        Solution solution = new Solution();
//        int[] array = new int[]{7,5,6,4};
//        int a = solution.InversePairs(array);
//        System.out.println(a);

//        Integer i01 = 59;
//        int i02 = 59;
//        Integer i03 =Integer.valueOf(59);
//        Integer i04 = new Integer(59);
//
//        System.out.println(i01 == i02);
//        System.out.println(i01 == i03);
//        System.out.println(i03 == i04);
//        System.out.println(i04 == i02);

//        int[] array = new int[]{4,5,1,6,2,7,3,8};
//
//        ArrayList<Integer> list = solution.GetLeastNumbers_Solution(array, 4);
//        for (Integer num : list){
//            System.out.println(num);
//        }

//        int[] pre = new int[]{1,2,4,7,3,5,6,8};
//        int[] in = new int[]{4,7,2,1,5,3,8,6};
//        TreeNode a = solution.reConstructBinaryTree(pre, in);
//        StringBuffer sb = new StringBuffer("WE are gs");
//        String a = solution.replaceSpace(sb);
//        System.out.println(a);

//        int a = solution.minNumberInRotateArray(new int[]{4,4,5,6,2,3,3,4,});
//        System.out.println(a);

//        StringBuffer sb = new StringBuffer();
//        StringBuffer sb2 = new StringBuffer();
//        StringBuffer sb3 = new StringBuffer();
//        StringBuffer sb4 = new StringBuffer();
//        sb.append(3 + 'e');
//        sb2.append(3 + "e");
//        sb3.append('3' + 'e');
//        sb4.append("3" + "e");
//
//        System.out.println(sb + " " + sb2 + " " + sb3);
//        System.out.println(sb4);
//        System.out.println('3' - 'e');


//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(11);
//        for (int a : stack){
//            System.out.println(a);
//        }
//
//        System.out.println(stack.get(2));

//        boolean a = solution.isSymmetrical(root);
//        ArrayList<Integer> list = solution.PrintFromTopToBottom(root);

//        ArrayList<ArrayList<Integer>> list = solution.Print(root);
//        for (ArrayList<Integer> num : list){
//            System.out.println(num);
//        }

//        ArrayList<Integer> list = new ArrayList<>();
////        list = null;
//        list.add(3);
//        System.out.println(list.get(0));






//        String str = solution.ReverseSentence("st. a am IS");
////        String str = solution.ReverseSentence("st.");
//        System.out.println(str);

    }

    /**
     * 用Java创建二叉树貌似成了一大难题，网上、书上好多写的代码特别复杂，不知道搞那么麻烦干啥
     * @return
     */
    public static TreeNode create() {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        if(value>0) {
            TreeNode node = new TreeNode(value);
            node.left = create();//？？
            node.right = create();
            return node;
        }
        return null;
    }

    public static void preOrder(TreeNode root) {
        if(root!=null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
