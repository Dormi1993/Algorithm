package com.fcj.corejava;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by dormi on 2017/12/1.
 */
public class InetAddressTest {
    public static void main(String[] args) throws IOException{
        if (args.length > 0){
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses){
                System.out.println(a);
            }
        } else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
