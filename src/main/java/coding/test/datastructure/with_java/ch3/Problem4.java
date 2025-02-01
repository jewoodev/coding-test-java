package coding.test.datastructure.with_java.ch3;

public class Problem4 {
    // 재귀 함수를 이용하여 문자열을 복사하는 함수
    public static void copyString(String s1, String s2) {
        // 종료 조건: s1이 비어 있으면 종료
        if (s1.isEmpty()) {
            System.out.println("Output : " + s2);
            return;
        }

        // 첫 번째 문자 복사
        s2 += s1.charAt(0);

        // 나머지 문자를 재귀적으로 처리
        copyString(s1.substring(1), s2);
    }

    public static void main(String[] args) {
        // 예시 입력
        String s1 = "hello";
        String s2 = "geeksforgeeks"; // 이 값은 실제로 필요하지 않지만 입력 형식에 맞추기 위해 설정

        // 복사 함수 호출
        copyString(s1, "");
    }
}
