package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM8 { // https://www.acmicpc.net/problem/15657, 브루트 포스 & 백트래킹
    private static int[] seq, sub;
    private static int cnt, len;
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        sub = new int[len];
        seq = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);

        go(0, 0);

        System.out.print(ans);
    }

    private static void go(int curLen, int s) {
        if (curLen == len) {
            for (int i : sub) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }

        for (int i = s; i < cnt; i++) {
            sub[curLen] = seq[i];
            go(curLen + 1, i);
        }
    }
}
