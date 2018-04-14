package com.dlut.cmh.io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/** 
* @author : Menghui Chen 
* @version ：2018年4月13日 下午2:27:31 
* @Description:
*/
public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(80);
        byte[] buffer = new byte[10];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet);
    }
}
