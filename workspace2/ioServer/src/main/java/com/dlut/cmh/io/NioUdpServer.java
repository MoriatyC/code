package com.dlut.cmh.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/** 
* @author : Menghui Chen 
* @version ：2018年4月13日 下午5:10:08 
* @Description:
*/
public class NioUdpServer {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(80));
        ByteBuffer buf = ByteBuffer.allocate(48);
        channel.receive(buf);
        System.out.println(new String(buf.array()));
    }
}
