package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class SumOfPartialSequences { // https://www.acmicpc.net/problem/1182, 브루트포스 | 비트마스크
    private static int ans, s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        go(arr);

        System.out.println(ans);
    }

    private static void go(int[] arr) {
        int sum = 0;
        for (int i = 1; i < (1 << arr.length); i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
            }
            if (sum == s) ans++;
            sum = 0;
        }
    }
}
