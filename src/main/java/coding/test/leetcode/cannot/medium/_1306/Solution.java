package coding.test.leetcode.cannot.medium._1306;

public class Solution {
    public boolean canReach(int[] arr, int start) {
        // 방문 여부를 추적할 배열
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int current, boolean[] visited) {
        // 범위를 벗어나거나 이미 방문한 경우
        if (current < 0 || current >= arr.length || visited[current]) {
            return false;
        }
        // 0에 도달한 경우
        if (arr[current] == 0) {
            return true;
        }
        // 현재 위치를 방문 처리
        visited[current] = true;

        // 왼쪽 및 오른쪽으로 점프
        return dfs(arr, current + arr[current], visited) ||
                dfs(arr, current - arr[current], visited);
    }
}
