package com.mardan.test_four;


import java.util.Calendar;
import java.util.TimeZone;


public class test_02 {
    public static void threading_run(){
        Print_Time p1 = new Print_Time("GMT+0");
        Print_Time p2 = new Print_Time("GMT+8");
        Print_Time p3 = new Print_Time("GMT+16");
        Thread th1 = new Thread(p1);
        Thread th2 = new Thread(p2);
        Thread th3 = new Thread(p3);
        th1.start();
        th2.start();
        th3.start();
    }

    public static void main(String[] argv){

        test_02 test=new test_02();
        test.threading_run();
    }
}

class Print_Time extends Thread{
    public String s;
    public Print_Time(String tzs){
        s=tzs;
    }

    @Override
    public void run() {
        TimeZone tz = TimeZone.getTimeZone(s);
        Calendar cr= Calendar.getInstance(tz);
        int year= cr.get(Calendar.YEAR);
        int month= cr.get(Calendar.MONTH)+1;
        int day= cr.get(Calendar.DAY_OF_MONTH);
        int hour= cr.get(Calendar.HOUR);
        int min= cr.get(Calendar.MINUTE);
        int sec= cr.get(Calendar.SECOND);
        System.out.println("时区："+s+" 时间为："+year+"-"+month+"-"+day+" "+hour+":"+min+":"+":"+sec);
    }
}