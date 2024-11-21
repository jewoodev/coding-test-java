package coding.test.hanghae.forthweek.why;

import java.io.*;
import java.util.*;

public class BJ17142 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 연구소 크기, 활성화할 바이러스 개수, 최소시간, 빈 칸 갯수
    static int N, M, answer, zeroCnt;
    // 연구소 맵
    static int[][] map;
    // 조합의 경우를 저장할 배열
    static Point[] choose;
    // 방문 처리용 배욜
    static boolean[][] visited;

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    // 바이러스 위치를 저장해둘 리스트
    static List<Point> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init(); // 초기 세팅
        DFS(0, 0);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵 크기
        M = Integer.parseInt(st.nextToken()); // 활성화되는 바이러스 개수
        map = new int[N][N]; // 연구소 맵
        choose = new Point[M]; // 활성화 바이러스를 담을 배열
        answer = Integer.MAX_VALUE;
        zeroCnt = 0;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) {
                    map[r][c] = -2;
                    virus.add(new Point(r, c));
                }
                else if (map[r][c] == 0) zeroCnt++;
                else if (map[r][c] == 1) map[r][c] = -1;
            }
        }
    }

    static void DFS(int start, int virusCnt) {
        if (virusCnt == M) {
            BFS();
            return;
        }
        else {
            for (int i = start; i < virus.size(); i++) {
                choose[virusCnt] = virus.get(i);
                DFS(i + 1, virusCnt + 1);
            }
        }
    }


    static void BFS() {
        // 이번 탐색에 쓸 map 정보, mapCopied
        int[][] mapCopied = new int[N][N];
        for (int i = 0; i < N; i++) {
            mapCopied[i] = Arrays.copyOf(map[i], N);
        }

        visited = new boolean[N][N];
        Queue<Point> q = new LinkedList<>();
        for (Point point : choose) { // 이번 조합의 활성화 바이러스 정보를 큐에 넣고 맵은 0으로 바꾼다
            q.offer(point);
            mapCopied[point.r][point.c] = 0;
            visited[point.r][point.c] = true;
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];

                if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue; // 맵밖
                if (visited[nR][nC]) continue; // 방문된 곳이면 넘기고
                if (mapCopied[nR][nC] == -1) continue; // 벽이면 넘기고
                if (mapCopied[nR][nC] == 0) cnt++; // 빈칸을 방문하면 카운트
                visited[nR][nC] = true;
                mapCopied[nR][nC] = mapCopied[now.r][now.c] + 1; // 소요시간 저장
                q.offer(new Point(nR, nC));
            }

            // 이번 탐색에서 바이러스 완전 감염이 불가능하면 return
            if (cnt != zeroCnt) return;

            // 바이러스 위치에 갱신될 수 있는 감염 소요시간은 0으로 초기화
            for (int i = 0; i < virus.size(); i++) {
                mapCopied[virus.get(i).r][virus.get(i).c] = 0;
            }

            // 연산된 시간 중 최대 시간 찾기
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (max < mapCopied[i][j])
                        max = mapCopied[i][j];
                }
            }

            // 탐색된 결과로 answer 갱신
            answer = Math.min(answer, max);
        }
    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
