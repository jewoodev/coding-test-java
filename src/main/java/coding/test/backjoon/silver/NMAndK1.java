package coding.test.backjoon.silver;

import java.io.*;
import java.util.Arrays;

public class NMAndK1 { // https://www.acmicpc.net/problem/18290, 브루트 포스 & 백트래킹
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] grid;
    static boolean[][] c;
    static int ans = Integer.MIN_VALUE, N, M, K;

    static void go(int cnt, int sum, int px, int py) throws Exception {
        if (cnt == K) {
            if (sum > ans) ans = sum;
            return;
        }

        for (int x = px; x < N; x++) {
            for (int y = (x == px ? py : 0); y < M; y++) {
                if (c[x][y]) continue;
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                        if (c[nx][ny]) flag = false;
                    }
                }

                if (flag) {
                    c[x][y] = true;
                    go(cnt + 1, sum + grid[x][y], x, y);
                    c[x][y] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        int[] read = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        N = read[0];
        M = read[1];
        K = read[2];
        grid = new int[N][M];
        c = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        go(0, 0, 0, 0);

        bw.write(ans + "\n");
        bw.flush();
    }
}
