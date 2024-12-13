package coding.test.leetcode.cannot.medium._443;

class Solution {
    public int compress(char[] chars) {
        int write = 0;  // 압축된 문자를 기록할 위치
        int read = 0;   // 현재 문자를 읽는 위치

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // 현재 문자 그룹의 길이를 계산
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // 현재 문자를 기록
            chars[write++] = currentChar;

            // 길이가 2 이상인 경우 길이를 기록
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;  // 압축된 배열의 길이 반환
    }
}
