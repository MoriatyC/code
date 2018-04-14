package com.dlut.cmh.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/** 
* @author : Menghui Chen 
* @version ：2018年4月14日 上午10:20:39 
* @Description:
*/
public class AioClient {
    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<?> future = client.connect(new InetSocketAddress("127.0.0.1", 8080));
        //阻塞直到链接成功
        future.get();
        
        Attachment att = new Attachment();
        att.setClient(client);
        att.setReadMode(false);
        att.setBuffer(ByteBuffer.allocate(2048));
        byte[] data = "I am a robot".getBytes();
        att.getBuffer().put(data);
        att.getBuffer().flip();
        
        //异步发送数据到服务端
        client.write(att.getBuffer(), att, new ClientChannelHandler());
        Thread.sleep(2000);
    }
}
