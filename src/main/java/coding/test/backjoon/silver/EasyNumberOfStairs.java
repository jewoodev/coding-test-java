package coding.test.backjoon.silver;

import java.util.*;

public class EasyNumberOfStairs { // https://www.acmicpc.net/problem/10844, DP
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mod = 1_000_000_000;
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(9);
            return;
        };

        // d[i][j] : 마지막 자릿 수가 j 인 쉬운 계단 수의 갯수
        long[][] d = new long[n + 1][10];

        for (int i = 1; i < 10; i++) {
            d[1][i] = 1; // 자릿 수가 1인 쉬운 계산 수 초기화
        }

        for (int i = 2; i <= n; i++) { // 길이가 i 인 쉬운 계단 수의 갯수 초기화
            for (int j = 0; j < 10; j++) { // 그런데, 마지막 자릿 수가 j 인
                if (j == 0) {
                    d[i][j] = d[i - 1][j + 1];
                }
                else if (j == 9) {
                    d[i][j] = d[i - 1][j - 1];
                }
                else {
                    d[i][j] += (d[i - 1][j - 1] + d[i - 1][j + 1]) % mod;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + d[n][i]) % mod;
        }
        System.out.println(ans);
    }
}
