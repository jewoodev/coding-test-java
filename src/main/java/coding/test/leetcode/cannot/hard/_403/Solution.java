package coding.test.leetcode.cannot.hard._403;

class Solution {
    public boolean canCross(int[] stones) {
        boolean flag = false;
        int k = 0;
        for (int i = 0; i < stones.length - 1; i++) {
            if(stones[i+1] - stones[i] == k - 1 ||
                    stones[i+1] - stones[i] == k ||
                    stones[i+1] - stones[i] == k + 1) {
                flag = true;
            } else flag = false;
        }
        return flag;
    }
}
