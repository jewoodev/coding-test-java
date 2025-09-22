package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM5 { // https://www.acmicpc.net/problem/15654, 브루트 포스 & 백트래킹
    private static int[] seq, sub;
    private static boolean[] selected;
    private static int cnt, len;
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cnt = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        seq = new int[cnt];
        sub = new int[len];
        selected = new boolean[cnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);

        go(0);

        System.out.print(ans);
    }

    private static void go(int curLen) {
        if (curLen == len) {
            for (int i : sub) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }

        for (int i = 0; i < cnt; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            sub[curLen] = seq[i];
            go(curLen + 1);
            selected[i] = false;
        }
    }
}
