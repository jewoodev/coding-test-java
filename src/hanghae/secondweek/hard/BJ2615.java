package hanghae.secondweek.hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2615 {

    public static int[][] arr = new int[19][19];
    public static boolean[][] visited = new boolean[19][19];
    public static int[] dR = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static int[] dC = {1, 1, 1, 0, -1, -1, -1, 0};
    public static int winner = 0;
    public static boolean over = false; // 5목을 넘어서는지 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int row = 0; row < 19; row++) {
            for (int col = 0; col < 19; col++) {
                if (arr[row][col] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        over = false;
                        DFS(new Node(row, col, arr[row][col]), 1, dir);
                        if (!over) { // 5목을 넘어서지 않은 경우
                            // 반대방향에서도 넘어서지 않는지 확인
                            int nr = row + dR[dir + 4];
                            int nc = col + dC[dir + 4];
                            int color = arr[row][col];
                            if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
                                if (arr[nr][nc] == color) {
                                    winner = 0;
                                }
                            }
                            if (winner != 0) {
                                System.out.println(winner);
                                System.out.println((row + 1) + " " + (col + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(winner);
    }
    
    public static void DFS(Node start, int level, int dir) {
        if (level == 5) {
            int nR = start.r + dR[dir];
            int nC = start.c + dC[dir];
            int color = start.color;

            if (nR < 0 || nR >= 19 || nC < 0 || nC >= 19) {
                winner = start.color;
                return;
            }

            if (arr[nR][nC] != color) {
                winner = start.color;
                return;
            }

            if (arr[nR][nC] == color) { // 5목을 넘어 6목인 경우
                over = true;
                return;
            }
        }

        int nR = start.r + dR[dir];
        int nC = start.c + dC[dir];
        int color = start.color;
        if (nR < 0 || nR >= 19 || nC < 0 || nC >= 19) return;
        if (arr[nR][nC] != color) return;
        if (visited[nR][nC]) return;

        visited[nR][nC] = true;
        DFS(new Node(nR, nC, color), level + 1, dir);
        if (!over) {
            visited[nR][nC] = false;
        }
    }

    private static class Node {
        int r, c, color;
        public Node(int r, int c, int color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
}