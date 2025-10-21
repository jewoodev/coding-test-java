package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class MoveOfKnight { // https://www.acmicpc.net/problem/7562, BFS
    private static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static StringBuilder ans = new StringBuilder();
    private static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            Point start = new Point(y, x, 0);
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            Point dest = new Point(y, x, 0);
            boolean[][] visited = new boolean[l][l];
            bfs(start, dest, visited);
        }

        System.out.print(ans);
    }

    private static void bfs(Point start, Point dest, boolean[][] visited) {
        Deque<Point> q = new ArrayDeque<>();
        q.offer(start);
        visited[start.y][start.x] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            int y = now.y;
            int x = now.x;
            if (dest.y == y && dest.x == x) {
                ans.append(now.cost).append("\n");
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                q.offer(new Point(ny, nx, now.cost + 1));
            }
        }
    }

    private static class Point {
        int y, x, cost;
        private Point(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
