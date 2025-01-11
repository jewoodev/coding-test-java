package coding.test.leetcode.cannot.medium._45;

class Solution {
    public int jump(int[] nums) {
        int jumps = 0; // 점프 횟수
        int currentEnd = 0; // 현재 점프 범위 끝
        int farthest = 0; // 현재까지 도달할 수 있는 가장 먼 위치

        for (int i = 0; i < nums.length - 1; i++) {
            // 현재 위치에서 도달할 수 있는 최대 위치 갱신
            farthest = Math.max(farthest, i + nums[i]);

            // 현재 점프 범위 끝에 도달하면 점프 횟수 증가
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // 도달할 수 있는 범위가 끝을 넘으면 바로 종료
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}