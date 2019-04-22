package com.mardan;

import java.lang.Thread;

public class print99_demo {
    public void threading_run() {
        print99 p1 = new print99(1,3);
        print99 p2 = new print99(4,6);
        print99 p3 = new print99(7,9);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        t2.start();
        t3.start();
        t1.start();
    }
    public static void main(String[] args) {
        print99_demo demo = new print99_demo();
        demo.threading_run();
    }
}
class print99 implements Runnable{
    int start,end;
    static int count=1;
    static final Object lock = new Object();
    public print99(int a,int b) {
        start=a;
        end=b;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(lock) {
                try {
                    if(start == count) {
                        for(int i=start;i<=end;i++) {
                            for(int j=1;j<=i;j++) {
                                System.out.print(i+"*"+j+"="+i*j+"\t");
                            }
                            System.out.println();
                        }
                        System.out.println("***----------***");
                        count += 3;
                        lock.notifyAll();
                    }
                    else {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}