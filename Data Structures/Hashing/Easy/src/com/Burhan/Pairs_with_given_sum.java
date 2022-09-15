package com.Burhan;

import java.util.HashMap;

public class Pairs_with_given_sum {
    public static void main(String[] args) {
        // int[] arr = {1, 5, 7, 1};
        int[] arr = {1, 1, 1, 1};
        int k = 2;
        int ans = pairSum(arr, arr.length, k);
        System.out.println(ans);
    }

    static int pairsSum(int[] arr, int n, int k) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) {
                continue;
            }
            for (int j = i+1; j < n; j++) {
                if (arr[i] + arr[j] == k) {
                    res++;
                }
            }
        }

        return res;
    }

    static int pairSum(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!hMap.containsKey(arr[i])) {
                hMap.put(arr[i], 1);
            }
            else {
                hMap.put(arr[i], hMap.get(arr[i]) + 1);
            }
        }

        int tCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (hMap.get(k - arr[i]) != null) {
                tCount += hMap.get(k - arr[i]);
            }    

            if (k - arr[i] == arr[i]) {
                tCount--;
            }
        }

        return tCount/2;
    }
}