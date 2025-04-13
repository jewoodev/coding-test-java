# [113. Path Sum II](https://leetcode.com/problems/path-sum-ii/description/)

루트 노드로부터 하위 노드로의 경로를 기억하면서 덧셈하는 것을 재귀로 처리해서 모든 경로의 경우들을 back tracking 하는 흐름의 논리로 풀이할 수 있다.

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, 0, targetSum, result, new ArrayList<>());
        return result;
    }
    
    private void pathSum(TreeNode node, int sum, int targetSum, List<List<Integer>> result, List<Integer> tmp) {
        if (node == null) return;
        sum += node.val;
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(tmp));
            }
        }
        
        pathSum(node.left, sum, targetSum, result, tmp);
        pathSum(node.right, sum, targetSum, result, tmp);
        
        tmp.remove(tmp.size() - 1);
    }
}
```