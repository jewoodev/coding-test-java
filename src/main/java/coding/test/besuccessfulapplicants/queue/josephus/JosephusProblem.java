package coding.test.besuccessfulapplicants.queue.josephus;

import java.util.ArrayDeque;

class JosephusProblem {
    public int solution(int N, int K) {
        var q = new ArrayDeque<Integer>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int cnt = 1;
        while (q.size() != 1) {
            if (cnt % K == 0) {
                q.poll();
            } else q.offer(q.poll());
            cnt++;
        }

        return q.poll();
    }
}
