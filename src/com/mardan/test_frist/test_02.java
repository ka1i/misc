package com.mardan.test_frist;

public class test_02 {
    public static void main(String[] argv) {
        for(int i=1;i<=9;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(i+"*"+j+"="+i*j);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}