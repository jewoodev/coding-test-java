package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class HideAndSeek4 { // https://www.acmicpc.net/problem/13913, BFS & DFS & 역추적
    private static int maxPosition = 100_000;
    private static boolean[] visited = new boolean[maxPosition + 1];
    private static int[] visitedFrom = new int[maxPosition + 1];
    private static int start, dest;
    private static Deque<Integer> trackingResult = new ArrayDeque<>();
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        bfs();

        tracking(dest);
        while (!trackingResult.isEmpty()) {
            ans.append(trackingResult.pollLast()).append(" ");
        }

        System.out.println(ans);
    }

    private static void tracking(int x) {
        if (x == start) {
            trackingResult.offer(x);
            return;
        }

        trackingResult.offer(x);
        tracking(visitedFrom[x]);
    }

    private static void bfs() {
        Deque<Subin> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(new Subin(start, 0));

        while (!q.isEmpty()) {
            Subin now = q.poll();

            if (now.x == dest) {
                ans.append(now.cost).append("\n");
                break;
            }

            if (now.x - 1 >= 0 && !visited[now.x - 1]) {
                int next = now.x - 1;
                visited[next] = true;
                visitedFrom[next] = now.x;
                q.offer(new Subin(next, now.cost + 1));
            }
            if (now.x + 1 <= maxPosition && !visited[now.x + 1]) {
                int next = now.x + 1;
                visited[next] = true;
                visitedFrom[next] = now.x;
                q.offer(new Subin(next, now.cost + 1));
            }
            if (now.x * 2 <= maxPosition && visitedFrom[now.x * 2] == 0) {
                int next = now.x * 2;
                visited[next] = true;
                visitedFrom[next] = now.x;
                q.offer(new Subin(next, now.cost + 1));
            }
        }
    }

    private static class Subin {
        int x, cost;
        private Subin(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
