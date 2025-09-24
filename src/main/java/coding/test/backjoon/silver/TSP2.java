package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class TSP2 { // https://www.acmicpc.net/problem/10971, 브루트포스 & 백트래킹
    private static int n, ans = Integer.MAX_VALUE;
    private static int[][] cost;
    private static int[] plan;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        cost = new int[n][n]; // 도시 i에서 j로 가기 위한 비용을 저장할 배열
        plan = new int[n]; // 방문할 도시 순서를 저장할 배열
        selected = new boolean[n]; // 방문할 도시로 선택했는지 여부를 저장할 배열
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0);

        System.out.println(ans);
    }

    private static void go(int curLen) {
        if (plan[0] >= 1) return; // 다시 첫 도시로 돌아오기 때문에 비용 계산 식이 중복 호출됨
        // 따라서 첫 도시를 고정시켜도 됨 첫 번째 도시는 도시가 몇 개이든 존재하기 때문에 이 도시를 고정

        if (curLen == n) {
            calculate();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            plan[curLen] = i;
            go(curLen + 1);
            selected[i] = false;
        }
    }

    private static void calculate() {
        int sum = 0;
        int end = n - 1;

        // 연속된 도시들 간의 이동 비용 계산
        for (int i = 0; i < end; i++) {
            if (cost[plan[i]][plan[i + 1]] == 0) return; // 갈 수 없는 경로면 종료
            sum += cost[plan[i]][plan[i + 1]];
        }
        // 마지막 도시에서 시작 도시로 돌아가는 비용 계산
        if (cost[plan[n - 1]][plan[0]] == 0) return; // 갈 수 없는 경로면 종료
        sum += cost[plan[n - 1]][plan[0]];

        ans = Math.min(ans, sum);
    }
}
