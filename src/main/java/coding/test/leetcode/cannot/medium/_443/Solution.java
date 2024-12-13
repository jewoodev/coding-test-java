package coding.test.leetcode.cannot.medium._443;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int compress(char[] chars) {
        char cur = chars[0];
        int cnt = 1;
        List<Character> list = new ArrayList<>();
        list.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (cur == chars[i]) {
                cnt++;
            } else if (cnt == 1) {
                list.add(chars[i]);
            } else {
                String fromCnt = String.valueOf(cnt);
                for (int j = 0; j < fromCnt.length(); j++) list.add(fromCnt.charAt(j));
                cnt = 1;
                list.add(chars[i]);
                cur = chars[i];
            }
        }

        if (cnt != 1) {
            String fromCnt = String.valueOf(cnt);
            for (int j = 0; j < fromCnt.length(); j++) list.add(fromCnt.charAt(j));
        }
        chars = listToCharArray(list);
        return list.size();
    }

    private char[] listToCharArray(List<Character> charList) {
        char[] charArray = new char[charList.size()];

        for (int i = 0; i < charList.size(); i++) {
            charArray[i] = charList.get(i);
        }

        return charArray;
    }
}
