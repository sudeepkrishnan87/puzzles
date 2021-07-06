package com.mytechexp.sorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
/*
If i < j and A[i] > A[j] then the pair (i, j) is called an inversion of A

Can acheived using merge sort technique
* */
public class InversionCount {


    public static void main(String[] arg) {
        InversionCount inversion = new InversionCount();
        int arr[] = new int[]{ 4, 5, 1, 2, 7, 3 };
        System.out.println(inversion.mergeSort(arr, arr.length));

    }

    private int mergeSort(int[] arr, int length) {
        int count = 0;
        if (length < 2)
            return 0;
        int mid = length / 2;//3,1
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int j = mid; j < length; j++)
            right[j - mid] = arr[j];

        count += mergeSort(left, mid);
        count += mergeSort(right, length - mid);
        count += inversionCont(arr, left, right, mid, length - mid);

return count;
    }

    private int inversionCont(int[] arr, int[] left, int[] right, int start, int end) {

        int swap = 0, i = 0, j = 0, k = 0;
        while (i < start && j < end) {
            if (left[i] <= right[j]) {

                arr[k++] = left[i++];
            } else {

                swap+=start-i;
                arr[k++] = right[j++];
            }
        }
        while (i < start) {
            arr[k++] = left[i++];
        }
        while (j < end) {
            arr[k++] = right[j++];
        }
        return swap;
    }
}