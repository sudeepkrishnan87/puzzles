package com.mytechexp.romanletters;

import java.util.Scanner;

public class IntegerToRoman {

    public static void main(String[] a)
    {

        String[] thousand={"","M","MM","MMM"};

        String hundrads[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String tens[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String ones[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};
    System.out.println("Enter the number you want to convert in to Roman letters <4000");
    Scanner sc=new Scanner(System.in);

    int number=sc.nextInt();

    String romanLetter=thousand[number/1000]+hundrads[(number%1000)/100]+tens[(number%100)/10]+ones[number%10];
    System.out.println(romanLetter);

    }
}
