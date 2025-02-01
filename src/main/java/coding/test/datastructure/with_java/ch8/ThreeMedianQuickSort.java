package coding.test.datastructure.with_java.ch8;

public class ThreeMedianQuickSort {
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    // 미디언 값 계산
    public static int medianOfThree(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[mid])
            swap(arr, left, mid);

        if (arr[left] > arr[right])
            swap(arr, left, right);

        if (arr[mid] > arr[right])
            swap(arr, mid, right);

        return arr[mid];
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int pivot = medianOfThree(arr, left, right);
        int i = left;
        int j = right; // medianOfThree() 를 수행하고 나면 pivot과 left, right 의 값들은 정렬이 된 상태이므로 루프 탐색 범위에 포함시키지 않는 것이 옳다.
        while (true) {
            while (++i <= right && arr[i] < pivot);
            while (--j >= left && arr[j] > pivot);
            if (i < j)
                swap(arr, i, j);
            else
                break;
        }
        swap(arr, j, left);

        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }
}
