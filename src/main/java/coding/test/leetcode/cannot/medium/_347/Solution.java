package coding.test.leetcode.cannot.medium._347;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 숫자별 빈도수 계산
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 빈도수를 인덱스로 하는 버킷 생성
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // 3. 빈도수가 높은 순서대로 k개 선택
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }

        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
