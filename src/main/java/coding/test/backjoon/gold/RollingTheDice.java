package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RollingTheDice { // https://www.acmicpc.net/problem/14499, 구현
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dice;
    private static int[][] map;
    private static int n, m, x, y, k;
    private static StringBuilder ans = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        rolling();
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        dice = new int[7];
    }

    private static void rolling() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int next = Integer.parseInt(st.nextToken());
            int nx = x + dx[next - 1];
            int ny = y + dy[next - 1];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            switch (next) {
                case 1 -> east();
                case 2 -> west();
                case 3 -> north();
                case 4 -> south();
            }
            x = nx;
            y = ny;
            if (map[x][y] == 0) map[x][y] = dice[6];
            else {
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            ans.append(dice[1]).append("\n");
        }
        System.out.println(ans);
    }

    private static void east() {
        int temp = dice[1];
        dice[1] = dice[4];
        dice[4] = dice[6];
        dice[6] = dice[3];
        dice[3] = temp;
    }

    private static void west() {
        int temp = dice[1];
        dice[1] = dice[3];
        dice[3] = dice[6];
        dice[6] = dice[4];
        dice[4] = temp;
    }

    private static void north() {
        int temp = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[6];
        dice[6] = dice[2];
        dice[2] = temp;
    }

    private static void south() {
        int temp = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[6];
        dice[6] = dice[5];
        dice[5] = temp;
    }
}
