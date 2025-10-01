package coding.test.backjoon.silver;

import java.io.*;

public class WineTasting { // https://www.acmicpc.net/problem/2156, DP
    /**
     * <p>D[i][j] = j번 연속해서 i번째 와인까지 마시는 경우들 중에 최대한 와인을 많이 마시는 경우의 '마신 양'
     * <p>{@code D[i][0] = max(D[i-1][0], D[i-1][1], D[i-1][2] }
     * <p>{@code D[i][1] = D[i-1][0] + A[i] }
     * <p>{@code D[i][2] = D[i-1][1] + A[i] }
     * <hr>
     * <h6>1차원으로도 풀이할 수 있다.
     * <p>{@code D[i] = max(D[i-1], D[i-2] + A[i], D[i-3] + A[i-1] + A[i]) }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(br.readLine());
        int[] d = new int[n+1];
        d[1] = a[1];
        if (n >= 2) d[2] = a[1] + a[2];

         for (int i = 3; i <= n; i++) {
            d[i] = d[i-1]; // i번째 와인을 마시지 않았을 때의 D[n] => d[i-1]
            d[i] = Math.max(d[i], d[i-2] + a[i]); // i번째 와인을 마셨을 때의 D[n] => d[i-2] + a[i]
            d[i] = Math.max(d[i], d[i-3] + a[i-1] + a[i]); // 2번 연속하여 i번째 와인을 마셨을 때의 D[n] => d[i-3] + a[i-1] + a[i]
        }

        int ans = d[1];
        for (int i = 2; i <= n; i++) {
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
    }
}
