package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class LIS { // https://www.acmicpc.net/problem/11053, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];
        int[] d = new int[N + 1];
        String[] read = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(read[i - 1]);
        }

        d[1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j >= 0; j--) {
                if (a[i] > a[i - j] && d[i] < d[i - j] + 1)
                    d[i] = d[i - j] + 1;
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (ans < d[i]) ans = d[i];
        }
        System.out.println(ans);
    }
}
