package doit.graph.bellman.cannot;

import java.io.*;
import java.util.*;

public class GoFastWithTimeMachine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int m = Integer.parseInt(st.nextToken()); //버스 노선의 개수
        List<Edge>[] a = new List[n + 1]; //노선 저장 배열

        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nS = Integer.parseInt(st.nextToken());
            int nE = Integer.parseInt(st.nextToken());
            int nW = Integer.parseInt(st.nextToken());
            a[nS].add(new Edge(nS, nE, nW));
        }

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (!visited[now]) visited[now] = true;
            for (Edge next : a[now]) {
                if (d[now] + next.weight < d[next.end] && visited[next.start]) {
                    d[next.end] = d[now] + next.weight;
                    q.offer(next.end);
                }
            }
        }
    }

    private static class Edge {
        int start;
        int end;
        int weight;
        public Edge(int s, int e, int w) {
            start = s;
            end = e;
            weight = w;
        }
    }
}
