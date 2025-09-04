package coding.test.backjoon.gold;

import java.io.*;

public class LIS4 { // https://www.acmicpc.net/problem/14002, DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        String[] read = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(read[i]);

        int[] d = new int[N];
        d[0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (a[i] > a[i - j] && d[i] < d[i - j] + 1)
                    d[i] = d[i - j] + 1;
            }
        }

        int i = 0;
        int ans = 0;
        for (; i < N; i++) {
            if (d[i] > ans) ans = d[i];
        }

        bw.write(ans + "\n");

        int before = 0;
        for (int j = 0; j < i; j++) {
            if (a[j] > before) {
                before = a[j];
                bw.write(before + " ");
            }
        }

        bw.flush();
    }
}
