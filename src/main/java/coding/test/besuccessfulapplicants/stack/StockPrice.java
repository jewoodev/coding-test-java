package coding.test.besuccessfulapplicants.stack;

import java.util.ArrayDeque;

class StockPrice { // https://school.programmers.co.kr/learn/courses/30/lessons/42584
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        var dq = new ArrayDeque<Integer>();
        dq.offerLast(0);

        for (int i = 1; i < n; i++) {
            while (!dq.isEmpty() && prices[i] < prices[dq.peekLast()]) {
                int j = dq.pollLast();
                answer[j] = i - j;
            }
            dq.offerLast(i);
        }

        while (!dq.isEmpty()) {
            int j = dq.pollLast();
            answer[j] = n - 1 - j;
        }

        return answer;
    }
}
