package com.mardan.test_four;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class test_04_server {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket s = ss.accept();
            String pathName = "D:\\prepare.txt"; // 空文本，用来接收数据。
            File file = test_04_server.createFile(pathName);
            InputStream in = s.getInputStream();
            FileOutputStream fos = new FileOutputStream(file);
            System.out.println("开始接数据...");
            byte[] buffer = new byte[1024];
            int len = 0;
            int dataCounter = 0;
            while ((len = in.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                dataCounter += len;
            }
            fos.close();
            in.close();
            s.close();
            ss.close();
            System.out.println("数据传输完毕，大小为" + dataCounter + "字节");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File createFile(String pathName) {
        File file = new File(pathName);
        if (file.exists() && file.isFile()) {
            System.out.println("使用已存在的文件");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}