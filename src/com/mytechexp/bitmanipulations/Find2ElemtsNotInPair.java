package com.mytechexp.bitmanipulations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Find the two elements that appear only once.
*
* A = [1, 2, 3, 1, 2, 4]
* Ans=[3,4]
*
* Here i am providing two answers with different time complexity
* */
public class Find2ElemtsNotInPair {
    public static void main(String[] a)
    {
        Find2ElemtsNotInPair find2ElemtsNotInPair=new Find2ElemtsNotInPair();
        Integer[] num=new Integer[]{1, 2, 3, 1, 2, 4};
        List<Integer> result=find2ElemtsNotInPair.solve(find2ElemtsNotInPair.solve(new ArrayList(Arrays.asList(num))));
        System.out.println(result);
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int xor = 0;
        for (int a : A)
            xor ^= a;

        //going to find the mask bit

        int mask = (xor & (xor - 1)) ^ xor;
        //System.out.print(mask);
        int a = 0, b = 0;
        for (int i : A) {
            if ((i & mask) != 0)
                a = i ^ a;
            else
                b = i ^ b;
        }

        A.clear();
        A.add(Math.min(a, b));
        A.add(Math.max(a, b));
        return A;
    }
 /*
        Collections.sort(A);
        Integer[] ans=new Integer[2];
        int i=0;
        int j=0;
        while(i<=A.size()-1)
        {
            if(i==A.size()-1)
            {
              ans[j]=A.get(i);
              break;

            }
            if((A.get(i)^A.get(i+1))==0)
            {
              i=i+2;
              continue;
            }
            else
            {
            ans[j]=A.get(i);
            i=i+1;
            j++;
            }
        }
        return new ArrayList(Arrays.asList(ans));
        // Tc= O(nlogn)
        // SC=O(2) so O(1);
        */



}
