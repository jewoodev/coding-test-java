package coding.test.leetcode.easy;

import java.util.*;

class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        var graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            var list = new ArrayList<Integer>();
            graph.put(i, list);
        }

        for (int i = 0; i < edges.length; i++) {
            var list1 = graph.get(edges[i][0]);
            list1.add(edges[i][1]);
            graph.put(edges[i][0], list1);

            var list2 = graph.get(edges[i][1]);
            list2.add(edges[i][0]);
            graph.put(edges[i][1], list2);
        }

        return go(graph, source, destination, visited);
    }

    private boolean go(Map<Integer, List<Integer>> graph, int start, int dest, boolean[] visited) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == dest) return true;

            var list = graph.get(cur);
            for (int i : list) {
                if (visited[i]) continue;

                visited[i] = true;
                q.offer(i);
            }
        }

        return false;
    }
}
