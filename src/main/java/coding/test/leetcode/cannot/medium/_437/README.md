# 437. Path Sum III

문제 링크: [링크](https://leetcode.com/problems/path-sum-iii/)

로직 설계가 어려워 풀지 못한 문제. 매우 어렵다고 느꼈다. 매우매우매우.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // 누적합이 0인 경로를 기본적으로 1개로 설정
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        // 현재 누적 합 계산
        currSum += node.val;

        // (현재 누적 합 - targetSum)이 prefixSumCount에 존재하면 해당 개수를 결과에 추가
        int count = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // 현재 누적 합을 prefixSumCount에 추가
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // 왼쪽과 오른쪽 서브트리 탐색
        count += dfs(node.left, currSum, targetSum, prefixSumCount);
        count += dfs(node.right, currSum, targetSum, prefixSumCount);

        // 백트래킹: 현재 노드의 누적 합 제거
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return count;
    }
}
```

각 노드에서 DFS를 하면서 특정 누적 합이 나타난 횟수를 맵 타입의 자료구조에 기록해두면, 그 자료구조에서 누적합에서 targetSum 값을 뺀 걸 키값으로 value를 찾아오면 그 value가 그 누적합을 만들어 낼 수 있는 누적합 Path의 갯수가 된다.
```
      10
     /  \
    5   -3
   / \     \
  3   2     11
 / \   \
3  -2   1
```
`targetSum = 8`

다음의 예제를 보자. 

## 누적 합 추적

1. 루트 노드(10)
    - 현재 `currSum = 10`
    - `currSum - targetSum = 10 - 8 = 2`
    - `prefixSumCount`에서 `2`가 없으므로, 경로 개수는 0개
    - `prefixSumCount` 갱신: `{0: 1, 10: 1}`
2. 왼쪽 자식 (5)
   - 현재 `currSum` = 15 (10 + 5). 
   - `currSum - targetSum = 15 - 8 = 7` 
   - `prefixSumCount`에서 `7`이 없으므로, 경로 개수는 0 
   - `prefixSumCount` 갱신: `{0: 1, 10: 1, 15: 1}` 
3. 왼쪽의 왼쪽 자식 (3)
   - 현재 `currSum = 18` `(10 + 5 + 3)` 
   - `currSum - targetSum = 18 - 8 = 10` 
   - `prefixSumCount`에서 `10`이 1개 있으므로, 누적 합 10에서 현재까지의 경로가 `targetSum`과 일치 
   - 경로 개수는 1
   - `prefixSumCount` 갱신: `{0: 1, 10: 1, 15: 1, 18: 1}`

## "currSum - targetSum = 15 - 8 = 7"

만약 `prefixSumCount`에 `{7: 2}`로 저장되어있다고 하면

"경로 시작점에서 누적 합이 7이 된 시점"이 2번 있었음을 의미한다.

현재 currSum이 15 일 때, `15 - 8 = 7`이니 "누적 합이 7이 된 지점" 두 곳에서 현재 노드까지의 경로가 2개가 있다는 것이 된다.

## 정리

이러한 논리로 DFS 탐색을 하면서 prefixSumCount를 이용해 각 누적합을 만드는 Path의 갯수를 세는 걸 이어나가면서 targetSum
