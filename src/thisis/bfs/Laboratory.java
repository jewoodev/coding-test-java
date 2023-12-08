package thisis.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
    private static int row, col;
    private static int[][] laborMap;
    private static int[][] infected;

    static int maxSpace = Integer.MIN_VALUE;//최대값을 찾기 위한 최소값 설정
    static Queue<int[]> q;
    private static int[] dx = {-1, 1, 0 ,0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException { //p341
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        laborMap = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                laborMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        bw.write(String.valueOf(maxSpace));
        br.close();
        bw.close();
    }

    private static void dfs(int wallCnt) { //벽세우기
        if (wallCnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (laborMap[i][j] == 0) {
                    laborMap[i][j] = 1;
                    dfs(wallCnt + 1);
                    laborMap[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() { //바이러스 퍼진 후 안전영역 초기화
        q = new LinkedList<>();
        initMap();

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && infected[nx][ny] == 0) {
                    infected[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (infected[i][j] == 0) {
                    cnt++;
                }
            }
        }
        maxSpace = Math.max(maxSpace, cnt);
    }

    private static void initMap() {
        infected = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                infected[i][j] = laborMap[i][j];

                if (infected[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
    }
}
