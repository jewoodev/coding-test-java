package coding.test.besuccessfulapplicants.stack;

import java.util.*;

public class RemovePairs { // https://school.programmers.co.kr/learn/courses/30/lessons/12973
    public int solution(String s)
    {
        var dq = new ArrayDeque<Character>();

        var inputToChar = s.toCharArray();
        for (int i = 0; i < inputToChar.length; i++) {
            dq.push(inputToChar[i]);
        }

        for (int i = 0; i < inputToChar.length; i++) {
            if (dq.isEmpty()) return 1;

            var cur = dq.pollFirst();
            var next = dq.peekFirst();

            if (cur == next) dq.pollFirst();
            else dq.offerLast(cur);
        }

        return dq.isEmpty() ? 1 : 0;
    }
}
