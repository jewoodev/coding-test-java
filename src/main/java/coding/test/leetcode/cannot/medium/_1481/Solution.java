package coding.test.leetcode.cannot.medium._1481;

import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 1. 빈도 계산
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 2. 빈도 정렬
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies);

        // 3. k만큼 삭제 수행
        int uniqueCount = frequencies.size();
        for (int freq : frequencies) {
            if (k >= freq) {
                k -= freq;
                uniqueCount--;
            } else {
                break;
            }
        }

        // 4. 결과 반환
        return uniqueCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 테스트 케이스
        int[] arr1 = {5, 5, 4};
        int k1 = 1;
        System.out.println(solution.findLeastNumOfUniqueInts(arr1, k1)); // 출력: 1

        int[] arr2 = {4, 3, 1, 1, 3, 3, 2};
        int k2 = 3;
        System.out.println(solution.findLeastNumOfUniqueInts(arr2, k2)); // 출력: 2
    }
}
