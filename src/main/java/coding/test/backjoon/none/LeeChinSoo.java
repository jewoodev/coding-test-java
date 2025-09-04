package coding.test.backjoon.none;

import java.util.*;

public class LeeChinSoo { // https://www.acmicpc.net/problem/2193, DP
    /**
     * D[i] = D[i-1] + D[i-2];
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] D = new long[N + 1];
        D[1] = 1;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + D[i - 2];
        }

        System.out.println(D[N]);
    }
}
