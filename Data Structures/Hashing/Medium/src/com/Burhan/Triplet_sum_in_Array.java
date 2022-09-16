package com.Burhan;

import java.util.HashSet;

public class Triplet_sum_in_Array {
    public static void main(String[] args) {
        // int[] arr = {1, 4, 45, 6, 10, 8};
        int[] arr = {1, 2, 4, 3, 6};
        boolean ans = hashMethod(arr, 13);
        System.out.println(ans);
    }

    // One Approach

    // static int twoPointer(int[] arr, int k) {
    //     Arrays.sort(arr);
    //     for (int i = 0; i < arr.length; i++) {
    //         int start = i+1;
    //         int end = arr.length-1;
    //         while (start < end) {
    //             if (arr[i] + arr[start] + arr[end] == k) {
    //                 return 1;
    //             }
    //             else if (arr[i] + arr[start] + arr[end] < k) {
    //                 start++;
    //             }
    //             else {
    //                 end--;
    //             }
    //         }
    //     }
    //     return -1;
    // }

    // Second Approach
    static boolean hashMethod(int[] arr, int k) {
        int sum = k;
        for (int i = 0; i < arr.length-2; i++) {
            HashSet<Integer> hset = new HashSet<>();
            int curr_sum = sum - arr[i];

            for (int j = i+1; j < arr.length; j++) {
                if (hset.contains(curr_sum - arr[j])) {
                    return true;
                }
                else {
                    hset.add(arr[j]);
                }
            }
        }

        return false;
    }
}
