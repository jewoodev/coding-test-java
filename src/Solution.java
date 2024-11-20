import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (i == size - 1) {
                    result.add(current.val);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                } else if (current.left != null){
                    queue.offer(current.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,4};
        TreeNode treeNode = new TreeNode(input[0]);
        for (int i = 1; i < input.length + 1; i++) {

        }


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
