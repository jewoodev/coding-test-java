package coding.test.backjoon.silver;

import java.util.*;
import java.io.*;

public class RestoreArray { // http://acmicpc.net/problem/16967, 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] b = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[][] a = restore(b, h, w, x, y);

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans.append(a[i][j]).append(" ");
            }
            ans.append("\n");
        }
        System.out.print(ans);
    }

    private static int[][] restore(int[][] b, int h, int w, int y, int x) {
        int[][] a = new int[h][w];

        // 겹치지 않은 영역 채우기.
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = b[i][j];
            }
        }
        for (int i = 1; i < h; i++) {
            for (int j = 0; j < x; j++) {
                a[i][j] = b[i][j];
            }
        }

        // 겹치는 영역 채우기.
        for (int i = y; i < h; i++) {
            for (int j = x; j < w; j++) {
                a[i][j] = b[i][j] - a[i - y][j - x];
            }
        }

        return a;
    }
}
