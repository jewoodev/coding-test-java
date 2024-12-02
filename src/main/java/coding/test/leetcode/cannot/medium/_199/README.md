# 199. Binary Tree Right Side View

문제 링크: [링크](https://leetcode.com/problems/binary-tree-right-side-view/description/)

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
    List<Integer> answer = new ArrayList<>();
    
    private void rightSide(TreeNode node, int depth) {
        if (node == null) return;
        
        if (depth == answer.size()) {
            answer.add(node.val);
        } 
        rightSide(node.right, depth + 1);
        rightSide(node.left, depth + 1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        rightSide(root, 0);
        
        return answer;
    }
}
```
오른쪽에서 봤을 때 보여지는 노드를 리스트로 위부터 아래 순으로 담아 출력해야 하는 문제로 `오른쪽에서 봤을 때 보여지는 노드`를 어떻게 판별할 것인지가 관건인 문제이다.  

풀이 아이디어의 시작은 recursion의 깊이와 answer 리스트의 길이에서 시작된다.  
recursion을 시작할 때 노드가 끊어진 곳인지 확인 후, recursion의 깊이(depth)와 answer 리스트의 길이(answer.size())가 같을 때 answer 리스트에 현재 노드의 값을 추가하도록 한다.$^{1. 조건식}$  
루트 노드부터 시작해 오른쪽 리프 노드부터 왼쪽 리프 노드 순으로 depth를 1씩 증가시키며 `1.조건식`을 확인하면 각 depth마다 가장 오른쪽에 위치한 노드를 담게 된다.    
