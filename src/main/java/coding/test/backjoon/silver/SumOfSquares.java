package coding.test.backjoon.silver;

import java.util.*;

public class SumOfSquares { // https://www.acmicpc.net/problem/1699, DP
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // dp[i] = i를 제곱수의 합으로 나타낼 때 최소 개수
        int[] dp = new int[n + 1];

        // 초기화: 최악의 경우 1^2을 i개 사용
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        // DP 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // i를 만들 때, j^2를 사용하는 경우
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
