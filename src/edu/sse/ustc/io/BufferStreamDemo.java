package edu.sse.ustc.io;

import java.awt.color.ICC_Profile;
import java.io.*;

/**
 * @author imarklei90
 * @since 2018.11.07
 */
public class BufferStreamDemo {

    private static final String inputFilePath = System.getProperty("user.dir") +
            File.separator + "data" + File.separator + "user.txt";

    public static void main(String[] args) throws IOException {
        writer();
        reader();
    }

    private static void reader() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(inputFilePath)));

        byte[] bytes = new byte[1024];
        int len = -1;
        while((len = bis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }
    }

    private static void writer(){
        BufferedOutputStream bos = null;
        String info = "我是缓冲输出流";
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File(inputFilePath)));
            bos.write(info.getBytes());
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
