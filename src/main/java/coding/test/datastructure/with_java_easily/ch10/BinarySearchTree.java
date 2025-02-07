package coding.test.datastructure.with_java_easily.ch10;

public class BinarySearchTree implements IndexInterface<TreeNode> {
    private TreeNode root;
    public BinarySearchTree() {
        root = null;
    }
    
    @Override
    public TreeNode search(Comparable searchKey) {
        return searchItem(root, searchKey);
    }

    private TreeNode searchItem(TreeNode root, Comparable searchKey) {
        if (root == null) {
            return null; // 검색 실패
        } else if (searchKey.compareTo(root.key) == 0) {
            return root;
        } else if (searchKey.compareTo(root.key) < 0) {
            return searchItem(root.left, searchKey);
        } else {
            return searchItem(root.right, searchKey);
        }
    }

    @Override
    public void insert(Comparable newKey) {
        root = insertItem(root, newKey);
    }

    private TreeNode insertItem(TreeNode root, Comparable newItem) {
        if (root == null) {
            root = new TreeNode(newItem);
        } else if (newItem.compareTo(root.key) < 0) {
            root.left = insertItem(root.left, newItem);
        } else {
            root.right = insertItem(root.right, newItem);
        }
        return root;
    }

    @Override
    public void delete(Comparable searchKey) {
        root = deleteItem(root, searchKey);
    }

    private TreeNode deleteItem(TreeNode root, Comparable searchKey) {
        if (root == null) return null;
        else {
            if (searchKey == root.key)
                root = deleteNode(root);
            else if (searchKey.compareTo(root.key) < 0) {
                root.left = deleteItem(root.left, searchKey);
            } else {
                root.right = deleteItem(root.right, searchKey);
            }
            return root;
        }
    }

    private TreeNode deleteNode(TreeNode root) {
        if ((root.left == null) && (root.right == null))
            return null;
        else if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            ReturnPair rPair = deleteMinItem(root.right);
            root.key = rPair.key;
            root.right = rPair.node;
            return root;
        }
    }

    private ReturnPair deleteMinItem(TreeNode root) {
        if (root.left == null) {
            return new ReturnPair(root.key, root.right);
        } else {
            ReturnPair rPair = deleteMinItem(root.left);
            root.left = rPair.node;
            rPair.node = root;
            return rPair;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    private class ReturnPair {
        private Comparable key;
        private TreeNode node;

        public ReturnPair(Comparable key, TreeNode node) {
            this.key = key;
            this.node = node;
        }
    }
}
