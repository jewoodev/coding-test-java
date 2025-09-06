package coding.test.backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class NAndM6 { // https://www.acmicpc.net/problem/15655, 브루트 포스 & 백트래킹
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] a, c;
    static boolean[] b;

    static void go(int selected, int idx, int N, int M) throws IOException {
        if (selected == M) {
            for (int i: c) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        if (idx > N) return;

        for (int i = idx; i < N; i++) {
            if (b[i]) continue;

            c[selected] = a[i];
            b[i] = true;
            go(selected + 1, i + 1, N, M);
            b[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] read = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int N = read[0];
        int M = read[1];
        a = new int[N];
        c = new int[M];
        b = new boolean[N];

        a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        go(0, 0, N, M);

        bw.flush();
    }
}
