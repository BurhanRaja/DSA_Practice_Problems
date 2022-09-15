package com.Burhan;

import java.util.HashMap;

public class Largest_Subarray_sum_Zero {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int ans = lSubarray(arr);
        System.out.println(ans);
    }

    static int lSubarray(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 && maxLen == 0) {
                maxLen++;
            }
            if (sum == 0) {
                maxLen = i+1;
            }

            Integer prev_i = hm.get(sum);

            if (prev_i != null) {
                maxLen = Math.max(maxLen, i-prev_i);
            }
            else {
                hm.put(sum, i);
            }
        }

        return maxLen;
    }
}
