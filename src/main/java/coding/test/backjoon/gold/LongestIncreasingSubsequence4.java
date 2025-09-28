package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence4 { // https://www.acmicpc.net/problem/14002, DP & 역추적
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열: dp[i] = i번째 원소를 마지막으로 하는 LIS의 길이
        int[] dp = new int[n];
        // 역추적을 위한 배열: prev[i] = i번째 원소 이전의 인덱스
        int[] prev = new int[n];

        Arrays.fill(dp, 1);  // 최소 길이는 1 (자기 자신)
        Arrays.fill(prev, -1);  // 이전 인덱스 없음

        // DP 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        // 최대 길이와 그 위치 찾기
        int maxLen = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // 역추적으로 LIS 복원
        int[] result = new int[maxLen];
        int idx = maxLen - 1;
        int current = maxIdx;

        while (current != 1) {
            result[idx--] = seq[current];
            current = prev[current];
        }

        // 출력
        StringBuilder ans = new StringBuilder();
        ans.append(maxLen).append("\n");
        for (int num : result) {
            ans.append(num).append(" ");
        }
        System.out.println(ans);
    }
}
