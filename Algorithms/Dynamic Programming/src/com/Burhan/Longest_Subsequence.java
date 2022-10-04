package com.Burhan;

public class Longest_Subsequence {
    public static void main(String[] args) {
        // String s1 = "ABCDGH";
        // String s2 = "AEDFHR";
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        // int m = s1.length(); // 6
        // int n = s2.length(); // 7

        // Simple recursion
        // int ans = lcs(s1, s2, m, n);
        // System.out.print(ans);

        // Memoization
        // memo = new int[m+1][n+1];
        // for (int i = 0; i < memo.length; i++) {
        //     for (int j = 0; j < memo[0].length; j++) {
        //         memo[i][j] = -1;
        //     }
        // }
        // int ans = lcs2(s1, s2, m, n);
        // System.out.print(ans);


        // Tabulation
        int ans = lcs3(s1, s2);
        System.out.print(ans);

    }

    // Naive
    static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return 1 + lcs(s1, s2, m-1, n-1);
        }
        else {
            return Math.max(lcs(s1, s2, m-1, n), lcs(s1, s2, m, n-1));
        }
    }

    // Memoization Solution
    static int[][] memo;
    static int lcs2(String s1, String s2, int m, int n) {
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (m == 0 || n == 0) {
            memo[m][n] = 0;
        }
        else {
            if (s1.charAt(m-1) == s2.charAt(n-1)) {
                memo[m][n] = 1 + lcs2(s1, s2, m-1, n-1);
            }
            else {
                memo[m][n] = Math.max(lcs2(s1, s2, m-1, n), lcs2(s1, s2, m, n-1));
            }
        }

        return memo[m][n];
    }

    // Tabulation Solution
    static int lcs3(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}