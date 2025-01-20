package coding.test.datastructure_with.ch7;

public class MinHeap {
    final static int MAX_SIZE = 100;
    int[] elements = new int[MAX_SIZE];
    int size = 0;

    void swap(int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }

    void minHeapify(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && elements[left] < elements[smallest])
            smallest = left;

        if (right < size && elements[right] < elements[smallest])
            smallest = right;

        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    boolean isEmpty() {
        return size == 0;
    }

    void insert(int item) throws Exception {
        if (size >= MAX_SIZE) throw new Exception("Priority queue is full. Cannot insert.");

        elements[size++] = item;
        int current = size - 1;
        while (current > 0 && elements[current] < elements[(current - 1) / 2]) {
            swap(current, (current - 1) / 2);
            current = (current - 1) / 2;
        }
    }

    int deleteMin() throws Exception {
        if (isEmpty()) throw new Exception("Priority queue is empty. Cannot delete.");

        int minItem = elements[0];
        elements[0] = elements[size - 1];
        size--;
        minHeapify(0);
        return minItem;
    }

    public static void main(String[] args) throws Exception {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(45);
        minHeap.insert(23);
        minHeap.insert(19);
        minHeap.insert(11);
        minHeap.insert(37);
        minHeap.insert(52);
        minHeap.insert(96);
        minHeap.insert(8);

        System.out.println("Deleted elements in ascending order:\n");
        while (!minHeap.isEmpty()) {
            int item = minHeap.deleteMin();
            System.out.printf("%d ", item);
        }
    }
}
