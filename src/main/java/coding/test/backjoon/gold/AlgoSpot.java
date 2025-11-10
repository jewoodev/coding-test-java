package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class AlgoSpot { // https://www.acmicpc.net/problem/1261, BFS
    private static int[][] map;
    private static int m, n;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makeMap(br);
        inputMapInfo(br);
        bfs();
    }

    private static void makeMap(BufferedReader br) throws IOException {
        String[] readFirst = br.readLine().split(" ");
        m = Integer.parseInt(readFirst[0]);
        n = Integer.parseInt(readFirst[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
    }

    private static void inputMapInfo(BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            String read = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = read.charAt(j) - '0';
            }
        }
    }

    private static void bfs() {
        Deque<Operator> dq = new ArrayDeque<>();
        visited[0][0] = true;
        dq.offer(new Operator(0, 0, 0));

        while (!dq.isEmpty()) {
            Operator cur = dq.poll();

            if (cur.x == m - 1 && cur.y == n - 1) {
                System.out.print(cur.cost);
                break;
            }

            goWest(cur, dq);
            goEast(cur, dq);
            goNorth(cur, dq);
            goSouth(cur, dq);
        }
    }

    private static void goWest(Operator cur, Deque<Operator> dq) {
        int next = cur.x - 1;
        if (next >= 0 && !visited[cur.y][next]) {
            visited[cur.y][next] = true;
            if (map[cur.y][next] == 1) {
                dq.offerLast(new Operator(cur.y, next, cur.cost + 1));
            } else {
                dq.offerFirst(new Operator(cur.y, next, cur.cost));
            }
        }
    }

    private static void goEast(Operator cur, Deque<Operator> dq) {
        int next = cur.x + 1;
        if (next < m && !visited[cur.y][next]) {
            visited[cur.y][next] = true;
            if (map[cur.y][next] == 1) {
                dq.offerLast(new Operator(cur.y, next, cur.cost + 1));
            } else {
                dq.offerFirst(new Operator(cur.y, next, cur.cost));
            }
        }
    }

    private static void goNorth(Operator cur, Deque<Operator> dq) {
        int next = cur.y - 1;
        if (next >= 0 && !visited[next][cur.x]) {
            visited[next][cur.x] = true;
            if (map[next][cur.x] == 1) {
                dq.offerLast(new Operator(next, cur.x, cur.cost + 1));
            } else {
                dq.offerFirst(new Operator(next, cur.x, cur.cost));
            }
        }
    }

    private static void goSouth(Operator cur, Deque<Operator> dq) {
        int next = cur.y + 1;
        if (next < n && !visited[next][cur.x]) {
            visited[next][cur.x] = true;
            if (map[next][cur.x] == 1) {
                dq.offerLast(new Operator(next, cur.x, cur.cost + 1));
            } else {
                dq.offerFirst(new Operator(next, cur.x, cur.cost));
            }
        }
    }

    private static class Operator {
        int y, x, cost;
        private Operator(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}
