package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class AliquotSum { // https://www.acmicpc.net/problem/17425, 수학
    private static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] numOfDivisors = new long[MAX];
        for (int i = 1; i < MAX; i++)
            numOfDivisors[i] = 1;

        for (int i = 2; i < MAX; i++) {
            for (int j = 1; i * j < MAX; j++) {
                numOfDivisors[i * j] += i;
            }
        }

        long[] sum = new long[MAX];
        for (int i = 1; i < MAX; i++) {
            sum[i] = sum[i - 1] + numOfDivisors[i];
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(sum[n]).append("\n");
        }

        System.out.print(sb);
    }
}
