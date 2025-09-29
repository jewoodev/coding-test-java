package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class ConsecutiveSum { // https://www.acmicpc.net/problem/1912, DP & LIS
    private static int n, maxSum = -1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] seq = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        go(seq, dp);
        System.out.println(maxSum);
    }

    private static void go(int[] seq, int[] dp) {
        dp[0] = seq[0];
        maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(seq[i], dp[i - 1] + seq[i]);
            if (dp[i] > maxSum) maxSum = dp[i];
        }
    }
}
