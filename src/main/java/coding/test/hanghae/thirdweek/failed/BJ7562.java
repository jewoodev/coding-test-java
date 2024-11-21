package coding.test.hanghae.thirdweek.failed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
# 요구사항 정리 #
1. 체스판 한 변의 길이와 나이트의 현재 위치, 이동하려는 위치가 주어진다.
2. 최소 몇 번만에 이동할 수 있는지 구하라.

# 풀이 논리 #
1. 현재 위치에서 BFS해서 최소 이동 횟수를 구한다.
*/

class BJ7562 {
    private static StringBuilder sb = new StringBuilder();
    private static int length, T, sR, sC, eR, eC;
    private static boolean[][] visited;
    private static int[] dR = {-2, 2, -1, 1};
    private static int[] dC = {-1, 1, -2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        for (int i = 0; i < T; i++) {
            length = Integer.parseInt(br.readLine());
            visited = new boolean[length][length];
            StringTokenizer st = new StringTokenizer(br.readLine());
            sR = Integer.parseInt(st.nextToken()); // 시작 위치 x
            sC = Integer.parseInt(st.nextToken()); // 시작 위치 y
            st = new StringTokenizer(br.readLine());
            eR = Integer.parseInt(st.nextToken()); // 도착 위치 x
            eC = Integer.parseInt(st.nextToken()); // 도착 위치 y
            BFS(sR, sC);
        }
        System.out.println(sb);
    }

    private static void BFS(int r, int c) {
        int cnt = 0;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(r, c)); // 시작 정점을 큐에 넣고
        visited[r][c] = true; // 시작 정점을 방문 처리
        while (!q.isEmpty()) {
            Point p = q.poll(); // 이번에 방문한 포인트
            for (int i = 0; i < 4; i++) {
                int nR = p.r + dR[i]; // 현재 좌표에서 이동할 수 있는 행
                int nC = p.c + dC[i]; // 열
                if (nR < 0 || nR >= length || nC < 0 || nC >= length || visited[nR][nC]) continue; // 이동이 불가능한지 확인
                if (nR == eR && nC == eC) {
                    sb.append(cnt).append("\n");
                }
                visited[nR][nC] = true;
                cnt++;
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