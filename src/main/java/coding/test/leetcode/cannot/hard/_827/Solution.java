package coding.test.leetcode.cannot.hard._827;

import java.util.*;

class Solution {
    int[] dR = {-1, 1, 0, 0};
    int[] dC = {0, 0, -1, 1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandId = 2; // 섬 ID는 2부터 시작 (0과 1은 이미 사용 중)
        Map<Integer, Integer> areaMap = new HashMap<>(); // 섬 ID -> 면적
        areaMap.put(0, 0); // ID 0인 경우 면적은 0으로 처리

        // 1. 각 섬의 면적을 계산하고 ID를 할당
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = calculateArea(grid, r, c, islandId);
                    areaMap.put(islandId, area);
                    islandId++;
                }
            }
        }

        // 2. 0을 1로 변경했을 때 연결되는 최대 면적 계산
        int maxArea = areaMap.values().stream().max(Integer::compare).orElse(0); // 초기 최대값

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for (int i = 0; i < 4; i++) {
                        int nR = r + dR[i];
                        int nC = c + dC[i];
                        if (nR >= 0 && nR < n && nC >= 0 && nC < n && grid[nR][nC] > 1) {
                            uniqueIslands.add(grid[nR][nC]);
                        }
                    }

                    int potentialArea = 1; // 현재 0을 1로 바꿨으므로 1부터 시작
                    for (int id : uniqueIslands) {
                        potentialArea += areaMap.get(id);
                    }
                    maxArea = Math.max(maxArea, potentialArea);
                }
            }
        }

        return maxArea;
    }

    private int calculateArea(int[][] grid, int r, int c, int id) {
        int n = grid.length;
        int area = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{r, c});
        grid[r][c] = id;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            area++;

            for (int i = 0; i < 4; i++) {
                int nR = cell[0] + dR[i];
                int nC = cell[1] + dC[i];

                if (nR >= 0 && nR < n && nC >= 0 && nC < n && grid[nR][nC] == 1) {
                    grid[nR][nC] = id;
                    stack.push(new int[]{nR, nC});
                }
            }
        }

        return area;
    }
}