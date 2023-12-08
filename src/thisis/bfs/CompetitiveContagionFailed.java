package thisis.bfs;

import java.io.*;
import java.util.StringTokenizer;

public class CompetitiveContagionFailed {

    private static int k;
    private static int n;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //줄의 개수
        n = Integer.parseInt(st.nextToken());
        //바이러스 개수
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) { // 시험관 초기값 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    private static void dfs() {
        while (checkProcess()) {

        }
    }

    private static boolean checkProcess() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) return true;
            }
        }
        return false;
    }

    private static void contagion() {
        for (int i = 1; i <= k; i++) { //번호가 작은 바이러스부터
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (map[j][l] == k) {
                        for (int m = 0; m < 4; m++) { //인접한 곳에 퍼트린다
                            int nx = j - dx[m];
                            int ny = j - dy[m];

                            if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                                map[nx][ny] = k;
                            }
                        }
                    }
                }
            }
        }
    }
}
