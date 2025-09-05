package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class RGBStreet { // https://www.acmicpc.net/problem/1149, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N + 1][3];
        int[][] d = new int[N + 1][3];
        for (int i = 1; i <= N; i++)
            a[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();


        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    d[i][j] = Math.min(d[i-1][1], d[i-1][2]) + a[i][j];
                } else if (j == 1) {
                    d[i][j] = Math.min(d[i-1][0], d[i-1][2]) + a[i][j];
                } else {
                    d[i][j] = Math.min(d[i-1][0], d[i-1][1]) + a[i][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, d[N][i]);
        }
        System.out.println(ans);
    }
}
