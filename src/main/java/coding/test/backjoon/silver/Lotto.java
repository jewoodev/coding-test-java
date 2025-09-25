package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class Lotto { // https://www.acmicpc.net/problem/6603, 브루트포스 & 백트래킹
    private static StringBuilder ans = new StringBuilder();
    private static int n, cutLine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            cutLine = n - 6;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] lotto = new int[6];

            go(arr, 0, 0, lotto);
            ans.append("\n");
        }
        System.out.print(ans);
    }

    private static void go(int[] arr, int curLen, int s, int[] lotto) {
        // 사전 종료 조건
        if (curLen == 0 && s > cutLine) return;
        // 수열의 첫 수가 cutLine을 넘어가는 순번의 수이면 수열의 길이가 6이 될 수 없음

        if (curLen == 6) {
            for (int i : lotto) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }

        for (int i = s; i < n; i++) {
            lotto[curLen] =  arr[i];
            go(arr, curLen + 1, i + 1, lotto);
        }
    }
}
