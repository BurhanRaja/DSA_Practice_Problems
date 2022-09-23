package com.Burhan;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 1, 5, 6};
        int ans = largestRect(arr);
        System.out.println(ans);

        // int[] prevAns = nextSmall(arr);
        // System.out.println(Arrays.toString(prevAns));
    }

    static int largestArea(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                }
                else {
                    break;
                }
            }
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                }
                else {
                    break;
                }
            }
            res = Math.max(res, curr);
        }

        return res;
    }


    // Prev Small Element
    static int[] prevSmall(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = s.peek();
            }

            s.add(i);
        }

        return ans;
    }

    // Next Small Element
    static int[] nextSmall(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = arr.length;
            }
            else {
                ans[i] = s.peek();
            }

            s.add(i);
        }

        return ans;
    }

    // Efficient Solution
    static int largestRect(int[] arr) {
        int res = 0;
        int[] prev = prevSmall(arr);
        int[] next = nextSmall(arr);
        
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            curr += (i-prev[i]-1)*arr[i];
            curr += (next[i]-i-1)*arr[i];

            res = Math.max(res, curr);
        }

        return res;
    }

}