package coding.test.leetcode.cannot.premium._305;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static class UnionFind {
        private int[] parent, rank;
        private int count; // 현재 섬의 개수

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = 0;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // 경로 압축
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--; // 두 섬을 연결했으므로 개수 감소
            }
        }

        public void addIsland() {
            count++; // 새로운 섬 추가
        }

        public int getCount() {
            return count;
        }
    }

    public int[] numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        int[][] grid = new int[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            if (grid[r][c] == 1) {
                result.add(uf.getCount()); // 이미 있는 육지는 무시
                continue;
            }

            grid[r][c] = 1;
            int index = r * n + c;
            uf.addIsland();

            // 상하좌우 탐색
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                    int neighborIndex = nr * n + nc;
                    uf.union(index, neighborIndex);
                }
            }

            result.add(uf.getCount());
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
