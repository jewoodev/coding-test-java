package coding.test.leetcode.easy._643;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += nums[j];
            }
            if (sum > max) max = sum;
        }
        return (double) max / k;
    }
}
