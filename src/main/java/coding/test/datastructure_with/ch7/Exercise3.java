package coding.test.datastructure_with.ch7;

import java.util.Arrays;

import static coding.test.datastructure_with.ch7.Exercise3.BinaryTree.treeToArray;

public class Exercise3 {
    class BinaryTree {
        // 배열 기반 이진 트리
        static class TreeNode {
            char value;
            TreeNode left;
            TreeNode right;

            TreeNode(char value) {
                this.value = value;
            }
        }

        // (A) 트리를 배열로 변환
        public static char[] treeToArray(TreeNode root, int size) {
            char[] array = new char[size];
            Arrays.fill(array, '-');
            fillArray(root, array, 1);
            return array;
        }

        private static void fillArray(TreeNode node, char[] array, int index) {
            if (node == null || index >= array.length) {
                return;
            }
            array[index] = node.value;
            fillArray(node.left, array, 2 * index);
            fillArray(node.right, array, 2 * index + 1);
        }

        // (B) 배열을 트리로 변환
        public static TreeNode arrayToTree(char[] array) {
            return buildTree(array, 1);
        }

        private static TreeNode buildTree(char[] array, int index) {
            if (index >= array.length || array[index] == '-') {
                return null;
            }
            TreeNode node = new TreeNode(array[index]);
            node.left = buildTree(array, 2 * index);
            node.right = buildTree(array, 2 * index + 1);
            return node;
        }

        // 트리 출력 (전위 순회)
        public static void printTree(TreeNode node) {
            if (node == null) {
                return;
            }
            System.out.print(node.value + " ");
            printTree(node.left);
            printTree(node.right);
        }
    }
    public static void main(String[] args) {
        // (A) 트리 생성
        BinaryTree.TreeNode root = new BinaryTree.TreeNode('A');
        root.left = new BinaryTree.TreeNode('B');
        root.right = new BinaryTree.TreeNode('C');
        root.left.left = new BinaryTree.TreeNode('D');
        root.left.right = new BinaryTree.TreeNode('E');
        root.right.left = new BinaryTree.TreeNode('F');
        root.right.right = new BinaryTree.TreeNode('G');
        root.left.left.left = new BinaryTree.TreeNode('H');
        root.left.left.right = new BinaryTree.TreeNode('I');

        // 트리를 배열로 변환
        char[] treeArray = treeToArray(root, 17); // 배열 크기: 17
        System.out.println("Tree as Array: " + Arrays.toString(treeArray));

        // 배열을 트리로 변환
        BinaryTree.TreeNode newRoot = BinaryTree.arrayToTree(treeArray);

        // 트리 출력 (전위 순회)
        System.out.print("Reconstructed Tree (Preorder): ");
        BinaryTree.printTree(newRoot);
    }
}
