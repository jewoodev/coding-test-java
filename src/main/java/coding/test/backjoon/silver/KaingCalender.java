package coding.test.backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class KaingCalender { // https://www.acmicpc.net/problem/6064
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] read = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int M = read[0];
            int N = read[1];
            int x = read[2] - 1;
            int y = read[3] - 1;

            boolean flag = false;
            for (int j = x; j < M * N; j += M) {
                if (j % N == y) {
                    bw.write(j + 1 + "\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) bw.write("-1\n");
        }

        bw.flush();
    }
}
