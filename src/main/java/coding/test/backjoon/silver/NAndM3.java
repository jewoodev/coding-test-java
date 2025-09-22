package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM3 { // https://www.acmicpc.net/problem/15651, 브루트 포스 & 백트래킹
    private static StringBuilder ans = new StringBuilder();
    private static int max, len;
    private static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        max = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        seq = new int[len];

        go(0);

        System.out.print(ans);
    }

    private static void go(int curLen) {
        if (curLen == len) {
            for (int i : seq) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }

        for (int i = 1; i <= max; i++) {
            seq[curLen] = i;
            go(curLen + 1);
        }
    }
}
