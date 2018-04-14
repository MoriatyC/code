package com.dlut.cmh.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/** 
* @author : Menghui Chen 
* @version ：2018年4月14日 下午2:01:54 
* @Description:
*/
public class ChannelHandler implements CompletionHandler<Integer, Attachment> {

    @Override
    public void completed(Integer ret, Attachment att) {
        if (att.isReadMode()) {
            ByteBuffer buffer = att.getBuffer();
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = new String(buffer.array()).trim();
            System.out.println("收到来自客户端的数据" + msg);
            
            //响应客户端请求，返回数据
            buffer.clear();
            buffer.put("response from server!".getBytes(Charset.forName("UTF-8")));
            att.setReadMode(false);
            buffer.flip();
            //写数据到客户端也是异步
            att.getClient().write(buffer, att, this);
        } else {
            //客户端写数据结束，可以有2种选择， 1. 继续等待客户端发送新的数据来， 2. 断开链接
//            att.setReadMode(true);
//            att.getBuffer().clear();
//            att.getClient().read(att.getBuffer(), att, this);
            try {
                att.getClient().close();
            } catch (IOException e) {
                
            }
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        System.out.println("链接断开");
    }

}
