package coding.test.besuccessfulapplicants.queue.devfeat;

import java.util.*;

class DevelopFeature {
    public int[] solution(int[] progresses, int[] speeds) {
        var answer = new ArrayList<Integer>();
        var days = new ArrayDeque<Integer>();
        for (int i = 0; i < speeds.length; i++) {
            days.offer((int) Math.ceil(100.0 - progresses[i]) / speeds[i]);
        }

        while (!days.isEmpty()) {
            int front = days.poll();
            int cnt = 1;
            while (!days.isEmpty() && days.peek() <= front) {
                days.poll();
                cnt++;
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
