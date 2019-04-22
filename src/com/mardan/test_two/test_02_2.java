package com.mardan.test_two;

import java.util.Arrays;
import java.util.Random;

public class test_02_2 {
    public static void main(String[] args) {
        int sim_demo[]=new int[10];
        for(int i = 0;i<sim_demo.length;i++) {
            Random init_ran=new Random();
            sim_demo[i]=init_ran.nextInt(101);
        }
        ArraySort as=new ArraySort(sim_demo);
        as.SetOrder();
        for(int i = 0;i<as.sim.length;i++) {
            System.out.print(as.sim[i]+"  ");
        }
    }
}
class ArraySort{
    static int MAXLong = 10;
    static int sim[]=new int[MAXLong];
    public static void SetOrder() {
        Arrays.sort(sim);
    }
    public ArraySort(int simtemp[]) {
        for(int i = 0;i<sim.length;i++) {
            sim[i]=simtemp[i];
        }
    }
}