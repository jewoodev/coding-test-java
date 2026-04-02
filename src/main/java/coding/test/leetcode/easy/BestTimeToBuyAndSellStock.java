package coding.test.leetcode.easy;

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                answer = Math.max(answer, prices[i] - min);
            }
        }

        return answer;
    }
}
