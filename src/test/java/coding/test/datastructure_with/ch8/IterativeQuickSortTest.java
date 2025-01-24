package coding.test.datastructure_with.ch8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IterativeQuickSortTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new int[]{12, 5, 9, 3, 14, 10, 6, 2}
                )
        );
    }

    private void test(int[] arr) throws Exception {
        IterativeQuickSort iq = new IterativeQuickSort();

        int size = arr.length;
        System.out.printf("Original Array: ");
        iq.printArray(arr, size);
        int left = 0;
        int right = size - 1;
        iq.iterativeQuickSort(arr, left, right);
        System.out.printf("Sorted Array: ");
        iq.printArray(arr, size);
    }
}