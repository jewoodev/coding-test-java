package coding.test.doit.graph.unionfind;

import java.io.*;
import java.util.StringTokenizer;

public class RepresentSet { /* P282 문제 50, 백준 1717번. 집합 표현하기 */
    /* 해설 본 후 고친 풀이 */

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
                if (checkSame(a, b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.close();
        br.close();
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (b > a) g[b] = g[a];
        else g[a] = g[b];
    }

    private static int find(int i) {
        if (g[i] == i) return i;
        else return g[i] = find(g[i]);
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        else return false;
    }
}

