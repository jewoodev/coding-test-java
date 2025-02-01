package coding.test.datastructure.with_java.ch7;

public class MinHeapSort {
    int[] array;
    int capacity;
    int size;

    MinHeapSort(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    void insert(int value) throws Exception {
        if (size >= capacity)
            throw new Exception("Heap is full. Cannot insert.");

        int i = size++;
        array[i] = value;
        while (i != 0 && array[i] < array[getParentIndex(i)]) {
            int temp = array[i];
            array[i] = array[getParentIndex(i)];
            array[getParentIndex(i)] = temp;
            i = getParentIndex(i);
        }
    }

    int extractMin() throws Exception {
        if (size <= 0)
            throw new Exception("Heap is empty. Cannot extract minimum.");

        int min = array[0];
        array[0] = array[size - 1];
        size--;

        int i = 0;
        while (true) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            int smallestIndex = i;

            if (leftChildIndex < size && array[leftChildIndex] < array[i])
                smallestIndex = leftChildIndex;

            if (rightChildIndex < size && array[rightChildIndex] < array[smallestIndex])
                smallestIndex = rightChildIndex;

            if (i == smallestIndex)
                break;

            int temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
            i = smallestIndex;
        }
        return min;
    }

    public static void heapSort(int arr[], int size) {
        MinHeapSort heap = new MinHeapSort(size);

        for (int i = 0; i < size; i++) {
            try {
                heap.insert(arr[i]);
            } catch (Exception e) {
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            try {
                arr[i] = heap.extractMin();
            } catch (Exception e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int size = arr.length;

        System.out.printf("Original array: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }

        heapSort(arr, size);
        System.out.printf("\nSorted array (in ascending order): ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");
    }
}
