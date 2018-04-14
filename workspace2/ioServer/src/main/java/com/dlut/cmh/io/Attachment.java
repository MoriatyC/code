package com.dlut.cmh.io;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

/** 
* @author : Menghui Chen 
* @version ：2018年4月14日 上午11:05:16 
* @Description:
*/
public class Attachment {
    private AsynchronousServerSocketChannel server;
    public AsynchronousServerSocketChannel getServer() {
        return server;
    }
    public void setServer(AsynchronousServerSocketChannel server) {
        this.server = server;
    }
    public AsynchronousSocketChannel getClient() {
        return client;
    }
    public void setClient(AsynchronousSocketChannel client) {
        this.client = client;
    }
    public boolean isReadMode() {
        return isReadMode;
    }
    public void setReadMode(boolean isReadMode) {
        this.isReadMode = isReadMode;
    }
    public ByteBuffer getBuffer() {
        return buffer;
    }
    public void setBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
    }
    private AsynchronousSocketChannel client;
    private boolean isReadMode;
    private ByteBuffer buffer;
}
