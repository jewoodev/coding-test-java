package coding.test.backjoon.silver;

import java.io.*;

public class Plus123 { // https://www.acmicpc.net/problem/9095, 브루트 포스 || DP
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            ans = 0;
            go(0, n, 0);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static void go(int cur, int n, int len) {
        if (len > 10) return;
        if (cur == n) {
            ans++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            go(cur + i, n, len + 1);
        }
    }
}

