# [57. Insert Interval](https://leetcode.com/problems/insert-interval/description/)

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

**Example 1:**

> **Input**: intervals = [[1,3],[6,9]], newInterval = [2,5]
> **Output**: [[1,5],[6,9]

**Example 2:**

> **Input**: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
> **Output**: [[1,2],[3,10],[12,16]]
> **Explanation**: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

**Constraints:**

- 0 <= intervals.length <= 104 
- intervals[i].length == 2 
- 0 <= starti <= endi <= 105 
- intervals is sorted by starti in ascending order. 
- newInterval.length == 2 
- 0 <= start <= end <= 105

---

## 접근 방식

1. **결과 리스트 초기화**: List<int[]> result를 사용하여 새로운 인터벌들을 저장합니다. 
2. **초기 인덱스 설정**: int i = 0을 설정하여 기존 intervals을 순회합니다. 
3. 겹치지 않는 인터벌 추가:
   - intervals[i][1] < newInterval[0]인 경우, newInterval과 겹치지 않으므로 현재 intervals[i]를 result에 추가하고 i++ 합니다. 
4. 겹치는 구간 병합:
- intervals[i][0] <= newInterval[1]인 경우, newInterval과 현재 intervals[i]가 겹치므로 newInterval을 병합합니다.
- newInterval[0] = Math.min(newInterval[0], intervals[i][0])
- newInterval[1] = Math.max(newInterval[1], intervals[i][1])
- i++ 하여 다음 인터벌을 확인합니다.
5. 병합된 newInterval 추가:
   - 병합된 newInterval을 result에 추가합니다.
6. 남은 인터벌 추가:
   - intervals[i][0] > newInterval[1] 이후 남은 모든 인터벌을 result에 추가합니다.
7. 리스트를 배열로 변환: result.toArray(new int[result.size()][])를 사용하여 결과를 반환합니다.

## 코드

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
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
```

## 시간 복잡도 분석

- O(N), 여기서 N은 intervals 배열의 크기입니다. 
- while 루프 3개가 있지만, 각 루프에서 i가 증가하며 한 번씩만 방문하므로 O(N)이 유지됩니다.