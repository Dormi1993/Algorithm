package com.fcj.test.didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dormi on 2017/8/26.
 */
public class Main {

    /**
     * 输入是两行时候的经验：
     *
     * 直接用1. 方法吧，最简单安全
     *
     * 1. 每一行都是用nextLine()，string分割成相应数字（例子：Main01)用这个最安全方便！！！
     *
     * 2. 第一行用while+nextInt，但是第二行的输入先用next或者nextLine，
     * 因为第二行如果还是用nextInt的话，会把这个数字当做是第一行里的数字，
     *
     * 3. 因为nextInt或next在没有nextLine的情况下，会把回车也当做空格，继续在while中运行。
     * 而后面有nextLine的话，next()、nextInt()往往会读取部分数据（会留下"\n"或者空格之后的数据）（例子huaweiMain1)
     *
     * 4. 或者第一行和第二行数字都放到list中，但是把list最后一个数字单独拿出来给K（例子fuchengjie）
     */

//    while (in.hasNextInt()) {//注意while处理多个case
//        list.add(in.nextInt());
//
//    }
//
//    in.nextLine();
//    int K = in.nextInt();这样是错的，第二行的数字还是会被加入到list中的，
// 除非你第二行输入的是string类型，然后K也是string


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {//注意while处理多个case
            list.add(in.nextInt());
        }

        int len = list.size();
        int[] nums = new int[len];
        int index = 0;

        for (int num : list){
            nums[index++] = num;
        }

        int result = find(nums);

        System.out.println(result);
    }

    public static int find(int[] array) {

        int len = array.length;

        int max = array[0];

        int sum = 0;

        for (int i = 0; i < len; i++){

            sum += array[i];

            if (sum > max){
                max = sum;
            }

            if (sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}

//-23 17 -7 11 -2 1 -34
