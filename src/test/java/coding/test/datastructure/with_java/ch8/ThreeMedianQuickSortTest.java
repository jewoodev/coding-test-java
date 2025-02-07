package coding.test.datastructure.with_java.ch8;

import coding.test.datastructure.with_java.ch8.ThreeMedianQuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeMedianQuickSortTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new int[]{12, 5, 9, 3, 14, 10, 6, 2}
                )
        );
    }

    private void test(int[] arr) {
        int size = arr.length;

        System.out.printf("Original Array: \n");
        ThreeMedianQuickSort.printArray(arr, size);

        int left = 0;
        int right = size - 1;

        ThreeMedianQuickSort.quickSort(arr, left, right);
        System.out.printf("Sorted Array: ");
        ThreeMedianQuickSort.printArray(arr, size);
    }
}