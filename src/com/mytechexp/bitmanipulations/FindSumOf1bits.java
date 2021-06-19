package com.mytechexp.bitmanipulations;

import java.util.ArrayList;
import java.util.Arrays;
/*
* /*
We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

ans:
 A = [1, 3, 5]


 f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
         = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
 */

public class FindSumOf1bits {

    public int cntBits(ArrayList<Integer> A) {
        int mod=1000*1000*1000+7;
        long ans=0;
        int count;
        for(int i=0;i<32;i++)
        {
            count=0;

            for(int j=0;j<A.size();j++)
            {

                if((A.get(j)&(1<<i))>0) {
                    count++;
                }
            }
            ans+=(2*count*(A.size()-count))%mod; //number of 1's * number of 0
            ans%=mod;
        }
        return (int)ans;
    }
    public static void main(String[] a)
    {
        FindSumOf1bits findSumOf1bits=new FindSumOf1bits();
        Integer[] num=new Integer[]{1, 3, 5};
        ArrayList<Integer> list=new ArrayList(Arrays.asList(num));
        System.out.println(findSumOf1bits.cntBits(list));
    }
}
