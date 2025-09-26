package coding.test.backjoon.silver;

import java.util.*;

public class MakeIt1 { // https://www.acmicpc.net/problem/1463, DP
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n < 4) {
            if (n == 1) System.out.println(0);
            else System.out.println(1);
            return;
        }
        int[] d = new int[n + 1];
        d[2] = 1;
        d[3] = 1;

        for (int i = 4; i <= n; i++) {
            d[i] += d[i - 1] + 1; // 모든 상황에서 실행될 수 있는 연산이므로 첫 번째 순서에 위치시킴

            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }

            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
        }

        System.out.println(d[n]);
    }
}
