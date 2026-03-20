package coding.test.leetcode.easy;

import java.util.*;

class RansomNote { // https://leetcode.com/problems/ransom-note/description/
    public boolean canConstruct(String ransomNote, String magazine) {
        var map = new HashMap<Character, Integer>();
        for (char c : magazine.toCharArray()) {
            var cnt = map.getOrDefault(c,0);
            map.put(c,++cnt);
        }

        for (char c : ransomNote.toCharArray()) {
            var cnt = map.get(c);
            if (cnt == null || cnt < 1) return false;
            map.put(c,--cnt);
        }
        return true;
    }
}
