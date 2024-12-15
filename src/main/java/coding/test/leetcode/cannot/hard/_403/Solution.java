package coding.test.leetcode.cannot.hard._403;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // 각 돌 위치를 map에 저장하고 초기 상태를 설정
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(1); // 첫 점프는 1로 시작

        for (int stone : stones) {
            for (int jump : map.get(stone)) {
                int nextStone = stone + jump;
                if (nextStone == stones[stones.length - 1]) {
                    return true; // 마지막 돌에 도달하면 true 반환
                }
                if (map.containsKey(nextStone)) {
                    if (jump - 1 > 0) map.get(nextStone).add(jump - 1);
                    map.get(nextStone).add(jump);
                    map.get(nextStone).add(jump + 1);
                }
            }
        }

        return false;
    }
}
