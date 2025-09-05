package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class LIS { // https://www.acmicpc.net/problem/11053, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] d = new int[N];

        for (int i = 0; i < N; i++) {
            d[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (a[i] > a[j] && d[i] < d[j] + 1)
                    d[i] = d[j] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (ans < d[i]) ans = d[i];
        }
        System.out.println(ans);
    }
}
