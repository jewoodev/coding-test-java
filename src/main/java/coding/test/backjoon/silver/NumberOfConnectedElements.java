package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NumberOfConnectedElements { // https://www.acmicpc.net/problem/11724, 그래프 & DFS & BFS
    private static List<Integer>[] em; // 간선 행렬
    private static boolean[] visited;
    private static int n;
    private static int ans;
    private static boolean isNew;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        em = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            em[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            em[x].add(y);
            em[y].add(x);
        }

        visited = new boolean[n + 1];

        ans = 0;

//        // dfs로 푸는 방법
//        for (int i = 1; i <= n; i++) {
//            isNew = true;
//            dfs(i);
//            if (!isNew) ans++;
//        }

        // bfs로 푸는 방법
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        System.out.println(ans);
    }

//    private static void dfs(int s) {
//        if (visited[s]) return;
//        visited[s] = true;
//
//        for (int i : em[s]) {
//            dfs(i);
//        }
//
//        isNew = false;
//    }

    private static void bfs(int s) {
        if (visited[s]) return;
        Deque<Integer> q = new ArrayDeque<>();

        visited[s] = true;
        q.offer(s);
        ans++;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : em[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
