package hanghae.forthweek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ4485 {
    private static int N, K, answer = 0;
    private static int[][] cave; // 동굴
    private static boolean[][] visited;
    private static List<Integer> list = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dR = {-1, 1, 0, 0};
    private static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); // 원생 수
        while (true) {
            init(); // 테스트 케이스마다 초기화
            BFS();
            if ((N = Integer.parseInt(br.readLine())) == 0) break;
        }
        System.out.print(answer);
    }

    private static void init() throws IOException {
        visited = new boolean[N][N];
        cave = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                cave[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void BFS() {
        Queue<Link> q = new ArrayDeque<>(125);
        q.offer(new Link(0, 0, cave[0][0]));

        while (!q.isEmpty()) {
            Link now = q.poll();

            // 출구에 도달할 때마다 min 값 갱신
            if (now.r == N - 1 && now.c == N - 1) {
                answer = Math.min(answer, now.money);
            }

            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];
                if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
                if (visited[nR][nC]) continue;
                visited[nR][nC] = true;
                q.offer(new Link(nR, nC, now.money + cave[nR][nC]));
            }
        }
    }

    private static class Link {
        // 좌표 위치, 금액
        int r, c, money;
        private Link(int r, int c, int money) {
            this.r = r;
            this.c = c;
            this.money = money;
        }
    }
}