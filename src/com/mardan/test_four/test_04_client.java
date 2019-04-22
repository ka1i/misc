package com.mardan.test_four;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class test_04_client {
    public static void main(String[] args) {
        String pathName = "E:\\Course\\Java程序设计\\University\\temp.txt";
        File file = new File(pathName);
        byte[] IP = new byte[] { 127, 0, 0, 1 };
        if (!(findFile(pathName))) {
            return;
        }
        System.out.println("正在连接到目标主机……");
        try {
            System.out.println("正在连接到目标主机...");
            InetAddress addr = InetAddress.getByAddress(IP);
            Socket s = new Socket(addr, 8888);
            OutputStream output = s.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            System.out.println("连接成功，正在传输数据...");
            byte[] buffer = new byte[1024];
            int len = 0;
            int dataCounter = 0;
            while ((len = fis.read(buffer)) != -1) {
                output.write(buffer, 0, len);
                dataCounter += len;
            }
            fis.close();
            output.close();
            s.close();
            System.out.println("数据传送完毕，共传送" + dataCounter + "字节。");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean findFile(String pathName) {
        File file = new File(pathName);
        if (file.isFile())
            return true;
        else
            return false;
    }
}