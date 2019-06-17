package edu.sse.ustc.nio;

import java.nio.ByteBuffer;

/**
 * NewIO： 实现按快读写，区别于IO的按流读写，提升了效率
 * 主要操作的是缓冲区
 * 缓冲区的三个变量：position|limit|capacity
 * IO操作的性能比较：
 * 内存映射 > NIO读写文件 > 使用了带缓存的IO > 没有使用带缓存的IO
 * @author imarklei90
 * @since 2018.11.10
 */
public class NIODemo {

    public static void main(String[] args) {
        // 创建一个字节缓冲区，申请的空间大小为8KB
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        System.out.println("position: " + byteBuffer.position());
        System.out.println("limit: " + byteBuffer.limit());
        System.out.println("capacity: " + byteBuffer.capacity());
        System.out.println("----------------------------------");

        // 向缓冲区中写入数据
        byteBuffer.put((byte)10);
        byteBuffer.put((byte)20);
        byteBuffer.put((byte)30);
        System.out.println("position: " + byteBuffer.position());
        System.out.println("limit: " + byteBuffer.limit());
        System.out.println("capacity: " + byteBuffer.capacity());
        System.out.println("----------------------------------");

        // 缓冲区反转(将position的值赋值给了limit)
        byteBuffer.flip();
        System.out.println("position: " + byteBuffer.position());
        System.out.println("limit: " + byteBuffer.limit());
        System.out.println("capacity: " + byteBuffer.capacity());
        System.out.println("----------------------------------");

        // 判断当前位置与限制之间是否有元素
        if(byteBuffer.hasRemaining()){
            // 返回当前位置与限制之间的元素熟
            for(int i = 0; i < byteBuffer.remaining(); i++){
                byte data = byteBuffer.get(i);
                System.out.println(data);
            }
        }

    }
}
