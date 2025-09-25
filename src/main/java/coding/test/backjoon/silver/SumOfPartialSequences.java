package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class SumOfPartialSequences { // https://www.acmicpc.net/problem/1182, 브루트포스
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

        go(0, 0, 0, arr);

        System.out.println(ans);
    }

    private static void go(int idx, int curSum, int cnt, int[] arr) {
        if (idx == arr.length) {
            // 크기가 양수인 부분수열만 고려 (cnt > 0)
            if (curSum == s && cnt > 0) ans++;
            return;
        }

        // 현재 원소를 선택하는 경우
        go(idx + 1, curSum + arr[idx], cnt + 1, arr);
        // 현재 원소를 선택하지 않는 경우
        go(idx + 1, curSum, cnt, arr);
    }
}
