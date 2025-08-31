package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NAndM3 { // https://www.acmicpc.net/problem/15651, 브루트 포스 & 백트래킹
    static int[] a = new int[7];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void go(int idx, int N, int M) throws IOException {
        if (idx == M) {
            for (int i = 0; i < idx; i++) {
                bw.write(a[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            a[idx] = i;
            go(idx + 1, N, M);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] read = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
        int N = read[0];
        int M = read[1];

        go(0, N, M);

        bw.flush();
    }
}
