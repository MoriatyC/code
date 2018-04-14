package com.dlut.cmh.io;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/** 
* @author : Menghui Chen 
* @version ：2018年4月13日 下午2:29:07 
* @Description:
*/
public class UpdClient {
    public static void main(String[] args) throws IOException {
        byte[] buffer = "0123456789".getBytes();
        InetAddress address = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 80);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(packet);
        byte[] buffer0 = packet.getData();
        System.out.println(new String(buffer0));
    }
}
