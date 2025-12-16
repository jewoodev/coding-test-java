package coding.test.datastructure.with_picture_easily.tree;

class BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftSubTree;
    private BinaryTree<T> rightSubTree;

    BinaryTree(T data) {
        this(data, null, null);
    }

    BinaryTree(T data, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        this.data = data;
        this.leftSubTree = leftTree;
        this.rightSubTree = rightTree;
    }

    // 해당 트리(노드)의 데이터 리턴
    T getData() {
        return data;
    }

    // 해당 트리(노드)의 데이터 설정
    void setData(T data) {
        this.data = data;
    }

    // 해당 트리(노드)의 왼쪽 서브 트리 리턴
    BinaryTree<T> getLeftSubTree() {
        return leftSubTree;
    }

    // 해당 트리(노드)의 오른쪽 서브 트리 리턴
    BinaryTree<T> getRightSubTree() {
        return rightSubTree;
    }

    // 해당 트리(노드)의 왼쪽 서브 트리를 tree로 설정
    void setLeftSubTree(BinaryTree<T> tree) {
        this.leftSubTree = tree;
    }

    // 해당 트리(노드)의 오른쪽 서브 트리를 tree로 설정
    void setRightSubTree(BinaryTree<T> tree) {
        this.rightSubTree = tree;
    }

    // 해당 트리를 전위순회
    void preOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) return;
        System.out.println(tree.data);
        preOrderTraversal(tree.getLeftSubTree());
        preOrderTraversal(tree.getRightSubTree());
    }

    // 해당 트리를 중위순회
    void inOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) return;
        inOrderTraversal(tree.getLeftSubTree());
        System.out.println(tree.data);
        inOrderTraversal(tree.getRightSubTree());
    }

    // 해당 트리를 후위순회
    void postOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) return;
        postOrderTraversal(tree.getLeftSubTree());
        postOrderTraversal(tree.getRightSubTree());
        System.out.println(tree.data);
    }

    // 왼쪽 서브 트리 제거 및 리턴
    BinaryTree<T> removeLeftSubTree() {
        BinaryTree<T> deletedNode = getLeftSubTree();
        setLeftSubTree(null);
        return deletedNode;
    }

    // 오른쪽 서브 트리 제거 및 리턴
    BinaryTree<T> removeRightSubTree() {
        BinaryTree<T> deletedNode = getRightSubTree();
        setRightSubTree(null);
        return deletedNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BinaryTree{").append("data = ").append(data)
                .append(", leftSubTree = ").append(leftSubTree)
                .append(", rightSubTree = ").append(rightSubTree).append("}\n");
        return sb.toString();
    }
}
