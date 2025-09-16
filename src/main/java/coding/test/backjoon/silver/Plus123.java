package coding.test.backjoon.silver;

import java.io.*;

public class Plus123 { // https://www.acmicpc.net/problem/9095, 브루트 포스 || DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] d = new int[11];
        d[0] = 1;
        for (int i = 1; i <= 10; i++)
            for (int j = 1; j <= 3; j++)
                if (i - j >= 0)
                    d[i] += d[i - j];

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(d[n]);
        }
    }
}

