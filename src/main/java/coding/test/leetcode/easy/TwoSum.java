package coding.test.leetcode.easy;

import java.util.*;

class TwoSum { // https://leetcode.com/problems/two-sum/description/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                var list = map.get(key);

                if (nums[i] == key && list.size() > 1) return new int[]{i, map.get(key).get(1)};
                else if (nums[i] == key && list.size() == 1) continue;

                return new int[]{i, map.get(key).get(0)};
            }
        }

        return null;
    }
}
