package coding.test.leetcode.cannot.medium._1562;

class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n)
            return n;

        int[] parent = new int[n + 2];
        int[] size = new int[n + 2];
        int[] count = new int[n + 2];
        int result = -1;

        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            parent[pos] = pos;
            size[pos] = 1;
            count[1]++;

            if (parent[pos - 1] != 0) {
                union(parent, size, count, pos - 1, pos);
            }
            if (parent[pos + 1] != 0) {
                union(parent, size, count, pos, pos + 1);
            }

            if (count[m] > 0) {
                result = i + 1;
            }
        }

        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int[] size, int[] count, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            count[size[rootX]]--;
            count[size[rootY]]--;

            parent[rootY] = rootX;
            size[rootX] += size[rootY];

            count[size[rootX]]++;
        }
    }
}