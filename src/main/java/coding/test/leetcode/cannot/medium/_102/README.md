# 102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

#### Example

Example 1:
![img.png](img.png)
> Input: root = [3,9,20,null,null,15,7]  
> Output: [[3],[9,20],[15,7]]

Example 2:

> Input: root = [1]  
> Output: [[1]]

Example 3:

> Input: root = []  
> Output: []

### Constraints

- The number of nodes in the tree is in the range [0, 2000]. 
- -1000 <= Node.val <= 1000

#### Code

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}
```