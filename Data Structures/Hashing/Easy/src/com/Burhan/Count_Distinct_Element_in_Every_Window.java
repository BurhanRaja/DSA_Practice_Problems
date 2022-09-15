package com.Burhan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Count_Distinct_Element_in_Every_Window {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4,2,3};
        // int[] arr = {4,1,1};
        int n = arr.length;
        int k = 4;

        ArrayList<Integer> ans = distEl(arr, n, k);

        System.out.println(ans);

    }

    static ArrayList<Integer> distEl(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        ArrayList<Integer> arrLst = new ArrayList<>();

        for (int j = 0; j < k; j++) {
            hMap.put(arr[j], hMap.getOrDefault(arr[j], 0) + 1);
        }
        arrLst.add(hMap.size());

        for (int i = k; i < n; i++) {
            if (hMap.get(arr[i-k])  == 1) {
                hMap.remove(arr[i-k]);
            }
            else {
                hMap.put(arr[i-k], hMap.get(arr[i-k])-1);
            }

            hMap.put(arr[i], hMap.getOrDefault(arr[i], 0)+1);

            arrLst.add(hMap.size());
        }

        return arrLst;
    }

    static ArrayList<Integer> distEl2(int[] arr, int n, int k) {
        int start = 0;
        int end = k-1;
        HashSet<Integer> hSet = new HashSet<>();
        ArrayList<Integer> arrLst = new ArrayList<>();
        
        while (end < n) {
            for (int j = start; j <= end; j++) {
                hSet.add(arr[j]);
            }
            arrLst.add(hSet.size());
            hSet.clear();
            start++;
            end++;
        }

        return arrLst;
    }
}
