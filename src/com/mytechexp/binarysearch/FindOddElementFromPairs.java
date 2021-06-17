package com.mytechexp.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
/*
* Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.
*
* Using XOR this can be acheived in O(n) times
*
* */
public class FindOddElementFromPairs {
    public int solve(ArrayList<Integer> A) {

        int start=0,end=A.size()-1;
        if(!A.get(0).equals(A.get(1)))
            return A.get(0);

        if(!A.get(end).equals(A.get(end - 1)))
            return A.get(end);

        return findOddone(A,start,end);
    }

    private int findOddone(ArrayList<Integer> A, int start,int end) {
        int mid = start + (end - start) / 2; // to avoid the overflow

        if ((!A.get(mid).equals(A.get(mid - 1))) && (!A.get(mid).equals(A.get(mid + 1))))  //boundary condition
            return A.get(mid);

        else if ((mid & 1) == 1 && A.get(mid).equals(A.get(mid - 1)) || (mid & 1) == 0 && A.get(mid).equals(A.get(mid + 1)))
            return findOddone(A, mid + 1, end);

        else
            return findOddone(A, start, mid - 1);
    }

    public static void main(String[] arg)
    {
        FindOddElementFromPairs findOddElementFromPairs=new FindOddElementFromPairs();
        Integer[] nums=new Integer[]{106, 106, 248, 248, 286, 286, 344, 357, 357};
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(nums));
        System.out.println(findOddElementFromPairs.solve(list));
    }
}
