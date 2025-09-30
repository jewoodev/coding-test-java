package coding.test.backjoon.gold;

import java.util.*;

public class SumDecomposition { // https://www.acmicpc.net/problem/2225, DP
    private static final int mod = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // dp[k][n] : k개의 정수를 더 해 n이 되는 경우의 수
        int[][] dp = new int[k + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] += dp[i - 1][j - l];
                    dp[i][j] %= mod;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
