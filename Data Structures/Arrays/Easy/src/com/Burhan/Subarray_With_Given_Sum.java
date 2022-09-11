package com.Burhan;

public class Subarray_With_Given_Sum {
    public static void main(String[] args) {
        int n = 42;
        int s = 468;
        int[] arr = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
                154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
        // ArrayList<Integer> ans = subarraySum(arr, n, s);
        subArraySum(arr, n, s);
        // System.out.println(ans);
    }

    static void subArr(int[] arr, int n, int s) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int j = 0;
            for (j = i; j < n; j++) {
                sum += arr[j];
                if (sum == s) {
                    System.out.print((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }

    // static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
    // // Your code here
    // ArrayList<Integer> res = new ArrayList<>(2);

    // int sum = arr[0];
    // int subCount = 0;
    // for (int i = 1; i < n; i++) {
    // while (sum > s && subCount < i - 1) {
    // sum -= arr[subCount];
    // subCount++;
    // }
    // if (sum == s) {
    // res.add(subCount + 1);
    // res.add(i + 1);
    // return res;
    // }
    // if (i < n) {
    // sum += arr[i];
    // }
    // }
    // res.add(-1);
    // return res;
    // }

    static int subArraySum(int arr[], int n, int sum) {
        int currentSum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum,
            // then remove the starting elements
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == sum) {
                int p = i - 1;
                System.out.println(
                        "Sum found between indexes " + start
                                + " and " + p);
                return 1;
            }

            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }

        System.out.println("No subarray found");
        return 0;
    }
}
