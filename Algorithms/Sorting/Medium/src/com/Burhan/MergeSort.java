package com.Burhan;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int half = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, half));
        int[] right = mergeSort(Arrays.copyOfRange(arr, half, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        
        int[] mix = new int[left.length + right.length];
        
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }
            else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            mix[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            mix[k] = right[j];
            j++;
            k++;
        }

        System.out.println();

        return mix;
    }
}
