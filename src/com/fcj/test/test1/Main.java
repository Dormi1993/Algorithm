package com.fcj.test.test1;

/**
 * Created by dormi on 2017/9/17.
 */
public class Main {

    public static void main(String args[]){
        Da da = new Da(5);
        Da da2 = new Da(5);

        System.out.println(da == da2);
        System.out.println(da.equals(da2));

        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a == b);
        System.out.println(a.equals(b));

        Integer aa = 999;//-128~127有缓存
        Integer bb = 999;//-128~127有缓存
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));

    }

}

class Da{
    int c;
    Da(int c){
        this.c = c;
    }
}
