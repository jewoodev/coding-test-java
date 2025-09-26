package coding.test.backjoon.silver;

import java.util.*;

public class Plus123 { // https://www.acmicpc.net/problem/9095, 브루트 포스 | DP
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] d = new int[12];
        d[0] = 1;
        d[1] = 1; // 1
        d[2] = 2; // 1 + 1, 2
        d[3] = 4; // 1 + 1 + 1, 2 + 1, 1 + 2, 3
        for (int j = 4; j <= 11; j++) {
            d[j] = d[j - 1] + d[j - 2] + d[j - 3];
        }
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sb.append(d[n]).append("\n");
        }
        System.out.print(sb);
    }
}

/**
 * ## 점화식 도출 과정 ##
 *
 * 1. 문제의 본질 이해
 * d[n] = n을 1, 2, 3의 합으로 나타내는 방법의 수
 * n을 만들기 위해서는 마지막에 1, 2, 3 중 하나를 더해야 함
 *
 * 2. 점화식 생각하는 방법
 * 핵심 아이디어: n을 만드는 방법들을 마지막에 더한 숫자에 따라 분류
 * 마지막에 1을 더한 경우: (n-1)을 만드는 방법의 수 × 1 = d[n-1]
 * 마지막에 2를 더한 경우: (n-2)를 만드는 방법의 수 × 1 = d[n-2]
 * 마지막에 3을 더한 경우: (n-3)를 만드는 방법의 수 × 1 = d[n-3]
 * 따라서: d[n] = d[n-1] + d[n-2] + d[n-3]
 *
 * 3. 구체적인 예시로 검증
 * n=4인 경우:
 * 마지막에 1을 더한 경우: d[3]의 모든 방법 + 1
 * (1+1+1) + 1 = 1+1+1+1
 * (1+2) + 1 = 1+2+1
 * (2+1) + 1 = 2+1+1
 * 마지막에 2를 더한 경우: d[2]의 모든 방법 + 2
 * (1+1) + 2 = 1+1+2
 * (2) + 2 = 2+2
 * 마지막에 3을 더한 경우: d[1]의 모든 방법 + 3
 * (1) + 3 = 1+3
 * 총 7가지 = d[3] + d[2] + d[1] = 4 + 2 + 1 = 7 ✓
 */

