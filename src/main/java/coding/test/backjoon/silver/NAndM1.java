package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM1 { // https://www.acmicpc.net/problem/15649, 브루트 포스 & 백트래킹
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] a;
    static boolean[] b;

    static void go(int idx, int N, int M) throws IOException {
        if (idx == M) {
            for (int i: a) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (b[i]) continue;
            a[idx] = i;
            b[i] = true;
            go(idx + 1, N, M);
            b[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] read = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int N = read[0];
        int M = read[1];
        a = new int[M];
        b = new boolean[N + 1];

        go(0, N, M);

        bw.flush();
    }
}
