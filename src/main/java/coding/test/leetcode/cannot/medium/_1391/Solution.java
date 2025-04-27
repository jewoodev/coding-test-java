package coding.test.leetcode.cannot.medium._1391;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        visited[0][0] = true;

        // 각 타일의 방향에 따른 이동 가능한 방향 정의
        int[][][] directions = {
                { { 0, -1 }, { 0, 1 } }, // 타일 1: 좌우
                { { -1, 0 }, { 1, 0 } }, // 타일 2: 상하
                { { 0, -1 }, { 1, 0 } }, // 타일 3: 좌하
                { { 0, 1 }, { 1, 0 } }, // 타일 4: 우하
                { { 0, -1 }, { -1, 0 } }, // 타일 5: 좌상
                { { 0, 1 }, { -1, 0 } } // 타일 6: 우상
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            int tile = grid[x][y] - 1;
            for (int[] dir : directions[tile]) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    // 다음 타일에서 현재 타일로 돌아올 수 있는지 확인
                    int nextTile = grid[newX][newY] - 1;
                    boolean canReturn = false;
                    for (int[] nextDir : directions[nextTile]) {
                        if (newX + nextDir[0] == x && newY + nextDir[1] == y) {
                            canReturn = true;
                            break;
                        }
                    }

                    if (canReturn) {
                        visited[newX][newY] = true;
                        queue.offer(new int[] { newX, newY });
                    }
                }
            }
        }

        return false;
    }
}