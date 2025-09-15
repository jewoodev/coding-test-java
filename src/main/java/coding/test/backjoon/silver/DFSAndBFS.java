package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class DFSAndBFS { // https://www.acmicpc.net/problem/1260, 그래프 & BFS & DFS
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer>[] g;
    private static boolean[] visited;

    private static void dfs(int cur) {
        if (visited[cur]) return;

        visited[cur] = true;
        sb.append(cur).append(" ");
        for (int i : g[cur]) {
            dfs(i);
        }
    }

    private static void bfs(int v) {
        Deque<Integer> q = new ArrayDeque<>();

        visited[v] = true;
        q.offer(v);
        while (!q.isEmpty()) {
            int c = q.poll();
            sb.append(c).append(" ");

            for (int i : g[c]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] read = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = read[0], m = read[1], v = read[2];
        g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            read = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int x = read[0];
            int y = read[1];
            g[x].add(y);
            g[y].add(x);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(g[i]);
        }

        // dfs
        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");

        // bfs
        visited = new boolean[n+1];
        bfs(v);
        sb.append("\n");
        System.out.println(sb);
    }
}
