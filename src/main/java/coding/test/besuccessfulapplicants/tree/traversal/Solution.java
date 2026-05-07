package coding.test.besuccessfulapplicants.tree.traversal;

import java.util.*;

class Solution {
    public String[] solution(int[] nodes) {
        var pre = new StringBuilder();
        var in = new StringBuilder();
        var post = new StringBuilder();

        preorder(nodes, 0, pre);
        inorder(nodes, 0, in);
        postorder(nodes, 0, post);

        return new String[]{
                pre.toString().trim(),
                in.toString().trim(),
                post.toString().trim()
        };
    }

    private void preorder(int[] nodes, int idx, StringBuilder sb) {
        if (idx >= nodes.length) return;
        sb.append(nodes[idx]).append(' ');
        preorder(nodes, 2 * idx + 1, sb);
        preorder(nodes, 2 * idx + 2, sb);
    }

    private void inorder(int[] nodes, int idx, StringBuilder sb) {
        if (idx >= nodes.length) return;
        inorder(nodes, 2 * idx + 1, sb);
        sb.append(nodes[idx]).append(' ');
        inorder(nodes, 2 * idx + 2, sb);
    }

    private void postorder(int[] nodes, int idx, StringBuilder sb) {
        if (idx >= nodes.length) return;
        postorder(nodes, 2 * idx + 1, sb);
        postorder(nodes, 2 * idx + 2, sb);
        sb.append(nodes[idx]).append(' ');
    }
}
