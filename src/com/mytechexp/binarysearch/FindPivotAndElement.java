package com.mytechexp.binarysearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.
* */
public class FindPivotAndElement {

    public int search(final List<Integer> A, int B) {

        int start=0,end=A.size()-1,mid=0;


        while(start<=end)
        {
            mid=start+(end-start)/2;
            if(B==A.get(mid))
                return mid;

            if(start>end)
                return -1;
            if(A.get(start)<A.get(mid))
            {
                if(A.get(start)<=B && A.get(mid)>=B)
                  end=mid-1;
                else
                    start=mid+1;

            }
            else
                if(A.get(mid)<=B && A.get(end)>=B)
                    start=mid+1;
                else
                    end=mid-1;

        }
        return -1;
    }

    public static void main(String[] arg)
    {
        FindPivotAndElement findPivotAndElement=new FindPivotAndElement();
        Integer[] num=new Integer[]{19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17};
        List<Integer>list= new ArrayList(Arrays.asList(num));
        System.out.println(findPivotAndElement.search(list,6));
    }
}
