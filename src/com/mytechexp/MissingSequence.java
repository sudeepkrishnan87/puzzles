package com.mytechexp;

import java.util.Arrays;

public class MissingSequence {
    public static void main(String[] args) {

        int[] num = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        int largest = 10;
        int expectedTotal = (10 * (10 + 1)) / 2;
        int actualTotal = Arrays.stream(num).sum();
        System.out.println("Missing number is"+ (expectedTotal-actualTotal));
    }


}
