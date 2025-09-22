package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM1 { // https://www.acmicpc.net/problem/15649, 브루트 포스
    private static StringBuilder ans = new StringBuilder();
    private static int[] seq;
    private static boolean[] selected;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[m];
        selected = new boolean[10];
        go(0);
        System.out.print(ans);
    }

    private static void go(int len) {
        if (len == m) {
            for (int i : seq) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            seq[len] = i;
            go(len + 1);
            selected[i] = false;
        }
    }
}
