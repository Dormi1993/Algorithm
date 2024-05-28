package com.fcj.test.jingyan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dormi on 2017/10/13.
 */
public class Combination {
    public static void combiantion(char chs[]) {
        if (chs == null || chs.length == 0) {
            return;
        }
        List<Character> list = new ArrayList();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, list);
        }
    }

    //从字符数组中第begin个字符开始挑选number个字符加入list中
    public static void combine(char[] cs, int begin, int number, List<Character> list) {
        if (number == 0) {// 这个其实相当于结束条件。对于排列，它的结束条件是start达到了list的最后一个元素了
            System.out.println(list.toString());
            return;
        }
        if (begin == cs.length) {
            return;
        }
        list.add(cs[begin]);
        combine(cs, begin + 1, number - 1, list);// 有begin，那么从begin+1开始的number-1
        list.remove((Character) cs[begin]);
        combine(cs, begin + 1, number, list);// 没有begin，那么从begin+1开始的number
    }

    public static void main(String args[]) {
        char chs[] = {'a', 'b', 'c'};
        combiantion(chs);

        Combination combination = new Combination();
        ArrayList<String> list = combination.Permutation("abc");
        System.out.println(list.size());
    }

    public ArrayList<String> Permutation(String str) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }

        char[] chars = str.toCharArray();
        Set<String> set = new HashSet<>();// 因为题目中可能有字符重复，所以要用set
        process(chars, 0, set);

        list.addAll(set);
        return list;

    }

    private void process(char[] chars, int start, Set<String> set) {
        if (start == chars.length - 1) {
            set.add(String.valueOf(chars));
        }
        for (int i = start; i < chars.length; i++) {
            // swap i with start
            swap(chars, start, i);
            // process
            process(chars, start + 1, set);// 这里是start+1, 不是i+1

            // swap back i with start
            swap(chars, start, i);
        }
    }

    private void swap(char[] chars, int start, int i) {
        char temp = chars[i];
        chars[i] = chars[start];
        chars[start] = temp;
    }
}
