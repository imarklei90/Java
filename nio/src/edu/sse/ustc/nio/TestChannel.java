package edu.sse.ustc.nio;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    @Test
    public void test5() throws CharacterCodingException { // 字符集
        Charset cs = Charset.forName("GBK");

        // 获取编码器
        CharsetEncoder ce = cs.newEncoder();

        // 获取解码器
        CharsetDecoder cd = cs.newDecoder();

        CharBuffer cBuffer = CharBuffer.allocate(1024);
        cBuffer.put("abcde");
        cBuffer.flip();

        // 编码
        ByteBuffer  bBuffer = ce.encode(cBuffer);

        for(int i = 0; i < 12; i++){
            System.out.println(bBuffer.get());
        }

        // 解码
        bBuffer.flip();
        CharBuffer cBuffer2 = cd.decode(bBuffer);
        System.out.println(cBuffer2.toString());

        System.out.println("-------------------");
        Charset cs2 = Charset.forName("UTF-8");
        bBuffer.flip();
        CharBuffer cBuffer3 = cs2.decode(bBuffer);
        System.out.println(cBuffer3.toString());

    }

    @Test
    public void test4() throws IOException { // 分散和聚集
        RandomAccessFile raFile = new RandomAccessFile("nio_testdata.txt", "rw");

        // 获取通道
        FileChannel channel1 = raFile.getChannel();

        // 分配指定大小的缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);

        // 分散读取（Channel -> Buffer）
        ByteBuffer[] buffers = {buffer1, buffer2};
        channel1.read(buffers);

        for(ByteBuffer byteBuffer : buffers){
            byteBuffer.flip();
        }

        System.out.println(new String(buffers[0].array(),0, buffers[0].limit()));
        System.out.println("------------------");
        System.out.println(new String(buffers[1].array(), 0, buffers[1].limit()));

        // 聚集写入 (Buffer -> Channel)
        RandomAccessFile raFile2 = new RandomAccessFile("nio_testdata.txt", "rw");
        FileChannel channel2 = raFile2.getChannel();
        channel2.write(buffers);
    }

    @Test
    public void test3() throws IOException { // 通道之间的数据传输
        FileChannel inChannel = FileChannel.open(Paths.get("data/nio_testdata.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("data/nio_transformData.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ);

        // 将数据从FileChannel传输到其他的Channel中
        //inChannel.transferTo(0, inChannel.size(), outChannel);

        // 将数据从源Channel传输到FileChannel
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void tetChannel2() throws IOException { // 直接缓冲区（内存映射文件）
        FileChannel inChannel = FileChannel.open(Paths.get("c:/", "xx.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE_NEW);

        // 内存映射文件
        MappedByteBuffer inMapperBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapperBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, outChannel.size());

        // 直接对缓冲区进行数据的读写操作
        byte[] arrs = new byte[inMapperBuffer.limit()];
        inMapperBuffer.get(arrs);
        outMapperBuffer.put(arrs);

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void testChannel(){ // 非直接缓冲区
        // 利用Channel完成文件复制
        FileInputStream fis = null;
        FileOutputStream fos = null;

        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try{
            fis = new FileInputStream("data/nio_testdata.txt");
            fos = new FileOutputStream("data/nio_dest.txt");

            // 获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 分配缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 将通道中的数据存入缓冲区中
            while((inChannel.read(buffer)!= -1)){
                buffer.flip(); // 切换数据读取模式(先从buffer中读取数据，再反转buffer)
                outChannel.write(buffer); // 将缓冲区中的数据写入通道中
                buffer.clear(); // 清空缓冲区，可以再次被写入数据
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
