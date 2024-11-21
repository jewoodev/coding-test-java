package coding.test.doit.graph.dajikstra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최단 경로 구하기 p319 백준 1753
public class FindShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        List<Edge>[] A = new List[V + 1]; //연결 정보 저장 배열
        boolean[] visited = new boolean[V + 1]; //방문 처리 배열
        int[] result = new int[V + 1]; //최단 경로 값 저장 배열

        //연결 정보 저장할 배열, 최단 경로 값 저장 배열 초기화
        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //출발
            int v = Integer.parseInt(st.nextToken()); //도착
            int w = Integer.parseInt(st.nextToken()); //가중치
            A[u].add(new Edge(v, w));
        }

        //다익스트라
        PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.value - e2.value);
        result[K] = 0;
        queue.offer(new Edge(K, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll(); //현재 방문 정점
            if (!visited[now.target]) visited[now.target] = true; //방문처리
            //현재 정점에서 연결된 간선들에 대해 판단
            for (int i = 0; i < A[now.target].size(); i++) {
                //현재 정점과 이어질 다음 정점
                Edge next = A[now.target].get(i);
                //다음 정점이 방문하지 않았고,
                //현재 가중치 + 해당 정점으로 향하는 가중치 값 < 해당 정점으로의 최단 경로 값이라면
                if (!visited[next.target] && now.value + next.value < result[next.target]) {
                    //해당 정점으로의 최단 경로 값 Update
                    result[next.target] = now.value + next.value;
                    //다음 방문할 예정이므로 queue에 넣어주기
                    queue.offer(new Edge(next.target, result[next.target]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (result[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(result[i] + "\n");
        }

        bw.close();
        br.close();
    }

    private static class Edge {
        int target;
        int value;
        private Edge(int target, int value) {
            this.target = target;
            this.value = value;
        }
    }
}
