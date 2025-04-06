package coding.test.leetcode.cannot.medium._3169;

import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        int tail = meetings[0][1], cnt = meetings[0][0] - 1;

        for (int i = 1; i < meetings.length; i++) {
            if (tail < meetings[i][0] - 1) {
                cnt += meetings[i][0] - tail - 1;
                tail = meetings[i][1];
            } else {
                tail = Math.max(tail, meetings[i][1]);
            }
        }

        cnt += days - tail;
        return cnt;
    }
}
