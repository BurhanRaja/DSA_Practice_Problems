package com.Burhan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Duplicate_in_Array {
    public static void main(String[] args) {
        int[] arr = { 2, 0, 3, 1, 2, 3, 19, 21, 1, 21, 20, 19, 20 };
        ArrayList<Integer> ans = duplicateEl(arr);
        System.out.println(ans);
    }

    static ArrayList<Integer> dupArray(int[] arr) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    if (a.contains(arr[i])) {
                        continue;
                    }
                    a.add(arr[i]);
                }
            }
        }
        if (a.isEmpty()) {
            a.add(-1);
            return a;
        } else {
            Collections.sort(a);
            return a;
        }
    }

    // Efficient - O(n)
    static ArrayList<Integer> duplicateEl(int[] arr) {
        ArrayList<Integer> a = new ArrayList<>();
        HashSet<Integer> h = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (h.contains(arr[i]) && a.contains(arr[i]) == false) {
                a.add(arr[i]);
            }
            h.add(arr[i]);
        }
        if(a.isEmpty()){
            a.add(-1);
            return a;
        }
        else {
            Collections.sort(a);
            return a;
        }
    }
}
