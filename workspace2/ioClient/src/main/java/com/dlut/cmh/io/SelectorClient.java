package com.dlut.cmh.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : Menghui Chen
 * @version ：2018年4月13日 下午7:19:17
 * @Description:
 */
public class SelectorClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));
        Thread.sleep(50000);
        // 发送请求
        ByteBuffer buffer = ByteBuffer.wrap("asdfs1234567".getBytes());
        socketChannel.write(buffer);

        // 读取响应
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();
            
            byte[] ret = new byte[num];
            readBuffer.get(ret);
            String result = new String(ret, "UTF-8");
            System.out.println("返回值789798789789" + result);
        }
        socketChannel.close();
    }
}
