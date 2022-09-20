package com.Burhan;

import java.util.HashSet;

public class Intersection_Two_Sorted_Array {
    public static void main(String[] args) {
        int[] l = {3, 5, 10, 10, 10, 15, 15, 20};
        int[] r = {5, 10, 10, 15, 30};
        intersection3(l, r);
    }

    static void intersection(int[] l, int[] r) {
        for (int i = 0; i < l.length; i++) {
            if (i>0 && l[i] == l[i-1]) {
                continue;
            }
            for (int j = 0; j < r.length; j++) {
                if (l[i] == r[j]) {
                    System.out.print(l[i] + " ");
                    break;
                }
            }
        }
    }

    // O(n+m) but auxilary space is hSet.size()
    static void intersection2(int[] l, int[] r) {
        HashSet<Integer> hSet = new HashSet<>();

        for (int i = 0; i < l.length; i++) {
            hSet.add(l[i]);
        }

        for (int i = 0; i < r.length; i++) {
            if (i>0 && r[i] == r[i-1]) {
                continue;
            }
            if (hSet.contains(r[i])) {
                System.out.print(r[i] + " ");
            }
        }
    }

    // O(n+m) with no auxilary space
    static void intersection3(int[] l, int[] r) {
        int i = 0;
        int j = 0;

        while (i < l.length && j < r.length) {
            if (i > 0 && l[i] == l[i-1]) {
                i++;
                continue;
            }
            if (l[i] < r[j]) {
                i++;
            }
            else if (l[i] > r[j]) {
                j++;
            }
            else {
                System.out.print(l[i] + " ");
                i++;
                j++;
            }
        }
    }
}
