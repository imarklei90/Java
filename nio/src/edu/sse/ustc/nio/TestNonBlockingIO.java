package edu.sse.ustc.nio;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class TestNonBlockingIO {

    @Test
    public void client() throws IOException { // 客户端
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        // 切换成非阻塞模式
        socketChannel.configureBlocking(false);

        // 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 发送数据到服务器端
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String data = scanner.next();
            buffer.put((new Date().toString() + "\n" + data).getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        // 关闭通道
        socketChannel.close();

    }

    @Test
    public void server() throws IOException { // 服务端
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 切换成非阻塞模式
        serverSocketChannel.configureBlocking(false);

        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));

        // 获取选择器
        Selector selector = Selector.open();

        // 将通道注册到选择器, 并且制定‘监听接收事件’
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 轮询式地获取选择器上已经‘准备就绪’的事件
        while(selector.select() > 0){
            // 获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
            while(itr.hasNext()){
                SelectionKey sk = itr.next();
                // 判断是什么事件准备就绪
                if(sk.isAcceptable()){
                    // 若‘接收就绪’，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 切换到非阻塞模式
                    socketChannel.configureBlocking(false);
                    int interests = SelectionKey.OP_ACCEPT | SelectionKey.OP_READ;
                    // 将通道注册到选择器上
                    socketChannel.register(selector, interests);
                }else if(sk.isReadable()){
                    // 获取当前选择去上‘读就绪’状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    // 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    int len;
                    while((len = socketChannel.read(buffer)) > 0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, len));
                        buffer.clear();
                    }
                }

                // 取消选择键（Selector不会自己从已选择键集中移除SelectionKey实例）
                itr.remove();
            }
        }
    }

    @Test
    public void send() throws IOException { // 客户端
        // 获取通道
        DatagramChannel datagramChannel = DatagramChannel.open();

        // 切换成非阻塞模式
        datagramChannel.configureBlocking(false);

        // 分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 发送数据到服务器端
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String data = scanner.next();
            buffer.put((new Date().toString() + "\n" + data).getBytes());
            buffer.flip();
            datagramChannel.send(buffer, new InetSocketAddress("127.0.0.1", 9898));
            buffer.clear();
        }

        // 关闭通道
        datagramChannel.close();

    }

    @Test
    public void receiver() throws IOException { // 服务端
        // 获取通道
        DatagramChannel datagramChannel = DatagramChannel.open();

        // 切换成非阻塞模式
        datagramChannel.configureBlocking(false);

        // 绑定连接
        datagramChannel.bind(new InetSocketAddress(9898));

        // 获取选择器
        Selector selector = Selector.open();

        // 将通道注册到选择器, 并且制定‘监听接收事件’
        datagramChannel.register(selector, SelectionKey.OP_READ);

        // 轮询式地获取选择器上已经‘准备就绪’的事件
        while(selector.select() > 0){
            // 获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
            while(itr.hasNext()){
                SelectionKey sk = itr.next();
                // 判断是什么事件准备就绪
                if(sk.isReadable()){
                    // 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    datagramChannel.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                }

                // 取消选择键
                itr.remove();
            }
        }
    }
}
