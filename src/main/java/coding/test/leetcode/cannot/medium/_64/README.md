# [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/description/)

위 문제는 2차원 grid에서 **좌상단**(0, 0)에서 **우하단**(m-1, n-1)까지 오른쪽 또는 아래쪽으로만 이동하면서 지나가는 경로 중 합이 최소가 되는 경로의 합을 구하는 문제이다.

이를 해결하기 위해 **동적 계획법**(Dynamic Programming, DP)을 사용한다.

```java
class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) grid[i][0] += grid[i - 1][0];
        for (int j = 1; j < grid[0].length; j++) grid[0][j] += grid[0][j - 1];
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
```

## 💡 동작 원리 설명

```java
public int minPathSum(int[][] grid)
```

grid 는 각 위치의 비용(또는 가중치)이 저장된 2차원 배열이다.

이 함수를 통해 최소 경로 합을 반환한다.

## 🔧 코드 동작 단계별 설명

1. 맨 윗줄 채우기 (오른쪽으로만 이동 가능)

```java
for (int j = 1; j < grid[0].length; j++)
    grid[0][j] += grid[0][j - 1];
```

(0,0) → (0,1) → (0,2)처럼 오른쪽으로만 이동하면서 누적 합을 저장한다.

즉, `grid[0][j]`는 `grid[0][j-1] + grid[0][j]`의 누적합이 된다.

2. 맨 왼쪽 열 채우기 (아래쪽으로만 이동 가능)

```java
for (int i = 1; i < grid.length; i++)
    grid[i][0] += grid[i - 1][0];
```

(0,0) → (1,0) → (2,0)처럼 아래쪽으로만 이동하면서 누적 합을 저장한다.

`grid[i][0]`는 `grid[i-1][0] + grid[i][0]`이 된다.

3. 나머지 칸들 채우기

```java
for (int i = 1; i < grid.length; i++) {
    for (int j = 1; j < grid[i].length; j++) {
        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
    }
}
```

각 칸 (i, j)로 오는 경로는 왼쪽(`grid[i][j - 1]`) 또는 위(`grid[i - 1][j]`)에서 올 수 있다.

그 두 경로 중 더 작은 합을 갖는 경로를 선택해서 현재 칸의 값을 업데이트한다.

4. 결과 반환

```java
return grid[grid.length - 1][grid[0].length - 1];
```

최종 목적지인 우하단 칸에 저장된 값이 최소 경로의 합이다.

## 📌 예시 1 적용 (grid = [[1,3,1],[1,5,1],[4,2,1]])

|   |   |   |
|---|---|---|
| 1 | 3 | 1 |
| 1 | 5 | 1 |
| 4 | 2 | 1 |

최소 경로: 1 → 3 → 1 → 1 → 1 = 7

코드는 각 위치에 최소 경로 합을 누적해서 저장해가고, 마지막 (2,2)의 값이 7이 된다.

## ✅ 결론

이 코드는 grid 자체를 DP 테이블로 활용해서, 공간 복잡도는 O(1) (in-place), 시간 복잡도는 O(m * n)으로 매우 효율적인 풀이다.

한마디로 요약하자면:

"각 칸에서 위 또는 왼쪽 중 더 작은 경로 비용을 선택해 누적합을 계산해나가는 DP 방식"