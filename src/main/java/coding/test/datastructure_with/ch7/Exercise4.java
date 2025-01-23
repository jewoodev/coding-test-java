package coding.test.datastructure_with.ch7;

public class Exercise4 {
    final static int MAX_SIZE = 100;
    int[] elements = new int[MAX_SIZE];
    int size = 0;

    void swap(int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }

    void insert(int value) throws Exception {
        if (size >= MAX_SIZE) throw new Exception("Min heap is full. Cannot insert.");

        elements[size++] = value;
        int current = size - 1;
        while (current > 0 && elements[current] < elements[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    public static void main(String[] args) throws Exception {
        Exercise4 minHeap = new Exercise4();

        minHeap.insert(11);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(4);
        minHeap.insert(25);
        minHeap.insert(6);
        minHeap.insert(8);
        minHeap.insert(1);

        System.out.println();
    }
}
