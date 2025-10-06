package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class BipartiteGraph { // https://www.acmicpc.net/problem/1707, 그래프 & BFS & DFS
    private static List<Integer>[] em; // 간선 행렬
    private static int[] group; // 해당 노드의 그룹 번호를 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 노드 개수
            int w = Integer.parseInt(st.nextToken()); // 간선 개수

            group = new int[v + 1];
            em = new ArrayList[v + 1];
            for (int j = 1; j <= v; j++) {
                em[j] = new ArrayList<>();
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                em[node1].add(node2);
                em[node2].add(node1);
            }

            boolean ok = true;
            for (int j = 1; j <= v; j++) {
                if (group[j] == 0) {
                    if (dfs(j, 1) == false) ok = false;
                }
            }

            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean dfs(int x, int c) {
        group[x] = c; // 현재 정점을 c번 그룹으로 지정

        for (int i : em[x]) { // 현재 정점과 인접한 모든 정점 탐색
            if (group[i] == 0) { // 인접 정점이 아직 그룹에 할당되지 않은 경우
                if (dfs(i, 3 - c) == false) { // 반대 그룹(3-c)으로 재귀 탐색
                    return false; // 탐색 중 이분 그래프 조건 위반 발견
                }
            } else if (group[i] == group[x]) { // 인접 정점이 이미 같은 그룹인 경우
                return false; // 이분 그래프 조건 위반 (인접 정점은 다른 그룹이어야 함)
            }
        }

        return true; // 현재 정점과 연결된 모든 정점이 올바르게 그룹화됨
    }
}
