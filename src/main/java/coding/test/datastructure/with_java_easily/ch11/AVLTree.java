package coding.test.datastructure.with_java_easily.ch11;

import coding.test.datastructure.with_java_easily.ch10.IndexInterface;

public class AVLTree implements IndexInterface<AVLNode> {
    private AVLNode root;
    static final AVLNode NIL = new AVLNode(null, null, null, 0);
    private final int LL = 1, LR = 2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;

    public AVLTree() {
        root = NIL;
    }

    @Override
    public AVLNode search(Comparable x) {
        return searchItem(root, x);
    }

    private AVLNode searchItem(AVLNode root, Comparable x) {
        if (root == NIL) return NIL;
        else if (x.compareTo(root.item) == 0) return root;
        else if (x.compareTo(root.item) < 0)
            return searchItem(root.left, x);
        else
            return searchItem(root.right, x);
    }

    @Override
    public void insert(Comparable x) {
        root = insertItem(root, x);
    }

    private AVLNode insertItem(AVLNode root, Comparable x) {
        if (root == NIL) {
            root = new AVLNode(x);
        } else if (x.compareTo(root.item) < 0) {
            root.left = insertItem(root.left, x);
            root.height = 1 + Math.max(root.right.height, root.left.height);
            int type = needBalance(root);
            if (type != NO_NEED)
                root = balanceAVL(root, type);
        } else {
            root.right = insertItem(root.right, x);
            root.height = 1 + Math.max(root.right.height, root.left.height);
            int type = needBalance(root);
            if (type != NO_NEED)
                root = balanceAVL(root, type);
        }
        return root;
    }

    @Override
    public void delete(Comparable x) {
        root = deleteItem(root, x);
    }

    private AVLNode deleteItem(AVLNode root, Comparable x) {
        if (root == NIL) return NIL;
        else {
            if (x.compareTo(root.item) == 0) {
                root = deleteNode(root);
            } else if (x.compareTo(root.item) < 0) {
                root.left = deleteItem(root.left, x);
                root.height = 1 + Math.max(root.right.height, root.left.height);
                int type = needBalance(root);
                if (type != NO_NEED)
                    root = balanceAVL(root, type);
            } else {
                root.right = deleteItem(root.right, x);
                root.height = 1 + Math.max(root.right.height, root.left.height);
                int type = needBalance(root);
                if (type != NO_NEED)
                    root = balanceAVL(root, type);
            }
            return root;
        }
    }

    private AVLNode deleteNode(AVLNode root) {
        if ((root.left == NIL) && (root.right == NIL)) {
            return NIL;
        } else if (root.left == NIL) {
            return root.right;
        } else if (root.right == NIL) {
            return root.left;
        } else {
            ReturnPair rPair = deleteMinItem(root.right);
            root.item = rPair.item;
            root.right = rPair.node;
            int type = needBalance(root);
            if (type != NO_NEED)
                root = balanceAVL(root, type);
            return root;
        }
    }

    private ReturnPair deleteMinItem(AVLNode root) {
        int type;
        if (root.left == NIL) {
            return new ReturnPair(root.item, root.right);
        } else {
            ReturnPair rPair = deleteMinItem(root.left);
            root.left = rPair.node;
            root.height = 1 + Math.max(root.right.height, root.left.height);
            type = needBalance(root);
            if (type != NO_NEED)
                root = balanceAVL(root, type);
            rPair.node = root;
            return rPair;
        }
    }

    private class ReturnPair {
        public Comparable item;
        public AVLNode node;

        public ReturnPair(Comparable it, AVLNode nd) {
            item = it;
            node = nd;
        }
    }

    private AVLNode balanceAVL(AVLNode root, int type) {
        AVLNode returnNode = NIL;
        switch (type) {
            case LL:
                returnNode = rightRotate(root);
                break;
            case LR:
                root.left = leftRotate(root.left);
                returnNode = rightRotate(root);
                break;
            case RR:
                returnNode = leftRotate(root);
                break;
            case RL:
                root.right = rightRotate(root.right);
                returnNode = leftRotate(root);
                break;
            default:
                System.out.println("Impossible type! Should be one of LL, LR, RR, RL");
                break;
        }
        return returnNode;
    }

    private AVLNode leftRotate(AVLNode t) {
        AVLNode RChild = t.right;
        if (RChild == NIL)
            System.out.println(t.item + "'s RChild shouldn't be NIL!");
        AVLNode RLChild = RChild.left;
        RChild.left = t;
        t.right = RLChild;
        t.height = 1 + Math.max(t.left.height, t.right.height);
        RChild.height = 1 + Math.max(RChild.left.height, RChild.right.height);
        return RChild;
    }

    private AVLNode rightRotate(AVLNode t) {
        AVLNode LChild = t.left;
        if (LChild == NIL)
            System.out.println(t.item + "'s LChild shouldn't be NIL!");
        AVLNode LRChild = LChild.right;
        LChild.right = t;
        t.left = LRChild;
        t.height = 1 + Math.max(t.left.height, t.right.height);
        LChild.height = 1 + Math.max(LChild.left.height, LChild.right.height);
        return LChild;
    }

    private int needBalance(AVLNode t) {
        int type = ILLEGAL;
        if (t.left.height + 2 <= t.right.height) {
            if (t.right.left.height <= t.right.right.height)
                type = RR;
            else
                type = RL;
        } else if (t.left.height >= t.right.height + 2) {
            if (t.left.left.height >= t.left.right.height)
                type = LL;
            else
                type = LR;
        } else {
            type = NO_NEED;
        }
        return type;
    }

    @Override
    public boolean isEmpty() {
        return root == NIL;
    }

    @Override
    public void clear() {
        root = NIL;
    }
}
