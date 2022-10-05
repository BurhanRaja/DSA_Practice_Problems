package com.Burhan;

public class Edit_Distaance_Problem {
    public static void main(String[] args) {
        String s1 = "SATURDAY";
        String s2 = "SUNDAY";
        int m = s1.length();
        int n = s2.length();

        // Naive
        // int ans = getDistance(s1, s2, m, n);
        // System.out.print(ans);

        // Memoization
        // memo = new int[m+1][n+1];
        // for (int i = 0; i <= m; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         memo[i][j] = -1;
        //     }
        // }
        // int ans = eD(s1, s2, m, n);
        // System.out.print(ans);

        // Tabulation
        int ans = eD2(s1, s2, m, n);
        System.out.print(ans);
    }

    static int getDistance(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return getDistance(s1, s2, m-1, n-1);
        }
        else {
            // Taking minimum of 1 + (insert, delete and replace) operations
            return 1 + Math.min(getDistance(s1, s2, m, n-1), Math.min(getDistance(s1, s2, m-1, n), getDistance(s1, s2, m-1, n-1)));
        }
    }

    // ? Memoization
    static int[][] memo;
    static int eD(String s1, String s2, int m, int n) {
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        if (s1.charAt(m-1) ==s2.charAt(n-1)) {
            memo[m][n] = eD(s1, s2, m-1, n-1);
        }
        else {
            memo[m][n] = 1 + Math.min(getDistance(s1, s2, m, n-1), Math.min(getDistance(s1, s2, m-1, n), getDistance(s1, s2, m-1, n-1)));
        }

        return memo[m][n];
    }

    // ? Tabulation
    static int eD2(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}
