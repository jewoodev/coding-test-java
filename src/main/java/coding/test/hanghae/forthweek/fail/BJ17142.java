package coding.test.hanghae.forthweek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
(0, 0)부터 BFS 해서 치즈 모서리를 만날 때마다 값을 2로 바꿔 녹이는 방법으로 로직을 구성한다.
 */

public class BJ17142 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, times, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static List<Point> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        answer = Integer.MAX_VALUE;

        initMap(); // 맵 정보 저장
        DFS(0, 0, 0);

        System.out.println(answer);
    }

    static void initMap() throws IOException {
        int zeroCnt = 0;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) virus.add(new Point(r, c));
                else if (map[r][c] == 0) zeroCnt++;
            }
        }
        if (zeroCnt == 0) {
            System.out.println(0);
            System.exit(0);
        }
    }

    static void DFS(int i, int j, int virusCnt) {
        if (virusCnt == M) {
            BFS();
            if (checkInfection()) {
                answer = Math.min(answer, times);
            } else answer = -1;
        }
        else {
            for (int r = i; r < N; r++) {
                for (int c = j; c < N; c++) {
                    if (map[r][c] == 0) {
                        map[r][c] = 2;
                        DFS(r, c, virusCnt++);
                        map[r][c] = 0;
                    }
                }
            }
        }
    }


    static void BFS() {
        Queue<Point> q = new LinkedList<>();
        for (Point point : virus) {
            q.offer(point);
            visited[point.r][point.c] = true;
        }

        times = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];

                if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
                if (!visited[nR][nC]) {
                    if (map[nR][nC] == 0) {
                        visited[nR][nC] = true;
                        map[nR][nC] = 2;
                        q.offer(new Point(nR, nC));
                    }
                }
            }
            times++;
        }
    }

    private static boolean checkInfection() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 0) return false;
            }
        }
        return true;
    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
