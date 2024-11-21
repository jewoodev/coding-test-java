package coding.test.thisis.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class MoveBlock { //p355
    class Solution {
        //dx, dy는 상하좌우 이동에 쓸 배열
        static int dx[] = {-1, 1, 0, 0};
        static int dy[] = {0, 0, -1, 1};
        //rx, ry는 회전 이동에 쓸 배열
        static int rx[][] = {{-1, 0, -1, 0}, {0, 0, 1, 1}};
        static int ry[][] = {{0, 0, 1, 1}, {-1, 0, -1, 0}};

        static class Robot {
            //dir: 가로 = 0, 세로 = 1 | time: 걸린 시간
            int x, y, dir, time;
            public Robot(int x, int y, int dir, int time) {
                this.x = x;
                this.y = y;
                this.dir = dir;
                this.time = time;
            }
        }

        public static int solution(int[][] board) {
            int answer = Integer.MAX_VALUE;
            int len = board.length;
            Queue<Robot> q = new LinkedList<>();
            boolean[][][] visited = new boolean[2][101][101];

            q.add(new Robot(0, 0, 0, 0));
            visited[0][0][0] = true;

            //로봇 운동 BFS
            while (!q.isEmpty()) {
                Robot cur = q.poll();
                //가로로 도착한 경우
                if (cur.dir == 0 && cur.x == len - 1 && cur.y == len - 2) {
                    answer = Math.min(answer, cur.time);
                    continue;
                //세로로 도착한 경우
                } else if (cur.dir == 1 && cur.x == len - 2 && cur.y == len - 1) {
                    answer = Math.min(answer, cur.time);
                    continue;
                }

                //상하좌우 이동
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!canMove(nx, ny, cur.dir, board)) continue;
                    if (!visited[cur.dir][nx][ny]) {
                        q.add(new Robot(nx, ny, cur.dir, cur.time + 1));
                        visited[cur.dir][nx][ny] = true;
                    }
                }

                //회전
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + rx[cur.dir][i];
                    int ny = cur.y + ry[cur.dir][i];

                    //가로 방향일 때는 상하로 움직일 수 있을 때 회전 가능
                    int cx = cur.x + dx[i % 2];
                    int cy = cur.y + dy[i % 2];

                    //세로 방향일 때는 좌우로 움직일 수 있을 때 회전 가능
                    if (cur.dir == 1) {
                        cx = cur.x + dx[i < 2 ? i+2 : i];
                        cy = cur.y + dy[i < 2 ? i+2 : i];
                    }

                    int ndir = cur.dir ^ 1;

                    //회전 할 수 있는지 확인
                    if (!canMove(nx, ny, ndir, board) || !canMove(cx, cy, cur.dir, board)) continue;
                    if (!visited[ndir][nx][ny]) {
                        q.add(new Robot(nx, ny, ndir, cur.time + 1));
                        visited[ndir][nx][ny] = true;
                    }
                }
            }
            return answer;
        }
    }

    private static boolean canMove(int nx, int ny, int dir, int[][] board) {
        int len = board.length;
        if (dir == 0) {
            if (nx >= 0 && nx < len && ny >= 0 && ny < len && ny + 1 < len && board[nx][ny] == 0 && board[nx][ny + 1] == 0) {
                return true;
            } return false;
        } else {
            if (nx >= 0 && nx < len && ny >= 0 && ny < len && nx + 1 < len && board[nx][ny] == 0 && board[nx + 1][ny] == 0) {
                return true;
            } return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] input = new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        int solution = Solution.solution(input);
        bw.write(String.valueOf(solution));
        bw.close();
    }
}
