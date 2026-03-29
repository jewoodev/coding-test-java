package coding.test.leetcode.easy;

import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        var dq = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dq.offerLast(')');
            } else if (c == '{') {
                dq.offerLast('}');
            } else if (c == '[') {
                dq.offerLast(']');
            } else {
                if (dq.isEmpty()) return false;

                var before = dq.pollLast();
                if (before != c) {
                    return false;
                }
            }
        }

        return dq.isEmpty();
    }
}
