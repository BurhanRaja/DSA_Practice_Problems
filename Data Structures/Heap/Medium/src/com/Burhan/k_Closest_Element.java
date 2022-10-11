package com.Burhan;

import java.util.Comparator;
import java.util.PriorityQueue;

public class k_Closest_Element {

    static class Pair {
        int diff;
        int index;

        Pair(int d, int i) {
            this.diff = d;
            this.index = i;
        }

        int getDiff() {
            return diff;
        }
        int getIndex() {
            return index;
        }
    }

    // Arrays.sort(arr, new Comparator<MyPriorityQueue>() {
    //     @Override
    //     public int compare(MyPriorityQueue p1, MyPriorityQueue p2) {
    //         return p1.diff - p2.diff;
    //     }
    // });

    public static void main(String[] args) {
        int[] arr = {10, 15, 7, 3, 4};
        int k = 2;
        int x = 8;
        kClosest2(arr, k, x);
    }

    // O(nk) :- Naive
    static void kClosest(int[] arr, int k, int x) {    
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < k; i++) {
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                if (visited[j] == false && Math.abs(arr[j] - x) <= minDiff) {
                    minDiff = Math.abs(arr[j] - x);
                    minDiffIndex = j;
                }
            }
            System.out.print(arr[minDiffIndex]+" ");
            visited[minDiffIndex] = true;
        }
    }

    // O(nlogk)
    static void kClosest2(int[] arr, int k, int x) {
        PriorityQueue<Pair> pMax = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.getDiff() - p1.getDiff();
            }
        });

        for (int i = 0; i < k; i++) {
            pMax.add(new Pair(Math.abs(arr[i]-x), i));
        }

        for (int i = k; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);
            if (pMax.peek().getDiff() > diff) {
                pMax.poll();
                pMax.add(new Pair(diff, i));
            }
        }

        while (!pMax.isEmpty()) {
            System.out.print(arr[pMax.poll().getIndex()] + " ");
        }
    }
}