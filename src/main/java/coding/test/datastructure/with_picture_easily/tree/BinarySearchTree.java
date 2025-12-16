package coding.test.datastructure.with_picture_easily.tree;

class BinarySearchTree {
    private BinaryTree<Integer> root;

    BinarySearchTree() {
        this(null);
    }

    BinarySearchTree(BinaryTree<Integer> rootNode) {
        this.root = rootNode;
    }

    void insert(int data) {
        if (root == null) {
            root = new BinaryTree(data);
            return;
        }

        BinaryTree<Integer> currentNode = root;
        BinaryTree<Integer> parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftSubTree();
            } else if (currentNode.getData() < data) {
                currentNode = currentNode.getRightSubTree();
            } else return; // 중복된 값은 삽입하지 않음
        }

        BinaryTree<Integer> newNode = new BinaryTree<>(data);
        if (parentNode.getData() > data) {
            parentNode.setLeftSubTree(newNode);
        } else {
            parentNode.setRightSubTree(newNode);
        }
    }

    BinaryTree<Integer> search(int targetData) {
        BinaryTree<Integer> currentNode = root;

        while (currentNode != null) {
            if (currentNode.getData() == targetData) {
                return currentNode;
            } else if (currentNode.getData() > targetData) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }
        return null;
    }

    BinaryTree<Integer> remove(int targetData) {
        BinaryTree<Integer> fakeParentRootNode = new BinaryTree<>(0);
        BinaryTree<Integer> parentNode = fakeParentRootNode;
        BinaryTree<Integer> currentNode = root;
        BinaryTree<Integer> deletingNode = null;

        fakeParentRootNode.setRightSubTree(root);

        // 삭제할 노드 찾기
        while (currentNode != null && currentNode.getData() != targetData) {
            parentNode = currentNode;
            if (currentNode.getData() > targetData) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        if (currentNode == null) return null; // 트리에 해당 노드가 없는 경우

        deletingNode = currentNode;

        // 제거할 노드가 터미널노드인 경우 (자식이 없는 경우)
        if (deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.removeLeftSubTree();
            } else {
                parentNode.removeRightSubTree();
            }
        }
        // 자식노드가 한 개 있는 경우
        else if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {
            BinaryTree<Integer> childOfDeletingNode;

            if (deletingNode.getLeftSubTree() != null) {
                childOfDeletingNode = deletingNode.getLeftSubTree();
            } else {
                childOfDeletingNode = deletingNode.getRightSubTree();
            }

            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.setLeftSubTree(childOfDeletingNode);
            } else {
                parentNode.setRightSubTree(childOfDeletingNode);
            }
        }
        // 자식노드가 두 개 있는 경우
        else {
            BinaryTree<Integer> replacingNode = deletingNode.getLeftSubTree();
            BinaryTree<Integer> parentOfReplacingNode = deletingNode;

            // 왼쪽 서브트리에서 가장 큰 값 찾기
            while (replacingNode.getRightSubTree() != null) {
                parentOfReplacingNode = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            int nodeDataToDelete = deletingNode.getData();
            deletingNode.setData(replacingNode.getData());

            if (parentOfReplacingNode.getLeftSubTree() == replacingNode) {
                parentOfReplacingNode.setLeftSubTree(replacingNode.getLeftSubTree());
            } else {
                parentOfReplacingNode.setRightSubTree(replacingNode.getLeftSubTree());
            }

            deletingNode = replacingNode;
            deletingNode.setData(nodeDataToDelete);
        }

        // 제거하려는 노드가 루트 노드라면
        if (fakeParentRootNode.getRightSubTree() != root) {
            root = fakeParentRootNode.getRightSubTree();
        }

        return deletingNode;
    }

    BinaryTree<Integer> getRoot() {
        return root;
    }
}
