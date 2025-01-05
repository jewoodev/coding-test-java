package coding.test.leetcode.easy._1710;

import java.util.Arrays;

/**
 * Bucket 정렬을 사용하면 더 효율적으로 풀 수 있는 케이스.
 */

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int result = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] < truckSize) {
                result += boxTypes[i][0]* boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                result += truckSize * boxTypes[i][1];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4));
    }
}
