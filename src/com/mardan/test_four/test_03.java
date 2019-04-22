package com.mardan.test_four;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class test_03 {
    public static void main(String[] argv){
        //写文件名
        String FILE_NAME="temp.txt";

        String scannerresult=null;
        while (true){
            System.out.print("请输入要写入文件的文字（输入quit以退出）: ");
            Scanner scanner=new Scanner(System.in);
            scannerresult=scanner.nextLine();
            if (scannerresult.equals("quit")){
                System.out.println("退出成功");
                System.exit(0);
            }
            try {
                File file=new File(FILE_NAME);
                if (!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter=new FileWriter(file.getName(),true);
                fileWriter.write(scannerresult+"\n");
                fileWriter.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            System.out.println("写入 "+scannerresult+" 成功");
        }
    }
}