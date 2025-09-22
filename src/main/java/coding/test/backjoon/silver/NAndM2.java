package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM2 { // https://www.acmicpc.net/problem/15650, 브루트 포스
    private static int[] seq;
    private static int max, len;
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        max = Integer.parseInt(st.nextToken());
        len = Integer.parseInt(st.nextToken());
        seq = new int[len];

        go(1,0);

        System.out.print(ans);
    }

    private static void go(int s, int curLen) {
        if (curLen == len) {
            for (int i : seq) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }

        for (int i = s; i <= max; i++) {
            seq[curLen] = i;
            go(i + 1, curLen + 1);
        }
    }
}
