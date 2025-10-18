package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class AlgoSpot { // https://www.acmicpc.net/problem/1261, BFS
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy= {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] cMap = new int[n][m]; // Count Map
        boolean[][] visited = new boolean[n][m];
        int[][] map = new int[n][m];
        for (int i=0; i<n; i++) {
            char[] read = br.readLine().toCharArray();
            for (int j=0; j<m; j++)
                map[i][j] = read[j] - '0';
        }

        Deque<Loc> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new Loc(0, 0, 0));

        while (!q.isEmpty()) {
            Loc now = q.poll();
            cMap[now.x][now.y] = now.cnt;

            for (int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx > -1 && ny > -1 && nx < n && ny < m && visited[nx][ny] == false) {
                    visited[nx][ny] = true;

                    if (map[nx][ny] == 1)
                        q.addLast(new Loc(nx, ny, now.cnt + 1));
                    else
                        q.addFirst(new Loc(nx, ny, now.cnt));
                }
            }
        }

        System.out.println(cMap[n-1][m-1]);
    }

    private static class Loc {
        int x, y, cnt;
        private Loc(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
