package coding.test.leetcode.easy;

class BinarySearch {
    public int search(int[] nums, int target) {
        return doSearch(nums, target, 0, nums.length - 1);
    }

    public int doSearch(int[] nums, int target, int start, int end) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return doSearch(nums, target, mid + 1, end);
        } else if (nums[mid] > target) {
            return doSearch(nums, target, start, mid - 1);
        }
        return - 1;
    }
}
