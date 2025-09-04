package coding.test.backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class NAndM5 { // https://www.acmicpc.net/problem/15654, 브루트 포스 & 백트래킹
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] a;
    static boolean[] b;
    static int[] arr;

    static void bruteForce(int cnt, int N, int M) throws IOException {
        if (cnt == M) {
            for (int i: arr) {
                bw.write(i + " ");
            }

            bw.write("\n");
            return;
        }


        for (int i = 0; i < N; i++) {
            if (b[i]) continue;

            b[i] = true;
            arr[cnt] = a[i];
            bruteForce(cnt + 1, N, M);
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
        b = new boolean[N];
        arr = new int[M];

        for (int i = 0; i < 1; i++) {
            a = Arrays.stream(br.readLine().split(" "))
                                    .mapToInt(Integer::parseInt).sorted().toArray();
        }

        bruteForce(0, N, M);

        bw.flush();
    }
}
