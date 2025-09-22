package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NMAndK1 { // https://www.acmicpc.net/problem/18290, 브루트 포스 & 백트래킹
    private static boolean[][] selected;
    private static int[][] board;
    private static int ans, n, m, k;
    // 상하좌우 방향 벡터
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        selected = new boolean[n][m];
        board = new int[n][m];
        ans = Integer.MIN_VALUE; // 음수가 있을 수 있으므로 최솟값으로 초기화

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작
        backtrack(0, 0, 0, 0);

        System.out.println(ans);
    }

    private static void backtrack(int cnt, int sum, int startY, int startX) {
        // K개를 모두 선택한 경우
        if (cnt == k) {
            ans = Math.max(ans, sum);
            return;
        }

        // 모든 칸을 순회하면서 선택 가능한 칸 찾기
        for (int y = startY; y < n; y++) {
            // 같은 행에서는 startX부터, 다른 행에서는 0부터 시작
            int x = (y == startY) ? startX : 0;

            for (; x < m; x++) {
                if (canSelect(y, x)) {
                    // 현재 칸 선택
                    selected[y][x] = true;

                    // 다음 칸부터 탐색 (중복 방지)
                    int nextY = y;
                    int nextX = x + 1;
                    if (nextX == m) {
                        nextY++;
                        nextX = 0;
                    }

                    backtrack(cnt + 1, sum + board[y][x], nextY, nextX);

                    // 선택 취소 (백트래킹)
                    selected[y][x] = false;
                }
            }
        }
    }

    // 현재 칸을 선택할 수 있는지 확인
    private static boolean canSelect(int y, int x) {
        if (selected[y][x]) return false;

        // 인접한 칸이 선택되어 있는지 확인
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (selected[ny][nx]) {
                    return false;
                }
            }
        }

        return true;
    }
}
