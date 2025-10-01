package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class IntegerTriangle { // https://www.acmicpc.net/problem/1932, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) a[i][j] += a[i - 1][j];
                else if (j == i) a[i][j] += a[i - 1][j - 1];
                else a[i][j] += Math.max(a[i - 1][j - 1], a[i - 1][j]);
            }
        }

        int ans  = a[n - 1][0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, a[n - 1][i]);
        }
        System.out.println(ans);
    }
}
