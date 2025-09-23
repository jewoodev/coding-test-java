package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class StartAndLink { // https://www.acmicpc.net/problem/14889, 브루트포스 & 백트래킹
    private static int[][] S;
    private static int n;
    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        S = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합을 사용하여 스타트 팀 선택
        boolean[] selected = new boolean[n];
        combination(0, 0, selected);

        System.out.println(minDiff);
    }

    // 조합: n개 중 n / 2개 선택
    private static void combination(int idx, int count, boolean[] selected) {
        if (count == n / 2) {
            calculateDifference(selected);
            return;
        }

        if (idx == n) return;

        // 현재 사람을 스타트 팀에 포함
        selected[idx] = true;
        combination(idx + 1, count + 1, selected);

        // 현재 사람을 스타트 팀에 포함하지 않음
        selected[idx] = false;
        combination(idx + 1, count, selected);
    }

    private static void calculateDifference(boolean[] selected) {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < n; i++) {
            // 스타트 팀의 능력치 계산
            if (selected[i]) {
                for (int j = 0; j < n; j++) {
                    if (selected[j]) {
                        startSum += S[i][j];
                    }
                }
            }

            // 링크 팀의 능력치 계산
            else {
                for (int j = 0; j < n; j++) {
                    if (!selected[j]) {
                        linkSum += S[i][j];
                    }
                }
            }
        }

        int diff = Math.abs(startSum - linkSum);
        minDiff = Math.min(minDiff, diff);
    }
}
