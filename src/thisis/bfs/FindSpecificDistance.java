package thisis.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindSpecificDistance { //p339
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, m, k, x;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());//도시의 개수
        m = Integer.parseInt(st.nextToken());//도로의 개수
        k = Integer.parseInt(st.nextToken());//거리 정보
        x = Integer.parseInt(st.nextToken());//출발 도시
        d = new int[n + 1];

        for (int i = 0; i <= n; i++) { //연결리스트에 노드 추가
            graph.add(new ArrayList<>());
            d[i] = -1; //최단거리 초기화
        }
        for (int i = 0; i < m; i++) { //간선 정보 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bfs();
    }

    private static void bfs() {
        d[x] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (d[next] == -1) {
                    d[next] = d[now] + 1;
                    q.add(next);
                }
            }
        }

        findNode();
    }

    private static void findNode() {
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check=true;
            }
        }

        if (check == false) System.out.println(-1);
    }
}
