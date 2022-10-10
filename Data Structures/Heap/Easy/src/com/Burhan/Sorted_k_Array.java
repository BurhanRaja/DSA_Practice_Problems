package com.Burhan;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorted_k_Array {
    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 18, 19, 17};
        int[] ans = sortK(arr, 2);
        System.out.println(Arrays.toString(ans));
    }

    // Elements can be between i-k to i+k
    static int[] sortK(int[] arr, int k) {
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        
        // adding the first three elements of index 0, 1, 2
        for (int i = 0; i <= k; i++) {
            pqMin.add(arr[i]);
        }

        // Traversing to the remaining elements and adding root elements of pqMin to the arr from 0 to n
        int index = 0;
        for (int i = k+1; i < arr.length; i++) {
            arr[index++] = pqMin.poll();
            pqMin.add(arr[i]);
        }

        // Removing and adding the remaining elements in pqMin
        while (!pqMin.isEmpty()) {
            arr[index++] = pqMin.poll();
        }

        return arr;
    }
}