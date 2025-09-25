package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class StartAndLink { // https://www.acmicpc.net/problem/14889, 브루트포스 & 백트래킹 | 비트마스킹
    private static int[][] s;
    private static int n;
    private static int minDiff = Integer.MAX_VALUE;
    private static List<Integer> start, link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = new ArrayList<>();
        link = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비트마스킹을 사용하여 스타트 팀 선택
        bitmasking();

        System.out.println(minDiff);
    }

    // 조합: n개 중 n / 2개 선택
    private static void bitmasking() {
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    start.add(j);
                }
                else link.add(j);
            }
            if (start.size() == n / 2) {
                calculateDiff();
            }
            start.clear();
            link.clear();
        }
    }

    private static void calculateDiff() {
        int startSum = 0;
        int linkSum = 0;
        int half = n / 2;

        for (int i = 0; i < half; i++) {
            for (int j = i + 1; j < half; j++) {
                startSum += s[start.get(i)][start.get(j)];
                startSum += s[start.get(j)][start.get(i)];
                linkSum += s[link.get(i)][link.get(j)];
                linkSum += s[link.get(j)][link.get(i)];
            }
        }

        int diff = Math.abs(startSum - linkSum);
        minDiff = Math.min(minDiff, diff);
    }
}
