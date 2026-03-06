package coding.test.besuccessfulapplicants.stack;

import java.util.*;

class RotateParentheses {
    public int solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
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
        var dq =  new ArrayDeque<>(origin);
        Deque<Character> stack = new ArrayDeque<>();

        while (!dq.isEmpty()) {
            var cur = dq.pollFirst();
            if (cur == '(' || cur == '{' || cur =='[') {
                stack.push(cur);
            }
            else {
                if (stack.isEmpty()) return false;

                char before = stack.peek();

                switch (cur) {
                    case ')' -> {
                        if (before != '(') return false;
                    }
                    case '}' -> {
                        if (before != '{') return false;
                    }
                    case ']' -> {
                        if (before != '[') return false;
                    }
                }
                stack.pop();
            }
        }
        return true;
    }
}
