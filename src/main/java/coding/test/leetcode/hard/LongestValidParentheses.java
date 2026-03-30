package coding.test.leetcode.hard;

import java.util.ArrayDeque;

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        var dq = new ArrayDeque<Integer>();
        dq.offerLast(-1);

        var cnt =  0;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (c == '(') {
                dq.offerLast(i);
            } else {
                dq.pollLast();
                if (dq.isEmpty()) {
                    dq.offerLast(i);
                } else {
                    cnt = Math.max(cnt, i - dq.peekLast());
                }
            }
        }
        return cnt;
    }
}
