package coding.test.backjoon.silver;

import java.util.*;
import java.io.*;

public class MazeExploration { // https://www.acmicpc.net/problem/2178, 그래프
    private static int[][] map, cost;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, m;

    private static void bfs(int x, int y) {
        Deque<Point> q = new ArrayDeque<>();

        cost[0][0] = 1;
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 1 && cost[nx][ny] == -1) {
                        cost[nx][ny] = cost[now.x][now.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cost = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] read = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = read[j] - '0';
                cost[i][j] = -1;
            }
        }

        bfs(0, 0);

        System.out.println(cost[n - 1][m - 1]);
    }

    private static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



// ----------- 방문 여부를 별도의 boolean 배열로 저장하는 풀이 ↓ ----------- //
//    private static int[][] map, c;
//    private static boolean[][] visited;
//    private static int[] dx = {-1, 1, 0, 0};
//    private static int[] dy = {0, 0, -1, 1};
//    private static int n, m;
//
//    private static void bfs(int x, int y) {
//        Deque<Point> q = new ArrayDeque<>();
//
//        c[0][0] = 1;
//        visited[0][0] = true;
//        q.add(new Point(x, y));
//
//        while (!q.isEmpty()) {
//            Point now = q.poll();
//            for (int i = 0; i < 4; i++) {
//                int nx = now.x + dx[i];
//                int ny = now.y + dy[i];
//                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
//                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
//                        c[nx][ny] = c[now.x][now.y] + 1;
//                        visited[nx][ny] = true;
//                        q.add(new Point(nx, ny));
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        map = new int[n][m];
//        c = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            char[] read = br.readLine().toCharArray();
//            for (int j = 0; j < m; j++) {
//                map[i][j] = read[j] - '0';
//            }
//        }
//        visited = new boolean[n][m];
//
//        bfs(0, 0);
//
//        System.out.println(c[n - 1][m - 1]);
//    }
//
//    private static class Point {
//        int x, y;
//        private Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}





// ----------- 오답 노트 ↓ ----------- //
//    private static int[][] map, c;
//    private static boolean[][] visited;
//    private static int[] dx = {-1, 1, 0, 0};
//    private static int[] dy = {0, 0, -1, 1};
//    private static int n, m, cost;
//
//    private static void bfs(int x, int y) {
//        Deque<Point> q = new ArrayDeque<>();
//        q.add(new Point(x, y, 1));
//
//        cost = 1;
//        while (!q.isEmpty()) {
//            Point now = q.poll();
//            visited[now.x][now.y] = true;
//            c[now.x][now.y] = now.cost;
//            ++cost; // 어떻게 다음 탐색에서 최소 거리를 저장하는 구조를 만들지 옳게 구하지 못했다.
//            for (int i = 0; i < 4; i++) {
//                int nx = now.x + dx[i];
//                int ny = now.y + dy[i];
//                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
//                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
//                        q.add(new Point(nx, ny, cost));
//                    }
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        map = new int[n][m];
//        c = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            char[] read = br.readLine().toCharArray();
//            for (int j = 0; j < m; j++) {
//                map[i][j] = read[j] - '0';
//            }
//        }
//        visited = new boolean[n][m];
//
//        bfs(0, 0);
//
//        System.out.println(map[n - 1][m - 1]);
//    }
//
//    private static class Point {
//        int x, y, cost;
//        private Point(int x, int y, int cost) {
//            this.x = x;
//            this.y = y;
//            this.cost = cost;
//        }
//    }
//}
