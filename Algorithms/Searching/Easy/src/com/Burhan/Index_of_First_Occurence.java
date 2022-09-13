package com.Burhan;

public class Index_of_First_Occurence {
    public static void main(String[] args) {
        int[] arr = {4, 9, 10, 20, 28, 36, 38, 38, 38, 43, 59, 62, 72};
        int ans = bs(arr, 38, 0, arr.length-1);
        System.out.println(ans);
    }


    static int bs(int[] arr, int x, int start, int end) {
        int mid = start + (end-start)/2;

        if (start > end) {
            return -1;
        }


        if (arr[mid] < x) {
            return bs(arr, x, mid+1, end);
        }
        else if (arr[mid] > x) {
            return bs(arr, x, start, mid-1);
        }
        else {
            if (mid == 0 || arr[mid-1] == arr[mid]) {
                return bs(arr, x, start, mid-1);
            }
            else {
                return mid;
            }
        }
    }
}