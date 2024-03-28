package hanghae.beforehand.test.copy;

import java.io.*;
import java.util.*;

public class Problem3 {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        char ch;
        Node left;
        Node right;

        public Node(char ch) {
            this.ch = ch;
        }
    }

    static class Tree {
        Node root;

        void insert(char thisNode, char left, char right) {
            if (root == null) {
                root = new Node(thisNode);
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                search(root, thisNode, left, right);
            }
        }

        void search(Node root, char thisNode, char left, char right) {
            if (root == null) {
                return;
            }

            if (root.ch == thisNode) {
                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else {
                search(root.left, thisNode, left, right);
                search(root.right, thisNode, left, right);
            }
        }

        // 전위 순회 -> (루트) (왼쪽 자식) (오른쪽 자식)
        void preorder(Node root) {
            sb.append(root.ch);
            if (root.left != null) {
                preorder(root.left);
            }
            if (root.right != null) {
                preorder(root.right);
            }
        }

        // 중위 순회 -> (왼쪽 자식) (루트) (오른쪽 자식)
        void inorder(Node root) {
            if (root.left != null) {
                inorder(root.left);
            }
            sb.append(root.ch);
            if (root.right != null) {
                inorder(root.right);
            }
        }

        // 후위 순회 -> (왼쪽 자식) (오른쪽 자식) (루트)
        void postorder(Node root) {
            if (root.left != null) {
                postorder(root.left);
            }
            if (root.right != null) {
                postorder(root.right);
            }
            sb.append(root.ch);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            tree.insert(a, b, c);
        }

        tree.preorder(tree.root);
        sb.append("\n");
        tree.inorder(tree.root);
        sb.append("\n");
        tree.postorder(tree.root);

        System.out.println(sb);
    }

}

