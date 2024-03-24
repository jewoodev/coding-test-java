package doit.graph.dajikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소 비용 구하기
//이미 방문한 정점은 건너뛰도록 구현하니 시간 통과
public class FindMinimumCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //도시의 개수
        int M = Integer.parseInt(br.readLine()); //버스의 개수

        List<List<Route>> R = new ArrayList<>(); //노선 케이스들을 저장하는 배열
        boolean[] visited = new boolean[N + 1]; //방문 처리 배열
        int[] result = new int[N + 1];//최소 비용 값 저장 배열

        for (int i = 0; i < N + 1; i++) {
            R.add(new ArrayList<>());
            result[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st  = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); //출발 도시
            int B = Integer.parseInt(st.nextToken()); //도착 도시
            int C = Integer.parseInt(st.nextToken()); //비용
            R.get(A).add(new Route(B, C));
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());//출발 도시
        int E = Integer.parseInt(st.nextToken());//도착 도시

        //다익스트라
        PriorityQueue<Route> queue = new PriorityQueue<>((r1, r2) -> r1.cost - r2.cost);
        result[S] = 0;
        queue.offer(new Route(S, 0));

        while (!queue.isEmpty()) {
            Route now = queue.poll();//현재 방문 정점
            if (!visited[now.target]) {
                visited[now.target] = true; //방문 처리
                //현재 정점에 연결된 간선들에 대한 판단
                for (int i = 0; i < R.get(now.target).size(); i++) {
                    Route next = R.get(now.target).get(i);//현재 정점과 이어질 다음 정점
                    //다음 정점이 방문되지 않았고,
                    //현재 비용 + 해당 정점으로 향하는 비용 < 해당 정점으로의 최소 비용값이라면
                    if (!visited[next.target] && now.cost + next.cost < result[next.target]) {
                        //해당 정점으로의 최소 비용값 갱신
                        result[next.target] = now.cost + next.cost;
                        //다음 방문할 예정이므로 queue에 넣어주기
                        queue.offer(new Route(next.target, result[next.target]));
                    }
                }
            }
        }

        System.out.println(result[E]);
    }

    private static class Route {
        int target;
        int cost;

        private Route(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }
}
