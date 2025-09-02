package coding.test.backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class NAndM4 { // https://www.acmicpc.net/problem/15652, 브루트 포스
    static int[] cnt = new int[9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void go(int selected, int idx, int N, int M) throws IOException {
        if (selected == M) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= cnt[i]; j++) {
                    bw.write(i + " ");
                }
            }
            bw.write("\n");
            return;
        }

        if (idx > N) return;

        for (int i = M - selected; i >= 1; i--) {
            cnt[idx] = i;
            go(selected + i, idx + 1, N, M);
        }
        cnt[idx] = 0;
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
