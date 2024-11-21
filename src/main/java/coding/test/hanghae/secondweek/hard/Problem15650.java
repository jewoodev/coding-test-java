package coding.test.hanghae.secondweek.hard;

import java.io.*;
import java.util.*;

class Problem15650 {
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visited = new boolean[n];
        dfs(n, m, 0);
        bw.close();
    }

    private static void dfs(int n, int m, int depth) throws IOException {
        if (depth == m) {
            for (int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                if (depth < 1)
                    arr[depth] = i + 1;
                else if (arr[depth - 1] > i + 1)
                    continue;
                else
                    arr[depth] = i + 1;
                visited[i] = true;
                dfs(n, m, depth+1);
                visited[i] = false;
            }
        }
    }
}