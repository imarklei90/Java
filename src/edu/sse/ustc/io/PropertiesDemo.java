package edu.sse.ustc.io;

import java.io.*;
import java.util.Properties;

/**
 * Properties读取配置文件
 * @author imarklei90
 * @since 2018.11.10
 */
public class PropertiesDemo {
    private static String version = "";
    private static String username = "";
    private static String password = "";

    public static void main(String[] args) {
        writeConfig();
        readConfig();
        System.out.println(version + "->" + username + "->" + password);
    }

    private static void readConfig(){
        Properties properties = new Properties();
        // 获取资源文件的方法(通过当前线程的类加载器对象获取指定包下的配置文件)
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("edu/sse/ustc/res/config.properties");
        try {
            properties.load(inputStream);
            version = properties.getProperty("app.version");
            username = properties.getProperty("app.username");
            password = properties.getProperty("app.password");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeConfig(){
        Properties properties = new Properties();
        properties.put("app.version", "2.0");
        properties.put("app.username", "user2");
        properties.put("app.password", "password2");

        try {
            OutputStream outputStream = new FileOutputStream(new File("config"));
            properties.store(outputStream, "update config");
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
