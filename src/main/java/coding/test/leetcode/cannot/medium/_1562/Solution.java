package coding.test.leetcode.cannot.medium._1562;

class Solution {
    public int findLatestStep(int[] arr, int m) {
        if (arr.length == m) return m;
        int[] length = new int[arr.length + 2];

        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int left = length[num - 1], right = length[num + 1];

            length[num - left] = left + right + 1;
            length[num + right] = left + right + 1;

            if (left == m || right == m) {
                result = i;
            }
        }

        return result;
    }
}