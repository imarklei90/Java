package edu.sse.ustc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * a Simple IO Demo
 * @since 2018.09.21
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException{
        FileInputStreamDemo fileInputDemo = new FileInputStreamDemo();
        fileInputDemo.readFileDemo();
    }

    private void readFileDemo() throws IOException {
        String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + "user.txt";
        System.out.println("filePath = " + filePath);
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int read = fileInputStream.read();
        String line = null;
        while((fileInputStream.read() != -1)){
            System.out.println(fileInputStream.read());
        }

    }
}
