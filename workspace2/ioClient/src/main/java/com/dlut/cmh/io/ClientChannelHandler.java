package com.dlut.cmh.io;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

/** 
* @author : Menghui Chen 
* @version ：2018年4月14日 下午2:45:03 
* @Description:
*/
public class ClientChannelHandler implements CompletionHandler<Integer, Attachment> {

    @Override
    public void completed(Integer ret, Attachment att) {
        ByteBuffer buffer = att.getBuffer();
        if (att.isReadMode()) {
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = new String(bytes, Charset.forName("UTF-8"));
            System.out.println("收到来自服务器的响应数据" + msg);
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        System.out.println("服务器无响应");
    }

}
