package coding.test.leetcode.easy;

import java.util.*;

class TwoSum { // https://leetcode.com/problems/two-sum/description/
    public int[] twoSum(int[] nums, int target) {
        boolean[] check = new boolean[nums.length];
        doSum(nums, target, 0, 0, check);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i]) list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean doSum(int[] nums, int target, int sum, int depth, boolean[] check) {
        if (depth > 2) return false;
        else if (sum == target && depth == 2) return true;

        for (int i = 0; i < nums.length; i++) {
            if (check[i]) continue;
            check[i] = true;
            sum += nums[i];
            if (doSum(nums, target, sum, depth + 1, check)) return true;
            check[i] = false;
            sum -= nums[i];
        }
        return false;
    }
}
