package com.Burhan;

import java.util.ArrayList;

public class Missing_Element {
    public static void main(String[] args) {
        // int[] arr = {0, -10, 1, 3, -20};
        // int[] arr = {1,2,3,4,5};
        // int[] arr = {4, 0, 1, 8, 2, 10, 3, 7, 5, 6};
        // int[] arr = { 0, 1 };
        int[] arr = {0};
        int ans = misEl(arr);
        System.out.println(ans);
    }

    static int missEl(int[] arr) {
        ArrayList<Integer> lst = new ArrayList<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            lst.add(arr[i]);
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < arr.length; i++) {
            left = arr[i] - 1;
            right = arr[i] + 1;

            if (left < 0) {
                continue;
            }

            if (!lst.contains(left)) {
                return left;
            } else if (!lst.contains(right)) {
                return right;
            }
        }

        return -13913913;
    }

    static int missingEl(int[] arr) {
        ArrayList<Integer> lst = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                lst.add(arr[i]);
            }
        }

        for (int i = 1; i <= arr.length+1; i++) {
            if (!lst.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    static int misEl(int[] arr) {

        boolean[] check = new boolean[arr.length+1];
        check[0] = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                check[arr[i]] = true;
            }
        }
        
        for (int i = 0; i < check.length; i++) {
            if (check[i] == false) {
                return i;
            }
        }

        return check.length;
    }
}