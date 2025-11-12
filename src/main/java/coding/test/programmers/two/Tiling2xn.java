package coding.test.programmers.two;

public class Tiling2xn { // https://school.programmers.co.kr/learn/courses/30/lessons/12900?language=java
    private static int cutter = 1_000_000_007;

    public int solution (int n) {
        int[][] dp = new int[60_001][2];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % cutter;
            dp[i][1] = (dp[i - 2][0] + dp[i - 2][1]) % cutter;
        }

        return (dp[n][0] + dp[n][1]) % cutter;
    }

//    public int solution (int n) {
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 1;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2]) % cutter;
//        }
//
//        return dp[n] % cutter;
//    }
}
