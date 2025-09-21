package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class LIS4 { // https://www.acmicpc.net/problem/14002, DP & 역추적
    private static StringBuilder sb = new StringBuilder();
    private static int[] v;
    private static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        a = new int[N];
        v = new int[N];
        String[] read = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(read[i]);
            v[i] = -1;
        }

        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            d[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (a[i] > a[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    v[i] = j;
                }
            }
        }

        int ans = 0;
        int p = 0;
        for (int i = 0; i < N; i++) {
            if (d[i] > ans) {
                ans = d[i];
                p = i;
            }
        }

        sb.append(ans).append("\n");
        go(p);
        System.out.print(sb);
    }

    private static void go(int p) throws IOException {
        if (p == -1) return;
        go(v[p]);
        sb.append(a[p]).append(" ");
    }
}
