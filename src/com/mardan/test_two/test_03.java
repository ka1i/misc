package com.mardan.test_two;

public class test_03 {
    public static void main(String[] args) {
        System.out.print("三角形面积:");
        S_of_Triangle tri=new S_of_Triangle(3,5);
        System.out.print("长方形面积:");
        S_of_rectangle rec=new S_of_rectangle(3,5);
    }
}
class S_of_Triangle{
    public S_of_Triangle(float w,float h) {
        System.out.println(w*h/2);
    }
}
class S_of_rectangle{
    public S_of_rectangle(float w,float h) {
        System.out.println(w*h);
    }
}