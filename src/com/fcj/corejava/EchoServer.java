package com.fcj.corejava;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dormi on 2017/12/1.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException{
        try(ServerSocket s = new ServerSocket(8190)){
            try (Socket incoming = s.accept()){
                InputStream inStream = incoming.getInputStream();
                OutputStream outSteam = incoming.getOutputStream();

                try (Scanner in = new Scanner(inStream, "UTF-8")){
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outSteam, "UTF-8"),
                            true);

                    out.println("Hello! Enter 'I love dormi' to exit");

                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("你好，徐涵喆，你刚刚打了" + "'"+ line + "'");
//                        out.println("Echo: " + line);
                        if (line.trim().equals("I love dormi"))
                            done = true;
                    }
                    out.println("dormi loves 徐涵喆 too");
                }
            }
        }
    }
}
