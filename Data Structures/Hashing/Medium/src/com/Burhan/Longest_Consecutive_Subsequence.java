package com.Burhan;

import java.util.HashSet;

public class Longest_Consecutive_Subsequence {
    public static void main(String[] args) {
        int[] arr = {2,6,1,9,4,5,3};

        int ans = longSubsequence(arr);
        System.out.println(ans);
    }

    static int longSubsequence(int[] arr) {
        HashSet<Integer> hset = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            hset.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!hset.contains(arr[i]-1)) {
                int j = arr[i];
                while (hset.contains(j)){
                    j++;
                }

                ans = Math.max(ans, j-arr[i]);
            }
        }

        return ans;

    }
}