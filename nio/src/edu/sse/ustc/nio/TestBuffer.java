package edu.sse.ustc.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * NIO的缓冲区
 */
public class TestBuffer {

    @Test
    public void test1(){
       // 分配指定大小的缓冲区
       ByteBuffer buffer = ByteBuffer.allocate(1024);

       System.out.println("----- Allocate -----");
       System.out.println(buffer.position());
       System.out.println(buffer.limit());
       System.out.println(buffer.capacity());

       // 存储数据
       buffer.put("abcde".getBytes());
       System.out.println("----- Put -----");
       System.out.println(buffer.position());
       System.out.println(buffer.limit());
       System.out.println(buffer.capacity());

       // 写数据模式切换成读取数据的模式:flip（将Position的位置设置为0,将Limit的位置设置为之前Position的位置）
       buffer.flip();
       System.out.println("----- Flip -----");
       System.out.println(buffer.position());
       System.out.println(buffer.limit());
       System.out.println(buffer.capacity());

        // 读数据
        byte[] arrs = new byte[buffer.limit()];
        buffer.get(arrs);
        System.out.println(new String(arrs, 0, arrs.length));
        System.out.println("----- Get -----");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // rewind 可重复读数据（将Position的位置设置为0,limit保持不变）
        buffer.rewind();
        System.out.println("----- Rewind -----");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // clear 清空缓冲区: 缓冲区中的数据依然存在（Position的位置设置为0,limit的位置设置为capacity）
        buffer.clear();
        System.out.println("----- Rewind -----");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        // compact 将所有未读的数据拷贝到Buffer起始处,将Position设置到最后一个未读元素的后面,limit被设置为capacity;buffer准备好写数据,但是不会覆盖未读的数据
        buffer.compact();
        System.out.println("----- Compact -----");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
   }

    @Test
    public void test2(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("abcde".getBytes());
        buffer.flip();
        byte[] arrs = new byte[buffer.limit()];
        buffer.get(arrs, 0,2);
        System.out.println(buffer.position());

        // mark 可以标记Buffer中的一个特定position
        buffer.mark();
        buffer.get(arrs, 0,2);
        System.out.println(buffer.position());

        // reset 恢复到mark位置
        buffer.reset();
        System.out.println(buffer.position());

        if(buffer.hasRemaining()){
            System.out.println("可以操作的数量 ： " + buffer.remaining());
        }
    }

    @Test
    public void testDirectBuffer(){
        // 分配直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        System.out.println(buffer.isDirect());

    }
}
