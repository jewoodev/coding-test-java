package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class LongestIncresingSubsequence { // https://www.acmi가장 긴 증가하는 부분 수열cpc.net/problem/11053, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] subSeq = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            subSeq[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[n]; // i 위치까지의 LIS의 길이
        d[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if (subSeq[i] > subSeq[i - j]) {
                    d[i] = Math.max(d[i], d[i - j] + 1);
                }
            }
            if (d[i] == 0) d[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
    }
}
