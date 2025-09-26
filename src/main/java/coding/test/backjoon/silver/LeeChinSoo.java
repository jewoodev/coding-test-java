package coding.test.backjoon.silver;

import java.util.*;

public class LeeChinSoo { // https://www.acmicpc.net/problem/2193, DP
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // num[i][j] : 길이가 i 인 이며 마지막 수가 j 인 이친수의 갯수
        long[][] num = new long[n + 1][2];
        num[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            num[i][0] = num[i - 1][0] + num[i - 1][1];
            num[i][1] = num[i - 1][0];
        }

        long ans = 0;
        for (int i = 0; i < 2; i++) {
            ans += num[n][i];
        }
        System.out.println(ans);
    }
}
