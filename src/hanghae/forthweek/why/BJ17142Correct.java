package hanghae.forthweek.why;

import java.util.*;
import java.io.*;

public class BJ17142Correct {
    // 연구소 크기, 바이러스 개수, 최소시간, 연구소 빈칸(0)의 갯수
    static int N, M, zeroCount, answer;
    // 연구소 맵, 연구소 맵 복사
    static int[][] map, mapCopied;
    // 조합에서 M개만큼 뽑아내어 담아낼 배열
    static Point[] choose;

    static int[] dR = { -1, 0, 1, 0 };
    static int[] dC = { 0, 1, 0, -1 };

    // 바이러스 위치를 저장해둘 리스트
    static List<Point> virus = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 초기화
        init();
        // 문제 풀이
        DFS(0, 0);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    // 초기화
    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        mapCopied = new int[N][N];
        choose = new Point[M];
        answer = Integer.MAX_VALUE;
        virus = new ArrayList<>();
        zeroCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                    map[i][j] = -2;
                } else if (map[i][j] == 1) {
                    // 현재 벽이라면 map 에 -1로 기록
                    map[i][j] = -1;
                } else {
                    // 빈 칸 갯수 기록
                    zeroCount++;
                }
            }
        }
    }

    // 조합 함수
    static void DFS(int start, int virusCnt) {
        if (virusCnt == M) {
            // 조합이 생성되면 바이러스 bfs 탐색
            BFS();
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            choose[virusCnt] = virus.get(i);
            DFS(i + 1, virusCnt + 1);
        }
    }

    // bfs 함수
    static void BFS() {
        // 이번 bfs에서 사용할 map 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mapCopied[i][j] = map[i][j];
            }
        }

        boolean[][] visited = new boolean[N][N];	// 방문 배열
        Queue<Point> q = new LinkedList<>();	// 바이러스 큐 생성
        // 조합에서 M개 뽑아낸 바이러스를 큐에 삽입, map에는 0으로 기록
        for (Point point : choose) {
            q.offer(point);
            mapCopied[point.r][point.c] = 0;
            visited[point.r][point.c] = true;
        }

        int count = 0;	// 빈칸(0)에 몇번 방문했는지 체크
        while (!q.isEmpty()) {
            Point now = q.poll();
            // 상, 우, 하, 좌 탐색
            for (int i = 0; i < 4; i++) {
                int nR = now.r + dR[i];
                int nC = now.c + dC[i];
                // 범위 나가면 탐색 X
                if (nR < 0 || nR >= N || nC < 0 || nC >= N) {
                    continue;
                }
                // 이미 방문했으면 탐색 X
                if (visited[nR][nC]) {
                    continue;
                }
                // 벽이면 탐색 X
                if (mapCopied[nR][nC] == -1) {
                    continue;
                }
                // 빈 칸(0)이면 count 증가
                if (mapCopied[nR][nC] != -2) {
                    count++;
                }
                mapCopied[nR][nC] = mapCopied[now.r][now.c] + 1; // 이전위치에서 +1 한 값을 map에 기록
                visited[nR][nC] = true;	// 방문처리
                q.offer(new Point(nR, nC));	// 큐에 삽입
            }
        }

        // 이번 탐색에서 빈칸에 바이러스를 모두 퍼뜨릴수 없을 경우 return
        if (count != zeroCount) {
            return;
        }

        // map에서 방문 시간을 체크하기 전, 비활성화된 바이러스들은 방문 시간에 포함되지 않으므로 0으로 초기화
        for (int i = 0; i < virus.size(); i++) {
            mapCopied[virus.get(i).r][virus.get(i).c] = 0;
        }

        // map에서 최대 시간 찾기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (max < mapCopied[i][j]) {
                    max = mapCopied[i][j];
                }
            }
        }

        // 이번 최대 시간이 전체 시간 중 최소인지 비교
        if (max < answer) {
            answer = max;
        }
    }

    // 큐에 바이러스 위치를 넣을때 사용할 Point 클래스
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
