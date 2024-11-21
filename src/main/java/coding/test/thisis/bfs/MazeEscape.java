package coding.test.thisis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeEscape { //p152
    static int row, col;
    static int[][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        maze = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] splitStr = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                maze[i][j] = Integer.parseInt(splitStr[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        que.add(y);
        int cnt = 1;
        int nx;
        int ny;

        while (!que.isEmpty()) {
            x = que.poll();
            y = que.poll();
            maze[x][y] = 0; //방문처리

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || nx > row - 1 || ny < 0 || ny > col - 1) continue;
                if (maze[nx][ny] == 1 && (nx > x || ny > y)) {
                    cnt++;
                    que.add(nx);
                    que.add(ny);
                }
            }
        }
        return cnt;
    }
}
