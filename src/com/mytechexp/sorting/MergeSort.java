package com.mytechexp.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 10, 6, 8, 5, 7, 3, 4};
        mergeSort(arr, arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    private static void mergeSort(int[] arr, int length) {

        if(length<2)
            return;
        int mid=length/2;

        int left[]=new int[mid];
        int right[]=new int[length-mid];

        for(int i=0;i<mid;i++)
        {
            left[i]=arr[i];
        }
        for(int j=mid;j<length;j++)
        {
            right[j-mid]=arr[j];
        }
        mergeSort(left,mid);
        mergeSort(right,length-mid);

        merge(arr,left,right,mid,length-mid);

    }

    private static void merge(int[] arr, int[] left, int[] right, int start, int end) {

       int i=0,j=0,k=0;
       while(i<start && j<end)
       {
           if(left[i]<=right[j])//Change <== to >= to make decending order sort

               arr[k++]=left[i++];
           else
               arr[k++]=right[j++];
       }
      while(i<start)
      {
          arr[k++]=left[i++];
      }
        while(j<end)
        {
            arr[k++]=right[j++];
        }

    }

}
