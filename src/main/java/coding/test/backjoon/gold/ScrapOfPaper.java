package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class ScrapOfPaper { // https://www.acmicpc.net/problem/14391, 브루트 포스 | 비트마스킹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int ans = 0;

        // 0: -, 1: | / 비트마스킹으로 가로 조각과 세로 조각의 집합들의 경우들을 생성
        for (int s = 0; s < (1 << (n * m)); s++) {
            int sum = 0;

            // 0: - (가로) 조각 의 합 계산
            for (int i = 0; i < n; i++) {
                int cur = 0;
                for (int j = 0; j < m; j++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) == 0) {
                        cur = cur * 10 + a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur; // 한 줄이 모두 가로인 경우, else 문에 들어가지 못하므로 덧셈 처리
            }

            // 1: | (세로) 조각의 합 계산
            for (int j = 0; j < m; j++) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) != 0) {
                        cur = cur * 10 + a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
