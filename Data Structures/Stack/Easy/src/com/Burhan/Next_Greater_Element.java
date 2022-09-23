package com.Burhan;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greater_Element {
    public static void main(String[] args) {
        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        nextElement(arr);
    }

    static void nextElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = arr[s.peek()];
            }
            s.add(i);
        }

        System.out.println(Arrays.toString(ans));
    }
}
