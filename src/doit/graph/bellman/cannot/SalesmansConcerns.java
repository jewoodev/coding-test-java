package doit.graph.bellman.cannot;

import java.io.*;
import java.util.*;

//p344 세일즈맨의 고민 / 백준 1219
public class SalesmansConcerns {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int s = Integer.parseInt(st.nextToken()); //시작 도시
        int e = Integer.parseInt(st.nextToken()); //도착 도시
        int m = Integer.parseInt(st.nextToken()); //교통 수단의 개수
        Edge[] edges = new Edge[m];
        long[] result = new long[n];
        Arrays.fill(result, Long.MIN_VALUE);
        result[s] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nS = Integer.parseInt(st.nextToken());
            int nE = Integer.parseInt(st.nextToken());
            int nC = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(nS, nE, nC);
        }

        st = new StringTokenizer(br.readLine());
        int[] earn = new int[n];
        for (int i = 0; i < n; i++) {
            earn[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                if (result[edge.start] != Long.MIN_VALUE
                        && result[edge.end] < result[edge.start] - edge.cost + earn[edge.end]) {
                    result[edge.end] = result[edge.start] - edge.cost + earn[edge.end];
                }
            }
        }
        boolean isCycle = false;
        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            if (result[edge.start] != Long.MIN_VALUE
                    && result[edge.end] < result[edge.start] - edge.cost + earn[edge.end]) {
                isCycle = true;
            }
        }

        if (isCycle) {
            for (int i = s + 1; i <= n - 1; i++) {
                if (result[i] == Long.MIN_VALUE) {
                    System.out.println("gg");
                    break;
                }
            }
            System.out.println("Gee");
        } else {
            System.out.println(result[e]);
        }
        br.close();
    }

    private static class Edge {
        int start;
        int end;
        int cost;
        public Edge(int s, int e, int c) {
            start = s;
            end = e;
            cost = c;
        }
    }
}
