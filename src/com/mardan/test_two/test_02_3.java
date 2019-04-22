package com.mardan.test_two;

public class test_02_3 {
    public static void main(String[] args) {
        Point point=new Point();
        point.setX(0);
        point.setY(0);
        point.movePoint(10, 20);
        point.getPoint();

    }
}

class Point{
    static int x,y;
    public Point() {
        x=0;
        y=0;
    }
    public static void setX(int temp_x) {
        x=temp_x;
    }
    public static void setY(int temp_y) {
        y=temp_y;
    }
    public static void getPoint() {
        System.out.println("最终位置:x:"+x+","+"y:"+y);
    }
    public static void movePoint(int temp_x,int temp_y) {
        x=temp_x;
        y=temp_y;
    }
}