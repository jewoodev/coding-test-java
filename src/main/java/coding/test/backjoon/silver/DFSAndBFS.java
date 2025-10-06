package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class DFSAndBFS { // https://www.acmicpc.net/problem/1260, 그래프 & BFS & DFS
    private static StringBuilder ans = new StringBuilder();
    private static List<Integer>[] em; // 간선 행렬
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= n; i++) {
            Collections.sort(em[i]);
        }

        // dfs
        visited = new boolean[n+1];
        dfs(v);
        ans.append("\n");

        // bfs
        visited = new boolean[n+1];
        bfs(v);
        ans.append("\n");
        System.out.println(ans);
    }

    private static void dfs(int cur) {
        if (visited[cur]) return;

        visited[cur] = true;
        ans.append(cur).append(" ");
        for (int i : em[cur]) {
            dfs(i);
        }
    }

    private static void bfs(int v) {
        Deque<Integer> q = new ArrayDeque<>();

        visited[v] = true;
        q.offer(v);
        while (!q.isEmpty()) {
            int c = q.poll();
            ans.append(c).append(" ");

            for (int i : em[c]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
