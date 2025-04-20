package coding.test.leetcode.cannot.medium._652;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        serialize(root, map, result);
        return result;
    }

    private String serialize(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) return "#";
        
        String serial = node.val + "," + serialize(node.left, map, result) + "," + serialize(node.right, map, result);
        
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            result.add(node);
        }
        
        return serial;
    }
} 