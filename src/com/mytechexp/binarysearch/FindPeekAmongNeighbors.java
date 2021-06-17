package com.mytechexp.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;


public class FindPeekAmongNeighbors {
    public int solve(ArrayList<Integer> A) {

        int left=0,right=A.size()-1;
        int result=findPeek(A,left,right);
        return result;
    }

    private int findPeek(ArrayList<Integer> A,int left, int right) {

        int mid = left + (right - left) / 2;

        if ((mid == 0 || A.get(mid) >= A.get(mid - 1)) && (mid == A.size() - 1 || A.get(mid) >= A.get(mid + 1)))
            return A.get(mid);

        else if (mid > 0 && A.get(mid) < A.get(mid - 1))
            return findPeek(A, left, mid - 1);
        else
            return findPeek(A, mid + 1, right);
    }



        public static void main(String[] args)
    {
        Integer[] num=new Integer[]{ 18, 33, 100, 135, 203, 270, 292, 310, 356, 392, 400, 429, 436, 461, 427, 403, 399, 375, 251, 245, 173, 130, 43};
        ArrayList<Integer> neighbor= new ArrayList(Arrays.asList(num));
        FindPeekAmongNeighbors findPeekAmongNeighbors=new FindPeekAmongNeighbors();
        System.out.println(findPeekAmongNeighbors.solve(neighbor));

    }
}
