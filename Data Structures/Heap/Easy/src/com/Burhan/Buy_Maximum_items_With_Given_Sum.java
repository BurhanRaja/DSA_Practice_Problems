package com.Burhan;

import java.util.PriorityQueue;

public class Buy_Maximum_items_With_Given_Sum {
    public static void main(String[] args) {
        // int[] costs = {1, 12, 5, 111, 200};
        int[] costs = {20, 10, 5, 30, 100};
        maxItems(costs, 35);
    }

    // Method 1 :- Sort the array and use it accordingly


    // Methos 2 :-
    static void maxItems(int[] arr, int sum) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pqMin.add(arr[i]);
        }

        int items = 0;

        for (int i = 0; i < arr.length; i++) {
            int cost = pqMin.poll();
            if (cost <= sum) {
                sum -= cost;
                items++;
            }
            else {
                break;
            }
        }

        System.out.println(items);
    }
}
