package com.mytechexp.romanletters;

import java.util.Scanner;

public class RomanToNumber {
    public static void main(String[] args)
    {
Scanner sc=new Scanner(System.in);
System.out.println("Enter the RomanLetter which you want to convert in  Capital");
   // String str="CCXVII";
        String str=sc.nextLine();
    int result=0;
    for(int i=0;i<str.length();i++)
    {
       if(i>0 && RomanMapper.getRomanEquivalent(str.charAt(i))>RomanMapper.getRomanEquivalent(str.charAt(i-1)))
        result+=RomanMapper.getRomanEquivalent(str.charAt(i))-2*RomanMapper.getRomanEquivalent(str.charAt(i-1));
        else
    result+=RomanMapper.getRomanEquivalent(str.charAt(i));
    }
   System.out.println(result);

}

}
