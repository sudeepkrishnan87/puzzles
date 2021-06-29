package com.mytechexp.logics;

/*
* Flip
Problem Description

You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
* */
import java.util.ArrayList;

public class KadaneAlgForFlippingBinary {
    public static void main(String[] arg)
    {
        KadaneAlgForFlippingBinary ksfObj=new KadaneAlgForFlippingBinary();
        String input="1101";
        ArrayList<Integer> result= ksfObj.flip(input);
        for (int i:result) {
            System.out.println(i);
        }

    }
    public ArrayList<Integer> flip(String A) {
      ArrayList<Integer> newInput=new ArrayList();
       int size=A.length();
       boolean flag=false;
       for(int i=0;i<size;i++)
       {
           if(A.charAt(i)=='1')
               newInput.add(-1);
           else {
               newInput.add(1);
               flag=true;
           }
       }
       if(!flag)
           return new ArrayList<Integer>();
        return applyKadance(newInput);
    }

    private ArrayList<Integer> applyKadance(ArrayList<Integer> newInput) {
        ArrayList<Integer> result=new ArrayList<>();
        int curMax=Integer.MIN_VALUE,max=0,left=1,right=1,currentLeft=0,currentRight=0;
        for(int i=0;i<newInput.size();i++)
        {
            max+=newInput.get(i);
            right=i+1;
            if(max>curMax)
            {
                curMax=max;
                currentLeft=left;
                currentRight=right;
            }
            if(max<0) {
                left = i + 2;
                max=0;
            }

        }

        result.add(currentLeft);
        result.add(currentRight);
        return result;
    }

}
