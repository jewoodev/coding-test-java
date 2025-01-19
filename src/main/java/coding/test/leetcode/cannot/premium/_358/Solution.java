package coding.test.leetcode.cannot.premium._358;

import java.util.*;

class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) return s; // k가 0인 경우 그대로 반환

        // Step 1: 문자 빈도수 계산
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: 빈도수 기준으로 최대 힙 생성
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        // Step 3: 슬라이딩 윈도우 사용
        Queue<Character> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll(); // 가장 높은 빈도 문자를 가져옴
            result.append(current); // 결과 문자열에 추가

            // 대기열에 추가
            waitQueue.offer(current);
            frequencyMap.put(current, frequencyMap.get(current) - 1); // 빈도 감소

            // 대기열 크기가 k 이상이면 다시 힙에 추가
            if (waitQueue.size() >= k) {
                char front = waitQueue.poll();
                if (frequencyMap.get(front) > 0) {
                    maxHeap.offer(front);
                }
            }
        }

        // Step 4: 배치 불가능한 경우 처리
        return result.length() == s.length() ? result.toString() : "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.rearrangeString("aabbcc", 3)); // "abcabc"
        System.out.println(solution.rearrangeString("aaabc", 3));  // ""
        System.out.println(solution.rearrangeString("a", 0));      // "a"
        System.out.println(solution.rearrangeString("programming", 3));
    }
}
