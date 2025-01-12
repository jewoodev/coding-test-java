package coding.test.datastructure_with.ch3;

public class Problem3 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";

        // 재귀적으로 문자열 조합 생성
        generateCombinations(str1, str2, "", 0, 0);
    }

    // str1과 str2의 인덱스 i, j를 사용하여 가능한 모든 문자열 조합을 생성하는 함수
    public static void generateCombinations(String str1, String str2, String current, int i, int j) {
        // 기저 조건: 둘 다 끝에 도달했으면 출력
        if (i == str1.length() && j == str2.length()) {
            System.out.println(current);
            return;
        }

        // str1에서 문자를 하나 추가한 경우
        if (i < str1.length()) {
            generateCombinations(str1, str2, current + str1.charAt(i), i + 1, j);
        }

        // str2에서 문자를 하나 추가한 경우
        if (j < str2.length()) {
            generateCombinations(str1, str2, current + str2.charAt(j), i, j + 1);
        }
    }
}
