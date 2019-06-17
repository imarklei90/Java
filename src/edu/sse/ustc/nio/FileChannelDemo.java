package edu.sse.ustc.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel
 * 实现文件的复制
 * @author imarklei90
 * @since 2018.11.10
 */
public class FileChannelDemo {

    private static final String fileSourcePath = System.getProperty("user.dir")
            + File.separator + "pic" + File.separator + "ustc_Logo.gif";

    private static final String fileDestPath = System.getProperty("user.dir")
            + File.separator + "data" + File.separator + "copy_from_pic_ustc_Logo.gif";

    private static void copyFile() throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileSourcePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 创建一个输入文件的通道
        FileChannel fileInputChannel = fileInputStream.getChannel();
        FileChannel fileOutputChannel = null;

        try {
            // 创建一个输出文件的通道
            fileOutputChannel = new FileOutputStream(fileDestPath).getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(fileInputChannel.read(byteBuffer) != -1){
            byteBuffer.flip();
            try {
                fileOutputChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byteBuffer.clear();
        }
        try {
            fileInputChannel.close();
            fileOutputChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {
        copyFile();
    }
}
