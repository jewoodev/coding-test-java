## [1391. Check if There is a Valid Path in a Grid](https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/description/)

하나의 타일에서 다른 타일로 이동하고, 그 타일에서 이전 타일로 되돌아갈 수 있는지를 확인하고, 다음으로 넘어가는 걸 반복하는 메커니즘을 수행하며 올바른 도로인지 확인할 수 있다. 

풀이 방식은 다음과 같다. 

1. BFS(너비 우선 탐색)를 사용하여 가능한 모든 경로를 탐색
2. 각 타일의 방향에 따라 다음 이동 가능한 위치를 결정
3. 방문한 위치를 기록하여 무한 루프 방지

이를 구현한 자바 코드는 다음과 같다. 

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        // 각 타일의 방향에 따른 이동 가능한 방향 정의
        int[][][] directions = {
            {{0, -1}, {0, 1}},  // 타일 1: 좌우
            {{-1, 0}, {1, 0}},  // 타일 2: 상하
            {{0, -1}, {1, 0}},  // 타일 3: 좌하
            {{0, 1}, {1, 0}},   // 타일 4: 우하
            {{0, -1}, {-1, 0}}, // 타일 5: 좌상
            {{0, 1}, {-1, 0}}   // 타일 6: 우상
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
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return false;
    }
}
```

이 코드는 다음과 같은 주요 특징을 가지고 있다. 

1. **BFS 사용**
   - 큐를 사용하여 가능한 모든 경로를 탐색
   - 시작점(0, 0)에서 시작하여 목적지(m-1, n-1)까지 도달할 수 있는지 확인
2. **방향 정의**
    - 각 타일(1-6)에 대해 가능한 이동 방향을 3차원 배열로 정의한다.
    - 예를 들어, 타일 1은 좌우로만 이동 가능하다.
3. **양방향 연결 확인**
    - 현재 타일에서 다음 타일로 이동할 때, 다음 타일에서도 현재 타일로 돌아올 수 있는지 확인한다.
    - 이는 도로가 양방향으로 연결되어 있어야 한다는 문제의 조건을 만족시키기 위함이다.
4. **방문 처리**
    - `visited` 배열을 사용하여 이미 방문한 위치를 추적한다.
    - 이는 무한 루프를 방지하고 효율을 높인다.

이 솔루션의 시간 복잡도는 O(mn)이며, 공간 복잡도도 O(mn)이다. 여기서 m과 n은 그리드의 행과 열의 크기이다.