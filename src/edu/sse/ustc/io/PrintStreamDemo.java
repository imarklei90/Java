package edu.sse.ustc.io;

import java.io.*;

/**打印流
 * @author imarklei90
 * @since 2018.11.08
 */
public class PrintStreamDemo {

    private static final String inputFilePath = System.getProperty("user.dir") +
            File.separator + "data" + File.separator + "user.txt";

    public static void main(String[] args) {
       // printStream();
        printWrite();
    }

    private static void printStream(){
        File inputFile = new File(inputFilePath);
        try {
            FileOutputStream outputStream = new FileOutputStream(inputFile);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            PrintStream printStream = new PrintStream(bos);

            printStream.print("这里是打印输出流");
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printWrite(){
        File inputFile = new File(inputFilePath);
        FileWriter writer = null;
        try {
            writer = new FileWriter(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(writer);
        PrintWriter printWriter = new PrintWriter(bw);
        printWriter.print("printWriter 打印输出流");
        printWriter.close();
    }
}
