package com.Burhan;

public class Coin_Change_Count_Combination {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6};
        int ans = getCount(arr, arr.length, 10);
        System.out.println(ans);
    }

    static int coinChange(int[] arr, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }

        int res = coinChange(arr, n-1, sum);
        if (arr[n-1] <= sum) {
            res += coinChange(arr, n, sum-arr[n-1]);
        }
        return res;
    }

    // Efficient
    static int getCount(int[] coins, int n, int sum) {
        int[][] dp = new int[sum+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int j = 1; j <= sum; j++) {
            dp[j][0] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1];
                if (coins[j-1] <= i) {
                    dp[i][j] += dp[i-coins[j-1]][j];
                }
            }
        }

        return dp[sum][n];

    }
}
