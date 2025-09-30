package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class Resignation { // https://www.acmicpc.net/problem/14501, 브루트포스 | DP
    private static int[] time;
    private static int[] money;
    private static int[] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 1-indexed로 사용 (1일 ~ n일)
        time = new int[n + 1]; // 그 날에 시작할 수 있는 상담의 소요일
        money = new int[n + 1]; // 그 날에 시작할 수 있는 상담의 수여액
        dp = new int[n + 2]; // dp[i] = i일부터 퇴사일까지 벌 수 있는 최대 금액

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }

        System.out.println(go(1));
    }

    // day일부터 시작해서 벌 수 있는 최대 금액
    private static int go(int day) {
        // 퇴사일이 되면 더 이상 상담할 수 없음
        if (day == n + 1) return 0;

        // 퇴사일을 넘어가면 불가능한 경우
        if (day > n + 1) return Integer.MIN_VALUE;

        // 이미 계산된 경우
        if (dp[day] != -1) return dp[day];

        // 1. day일의 상담을 하지 않는 경우: 다음 날로 이동
        int skip = go(day + 1);

        // 2. day일의 상담을 하는 경우: day + time[day]일로 이동
        int take = go(day + time[day]) + money[day];

        // 두 경우 중 최댓값 선택
        dp[day] = Math.max(skip, take);
        return dp[day];
    }
}

/*
 * DP 정의: dp[i] = i일부터 n+1일(퇴사일)까지 벌 수 있는 최대 상담 금액
 *
 * 점화식:
 * - i일의 상담을 하지 않는 경우: dp[i] = dp[i+1]
 * - i일의 상담을 하는 경우: dp[i] = money[i] + dp[i+time[i]]
 *   (단, i+time[i] <= n+1 인 경우에만 가능)
 * - dp[i] = max(dp[i+1], money[i] + dp[i+time[i]])
 *
 * Base case: dp[n+1] = 0 (퇴사일에는 상담 불가)
 *
 * 예시 (N=7):
 * day:  1   2   3   4   5   6   7   8
 * T:    3   5   1   1   2   4   2   -
 * P:    10  20  10  20  15  40  200 -
 *
 * 거꾸로 계산:
 * dp[8] = 0 (퇴사일)
 * dp[7] = max(dp[8], 200+dp[9]) = max(0, MIN) = 0 (7일 상담은 9일에 끝나므로 불가)
 * dp[6] = max(dp[7], 40+dp[10]) = max(0, MIN) = 0 (6일 상담도 불가)
 * dp[5] = max(dp[6], 15+dp[7]) = max(0, 15+0) = 15
 * dp[4] = max(dp[5], 20+dp[5]) = max(15, 20+15) = 35
 * dp[3] = max(dp[4], 10+dp[4]) = max(35, 10+35) = 45
 * dp[2] = max(dp[3], 20+dp[7]) = max(45, 20+0) = 45
 * dp[1] = max(dp[2], 10+dp[4]) = max(45, 10+35) = 45
 */