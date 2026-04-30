package coding.test.besuccessfulapplicants.queue.stackofcards;

import java.util.*;

class StackOfCards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        var q1 = new ArrayDeque<>(Arrays.asList(cards1));
        var q2 = new ArrayDeque<>(Arrays.asList(cards2));

        for (String s : goal) {
            if (!q1.isEmpty() && q1.peek().equals(s)) {
                q1.poll();
            }
            else if (!q2.isEmpty() && q2.peek().equals(s)) {
                q2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }
}
