package com.mytechexp.logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].
* */
public class Maximum_J_I {
    public static void main(String []arg)
    {
        Maximum_J_I mxObj=new Maximum_J_I();
        Integer[] array=new Integer[]{3,5,1,4,2};
        System.out.println(mxObj.maximumGap(new ArrayList<Integer>(Arrays.asList(array))));

    }
    public int maximumGap(final List<Integer> A) {
        ArrayList<Pair> pairArray=new ArrayList<>();
        int size=A.size();
        for(int i=0;i<size;i++)
        {
            pairArray.add(new Pair(A.get(i),i));
        }

        Collections.sort(pairArray);
        // so we have elements in sorted based on values
        /*Iterate from last to first since it is a sortd array so no need of
        * any A[i]<=A[j] calculations it will be fine now just compare the index
        * */
        int max_index=pairArray.get(size-1).getIndex();
        int ans=0;
        for(int i=size-2;i>=0;i--)//skipping the first last elemet, we dont have any to compare on the right hand side
        {
            int cur_index=pairArray.get(i).getIndex();
            if(max_index>cur_index) {
                if (max_index - cur_index > ans)
                    ans = max_index - cur_index;
            }
            else
                max_index=cur_index;
        }
   return ans;
    }
}
class Pair implements Comparable<Pair>
{
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }

    private int num;
    private int index;

    @Override
    public int compareTo(Pair pair) {
        return Integer.compare(getNum(),pair.getNum());
    }
}