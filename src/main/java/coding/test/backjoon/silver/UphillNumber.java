package coding.test.backjoon.silver;

import java.util.*;

public class UphillNumber { // https://www.acmicpc.net/problem/11057, DP
    private static final int mod = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[n + 1][10];
        Arrays.fill(dp[1], 1); // 수는 0으로 시작할 수 있어 첫 째 자리에는 어떤 수도 올 수 있음

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        System.out.println(ans);
    }
}
