package hanghae.beforehand.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3 {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        char id;
        Node left, right;

        Node(char newId){
            id = newId;
            left = right = null;
        }
    }
    static class BST {
        static Node root;

        static void put(char k, char left, char right) {
            if (root == null) {
                root = new Node(k);

                if (left != '.') {
                    root.left = new Node(left);
                }
                if (right != '.') {
                    root.right = new Node(right);
                }
            } else
                search(root, k, left, right);
        }

        static void search(Node n, char k, char left, char right) {
            if (n == null) return;

            if (n.id == k) {
                if (left != '.') {
                    n.left = new Node(left);
                }
                if (right != '.') {
                    n.right = new Node(right);
                }
            } else {
                search(n.left, k, left, right);
                search(n.right, k, left, right);
            }
        }

        static void preOrder(Node n) {
            if (n == null) return;
            sb.append(n.id);
            preOrder(n.left);
            preOrder(n.right);
        }

        static void inOrder(Node n) {
            if (n == null) return;
            inOrder(n.left);
            sb.append(n.id);
            inOrder(n.right);
        }

        static void postOrder(Node n) {
            if (n == null) return;
            postOrder(n.left);
            postOrder(n.right);
            sb.append(n.id);
        }

        static void print() {
            preOrder(root);
            sb.append("\n");
            inOrder(root);
            sb.append("\n");
            postOrder(root);
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BST bst = new BST();
        StringTokenizer st;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            char rootNode = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            bst.put(rootNode, left, right);
        }

        bst.print();
    }
}
