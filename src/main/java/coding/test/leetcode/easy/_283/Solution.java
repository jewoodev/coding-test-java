package coding.test.leetcode.easy._283;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class Solution {
    public void moveZeroes(int[] nums) {
        int numsLength = nums.length;
        int startIndex = 0;
        int lastIndex = numsLength - 1;
        int temp;

        Arrays.sort(nums);

        for (int i = 0; i < lastIndex; i++) {
            if (nums[i] != 0) {
                temp = nums[startIndex];
                nums[startIndex++] = nums[i];
                nums[i] = temp;
            }
            else {
                temp = nums[lastIndex];
                nums[lastIndex--] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0,1,0,3,12});
    }
}