package coding.test.besuccessfulapplicants.stack;

import java.util.*;

class RemovePairs { // https://school.programmers.co.kr/learn/courses/30/lessons/12973
    public int solution(String s)
    {
        var dq = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!dq.isEmpty() && dq.peekLast() == c) {
                dq.pollLast();
            }
            else dq.offerLast(c);
        }

        return dq.isEmpty() ? 1 : 0;
    }
}
