package coding.test.datastructure.with_java.ch7;

public class Exercise1 {
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    class BinaryTree {
        TreeNode root;

        public BinaryTree() {
            // 트리 구성
            root = new TreeNode(29);
            root.left = new TreeNode(25);
            root.right = new TreeNode(38);

            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(26);
            root.right.left = new TreeNode(30);
            root.right.right = new TreeNode(50);

            root.left.left.left = new TreeNode(4);
            root.left.left.right = new TreeNode(8);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(66);

            root.right.left.right = new TreeNode(28);
            root.right.right.left = new TreeNode(46);
            root.right.right.left.right = new TreeNode(37);
            root.right.right.right = new TreeNode(2);
        }
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int findPathLength(TreeNode root, int start, int end) {
        TreeNode lca = findLCA(root, start, end);
        return getDistance(lca, start, 0) + getDistance(lca, end, 0);
    }

    private TreeNode findLCA(TreeNode node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if (node.value == n1 || node.value == n2) {
            return node;
        }
        TreeNode left = findLCA(node.left, n1, n2);
        TreeNode right = findLCA(node.right, n1, n2);

        if (left != null && right != null) {
            return node;
        }
        return (left != null) ? left : right;
    }

    private int getDistance(TreeNode node, int value, int distance) {
        if (node == null) {
            return -1;
        }
        if (node.value == value) {
            return distance;
        }
        int left = getDistance(node.left, value, distance + 1);
        if (left != -1) {
            return left;
        }
        return getDistance(node.right, value, distance + 1);
    }

    public int countLeafNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    public boolean isBinaryTree(TreeNode node) {
        if (node == null) {
            return true; // 빈 트리는 BST로 간주
        }

        // 왼쪽 자식이 존재하고 부모 노드보다 크다면 BST 아님
        if (node.left != null && node.left.value >= node.value) {
            return false;
        }

        // 오른쪽 자식이 존재하고 부모 노드보다 작다면 BST 아님
        if (node.right != null && node.right.value <= node.value) {
            return false;
        }

        // 왼쪽과 오른쪽 서브트리에 대해 재귀적으로 검사
        return isBinaryTree(node.left) && isBinaryTree(node.right);
    }

    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        BinaryTree tree = exercise1.new BinaryTree();

        // 1. 트리 높이 구하기
        System.out.println("Tree Height: " + exercise1.getHeight(tree.root));

        // 2. 29에서 37까지의 경로 길이 구하기
        System.out.println("Path Length (29 -> 37): " + exercise1.findPathLength(tree.root, 29, 37));

        // 3. 리프 노드 개수 구하기
        System.out.println("Leaf Node Count: " + exercise1.countLeafNodes(tree.root));

        // 4. 바이너리 트리 여부 확인
        System.out.println("Is Binary Tree: " + exercise1.isBinaryTree(tree.root));
    }
}

/*
01. (4) 바이너리 트리가 아니다. 66, 28, 37, 2의 위치가 이진 트리의 규칙(왼쪽 자식노드는 부모노드보다 작고, 오른쪽 자식노드는 크다)을 지키고 있지 않기 때문이다.
*/