package coding.test.datastructure_with.ch7;

public class Exercise2 {
    // 트리 노드 클래스 정의
    static class TreeNode {
        char value;
        TreeNode left;
        TreeNode right;

        private TreeNode(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static class TreeTraversal {
        // 전위 순회
        private static void preOrder(TreeNode node) {
            if (node == null) return;
            System.out.print(node.value + " "); // 루트
            preOrder(node.left);               // 왼쪽
            preOrder(node.right);              // 오른쪽
        }

        // 중위 순회
        private static void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);                // 왼쪽
            System.out.print(node.value + " "); // 루트
            inOrder(node.right);               // 오른쪽
        }

        // 후위 순회
        private static void postOrder(TreeNode node) {
            if (node == null) return;
            postOrder(node.left);              // 왼쪽
            postOrder(node.right);             // 오른쪽
            System.out.print(node.value + " "); // 루트
        }
    }

    public static void main(String[] args) {
        // 트리 생성
        TreeNode root = new TreeNode('M');
        root.left = new TreeNode('K');
        root.right = new TreeNode('L');

        TreeNode K = root.left;
        K.left = new TreeNode('G');
        K.right = new TreeNode('H');
        TreeNode L = root.right;
        L.left = new TreeNode('I');
        L.right = new TreeNode('J');

        TreeNode G = root.left.left;
        G.left = new TreeNode('A');
        G.right = new TreeNode('B');
        TreeNode H = root.left.right;
        H.left = new TreeNode('C');
        TreeNode I = root.right.left;
        I.left = new TreeNode('D');
        I.right = new TreeNode('E');
        TreeNode J = root.right.right;
        J.right = new TreeNode('F');

        // 탐색 및 결과 출력
        TreeTraversal treeTraversal = new TreeTraversal();
        System.out.println("전위 순회:");
        treeTraversal.preOrder(root);
        System.out.println();

        System.out.println("중위 순회:");
        treeTraversal.inOrder(root);
        System.out.println();

        System.out.println("후위 순회:");
        treeTraversal.postOrder(root);
        System.out.println();
    }
}
