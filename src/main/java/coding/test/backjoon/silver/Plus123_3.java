package coding.test.backjoon.silver;

import java.io.*;

public class Plus123_3 { // https://www.acmicpc.net/problem/15988, DP
    private static final long mod = 1_000_000_009L;
    private static final int maxN = 1_000_000;

    /**
     * {@code D[n] = D[n-1] + D[n-2] + D[n-3]}
     * <p>1 (1)
     * <p>1 + 1 / 2 (2)
     * <p>1 + 1 + 1 / 2 + 1 / 1 + 2 / 3 (4)
     * <p>1 + 1 + 1 + 1 / 2 + 1 + 1 / 3 + 1 / 1 + 1 + 2 / 2 + 2 / 1 + 2 + 1 / 1 + 3 (7)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] d = new long[maxN + 1];
        d[0] = d[1] = 1;
        d[2] = 2;
        for (int j = 3; j <= maxN; j++) {
            d[j] = (d[j - 1] + d[j - 2] + d[j - 3]) % mod;
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(d[n]).append("\n");
        }

        System.out.println(sb);
    }
}
