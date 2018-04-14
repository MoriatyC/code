package com.dlut.cmh.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/** 
* @author : Menghui Chen 
* @version ：2018年4月12日 下午3:52:48 
* @Description:
*/
public class TcpBioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 7777);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建读取服务器端返回的流BufferedReader
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //创建向服务器写入流的PrintWriter
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        //向服务器发送字符串信息,失败也不会异常，一直阻塞或者网络io出现异常
        out.println("hello 我日你吗");
        //阻塞读取服务端返回信息，阻塞到服务器返回或者io异常
//        in.readLine();
    }
}
