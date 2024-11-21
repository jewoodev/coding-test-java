package coding.test.doit.graph.bellman;

import java.io.*;
import java.util.*;

//p338 타임머신으로 빨리 가기 / 백준 11657
public class GoFastWithTimeMachine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int m = Integer.parseInt(st.nextToken()); //버스 노선의 개수
        Edge[] edges = new Edge[m + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nS = Integer.parseInt(st.nextToken());
            int nE = Integer.parseInt(st.nextToken());
            int nW = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(nS, nE, nW);
        }

        //벨만-포드
        long[] d = new long[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;
        for (int i = 1; i < n; i++) { //n보다 1개 적은 수만큼 반복
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                //더 작은 최단 거리가 있을 때 업데이트
                if (d[edge.start] != Integer.MAX_VALUE
                        && d[edge.end] > d[edge.start] + edge.weight) {
                    d[edge.end] = d[edge.start] + edge.weight;
                }
            }
        }
        boolean mCycle = false;
        for (int i = 0; i < m; i++) { //음수 사이클 확인
            Edge edge = edges[i];
            if (d[edge.start] != Integer.MAX_VALUE
                    && d[edge.end] > d[edge.start] + edge.weight) {
                mCycle = true;
            }
        }

        if (!mCycle) {
            for (int i = 2; i <= n; i++) {
                if (d[i] == Integer.MAX_VALUE)
                    bw.write("-1\n");
                else
                    bw.write(d[i] + "\n");
            }
        } else {
            bw.write("-1\n");
        }
        bw.close();
        br.close();
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
