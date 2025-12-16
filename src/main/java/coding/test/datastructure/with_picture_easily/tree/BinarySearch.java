package coding.test.datastructure.with_picture_easily.tree;

class BinarySearch {
    public static int search(int[] arr, int target, int start, int end) { // O(logN)
        if (start > end) return -1; // 찾지 못하면 -1 리턴

        int mid = (start + end) / 2;

        if (arr[mid] == target) return mid;
        else if (target > arr[mid]) {
            return search(arr, target, mid + 1, end);
        } else {
            return search(arr, target, start, mid - 1);
        }
    }
}
