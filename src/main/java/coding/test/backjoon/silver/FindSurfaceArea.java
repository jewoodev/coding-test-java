package coding.test.backjoon.silver;

import java.util.*;
import java.io.*;

public class FindSurfaceArea { // https://www.acmicpc.net/problem/16931, 구현
    private static int[] dx = {0,0,0,0,-1,1};
    private static int[] dy = {0,0,-1,1,0,0};
    private static int[] dz = {-1,1,0,0,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // '각 칸에 쌓인 정육면체 개수'와 '각 위치의 정육면체 유무'를 저장
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] pentUp = new int[102][102]; // '각 칸에 쌓인 정육면체 개수'
        boolean[][][] isExist = new boolean[102][102][102]; // '각 위치의 정육면체 유무'
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                pentUp[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 1; k <= pentUp[i][j]; k++)
                    isExist[i][j][k] = true;
                }
        }

        // pentUp을 이용해 쌓인 정육면체를 모두 순회하며
        int ans = 0;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                for (int z = 1; z <= pentUp[y][x]; z++) {
                    for (int k = 0; k < 6; k++) { // 상하좌우앞뒤를 조회해
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        int nz = z + dz[k];
                        if (isExist[ny][nx][nz] == false) // 정육면체가 있지 않으면
                            ans++; // 겉넓이에 추가
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
