package coding.test.backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class NAndM2 { // https://www.acmicpc.net/problem/15650, 브루트 포스 & 백트래킹
    static int[] a = new int[8];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void go(int selected, int idx, int N, int M) throws IOException {
        if (selected == M) {
            for (int i = 0; i < 8; i++) {
                if(a[i] != 0) bw.write(a[i] + " ");
            }
            bw.write("\n");
            return;
        }

        if (idx > N) return;
        a[selected] = idx;
        go(selected + 1,idx + 1, N, M);
        a[selected] = 0;
        go(selected, idx + 1, N, M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] read = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
        int N = read[0];
        int M = read[1];

        go(0, 1, N, M);

        bw.flush();
    }
}
