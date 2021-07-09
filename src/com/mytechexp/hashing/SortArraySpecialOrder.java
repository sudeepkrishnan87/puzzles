package com.mytechexp.hashing;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
* Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
* For the elements not present in B, append them at last in sorted order.
*
*A = [1, 2, 3, 4, 5]
B = [5, 4, 2]
* o/p
* [5, 4, 2, 1, 3]
*
* A = [5, 17, 100, 11]
B = [1, 100]
* O/P
* [100, 5, 11, 17]
*
*
*
* */
public class SortArraySpecialOrder {
    public static void main(String[] arg)
    {
        SortArraySpecialOrder sortArraySpecialOrder=new SortArraySpecialOrder();
        int[] A=new int[]{1, 2, 3, 4, 5};
        int[] B=new int[]{5, 4, 2};
        int[] result= sortArraySpecialOrder.solve(A,B);
        for(int i=0;i<result.length;i++)
        System.out.println(result[i]);
    }
    public int[] solve(int[] A, int[] B) {
        //int[] result=new int [A.length];
        Map<Integer,Integer> map=new TreeMap<>();//ferequency also recording and sorting
        for(int i=0;i<A.length;i++)
        {
            if(map.containsKey(A[i]))
                map.put(A[i],map.get(A[i])+1);
            else
                map.put(A[i],1);
        }

        int i=0,j=0;
        while(i<B.length)
        {
            if(map.containsKey(B[i]))
            {
                if(map.get(B[i])>1)
                {
                    for(int x=0;x<map.get(B[i]);x++)
                    {
                        A[j]=B[i];
                        j++;
                    }
                }
                else
                {
                    A[j]=B[i];
                    j++;
                }
                map.remove(B[i]);
            }
            i++;
        }

        for(Entry<Integer,Integer> entry : map.entrySet()){
            int frequency=entry.getValue();
            while(frequency >0)
            {
                A[j]=entry.getKey();
                j++;
                frequency--;
            }
        }

        return A;
    }
}
