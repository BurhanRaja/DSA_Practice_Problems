package com.Burhan;

import java.util.Arrays;

public class Inversion_Count {
    public static void main(String[] args) {
        // int[] arr = {1, 6, 2, 3};
        // int[] arr = {2, 4, 1, 3, 5};
        // int[] arr = {2, 3, 4, 5, 6};
        int[] arr = {1, 20, 6, 4, 5};
        // int ans = inversionCount(arr);
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    static int inversionCount(int[] arr) {
        if (isSorted(arr)) {
            return 0;
        }
        else {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                boolean flag = false;
                for (int j = 1; j < arr.length; j++) {
                    if (arr[j-1] > arr[j]) {
                        swap(arr, j-1, j);
                        flag = true;
                        count++;
                    }
                }
                if (!flag){
                    break;
                }
            }
            return count;
        }

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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

        return mix;
    }


}