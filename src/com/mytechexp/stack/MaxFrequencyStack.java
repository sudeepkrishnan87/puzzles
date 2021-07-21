package com.mytechexp.stack;

import java.util.*;
/*
* You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
* */
public class MaxFrequencyStack {
    public static void main(String[] arg)
    {
        MaxFrequencyStack obj=new MaxFrequencyStack();
       ArrayList<ArrayList<Integer>> freqList=new ArrayList<>();
        Integer[][] test=new Integer[][]{ {1,2},{2,0},{1,2},{1,7},{2,0},{2,0},{1,4},{1,1},{1,7}};

        for(Integer[] arr:test)
        {
            ArrayList<Integer> currentSubList = new ArrayList<>(arr.length);
            Collections.addAll(currentSubList,arr);
            freqList.add(currentSubList);
        }


        ArrayList<Integer> result=obj.solve(freqList);
       result.forEach(n->System.out.print(n+","));
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        Map<Integer,Integer> freq=new HashMap<>();
        Map<Integer,Stack<Integer>> stackMap=new HashMap<>();

        ArrayList<Integer> result=new ArrayList<>();

        int size=A.size();
        int maxFreq=1;
        for(int i=0;i<size;i++)
        {
            int operation=A.get(i).get(0);
            int value=A.get(i).get(1);
            if(operation==1)
            {
                if(freq.containsKey(value))
                {
                    freq.replace(value,freq.get(value)+1);
                    result.add(-1);
                    maxFreq=Math.max(maxFreq,freq.get(value));
                }
                else
                {
                    freq.put(value,1);
                    if(maxFreq==0)
                        maxFreq=1;
                    result.add(-1);
                }
                int frequency=freq.get(value);
                if(stackMap.containsKey(frequency))
                {
                    Stack st=stackMap.get(frequency);
                    st.push(value);

                    stackMap.replace(frequency,st);
                }
                else
                {
                    Stack<Integer> stack=new Stack<>();
                    stack.push(value);
                    stackMap.put(frequency,stack);
                }
            }
            else
            {
                if(value==0 && maxFreq>0)
                {
                    int ans=stackMap.get(maxFreq).pop();
                    freq.put(ans,maxFreq-1);
                    if(stackMap.get(maxFreq).empty()) {
                        --maxFreq;
                    }
                    result.add(ans);

                }
            }

        }

        return result;
    }
}
