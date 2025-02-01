package coding.test.datastructure.with_java.ch7;

class BinaryTreePriorityQueue {
    TreeNode root = null;

    private TreeNode createNode(int data) {
        TreeNode newNode = new TreeNode();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }

    private TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return createNode(data);

        if (data > root.data)
            root.right = insert(root.right, data);
        else
            root.left = insert(root.left, data);

        return root;
    }

    void enqueue(int data) {
        root = insert(root, data);
    }

    int dequeue() throws Exception {
        TreeNode current = root;
        TreeNode parent = null;

        if (current == null)
            throw new Exception("Queue is empty. Cannot dequeue.");

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        int maxItem = current.data;
        if (parent != null)
            parent.right = current.left;
        else
            root = current.left;

        return maxItem;
    }

    private void _inorder(TreeNode root) {
        if (root != null) {
            _inorder(root.left);
            System.out.printf("%d ", root.data);
            _inorder(root.right);
        }
    }

    void inorder() {
        _inorder(root);
    }

    public static void main(String[] args) {
        BinaryTreePriorityQueue pq = new BinaryTreePriorityQueue();

        pq.enqueue(10);
        pq.enqueue(45);
        pq.enqueue(23);
        pq.enqueue(19);
        pq.enqueue(11);
        pq.enqueue(37);
        pq.enqueue(52);
        pq.enqueue(96);
        pq.enqueue(8);
        System.out.printf("Inorder traversal (ascending order):\n");
        pq.inorder();
        System.out.printf("\nDequeue elements in descending order:\n");

        while (true) {
            try {
                int item = pq.dequeue();
                System.out.printf("%d ", item);
            } catch (Exception e) {
                break;
            }
        }
    }


    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }
}
