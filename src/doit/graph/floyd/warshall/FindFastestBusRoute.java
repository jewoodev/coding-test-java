package doit.graph.floyd.warshall;

import java.io.*;
import java.util.*;

/** p354 문제 61 가장 빠른 버스 노선 구하기, 백준 11404
 *
 */

class FindFastestBusRoute {

    private static int N; // 도시 개수
    private static int M; // 노선 개수

    private static int distance[][];

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) { // 인접 행렬 초기화
            for (int j = 1; j <= N; j++) {
                if (i != j) distance[i][j] = 10000001;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (distance[s][e] > v) distance[s][e] = v;
        }

        floydWarshall();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == 10000001) sb.append("0 ");
                else sb.append(distance[i][j]).append(" ");
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}
