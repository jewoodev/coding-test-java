package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence4 { // https://www.acmicpc.net/problem/14002, DP & 역추적
    private static int maxLen = 0; // LIS의 길이
    private static int maxIdx = 0; // LIS의 마지막 수가 위치한 인덱스
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int[] mem = new int[n]; // LIS를 만드는 수의 위치를 저장할 배열
        int[] seq = new int[n]; // 수열
        // DP 배열 : dp[i] = i번째 원소를 마지막으로 하는 LIS의 길이
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; // 최소 길이는 1 (자기 자신)
            mem[i] = -1; // 이전 인덱스 없음(-1)로 초기화
        }

        go(seq, mem, dp); // mem과 dp를 채우기 위한 연산 수행

        findMaxLenAndIdx(dp); // maxLen과 maxIdx를 찾기

        int[] lis = getLis(seq, mem); // LIS를 찾기

        ans.append(maxLen).append("\n");
        for (int i : lis) {
            ans.append(i).append(" ");
        }
        System.out.println(ans);
    }

    private static void go(int[] seq, int[] mem, int[] dp) {
        for (int i = 1; i < seq.length; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[j] + 1 > dp[i]) { // 새로운 LIS가 발견될 때마다
                    dp[i] = dp[j] + 1; // LIS 관련 레코드 갱신
                    mem[i] = j;
                }
            }
        }
    }

    private static void findMaxLenAndIdx(int[] dp) {
        for (int i = 0; i < n; i++) {
            if (maxLen < dp[i]) { // 새로운 LIS가 발견되었으면
                maxLen = dp[i]; // LIS 정보들을
                maxIdx = i; // 갱신
            }
        }
    }

    private static int[] getLis(int[] seq, int[] mem) {
        int[] lis = new int[maxLen];
        int idx = maxLen - 1;
        int current = maxIdx;
        while (current != -1) {
            lis[idx--] = seq[current];
            current = mem[current];
        }
        return lis;
    }
}
