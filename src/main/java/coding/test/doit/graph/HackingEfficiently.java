package coding.test.doit.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HackingEfficiently { /* P265 문제 47, 백준 1325번. 효율적으로 해킹하기 */
    private static int n, m;
    private static boolean[] visited;
    private static int[] answer;
    private static ArrayList<Integer>[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        int m = Integer.parseInt(st.nextToken()); //신뢰 관계 개수
        a = new ArrayList[n + 1];
        answer = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
        }
        for (int i = 1; i < n + 1; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }
        int maxVal = 0;
        for (int i = 1; i < n + 1; i++) {
            if (maxVal < answer[i]) maxVal = answer[i];
        }
        for (int i = 1; i < n + 1; i++) {
            if (answer[i] == maxVal) bw.write(i + " ");
        }
        bw.close();
        br.close();
    }

    private static void bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (Integer i : a[nowNode]) {
                if (visited[i] == false) {
                    visited[i] = true;
                    answer[i]++;
                    q.add(i);
                }
            }
        }
    }

    private static void dfs(int index) {
        visited[index] = true;
        for (Integer i : a[index]) {
            if (visited[i]) continue;
            answer[i]++;
            dfs(i);
        }
    }
}

