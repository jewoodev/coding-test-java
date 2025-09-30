package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class RGBStreet { // https://www.acmicpc.net/problem/1149, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n + 1][3]; // i번째 집에 j번째 색을 칠할 때의 비용
        int[][] dp = new int[n + 1][3]; // dp[i][j] : i번째 집에 j번째 색을 칠할 때의 최소 비용
        for (int i = 1; i <= n; i++) { // 주어지는 색칠 비용 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) { // 첫 번째 부터 차례차례 dp 배열 값을 연산
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}
