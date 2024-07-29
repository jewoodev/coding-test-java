package hanghae.forthweek.fail;

import java.io.*;
import java.util.*;

class BJ16236 {
    static int[] dR = new int[] {0, 0, -1, 1};
    static int[] dC = new int[] {-1, 1, 0, 0};
    static Shark shark, lastShark;
    static int n, eatCnt, time; // 맵 크기, 먹은 횟수, 걸린 시간
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        // 맵 정보 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) shark = new Shark(i, j, 0);
            }
        }

        BFS();
        if (eatCnt > 0) System.out.println(lastShark.time);
        else System.out.println(0);
    }

    static void BFS() {
        Queue<Shark> q = new LinkedList<>();
        q.offer(shark);
        boolean[][] visited = new boolean[n][n];
        visited[shark.r][shark.c] = true; // 시작점 방문 처리
        eatCnt = 0;
        time = 0;

        while (!q.isEmpty()) {
            Shark now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];

                if (nR < 0 || nC < 0 || nR >= n || nC >= n || visited[nR][nC]) continue;
                if (map[nR][nC] != 0 && map[nR][nC] < 9) eatCnt++;
                visited[nR][nC] = true;
                q.offer(new Shark(nR, nC, now.time + 1));
            }
            lastShark = now;
        }
    }

    static class Shark {
        int r, c, time;
        Shark(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
