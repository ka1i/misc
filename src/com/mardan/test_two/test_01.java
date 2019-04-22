package com.mardan.test_two;

import java.util.Arrays;
import java.util.Random;

//TestArray test
public class test_01 {

    public static void main(String[] args) {
        TestArray.MAXLong=5;
        TestArray.array_sort_demo();
    }
}
class TestArray{
    static int MAXLong = 10;

    public static void array_sort_demo() {
        int sim[]=new int[MAXLong];
        System.out.print("排序前:");
        for(int i=0;i<MAXLong;i++) {
            Random init_ran=new Random();
            sim[i]=init_ran.nextInt(101);
            System.out.print(sim[i]+"\t");
        }
        Arrays.sort(sim);
        System.out.println();
        System.out.print("排序后:");
        for(int i=0;i<MAXLong;i++) {
            System.out.print(sim[i]+"\t");
        }
    }
}