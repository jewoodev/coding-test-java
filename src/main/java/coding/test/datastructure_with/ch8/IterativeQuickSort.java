package coding.test.datastructure_with.ch8;

public class IterativeQuickSort {
    // 스택의 최대 크기 설정
    final static int MAX_STACK_SIZE = 100;
    StackItem[] stack = new StackItem[MAX_STACK_SIZE];
    int top = -1;

    private void push(int left, int right) throws Exception {
        if (top < MAX_STACK_SIZE - 1) {
            stack[++top] = new StackItem(left, right);
        } else {
            throw new Exception("Stack is full!");
        }
    }

    private StackItem pop() throws Exception {
        if (top >= 0) {
            StackItem item = stack[top--];
            return item;
        } else {
            throw new Exception("Stack is empty!");
        }
    }

    // 배열에서 두 요소의 위치를 바꾸는 함수
    public static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    // 미디언 값 계산
    private int medianOfThree(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }
        return arr[mid];
    }

    void iterativeQuickSort(int[] arr, int left, int right) throws Exception {
        push(left, right);
        while (top >= 0) {
            StackItem item = pop(); // 스택에서 범위를 가져옴
            left = item.left;
            right = item.right;
            if (right - left <= 0) {
                continue; // 범위가 1 이하면 다음 반복으로 건너뜀
            }
            int pivot = medianOfThree(arr, left, right);
            int i = left;
            int j = right;
            while (true) {
                while (++i <= right && arr[i] < pivot);
                while (--j >= left && arr[j] > pivot);
                if (i < j) {
                    swap(arr, i, j);
                } else break;
            }
            swap(arr, left, j);
            if (i - 1 - left >= right - i - 1) {
                push(left, j);
                push(j + 1, right);
            } else {
                push(j + 1, right);
                push(left, j);
            }
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("\n");
    }

    static class StackItem {
        int left;
        int right;

        public StackItem(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
