package com.Burhan;

import java.util.Arrays;
import java.util.Stack;

public class Stock_Span_Problem {
    public static void main(String[] args) {
        int[] arr = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        int[] ans = stockSpan(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] stockSpan(int[] arr) {
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    count++;
                }
                else {
                    break;
                }
            }
            ans[i] = count;
        }

        return ans;
    }

    static void stockSpan2(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int span = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                span = i+1;
            }
            else {
                span = i-s.peek();
            }

            System.out.print(span + " ");
            s.push(i);
        }
    }
}
