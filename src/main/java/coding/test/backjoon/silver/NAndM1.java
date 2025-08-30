package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM1 { // https://www.acmicpc.net/problem/15649, 브루트 포스 & 백트래킹
    static int[] a = new int[9];
    static boolean[] c = new boolean[9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void go(int idx, int N, int M) throws IOException {
        if (idx == M) {
            for (int i = 0; i < 8; i++) {
                if (a[i] != 0) bw.write(a[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[idx] = i;
            go(idx + 1, N, M);
            c[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        go(0, N, M);

        bw.flush();
    }
}
