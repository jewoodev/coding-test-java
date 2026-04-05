package coding.test.leetcode.easy;

class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) return 0;

        // 1. pi 배열 구축
        int[] pi = new int[m];
        int len = 0;  // 이전 위치까지의 최장 prefix-suffix 길이
        int i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                pi[i++] = ++len;
            } else if (len > 0) {
                len = pi[len - 1];  // 핵심: len을 0으로 리셋하지 않고 pi를 따라감
            } else {
                pi[i++] = 0;
            }
        }

        // 2. 매칭
        int hi = 0, ni = 0;
        while (hi < n) {
            if (haystack.charAt(hi) == needle.charAt(ni)) {
                hi++;
                ni++;
                if (ni == m) return hi - m;
            } else if (ni > 0) {
                ni = pi[ni - 1];  // haystack 포인터는 되돌리지 않음
            } else {
                hi++;
            }
        }

        return -1;
    }
}
