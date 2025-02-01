package coding.test.datastructure.with_java.ch7;

public class HeapTest {
    final static int MAX_ELEMENT = 100;
    int[] heap = new int[MAX_ELEMENT];
    int heapSize;

    boolean isHeapFull() {
        return heapSize == MAX_ELEMENT - 1;
    }

    boolean isHeapEmpty() {
        return heapSize == 0;
    }

    void push(int item) throws Exception {
        int i;

        if (isHeapFull()) throw new Exception("The heap is full.");

        heapSize++;
        i = heapSize;
        while ((i != 1) && (item > heap[i / 2])) {
            heap[i] = heap[i / 2];
            i /= 2;
        }
        heap[i] = item;
    }

    int pop() throws Exception {
        int parent, child;
        int item, temp;

        if (isHeapEmpty()) throw new Exception("The heap is empty.");

        item = heap[1];
        temp = heap[heapSize--];
        parent = 1;
        child = 2;

        while (child <= heapSize) {
            if ((child < heapSize) && (heap[child] < heap[child + 1]))
                child++;
            if (temp >= heap[child])
                break;
            heap[parent] = heap[child];
            parent = child;
            child = child * 2;
        }
        heap[parent] = temp;
        return item;
    }

    void printHeap() {
        int i;
        System.out.printf(" Heap : ");
        for (i = 1; i <= heapSize; i++)
            System.out.printf(" [%d] ", heap[i]);
    }

    public static void main(String[] args) throws Exception {
        HeapTest heap = new HeapTest();
        int i, n, item;

        heap.push(10);
        heap.push(45);
        heap.push(19);
        heap.push(11);
        heap.push(96);

        heap.printHeap();
        n = heap.heapSize;

        for (i = 0; i <= n - 1; i++) {
            item = heap.pop();
            System.out.printf(" \n delete : [%d] ", item);
        }
    }
}
