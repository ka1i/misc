package com.mardan.test_frist;

public class test_04 {
    public static int Fibonacci(int n) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        //System.out.println(n);
        return (Fibonacci(n-1)+Fibonacci(n-2));
    }

    public static void main(String[] args) {
        System.out.println("test:");
        for(int i=0;i<15;i++) {
            System.out.print(Fibonacci(i)+"  ");
        }
    }
}