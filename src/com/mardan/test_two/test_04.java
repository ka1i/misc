package com.mardan.test_two;

public class test_04 {
    final static int MAX=11;
    public static void main(String[] args) {
        int sim[]=new int[MAX];
        for(int i=1;i<MAX;i++) {
            if(i==1||(i%2==0&&i!=2)) {
                for(int j=2;j<i;j++) {
                    if(i%j==0) {
                        sim[i]=1;
                    }
                }
            }
            else {
                sim[i]=0;
            }
        }

        for(int i=1;i<MAX;i++) {
            System.out.print(sim[i]+"\t");
        }
    }
}