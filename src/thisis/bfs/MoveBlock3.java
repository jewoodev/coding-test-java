package thisis.bfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class MoveBlock3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] input = new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        int solution = MoveBlock3.Solution.solution(input);
        bw.write(String.valueOf(solution));
        bw.close();
    }
    private static class Solution { //p355
        private static int map[][];
        private static int n;
        private static int dx[] = {-1, 1, 0, 0};
        private static int dy[] = {0, 0, -1, 1};
        private static boolean[][] row;
        private static boolean[][] col;
        private static int answer;

        static class Robot {
            Point p1, p2;
            int dir; // 가로: 0, 세로: 1
            public Robot(Point p1, Point p2, int dir) {
                this.p1 = p1;
                this.p2 = p2;
                this.dir = dir;
            }
        }

        static class Point {
            int x, y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public static int solution(int[][] board) {
            n = board.length;
            answer = 0;
            row = new boolean[n][n];
            col = new boolean[n][n];
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                map[i] = board[i].clone();
            }

            row[0][0] = true;
            row[0][1] = true;

            start();
            return answer;
        }
        private static void start() {
            Queue<Robot> q = new LinkedList<>();
            q.add(new Robot(new Point(0, 0), new Point(0, 1), 0));
            q.add(new Robot(null, null, -1));
            int cnt = 0;

            while (!q.isEmpty()) {
                Robot now = q.poll();

                if (now.dir == -1) {
                    cnt++;
                    if (!q.isEmpty()) {
                        q.add(new Robot(null, null, -1));
                    } continue;
                }

                if ((now.p1.x == n - 1 && now.p1.y == n - 1) || (now.p2.x == n - 1 && now.p2.y == n - 1)) {
                    answer = cnt;
                    break;
                }

                if (now.dir == 0) {
                    for (int i = 0; i < 4; i++) {
                        int nx1 = now.p1.x + dx[i];
                        int ny1 = now.p1.y + dy[i];
                        int nx2 = now.p2.x + dx[i];
                        int ny2 = now.p2.y + dy[i];

                        if (check(nx1, ny1) && check(nx2, ny2)) {
                            if (!row[nx1][ny1] || !row[nx2][ny2]) {
                                Robot next = new Robot(new Point(nx1, ny1), new Point(nx2, ny2), 0);
                                row[nx1][ny1] = true;
                                row[nx2][ny2] = true;
                                q.add(next);
                            }
                        }
                    }

                    for(int i = -1; i <= 1; i+=2) {
                        int nx1 = now.p1.x + i;
                        int ny1 = now.p1.y;
                        int nx2 = now.p2.x + i;
                        int ny2 = now.p2.y;

                        if (check(nx1, ny1) && check(nx2, ny2)) {
                            if (rotate(nx1, ny1, now.p1.x, now.p1.y) && (!col[nx1][ny1] || !col[now.p1.x][now.p1.y])) {
                                col[nx1][ny1] = true;
                                col[now.p1.x][now.p1.y] = true;
                                q.add(new Robot(new Point(nx1, ny1), new Point(now.p1.x, now.p1.y), 1));
                            }
                            if (rotate(nx2, ny2, now.p2.x, now.p2.y) && (!col[nx2][ny2] || !col[now.p2.x][now.p2.y])) {
                                col[nx2][ny2] = true;
                                col[now.p2.x][now.p2.y] = true;
                                q.add(new Robot(new Point(nx2, ny2), new Point(now.p2.x, now.p2.y), 1));
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        int nx1 = now.p1.x + dx[i];
                        int ny1 = now.p1.y + dy[i];
                        int nx2 = now.p2.x + dx[i];
                        int ny2 = now.p2.y + dy[i];

                        if (check(nx1, ny1) && check(nx2, ny2)) {
                            if (!col[nx1][ny1] || !col[nx2][ny2]) {
                                Robot next = new Robot(new Point(nx1, ny1), new Point(nx2, ny2), 1);
                                col[nx1][ny1] = true;
                                col[nx2][ny2] = true;
                                q.add(next);
                            }
                        }
                    }

                    for(int i = -1; i <= 1; i+=2) {
                        int nx1 = now.p1.x;
                        int ny1 = now.p1.y + i;
                        int nx2 = now.p2.x;
                        int ny2 = now.p2.y + i;

                        if (check(nx1, ny1) && check(nx2, ny2)) {
                            if (rotate(nx1, ny1, now.p1.x, now.p1.y) && (!row[nx1][ny1] || !row[now.p1.x][now.p1.y])) {
                                row[nx1][ny1] = true;
                                row[now.p1.x][now.p1.y] = true;
                                q.add(new Robot(new Point(nx1, ny1), new Point(now.p1.x, now.p1.y), 0));
                            }
                            if (rotate(nx2, ny2, now.p2.x, now.p2.y) && (!row[nx2][ny2] || !row[now.p2.x][now.p2.y])) {
                                row[nx2][ny2] = true;
                                row[now.p2.x][now.p2.y] = true;
                                q.add(new Robot(new Point(nx2, ny2), new Point(now.p2.x, now.p2.y), 0));
                            }
                        }
                    }
                }
            }
        }
        public static boolean rotate(int x1, int y1, int x2, int y2) {
            if (!check(x1, y1) || !check(x2, y2)) return false;
            return true;
        }

        public static boolean check(int x, int y) {
            return x >= 0 && y >= 0 && x < n && y < n && map[x][y] == 0;
        }
    } //Solution
}