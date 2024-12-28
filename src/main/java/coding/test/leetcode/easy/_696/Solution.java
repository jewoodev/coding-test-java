package coding.test.leetcode.easy._696;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int countBinarySubstrings(String s) {
        Deque<String> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length()+1; j++) {
                String substring = s.substring(i, j);
                char[] chars = substring.toCharArray();
                char first = chars[0];
                int count = 0;
                boolean flag = false;
                boolean secondFlag = true;
                for (char c : chars) {
                    if (c == first) {
                        count++;
                        if (flag == true) {
                            secondFlag = false;
                            break;
                        }
                    }
                    else {
                        count--;
                        flag = true;
                    }
                }
                if (secondFlag == false) break;
                if (count == 0 && flag == true) dq.add(substring);
            }
        }
        return dq.size();
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}