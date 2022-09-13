package com.Burhan;

public class peak_Element {
    public static void main(String[] args) {
        // int[] arr = {10, 20, 15, 2, 23, 90, 67};
        // int[] arr = {5, 10, 20, 15};
        int[] arr = {1, 13};
        int ans = peakElement(arr, 0, arr.length-1);
        System.out.println(ans);
    }

    // Naive
    static int peakEl(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i-1] < arr[i] && arr[i+1] < arr[i]) {
                return i;
            }
        }
        return -1;
    }

    // Efficient
    static int peakElement(int[] arr, int left, int right) {
        int mid = left + (right-left)/2;

        if (left > right) {
            return -1;
        }

        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid==arr.length-1 || arr[mid+1] <= arr[mid])) {
            return mid;
        }
        else if (mid > 0 && arr[mid-1] > arr[mid]) {
            return peakElement(arr, left, mid-1);
        }
        else {
            return peakElement(arr, mid+1, right);
        }
    }
}
