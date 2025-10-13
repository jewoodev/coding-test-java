package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class Tomato { // https://www.acmicpc.net/problem/7576, BFS
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;
    private static Deque<Point> q = new ArrayDeque<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) q.offer(new Point(i, j));
            }
        }

        bfs();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (max < map[i][j]) max = map[i][j];
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max - 1);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 0) {
                    map[ny][nx] = map[cur.y][cur.x] + 1;
                    q.offer(new Point(ny, nx));
                }
            }
        }
    }

    private static class Point {
        int x, y;
        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
