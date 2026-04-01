package coding.test.leetcode.medium;

import java.util.PriorityQueue;

class MinCostToConnectAllPoints { // https://leetcode.com/problems/min-cost-to-connect-all-points/description/
    public int minCostConnectPoints(int[][] points) {
        var pq = new PriorityQueue<Edge>((e1, e2) -> e1.cost - e2.cost);
        boolean[] visited = new boolean[points.length];
        visited[0] = true;

        for (int i = 1; i < points.length; i++) {
            pq.offer(
                    new Edge(
                            i,
                            Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1])
                    )
            );
        }

        int answer = 0;
        int cnt = 0;
        int fullCnt = points.length - 1;
        while (cnt != fullCnt) {
            var edge = pq.poll();
            if (visited[edge.to]) continue;

            answer += edge.cost;
            cnt++;
            visited[edge.to] = true;

            for (int i = 1; i < points.length; i++) {
                if (!visited[i]) {
                    pq.offer(
                            new Edge(
                                    i,
                                    Math.abs(points[edge.to][0] - points[i][0]) + Math.abs(points[edge.to][1] - points[i][1])
                            )
                    );
                }
            }
        }

        return answer;
    }

    private class Edge {
        int to, cost;
        private Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

