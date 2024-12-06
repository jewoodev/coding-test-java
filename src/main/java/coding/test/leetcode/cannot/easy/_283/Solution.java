package coding.test.leetcode.cannot.easy._283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums = swap(nums, idx, i);
                idx++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private int[] swap(int[] numArr, int idx, int point) {
        int temp = numArr[idx];
        numArr[idx] = numArr[point];
        numArr[point] = temp;
        return numArr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0,1,0,3,12});
    }
}