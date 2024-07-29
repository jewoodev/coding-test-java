package hanghae.thirdweek.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
# 요구사항 정리 #
1. 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
2. 적록색약이 있는 사람과 없는 사람이 그림을 봤을 때 색깔 별로 구역을 몇 개로 나눌 수 있는지 구하라.

# 풀이 논리 #
1. (0, 0) 의 위치부터 그림의 좌표마다 BFS하면서 같은 색인 경우 방문 처리함으로써
2. 방문 처리되지 않은 좌표를 찾을 때마다 새로운 색의 구역이 시작되는 것으로 간주한다.
*/

class BJ10026 {
    private static StringBuilder sb = new StringBuilder();
    private static char[][] color;
    private static boolean[][] visited;
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 그리드 크기 N
        visited = new boolean[N][N];
        color = new char[N][N]; // 보통 색 정보를 저장할 배열
        // 색 정보 저장
        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < N; c++) {
                color[r][c] = input.charAt(c);
            }
        }

        // 정상
        int section = 0; // 구역의 개수
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) { // 방문 되지 않은 곳을 찾을 때마다
                    section++; // 새로운 구역을 찾은 것
                    BFS(r, c); // 그 곳에서 BFS
                }
                // 적록색약인 경우를 확인하기 위해 탐색이 끝난 포인트는 색을 바꿔준다.
                if (color[r][c] == 'R') color[r][c] = 'G';
            }
        }
        sb.append(section).append(" ");

        // 적록색약
        section = 0;
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    section++;
                    BFS(r, c);
                }
            }
        }
        sb.append(section);
        System.out.println(sb);
    }

    private static void BFS(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c)); // 시작 정점을 큐에 넣고
        visited[r][c] = true; // 시작 정점을 방문 처리
        while (!q.isEmpty()) {
            Point p = q.poll(); // 이번에 방문한 포인트
            for (int i = 0; i < 4; i++) {
                int nR = p.r + dR[i]; // 현재 좌표에서 이동할 수 있는 행
                int nC = p.c + dC[i]; // 열
                if (nR < 0 || nR >= N || nC < 0 || nC >= N) continue; // 이동이 불가능한지 확인
                if (visited[nR][nC] || color[p.r][p.c] != color[nR][nC]) continue; // 방문 여부와 같은 색인지를 확인
                visited[nR][nC] = true; // 두 조건을 만족하면
                q.offer(new Point(nR, nC)); // 다음 방문할 포인트로 지정
            }
        }
    }

    private static class Point {
        int r, c;
        private Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}