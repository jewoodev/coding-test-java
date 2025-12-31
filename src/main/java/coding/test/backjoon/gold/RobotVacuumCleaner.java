package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RobotVacuumCleaner { // https://www.acmicpc.net/problem/14503, 구현 & 시뮬레이션
    private static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    private static int[] dc = {0, 1, 0, -1};
    private static int[][] map;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(clean(r, c, dir));
    }

    private static int clean(int r, int c, int dir) {
        int count = 0;

        while (true) {
            // 1. 현재 칸이 청소되지 않은 경우 청소
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소 완료 표시
                count++;
            }

            // 2. 주변 4칸 중 청소되지 않은 빈 칸 확인
            boolean hasUncleanedCell = false;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (isValid(nr, nc) && map[nr][nc] == 0) {
                    hasUncleanedCell = true;
                    break;
                }
            }

            if (!hasUncleanedCell) {
                // 2-1. 청소되지 않은 빈 칸이 없는 경우
                // 후진 방향 계산 (현재 방향의 반대)
                int backDir = (dir + 2) % 4;
                int br = r + dr[backDir];
                int bc = c + dc[backDir];

                if (isValid(br, bc) && map[br][bc] != 1) {
                    // 후진 가능
                    r = br;
                    c = bc;
                } else {
                    // 2-2. 후진 불가능 - 작동 멈춤
                    break;
                }
            } else {
                // 3. 청소되지 않은 빈 칸이 있는 경우
                // 3-1. 반시계 방향으로 90도 회전
                dir = (dir + 3) % 4;

                // 3-2. 앞쪽 칸이 청소되지 않은 빈 칸이면 전진
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (isValid(nr, nc) && map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
                // 아니면 1번으로 (다시 회전 시도)
            }
        }

        return count;
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
