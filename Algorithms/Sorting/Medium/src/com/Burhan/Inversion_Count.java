package com.Burhan;

public class Inversion_Count {
    public static void main(String[] args) {
        // int[] arr = {1, 6, 2, 3};
        // int[] arr = {2, 4, 1, 3, 5};
        // int[] arr = {2, 3, 4, 5, 6};
        int[] arr = {1, 20, 6, 4, 5};
        int ans = inversionCount(arr);
        // int[] ans = mergeSort(arr);
        // System.out.println(Arrays.toString(ans));
        System.out.println(ans);
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    // Naive
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
}