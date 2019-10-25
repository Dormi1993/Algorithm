package com.fcj.test.test1;

/**
 * Created by dormi on 2017/9/17.
 */
public class Test {
    public static void main(String args[]) {

//        if(args==null||new Test(){{Test.main(null);}}.equals("abcde")){
////        if(System.out.print("a") == null){
//            System.out.println("a");
//
//        }else{
//
//            System.out.println("b");
//        }

        for(int i =0 ; i< 10 ;i++){

            if(i%3== 0){
                thread(("a"+i));
            }else{
                thread((""+i));
            }
        }

    }

    public static void thread(String str){
        final String a =str;
        new Thread(
                new Runnable(){
                    public void run(){
                        try{
                            method(a);
                        }catch(Exception e){
                        }
                        System.out.println(a+"这里执行！");
                    }
                }
        ).start();
    }

    public static void method(String a){
        Integer.parseInt(a);
    }
}