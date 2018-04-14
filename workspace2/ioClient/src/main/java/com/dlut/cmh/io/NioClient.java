package com.dlut.cmh.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/** 
* @author : Menghui Chen 
* @version ：2018年4月12日 下午9:08:24 
* @Description:
*/
public class NioClient {
    public static void main(String[] args) throws IOException {
        String newData = "操你妈" + System.currentTimeMillis();
        DatagramChannel channel = DatagramChannel.open();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.put(newData.getBytes());
        buf.flip();
        int bytesSent = channel.send(buf, new InetSocketAddress("127.0.0.1", 80));
        
        
        
        
//        SocketChannel channel = SocketChannel.open();
//        //设置为非阻塞
//        channel.configureBlocking(false);
//        //对于非阻塞模式，like返回false，表示连接正在建立
//        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8801);
//        channel.connect(socketAddress);
//        Selector selector = Selector.open();
//        //向channel注册selector以及感性的链接时间
//        channel.register(selector, SelectionKey.OP_CONNECT);
//        //阻塞直到有感兴趣的IO时间发生，或者达到超时时间，如果希望一直等，可以使用无参数的select
//        int nKeys = selector.select(1000);
//        //nKeys大于0，说明有感兴趣的事件发生
//        SelectionKey sKey = null;
//        if (nKeys > 0) {
//            Set<SelectionKey> keys = selector.selectedKeys();
//            for (SelectionKey key: keys) {
//                if (key.isConnectable()) {
//                    SocketChannel sc = (SocketChannel) key.channel();
//                    sc.configureBlocking(false);
//                    sKey = sc.register(selector, SelectionKey.OP_READ);
//                    sc.finishConnect();
//                } else if (key.isReadable()) {
//                    ByteBuffer buffer = ByteBuffer.allocate(1024);
//                    SocketChannel sc= (SocketChannel) key.channel();
//                    int readBytes = 0;
//                    try {
//                        int ret = 0;
//                        try {
//                            //读取目前可读的流，sc.read返回的为成功复制到bytebuffer中的字节数，操作阻塞 ，结尾返回-1
//                            while ((ret = sc.read(buffer)) > 0) {
//                                readBytes += ret;
//                            }
//                        } finally {
//                            buffer.flip();
//                        }
//                        
//                    } finally {
//                        if (buffer != null) {
//                            buffer.clear();
//                        }
//                    }
//                } else if (key.isWritable()) {
//                    key.interestOps(key.interestOps() & (~SelectionKey.OP_WRITE));
//                    SocketChannel sc = (SocketChannel) key.channel();
//                    int writtenedSize = sc.write(ByteBuffer);
//                    StringBuilder sb = new StringBuilder();
//                    sb.de
//                }
//            }
//        }
    }
}
