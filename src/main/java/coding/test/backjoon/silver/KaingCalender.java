package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class KaingCalender { // https://www.acmicpc.net/problem/6064, 브루트 포스 & 중국인의 나머지 정리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1; // 중국인의 나머지 정리를
            int y = Integer.parseInt(st.nextToken()) - 1; // 적용

            boolean flag = false;
            for (int j = x; j < m * n; j += m) { // x, y 중에 하나는 고정하고 나머지 하나가 맞춰지는지 확인해봐도 됨
                if (j % n == y) { // i를 x로 고정하고 j를 m씩 늘리면서 y와 일치하면 출력
                    sb.append(j + 1).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) sb.append("-1\n");
        }

        System.out.print(sb);
    }
}
