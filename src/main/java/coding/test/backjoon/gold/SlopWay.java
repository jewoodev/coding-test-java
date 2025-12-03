package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class SlopWay { // https://www.acmicpc.net/problem/14890, 구현
    private static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        boolean[][] c = new boolean[n][n]; // 경사로 유무

        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 행 검사.
            if (canPass(map[i])) ans++;
        }
        for (int j = 0; j < n; j++) {
            // 열 검사.
            int[] col = new int[n];
            for (int i = 0; i < n; i++)
                col[i] = map[i][j];
            if (canPass(col)) ans++;
        }

        System.out.println(ans);
    }

    private static boolean canPass(int[] a) {
        // 한 줄 검사.
        boolean[] c = new boolean[n];
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != a[i]) { // 인접한 칸의 높이가 다르면
                int diff = Math.abs(a[i] - a[i - 1]);
                if (diff != 1) // 낮은 칸과 높은 칸의 높이 차는 1이어야 한다.
                    return false;

                if (a[i - 1] < a[i]) {
                    for (int j = 1; j <= l; j++) {
                        if (i - j < 0) // 경사로를 놓다가 범위를 벗어나는 경우.
                            return false;

                        if (a[i - 1] != a[i - j]) // 낮은 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우.
                            return false;

                        if (c[i - j]) // 경사로가 이미 놓여져 있는 경우.
                            return false;

                        c[i - j] = true;
                    }
                } else {
                    // a[i - 1] > a[i]
                    for (int j = 0; j < l; j++) {
                        if (i + j >= n)
                            return false;

                        if (a[i] != a[i + j])
                            return false;

                        if (c[i + j])
                            return false;

                        c[i + j] = true;
                    }
                }
            }
        }
        return true;
    }
}
