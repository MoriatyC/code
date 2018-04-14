package com.dlut.cmh.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;


public class TcpBioServer {
   
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("waiting");
        Socket socket = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(in.readLine());
    }
}
