package coding.test.backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class NAndM7 { // https://www.acmicpc.net/problem/15656, 브루트 포스 & 백트래킹
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] a, c;

    static void go(int selected, int idx, int N, int M) throws IOException {
        if (selected == M) {
            for (int i = 0; i < M; i++) {
                bw.write(c[i] + " ");
            }
            bw.write("\n");
            return;
        }

        if (idx > N) return;

        for (int i = 0; i < N; i++) {
            c[selected] = a[i];
            go(selected + 1, i + 1, N, M);
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
        a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        go(0, 0, N, M);

        bw.flush();
    }
}
