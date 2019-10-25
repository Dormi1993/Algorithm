package com.fcj.tcpip;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dormi on 2017/11/21.
 */
public class TCPEchoServer {
    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[256];
        buffer[0] = 4;
        buffer[3] = 2;
        buffer[4] = 9;
        int br = 0;
        ServerSocket listenSocker = new ServerSocket(8080);
        for (;;){
            Socket connectSocket = listenSocker.accept();

            InputStream in = connectSocket.getInputStream();
            OutputStream out = connectSocket.getOutputStream();

            while ((br = in.read(buffer)) > 0){
                out.write(buffer, 0, br);
            }
            connectSocket.close();
        }
    }
}
