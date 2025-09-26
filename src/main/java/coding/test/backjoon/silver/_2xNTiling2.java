package coding.test.backjoon.silver;

import java.util.*;

public class _2xNTiling2 { // https://www.acmicpc.net/problem/11727, DP
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[1001];
        a[0] = 1;
        a[1] = 1; // 1, 3, 5, 9, 15
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + (2 * a[i - 2]);
            a[i] %= 10007;
        }

        System.out.println(a[n]);
    }
}
