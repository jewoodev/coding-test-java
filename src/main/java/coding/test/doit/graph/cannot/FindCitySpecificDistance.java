package coding.test.doit.graph.cannot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindCitySpecificDistance { //P260 문제46, 백준 18352번. 특정 거리의 도시 찾기
    private static int[] visited; //방문 거리 저장 배열
    private static ArrayList<Integer>[] a; //그래프 데이터 저장 인접 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //도시의 개수
        int m = Integer.parseInt(st.nextToken()); //도로의 개수
        int k = Integer.parseInt(st.nextToken()); //거리 정보(주어지는 조건, 최단 거리)
        int x = Integer.parseInt(st.nextToken()); //출발 도시의 번호
        a = new ArrayList[n + 1];
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            a[s].add(e);
        }
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }
        bfs(x);
        for (int i = 0; i <= n; i++) {
            if (visited[i] == k) answer.add(i);
        }
        if (answer.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(answer);
            for (Integer i : answer) {
                System.out.println(i);
            }
        }
    }

    private static void bfs(int node) { /* 너비 우선 탐색을 하며  */
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node]++;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (Integer i : a[nowNode]) {
                if (visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    q.add(i);
                }
            }
        }
    }
}
