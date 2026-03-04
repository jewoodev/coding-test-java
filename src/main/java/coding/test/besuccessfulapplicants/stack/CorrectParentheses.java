package coding.test.besuccessfulapplicants.stack;

import java.util.*;

class CorrectParentheses { // https://school.programmers.co.kr/learn/courses/30/lessons/12909
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            var cur = s.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
