package com.dlut.cmh.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/** 
* @author : Menghui Chen 
* @version ：2018年4月14日 上午10:20:29 
* @Description:
*/
public class AioServer {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8080));
        Attachment att = new Attachment();
        att.setServer(server);
        server.accept(att, new CompletionHandler<AsynchronousSocketChannel, Attachment>(){
           @Override
           public void completed(AsynchronousSocketChannel client, Attachment att) {
               try {
                   SocketAddress clientAddr = client.getRemoteAddress();
                   System.out.println("收到新的链接:" + clientAddr);
                   
                   //收到新的链接后，server应该重新调用accept方法等待新的链接进来
                   att.getServer().accept(att, this);
                   
                   Attachment newAtt = new Attachment();
                   newAtt.setServer(server);
                   newAtt.setClient(client);
                   newAtt.setReadMode(true);
                   newAtt.setBuffer(ByteBuffer.allocate(2048));
                   
                   client.read(newAtt.getBuffer(), newAtt, new ChannelHandler());
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }
           @Override
           public void failed(Throwable t, Attachment att) {
               System.out.println("accept failed");
           }
        });
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            
        }
        
    }
}
