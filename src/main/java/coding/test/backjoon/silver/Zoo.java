package coding.test.backjoon.silver;

import java.util.*;

public class Zoo { // https://www.acmicpc.net/problem/1309, DP
    private static int mod = 9901;
    /**
     * {@code D[n][0] = D[n-1][0] + D[n-1][1] + D[n][2]}
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[][] d = new int[N][3];
        for (int i = 0; i < 3; i++) {
            d[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            d[i][0] = (d[i-1][1] + d[i-1][2] + d[i-1][0]) % mod;
            d[i][1] = (d[i-1][0] + d[i-1][2]) % mod;
            d[i][2] = (d[i-1][0] + d[i-1][1]) % mod;
        }

        int ans = (d[N-1][0] + d[N-1][1] + d[N-1][2]) % mod;
        System.out.println(ans);
    }
}
