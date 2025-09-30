package coding.test.backjoon.silver;

import java.io.*;

public class Plus123_5 { // https://www.acmicpc.net/problem/15990, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mod = 1_000_000_009;
        int t = Integer.parseInt(br.readLine());
        // sumCase[i][j] : 마지막 수 j 일 때 1 ~ 3 을 더해서 n 이 나오는 가짓수
        long[][] sumCase = new long[100_000 + 1][4];

        // 초기값 설정
        sumCase[1][1] = 1; // 1을 만드는 방법: 1
        sumCase[2][2] = 1; // 2를 만드는 방법: 2
        sumCase[3][1] = 1; // 3을 만드는 방법: 2+1
        sumCase[3][2] = 1; // 3을 만드는 방법: 1+2
        sumCase[3][3] = 1; // 3을 만드는 방법: 3

        for (int i = 4; i <= 100_000; i++) {
            // 마지막에 1을 더하는 경우: i-1에서 2 또는 3으로 끝나는 경우들
            sumCase[i][1] = (sumCase[i - 1][2] + sumCase[i - 1][3]) % mod;

            // 마지막에 2를 더하는 경우: i-2에서 1 또는 3으로 끝나는 경우들
            sumCase[i][2] = (sumCase[i - 2][1] + sumCase[i - 2][3]) % mod;

            // 마지막에 3을 더하는 경우: i-3에서 1 또는 2로 끝나는 경우들
            sumCase[i][3] = (sumCase[i - 3][1] + sumCase[i - 3][2]) % mod;
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long sum = (sumCase[n][1] + sumCase[n][2] + sumCase[n][3]) % mod;
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
