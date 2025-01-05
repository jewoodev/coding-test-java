package coding.test.leetcode.cannot.medium._1424;

import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        int totalElements = 0;

        // 각 요소를 대각선 그룹으로 분류
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int diagonalKey = i + j;
                diagonalMap.putIfAbsent(diagonalKey, new ArrayList<>());
                diagonalMap.get(diagonalKey).add(nums.get(i).get(j));
                totalElements++;
            }
        }

        // 결과 배열 생성
        int[] result = new int[totalElements];
        int index = 0;

        // 대각선 순서대로 요소 추가
        for (int key = 0; key <= diagonalMap.size(); key++) {
            if (diagonalMap.containsKey(key)) {
                List<Integer> diagonal = diagonalMap.get(key);
                // 대각선의 요소는 역순으로 저장되므로 순서대로 결과에 추가
                for (int i = diagonal.size() - 1; i >= 0; i--) {
                    result[index++] = diagonal.get(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예제 1
        List<List<Integer>> nums1 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        System.out.println(Arrays.toString(solution.findDiagonalOrder(nums1))); // [1, 4, 2, 7, 5, 3, 8, 6, 9]

        // 예제 2
        List<List<Integer>> nums2 = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7),
                Arrays.asList(8),
                Arrays.asList(9, 10, 11),
                Arrays.asList(12, 13, 14, 15, 16)
        );
        System.out.println(Arrays.toString(solution.findDiagonalOrder(nums2))); // [1, 6, 2, 7, 3, 8, 4, 9, 12, 5, 10, 13, 11, 14, 15, 16]
    }
}
