package coding.test.besuccessfulapplicants.queue;

import java.util.ArrayDeque;

class JosephusProblem { // https://school.programmers.co.kr/learn/courses/30/lessons/81303
    public int solution(int N, int K) {
        var dq = new ArrayDeque<Integer>();
        for (int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }

        while (dq.size() > 1) {
            for (int i = 0; i < K - 1; i++) {
                dq.offerLast(dq.pollFirst());
            }
            dq.pollFirst();
        }

        return dq.pollFirst();
    }
}
