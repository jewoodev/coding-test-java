package coding.test.leetcode.cannot.hard._403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> steps = new HashMap<>();
        for (int stone : stones) {
            steps.put(stone, new HashSet<>());
        }
        steps.get(0).add(0);

        int target = stones[stones.length - 1];
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];

            Set<Integer> stepSet = steps.get(stone);
            for (Integer step : stepSet) {
                for (int k = step - 1; k <= step + 1; k++) {
                    if (steps.containsKey(stone + k)) {
                        if (stone + k == target) return true;
                        if (stone + k != stone) {
                            steps.get(stone + k).add(k);
                        }
                    }
                }
            }
        }

        return false;
    }
}

