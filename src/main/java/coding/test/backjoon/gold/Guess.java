package coding.test.backjoon.gold;

import java.util.*;

public class Guess { // https://www.acmicpc.net/problem/1248, 브루트포스 & 백트래킹
    private static int n;
    private static int[][] sign;
    private static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        ans = new int[n];
        sign = new int[n][n];
        String signs = sc.next();

        // 부호 행렬을 2차원 배열로 변환
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char x = signs.charAt(idx++);
                if (x == '0')
                    sign[i][j] = 0;
                else if (x == '+')
                    sign[i][j] = 1;
                else
                    sign[i][j] = -1;
            }
        }

        go(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean go(int idx) {
        if (idx == n) return true;

        if (sign[idx][idx] == 0) {
            ans[idx] = 0;
            return check(idx) && go(idx + 1);
        }

        for (int i = 1; i <= 10; i++) {
            ans[idx] = sign[idx][idx] * i;
            if (check(idx) && go(idx + 1)) return true;
        }

        return false;
    }

    private static boolean check(int idx) {
        int sum = 0;
        for (int i = idx; i >= 0; i--) {
            sum += ans[i];

            if (sign[i][idx] == 0) {
                if (sum != 0) return false;
            } else if (sign[i][idx] < 0) {
                if (sum >= 0) return false;
            } else if (sign[i][idx] > 0) {
                if (sum <= 0) return false;
            }
        }
        return true;
    }
}