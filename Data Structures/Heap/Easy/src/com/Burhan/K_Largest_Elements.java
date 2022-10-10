package com.Burhan;

import java.util.Collections;
import java.util.PriorityQueue;

public class K_Largest_Elements {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 8};
        int k = 2;
        kLargest2(arr, k);
    }

    // O(n+klogk)
    static void kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            pqMax.add(arr[i]);
        }

        // O(klogk)
        for (int i = 0; i < k; i++) {
            System.out.print(pqMax.poll() + " ");
        }
    }

    // O(k+(n-k)logk) Better Solution
    static void kLargest2(int[] arr, int k) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        // O(k)
        for (int i = 0; i <= k; i++) {
            pqMin.add(arr[i]);
        }

        // O((n-k)logk)
        for (int i = k+1; i < arr.length; i++) {
            if (arr[i] < pqMin.peek()) {
                continue;
            }
            else {
                pqMin.poll();
                pqMin.add(arr[i]);
            }
        }

        // O(k)
        for (int i = 0; i < pqMin.size(); i++) {
            System.out.print(pqMin.poll() + " ");
        }
    }
}
