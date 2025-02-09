package coding.test.leetcode.cannot.medium._57;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. 겹치지 않는 구간 (newInterval보다 앞에 있는 경우)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. 겹치는 구간 병합
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // 병합된 newInterval 추가

        // 3. 남은 구간 추가
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // 4. 리스트를 배열로 변환하여 반환
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = insert(intervals1, newInterval1);
        printResult(result1);

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = insert(intervals2, newInterval2);
        printResult(result2);
    }

    private static void printResult(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + "," + intervals[i][1] + "]");
            if (i < intervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}