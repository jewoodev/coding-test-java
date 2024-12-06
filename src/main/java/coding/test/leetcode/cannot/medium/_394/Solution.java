package coding.test.leetcode.cannot.medium._394;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque();
        Deque<StringBuilder> resStack = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else if (c == '[') {
                countStack.push(count);
                resStack.push(sb);
                sb = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder prefix = resStack.pop();
                int k = countStack.pop();
                while (k > 0) {
                    prefix.append(sb);
                    k--;
                }
                sb = prefix;
            }
        }

        return sb.toString();
    }
}
