package coding.test.leetcode.medium;

import java.util.*;

class MinCostToConnectAllPoints { // https://leetcode.com/problems/min-cost-to-connect-all-points/description/
    public int minCostConnectPoints(int[][] points) {
        int[] parent = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            parent[i] = i;
        }

        var q = new PriorityQueue<Edge>((e1, e2) -> e1.cost - e2.cost);
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) +  Math.abs(points[i][1] - points[j][1]);
                q.offer(new Edge(i, j, cost));
            }
        }

        int cost = 0;
        while (!q.isEmpty()) {
            var cur = q.poll();
            if (find(parent, cur.from) != find(parent, cur.to)) {
                union(parent, cur.from, cur.to);
                cost += cur.cost;
            }
        }

        return cost;
    }

    private int find(int[] parent, int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }

    private static class Edge {
        int from, to, cost;
        private Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
