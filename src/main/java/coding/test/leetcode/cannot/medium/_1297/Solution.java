package coding.test.leetcode.cannot.medium._1297;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // 빈도수 저장용 Map
        Map<String, Integer> substringFrequency = new HashMap<>();
        int maxFrequency = 0;

        // 슬라이딩 윈도우와 고유 문자 체크용 배열
        int[] charCount = new int[26];
        int uniqueCount = 0;

        // 슬라이딩 윈도우
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 오른쪽 문자 추가
            char rightChar = s.charAt(i);
            if (charCount[rightChar - 'a']++ == 0) uniqueCount++;

            // 윈도우 크기 제한 유지
            while (i - j + 1 > minSize) {
                char leftChar = s.charAt(j++);
                if (--charCount[leftChar - 'a'] == 0) uniqueCount--;
            }

            // 조건 만족 시 빈도수 업데이트
            if (i - j + 1 == minSize && uniqueCount <= maxLetters) {
                String substring = s.substring(j, i + 1);
                substringFrequency.put(substring, substringFrequency.getOrDefault(substring, 0) + 1);
                maxFrequency = Math.max(maxFrequency, substringFrequency.get(substring));
            }
        }

        return maxFrequency;
    }
}
