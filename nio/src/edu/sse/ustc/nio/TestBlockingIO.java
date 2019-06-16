package edu.sse.ustc.nio;

import org.junit.Test;
import sun.reflect.generics.scope.Scope;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingIO {

    @Test
    public void client() throws IOException { // 客户端
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        // 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        FileChannel inChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);

        // 读取本地文件，发送到服务器端
        while(inChannel.read(buffer) != -1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        // 接收服务端反馈
        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1){
            buffer.flip();
            System.out.println(new String(buffer.array(), 0,len));
            buffer.clear();
        }

        // 关闭通道
        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException { // 服务端
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        // 获取客户端连接的通道
        SocketChannel socketChannel = serverSocketChannel.accept();

        FileChannel outChannel = FileChannel.open(Paths.get(""), StandardOpenOption.WRITE, StandardOpenOption.READ);

        // 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 接收客户端数据，保存到本地
        while(socketChannel.read(buffer) != -1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        // 发送反馈给客户端
        buffer.put("反馈".getBytes());
        buffer.flip();
        socketChannel.write(buffer);


        // 关闭通道
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }
}
