package com.mardan.test_frist;

import java.util.Scanner;

public class test_03 {
    public static void main(String[] argv) {
        System.out.print("请输入要求和的数字(like this 20170925): ");
        Scanner input=new Scanner(System.in);
        String exp_str=input.nextLine();
        char[] exp=exp_str.toCharArray();
        int sum=0;
        for(int count=0;count<exp.length;count++) {
            System.out.print(exp[count]);
            if(count<(exp.length)-1) {
                System.out.print("+");
            }
            sum=sum+Integer.parseInt(exp[count]+"");
        }
        System.out.println("="+sum);
        input.close();
    }
}