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
 * @version ：2018年4月13日 下午7:18:57
 * @Description:
 */
public class SelectorServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.socket().bind(new InetSocketAddress(8080));
        // 将其注册到Slector中，监听accept
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    System.out.println("accept");
                    // 有已经接受的新到的服务端的链接
                    SocketChannel socketChannel = server.accept();
                    // 有新的链接不代表这个通道有数据
                    // 将这个新的socketchannel注册到selector，监听read时间等待数据
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    System.out.println("read");
                    // 有数据可读
                    // 上面一个if分支中注册了监听read的通道
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    int num = socketChannel.read(readBuffer);
                    if (num > 0) {
                        System.out.println("收到数据" + new String(readBuffer.array()));
                        ByteBuffer buffer = ByteBuffer.wrap("返回给客户端".getBytes());
                        socketChannel.write(buffer);
                    } else if (num == -1) {
                        socketChannel.close();
                    }
                }
            }
        }
        // ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        // while (true) {
        // SocketChannel socketChannel = serverSocketChannel.accept();
        // SocketHandler handler = new SocketHandler(socketChannel);
        // new Thread(handler).start();
        // }
    }
}
