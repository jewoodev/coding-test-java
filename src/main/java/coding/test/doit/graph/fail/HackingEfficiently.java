package coding.test.doit.graph.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HackingEfficiently {

    /* 예상 못한 에러를 만난 내 코드, 계속 풀어보려 했는데 안 풀린다. */
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
}
