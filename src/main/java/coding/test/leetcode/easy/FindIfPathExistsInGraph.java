package coding.test.leetcode.easy;

import java.util.*;

class FindIfPathExistsInGraph { // https://leetcode.com/problems/find-if-path-exists-in-graph/description/
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] visited = new boolean[n][n];
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

    private boolean go(Map<Integer, List<Integer>> graph, int start, int dest, boolean[][] visited) {
        if (start == dest) return true;

        var list = graph.get(start);
        for (int i : list) {
            if (visited[start][i]) continue;
            visited[start][i] = true;
            visited[i][start] = true;
            if (go(graph, i, dest, visited)) return true;
            visited[i][start] = false;
            visited[i][start] = false;
        }
        return false;
    }
}
