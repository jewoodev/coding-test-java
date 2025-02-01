package coding.test.datastructure.with_java.ch7;

public class WinnerTree {
    Node[] tree;
    int numLeaves;
    int size;
    Run[] runs;

    Node min(Node a, Node b) {
        if (a.key < b.key) return a;
        else return b;
    }

    void initializeWinnerTree(int n, Run[] r) {
        runs = r;
        numLeaves = n;
        size = 1;
        while (size < numLeaves)
            size *= 2;
        tree = new Node[size * 2];
        for (int i = 0; i < size * 2; ++i) {
            tree[i] = Node.infNode;
        }
        for (int i = 0; i < numLeaves; ++i) {
            tree[i + size] = runs[i].getNext();
        }
        for (int i = size - 1; i >= 1; --i) {
            tree[i] = min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    int selectMin() {
        Node winner = tree[1];
        int index = winner.runIndex + size;

        tree[index] = runs[winner.runIndex].getNext();
        index /= 2;
        while (index > 0) {
            tree[index] = min(tree[index * 2], tree[index * 2 + 1]);
            index /= 2;
        }
        return winner.key;
    }

    public static void main(String[] args) {
        int runsKey[][] = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        int numLeaves = 3;
        int numNodeRun = runsKey[0].length;

        Run[] runs = new Run[numLeaves];
        for (int i = 0; i < numLeaves; i++) {
            runs[i] = new Run(i, runsKey[i]);
        }

        WinnerTree winnerTree = new WinnerTree();
        winnerTree.initializeWinnerTree(numLeaves, runs);
        System.out.printf("Sorted Sequences: ");
        for (int i = 0; i < numLeaves * numNodeRun; ++i) {
            int minVal = winnerTree.selectMin();
            System.out.printf("%d ", minVal);
        }
        System.out.println();
    }

    static class Node {
        int key;
        int runIndex;

        public Node(int key, int runIndex) {
            this.key = key;
            this.runIndex = runIndex;
        }

        static Node infNode = new Node(Integer.MAX_VALUE, -1);
    }

    static class Run {
        Node[] runs;
        int front;

        Run(int runIndex, int[] list) {
            runs = new Node[list.length];
            for (int i = 0; i < list.length; i++)
                runs[i] = new Node(list[i], runIndex);
            front = -1;
        }

        Node getNext() {
            if (front >= runs.length - 1)
                return Node.infNode;
            front++;
            return runs[front];
        }
    }
}
