package com.Burhan;

import java.util.Stack;

public class Previous_Greater_Element {
    public static void main(String[] args) {
        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        prevElement(arr);
    }

    static void prevElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        s.add(0);
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                System.out.print(-1 + " ");
            }
            else {
                System.out.print(arr[s.peek()] + " ");
            }
            s.add(i);
        }
    }
}
