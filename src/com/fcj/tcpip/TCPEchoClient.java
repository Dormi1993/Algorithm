package com.fcj.tcpip;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by dormi on 2017/11/21.
 */
public class TCPEchoClient {
    public static void main(String[] args) throws Exception{
        byte[] recvBuf = new byte[256];
        byte[] sendBuf = new byte[256];

        int tbr = 0;

        int br;

        Socket socket = new Socket("server name", 8080);

        BufferedReader In = new BufferedReader(new InputStreamReader(System.in));

        String sendString = In.readLine();
        sendBuf = sendString.getBytes();

        OutputStream out = socket.getOutputStream();
        out.write(sendBuf);

        InputStream in = socket.getInputStream();
        while (tbr < sendBuf.length){
            br = in.read(recvBuf, tbr, sendBuf.length);//??
            tbr = tbr + br;
        }

        String recvString = new String(recvBuf);
        System.out.println("Received from server:" + recvString);

        socket.close();
    }
}
