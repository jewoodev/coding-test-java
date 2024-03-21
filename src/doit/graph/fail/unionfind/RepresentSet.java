package doit.graph.fail.unionfind;

import java.io.*;
import java.util.StringTokenizer;

public class RepresentSet { /* P282 문제 50, 백준 1717번. 집합 표현하기 */

    /* 풀었는데 13퍼센트인가 오답 터짐, 그래서 해설 확인 */
    private static int[] g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        g = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (o == 0) {
                union(a, b);
            } else {
                if (g[a] == g[b]) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.close();
        br.close();
    }

    private static void union(int a, int b) {
        if (g[a] < g[b]) g[b] = g[a];
        else g[a] = g[b];
    }
}

