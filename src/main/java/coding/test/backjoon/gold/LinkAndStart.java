package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class LinkAndStart { // https://www.acmicpc.net/problem/15661, 브루트포스 & 백트래킹
    private static int[][] S;
    private static int n, ans = Integer.MAX_VALUE;
    private static List<Integer> link, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        link = new ArrayList<>();
        start = new ArrayList<>();

        n = Integer.parseInt(br.readLine());
        S = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        System.out.println(ans);
    }

    private static void combination(int idx, int cnt) {
        if (ans == 0) return;

        // 기저 조건: 모든 사람을 처리했을 때
        if (idx == n) {
            // 양쪽 팀 모두 최소 1명씩은 있어야 함
            if (cnt > 0 && cnt < n) {
                calculateDiff();
            }
            return;
        }

        // 현재 사람을 링크 팀에 포함시키기
        link.add(idx);
        combination(idx + 1, cnt + 1);
        link.remove(link.size() - 1);

        // 현재 사람을 스타트 팀에 포함시키기
        start.add(idx);
        combination(idx + 1, cnt);
        start.remove(start.size() - 1);
    }

    private static void calculateDiff() {
        int linkSum = 0;
        int startSum = 0;

        for (int i = 0; i < link.size(); i++) {
            for (int j = 0; j < link.size(); j++) {
                if (i == j) continue;
                linkSum += S[link.get(i)][link.get(j)];
            }
        }
        for (int i = 0; i < start.size(); i++) {
            for (int j = 0; j < start.size(); j++) {
                if (i == j) continue;
                startSum += S[start.get(i)][start.get(j)];
            }
        }

        int diff = Math.abs(startSum - linkSum);
        ans = Math.min(ans, diff);
    }
}