# 938. Range Sum of BST

문제 링크: [링크](https://leetcode.com/problems/range-sum-of-bst/description/)

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        int answer = low + high;

        while (!dq.isEmpty()) {
            TreeNode cur = dq.poll();

            if (cur.val > low && cur.val < high) answer += cur.val;
            if (cur.left != null) dq.offer(cur.left);
            if (cur.right != null) dq.offer(cur.right);
        }
        return answer;
    }

}
```

BST는 작은 요소를 왼쪽에, 큰 요소를 오른쪽에 위치시키는 트리임을 이용하면 더 효율적이다.