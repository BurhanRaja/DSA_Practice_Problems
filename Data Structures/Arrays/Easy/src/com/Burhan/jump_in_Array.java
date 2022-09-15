package com.Burhan;

public class jump_in_Array {
    public static void main(String[] args) {
        // int[] arr = {1, 4, 3, 2, 6, 7};
        int[] arr = {2, 3, 1, 1, 4};
        // int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9, 3, 2, 7, 5, 1, 3, 5, 4, 6, 7, 10};
        int ans = minJump(arr);
        System.out.println(ans);
    }

    static int jumps(int[] arr) {
        int jump = 0;
        int noOfJump = 0;
        while (jump < arr.length-1) {
            jump += arr[jump];
            noOfJump++;
        }

        if (noOfJump == 0) {
            return -1;
        }

        return noOfJump;
    }

    // static int minJump(int[] arr) {

    // }
}
