package doit.graph;

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
    /* 예상 못한 에러를 만난 내 코드, 계속 풀어보려 했는데 안 풀린다. */
    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        int m = Integer.parseInt(st.nextToken()); //신뢰 관계 개수
        ArrayList<Integer>[] a = new ArrayList[n + 1]; //컴퓨터 관계 그래프
        for (int i = 1; i < n + 1; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); //컴퓨터 번호
            int t = Integer.parseInt(st.nextToken()); //c가 신뢰하는 컴퓨터 번호
            a[t].add(c);
        }
        int[] visited = new int[n + 1]; //BFS로 신뢰도가 체크될 때마다 신뢰받는 컴퓨터 개수를 갱신할 배열
        bfs(a, visited);
        int maxVal = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] > maxVal) {
                maxVal = visited[i];
                result.add(i);
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == maxVal) result.add(i);
        }
        result.sort((v1, v2) -> v1 - v2);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    private static void bfs(ArrayList<Integer>[] a, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < a.length; i++) {
            for (Integer now : a[i]) {
                if (visited[now] == 0) visited[now]++;
                q.add(now);
                while (!q.isEmpty()) {
                    Integer trusted = q.poll();
                    if (visited[trusted] == 0) visited[trusted] = visited[now] + 1;
                }
            }
        }
    }
}*/
