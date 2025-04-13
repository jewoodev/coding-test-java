# [129. Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/description/)

루트 노드에서 하위 노드로 뻗어가면서 루트 노드의 값에 10을 곱해주고 두 개 하위 노드에 덧셈을 하는 것을 리프 노드까지 이어가는 걸 재귀 방식으로 구현해 더해주면 된다.

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return find(root, 0);
    }


    private int find(TreeNode node, int sum) {
        if (node == null) return 0;


        int cur = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return cur;
        }


        return find(node.left, cur) + find(node.right, cur);
    }
}
```