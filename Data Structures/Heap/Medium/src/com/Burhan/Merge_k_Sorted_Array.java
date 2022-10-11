package com.Burhan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Array {
    public static void main(String[] args) {
        int[][] arr = {
            {10, 20, 30},
            {5, 15},
            {1, 9, 11, 18}
        };

        mergeKArray3(arr);
    }

    // O(nk lognk)
    static void mergeKArray(int[][] arr) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                array.add(arr[row][col]);
            }
        }

        Collections.sort(array);

        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    // O(nk^2)
    static void mergeKArray2(int[][] arr) {
        int[] res = new int[arr[0].length];

        for (int i = 0; i < arr[0].length; i++) {
            res[i] = arr[0][i];
        }

        for (int i = 1; i < arr.length; i++) {
            res = merge(res, arr[i]);
        }

        System.out.println(Arrays.toString(res));
    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            }
            else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }


    static void mergeKArray3(int[][] arr) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                pqMin.add(arr[row][col]);
            }
        }

        ArrayList<Integer> array = new ArrayList<>();
        while (!pqMin.isEmpty()) {
            array.add(pqMin.poll());
        }

        System.out.print(array);
    }
}
