package coding.test.datastructure.with_java.ch7;

public class PriorityQueue {
    final static int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    void enqueue(int item) throws Exception {
        if (size >= MAX_SIZE) throw new Exception("Queue is full. Cannot enqueue.");

        int i = ++size;
        while (i > 1 && item > heap[i / 2]) {
            heap[i] = heap[i / 2];
            i /= 2;
        }
        heap[i] = item;
    }

    int dequeue() throws Exception {
        if (size == 0) throw new Exception("Queue is empty. Cannot dequeue.");

        int parent = 1, child = 2;
        int item = heap[1];
        int temp = heap[size--];
        while (child <= size) {
            if (child < size && heap[child] < heap[child + 1])
                child++;

            if (temp >= heap[child])
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
        return item;
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(10);
        pq.enqueue(45);
        pq.enqueue(23);
        pq.enqueue(19);
        pq.enqueue(11);
        pq.enqueue(37);
        pq.enqueue(52);
        pq.enqueue(96);
        pq.enqueue(8);
        System.out.printf("Dequeue elements in descending order:\n");
        while (pq.size > 0) {
            int item = pq.dequeue();
            System.out.printf("%d ", item);
        }
    }
}
