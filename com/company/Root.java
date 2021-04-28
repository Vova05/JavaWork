package com.company;

import java.util.Scanner;

public class Root implements Comparable{
    public static void main(String[] args) {
        Comparable a=new Comparable() {
            @Override
            public int compareTo(Object o) {
                Scanner sc=new Scanner(System.in);
                String a=sc.nextLine();
                String b=sc.nextLine();
                double sum1,sum2,res1=0,res2=0;
                sum1=Double.parseDouble(a);
                sum2=Double.parseDouble(b);
                while(sum1>=1){
                    res1+=(int)sum1%10;
                    sum1/=10;
                }
                while(sum2>=1){
                    res2+=(int)sum2%10;
                    sum2/=10;
                }
               if(res1>res2){
                   System.out.println("First number bigger!");
                   return 0;
               }else{
                   System.out.println("Second number bigger!");
                   return 1;
               }
            }
        };
        a.compareTo(a);
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }
}
