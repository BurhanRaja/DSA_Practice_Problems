package com.Burhan;

public class Missing_in_subarray {
    public static void main(String[] args) {
        int n = 2;
        int[] arr = new int[n];
        arr[0] = 1;

        // System.out.println(Arrays.toString(arr));
        int ans = missingNum(arr, n);
        System.out.println(ans);
    }

    static int missingNum(int[] arr, int n) {
        int ans = (n*(n+1))/2;
        for (int i = 0; i < arr.length; i++) {
            ans -= arr[i];
        }
        if (ans != 0) {
            return ans;
        }
        else {
            return -1;
        }
    }
}
