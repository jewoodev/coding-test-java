package doit.graph.dajikstra.fail;

import java.io.*;
import java.util.*;

public class FindKthShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//도시 개수
        int m = Integer.parseInt(st.nextToken());//도시 간 도로 개수
        int k = Integer.parseInt(st.nextToken());//k번째의 k
        boolean[] visited = new boolean[n + 1];

        List<Route>[] A = new List[n + 1]; //도로 정보 저장 배열
        PriorityQueue<Integer>[] B = new PriorityQueue[n + 1]; //K번째 최단 경로 저장 배열

        for (int i = 0; i < n + 1; i++) {
            A[i] = new ArrayList<>();
            B[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            A[start].add(new Route(dst, cost));
        }

        //다익스트라
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (!visited[now]) visited[now] = true;
                for (Route route : A[now]) {
                    if (!visited[route.target]) {
                        if (!B[route.target].isEmpty()) {
                            B[route.target].offer(B[route.target].poll() + route.time);
                        } else {
                            B[route.target].offer(route.time);
                        }
                        queue.offer(route.target);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k - 1; j++) {
                B[i].poll();
            }
        }
        for (int i = 1; i <= n; i++) {
            if (B[i].isEmpty()) bw.write(-1 + "\n");
            else bw.write(B[i].poll() + "\n");
        }
        bw.close();
        br.close();
    }

    private static class Route {
        int target; //도착 도시
        int time;//소요 시간
        private Route(int tg, int tm) {
            target = tg;
            time = tm;
        }
    }
}

