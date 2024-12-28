package coding.test.leetcode.cannot.easy._696;


class Solution {
    public static int countBinarySubstrings(String s) {
        int prevGroupLength = 0; // 이전 그룹의 길이
        int currGroupLength = 1; // 현재 그룹의 길이
        int count = 0; // 결과값

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroupLength++; // 현재 그룹의 길이를 증가
            } else {
                count += Math.min(prevGroupLength, currGroupLength); // 이전 그룹과 현재 그룹의 최소값을 결과에 추가
                prevGroupLength = currGroupLength; // 현재 그룹을 이전 그룹으로 변경
                currGroupLength = 1; // 새로운 그룹 시작
            }
        }

        // 마지막 그룹 처리
        count += Math.min(prevGroupLength, currGroupLength);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}