package coding.test.leetcode.cannot.medium._886;

import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 그래프를 인접 리스트로 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }

        // 각 노드의 그룹 정보를 저장 (-1: 미방문, 0: 그룹 1, 1: 그룹 2)
        int[] group = new int[n + 1];
        Arrays.fill(group, -1);

        // BFS를 사용한 이분성 검사
        for (int i = 1; i <= n; i++) {
            if (group[i] == -1) { // 아직 방문하지 않은 노드
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                group[i] = 0; // 그룹 1로 설정

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph.get(node)) {
                        if (group[neighbor] == -1) { // 인접 노드가 미방문 상태인 경우
                            group[neighbor] = 1 - group[node]; // 현재 노드와 다른 그룹으로 설정
                            queue.offer(neighbor);
                        } else if (group[neighbor] == group[node]) {
                            // 모순 발견: 인접 노드가 같은 그룹에 속함
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
