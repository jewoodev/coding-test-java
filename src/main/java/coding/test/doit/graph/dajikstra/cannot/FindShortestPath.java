package coding.test.doit.graph.dajikstra.cannot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//최단 경로 구하기 p319 백준 1753
//방문 체크를 모두 했을 때 반복을 멈추는 것으로 하는게 맞을까?
public class FindShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Edge>> A = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            A.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A.get(u).add(new Edge(v, w));
        }
        int[] D = new int[V + 1];
        for (int i = 0; i < V; i++) {
            D[i] = Integer.MAX_VALUE;
        }
        D[S] = 0;
        boolean[] visited = new boolean[V + 1];
    }

    private static class Edge {
        int targetNode;
        int value;
        private Edge(int targetNode, int value) {
            this.targetNode = targetNode;
            this.value = value;
        }
    }
}
