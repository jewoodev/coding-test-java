package coding.test.leetcode.easy;

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertLower(root);

        return root;
    }

    public TreeNode invertLower(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertLower(root.left);
        invertLower(root.right);

        return root;
    }

    private class TreeNode {
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
}
