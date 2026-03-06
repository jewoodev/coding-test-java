package coding.test.besuccessfulapplicants.stack;

import java.util.*;

class RotateParentheses {
    public int solution(String s) {
        var dq = new ArrayDeque<Character>();
        for (var c : s.toCharArray()) {
            dq.offerLast(c);
        }
        int cnt = 0;

        if (isCorrect(dq)) cnt++;

        for (int i = 0; i < s.length() - 1; i++) {
            dq.offerLast(dq.pollFirst());
            if (isCorrect(dq)) cnt++;
        }

        return cnt;
    }

    private boolean isCorrect(Deque<Character> origin) {
        var stack = new ArrayDeque<Character>();

        for (var cur : origin) {
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            }
            else {
                if (stack.isEmpty()) return false;

                var before = stack.pop();
                if (cur == ']' && before != '[') return false;
                if (cur == ')' && before != '(') return false;
                if (cur == '}' && before != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
