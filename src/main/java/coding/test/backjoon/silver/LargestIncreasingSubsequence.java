package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class LargestIncreasingSubsequence { // https://www.acmicpc.net/problem/11055, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] d = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + a[i]) {
                    d[i] = d[j] + a[i];
                }
            }
        }

        int ans = d[0];
        for (int i = 0; i < n; i++) {
            if (ans < d[i]) ans = d[i];
        }
        System.out.println(ans);
    }
}
