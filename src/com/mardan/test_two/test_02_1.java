package com.mardan.test_two;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


//Mydate class
public class test_02_1 {
    public static void main(String[] args) throws IOException {
        Mydate.MyData_demo();
    }

}
class Mydate{
    static String nowdate;
    public static void MyData_demo() throws IOException {
        nowdate = Get_date();
        while (true){
            System.out.println("ÏÖÔÚÊÇ:"+nowdate);
            user_guide();
            @SuppressWarnings("resource")
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            switch(choose) {
                case 1:
                    set_date();
                    break;
                case 2:
                    add_date();
                    break;
                case 3:
                    show_date();
                    break;
                case 4:
                    System.out.println("³ÌÐòÕý³£ÍË³ö...");
                    System.exit(0);
                default:
                    System.out.println("ÊäÈëŽíÎó");
            }
        }
    }

    public static void set_date() {
        System.out.print("ÇëÊäÈëÄãÒªÉèÖÃµÄÈÕÆÚ(like:2018-11-23)£º");
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        String date = scan.next();
        String result=check_date(date);
        if(result!=date) {
            System.out.println(result);
        }
        else {
            nowdate=date;
        }
    }

    public static void add_date() {
        System.out.print("ÇëÊäÈëÄãÒªÔöŒÓµÄÌìÊý(like:12)£º");
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        int date = scan.nextInt();
        String[] date_get_str=nowdate.split("-");
        int[] date_get = new int[date_get_str.length];
        for(int i=0;i<date_get_str.length;i++) {
            date_get[i]=Integer.parseInt(date_get_str[i]);
        }
        String date_exp=inttostr(date_get[0])+"-"+inttostr(date_get[1])+"-"+inttostr(date_get[2]+date);
        System.out.println(date_exp);
        String result=check_date(date_exp);
        if(result!=date_exp) {
            System.out.println(result);
        }
        else {
            nowdate=date_exp;
        }
    }
    public static void show_date() {
        System.out.println("\n\tÏÖÔÚÊÇ:"+nowdate+"\n");

    }

    public static void user_guide() {
        System.out.println("\tWelcome to this progream");
        System.out.println("\t\t1.ÉèÖÃÈÕÆÚ");
        System.out.println("\t\t2.ÔöŒÓÈÕÆÚ");
        System.out.println("\t\t3.Êä³öÈÕÆÚ");
        System.out.println("\t\t4.ÍË³ö³ÌÐò");
        System.out.print("\t    ÇëÊäÈëÄãµÄÑ¡Ôñ:");
    }

    public static String inttostr(int convert_int) {
        return String.valueOf(convert_int);
    }

    public static String Get_date() {
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        String now_date = data.format(new Date());
        return now_date;
    }
    public static String check_date(String date) {
        String returncode="ÊäÈëÈÕÆÚŽíÎó,ÇëÌîÐŽ1970-1-1Ö®ºóµÄÅ¶";;
        String[] date_get_str=date.split("-");
        int[] date_get = new int[date_get_str.length];
        for(int i=0;i<date_get_str.length;i++) {
            date_get[i]=Integer.parseInt(date_get_str[i]);
            //System.out.println("date_get["+i+"]="+date_get[i]);
        }
        Boolean status=false;
        if(date_get[0]>=1970) {
            status=true;
            if(1<=date_get[1]&&date_get[1]<=12) {
                switch (date_get[1]) {
                    case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                        if(date_get[2]<1||date_get[2]>31) {
                            returncode=date_get[1]+"ÔÂ·ÝÊÇ31ÌìµÄÑœ";
                            status=false;
                        }
                        break;
                    case 2:
                        if((date_get[0]%4==0&&date_get[0]%100!=0)||date_get[0]%400==0) {
                            if(date_get[2]<1||date_get[2]>29) {
                                returncode="ÈòÄêÊÇÓÐ29ÌìµÄÑœ";
                                status=false;
                            }
                        }
                        else {
                            if(date_get[2]<1||date_get[2]>28) {
                                returncode="ÆœÄêÊÇÓÐ28ÌìµÄÑœ";
                                status=false;
                            }
                        }
                        break;
                    case 4:case 6:case 9:case 11:
                        if(date_get[2]<1||date_get[2]>30) {
                            returncode=date_get[1]+"ÔÂ·ÝÊÇ30ÌìµÄÑœ";
                            status=false;
                        }
                        break;
                }
            }
        }

        if(status) {
            return date;

        }
        else {
            return returncode;
        }
    }
}