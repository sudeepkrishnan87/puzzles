package com.mytechexp.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.
*
* */
public class SubArrayWith0 {
    public static void main(String[] arg)
    {
        SubArrayWith0 subArrayWith0=new SubArrayWith0();
        int[] arr=new int[]{4,3,3,-10,5,6,-1};
        System.out.println(subArrayWith0.solve(arr));
    }
    public int solve(int[] A) {
        Set<Long> set=new HashSet<>();
        int mod=1000*1000*1000+7;
        long sum=0l;

        for(int i=0;i<A.length;i++)
        {
            sum=(sum+A[i]);

            if(A[i]==0||sum==0||set.contains(sum))
            {
                return 1;
            }
            set.add(sum);
        }
        return 0;
    }

}
