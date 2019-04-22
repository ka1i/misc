package com.mardan.test_four;

//检测
public class test_01 {
    public  int k=0;
    public static void catch_arithmetic(){
        int i,j;
        i=22;j=0;
        try {
            int result = i/j;
        }catch (ArithmeticException e){
            System.out.println(i+"/"+j+"\t除零错误");
        }
    }

    public static void catch_indexoutofbounds(){
        int[] testarray= {0,1,2,3,4,5};
        try {
            for (int i=0;i<10;i++){
                System.out.println(testarray[i]);
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("越界错误");
        }

    }

    public static void catch_nullpointer(){
        try {
            test_01[] ts = new test_01[3];
            System.out.println("i得值:"+ts[2].k);
        }catch (NullPointerException e){
            System.out.println("nullpointer error");
        }
    }

    public static void main(String[] argv){

        catch_arithmetic();

        catch_indexoutofbounds();

        catch_nullpointer();
    }

}
