package coding.test.datastructure.with_java.ch7;

public class BinarySearchTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);

        if (data == root.data) return root;

        if (data < root.data) root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                TreeNode temp = findMin(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }
        return root;
    }

    public static TreeNode findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.printf("%d ", root.data);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;

        root = insert(root, 20);
        root = insert(root, 15);
        root = insert(root, 12);
        root = insert(root, 25);
        root = insert(root, 22);
        root = insert(root, 21);
        root = insert(root, 30);
        System.out.printf("Inorder Traversal (Original Tree): ");
        inorder(root);
        System.out.printf("\n");
        int keyToDelete = 20;
        root = deleteNode(root, keyToDelete);
        System.out.printf("Inorder Traversal (After Deleting %d): ", keyToDelete);
        inorder(root);
        System.out.printf("\n");
        int keyToInsert = 30;
        root = insert(root, keyToInsert);
        System.out.printf("Inorder Traversal (After Inserting %d): ", keyToInsert);
        inorder(root);
        System.out.printf("\n");
    }
}
