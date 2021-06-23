package com.mytechexp.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CowStallProblem {
 public static void main(String []a)
 {
     CowStallProblem cowStallProblem=new CowStallProblem();
     Integer[] num=new Integer[]{1, 2, 3, 4, 5};
     System.out.println(cowStallProblem.solve(new ArrayList<Integer>(Arrays.asList(num)),3));
 }
    public int solve(ArrayList<Integer> A, int B) {
        int size=A.size()-1;
        if(B==2 && A.size()==2)
            return A.get(size-1)-A.get(0);


        Collections.sort(A); //O(logn)
        int left_idx=0,right_indx=A.get(size);
        //Reduce the search space technique using binary search
        int mid=0,last_possible=0;
        while(left_idx<right_indx)
        {
            mid=(left_idx+right_indx)/2;
            //in this mid space can we arrange the cows to get min max space

                if(check(A,mid,B)) {
                    left_idx = mid + 1;
                    if(last_possible<mid)
                    last_possible=mid;
                }

                else
                    right_indx=mid;


        }
        return last_possible;
    }
    private boolean check(ArrayList<Integer> A,int mid,int cow)
    {
        int cowCurrently=A.get(0);
        cow--;
        for(int i=1;i<A.size();i++)
        {
            if((A.get(i)-cowCurrently)>=mid)//checking minimum mid number of space required
            {
                cowCurrently=A.get(i);
                cow--;
                if(cow==0)
                    return true;
            }
        }
        return false;
    }
}
