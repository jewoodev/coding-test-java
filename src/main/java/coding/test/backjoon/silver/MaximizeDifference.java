package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class MaximizeDifference { // https://www.acmicpc.net/problem/10819, 순열
    private static int n, ans = Integer.MIN_VALUE;
    private static boolean[] selected;
    private static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        selected = new boolean[n];
        tmp = new int[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        go(0);

        System.out.println(ans);
    }

    private static void go(int curLen) {
        if (curLen == n) {
            calculate();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            tmp[curLen] = arr[i];
            go(curLen + 1);
            selected[i] = false;
        }
    }

    private static void calculate() {
        int end = n - 2;
        int result = 0;
        for (int i = 0; i <= end; i++) {
            result += Math.abs(tmp[i] - tmp[i + 1]);
        }
        ans = Math.max(ans, result);
    }
}
