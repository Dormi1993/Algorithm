package com.fcj.corejava;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dormi on 2017/12/1.
 */
public class SocketTest {
        public static void main(String[] args) throws IOException{
        try (Socket s = new Socket("time-a.nist.gov", 13);//这个网站不行？？
             Scanner in = new Scanner(s.getInputStream(), "UTF-8")){

            while (in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }

        }

    }

//    public static void main(String[] args) {
//        try {
//            Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13); //打开一个套接字
//            InputStream inS = s.getInputStream();  //获取流对象
//            Scanner in = new Scanner(inS); //获取流中的数据
//            while (in.hasNextLine()) {
//                String line = in.nextLine();  //读取数据
//                System.out.println(line); //打印数据
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
