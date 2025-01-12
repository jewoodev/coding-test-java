package coding.test.datastructure_with.ch3;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public static void main(String[] args) {
        int N = 2; // 예시로 N=2
        List<String> sequences = findSequences(N);

        // 결과 출력
        for (String sequence : sequences) {
            System.out.println(sequence);
        }
    }

    public static List<String> findSequences(int N) {
        List<String> result = new ArrayList<>();
        int length = 2 * N; // 전체 길이
        char[] sequence = new char[length];

        // 재귀 호출 시작
        findSequencesRecursive(sequence, 0, N, result);
        return result;
    }

    private static void findSequencesRecursive(char[] sequence, int index, int N, List<String> result) {
        int length = sequence.length;

        // 모든 비트를 다 채운 경우
        if (index == length) {
            if (isValid(sequence, N)) {
                result.add(new String(sequence));
            }
            return;
        }

        // 현재 위치에 0을 넣는 경우
        sequence[index] = '0';
        findSequencesRecursive(sequence, index + 1, N, result);

        // 현재 위치에 1을 넣는 경우
        sequence[index] = '1';
        findSequencesRecursive(sequence, index + 1, N, result);
    }

    private static boolean isValid(char[] sequence, int N) {
        int firstSum = 0;
        int lastSum = 0;

        // 첫 N 비트 합 계산
        for (int i = 0; i < N; i++) {
            firstSum += sequence[i] - '0'; // '0' 또는 '1'을 정수로 변환
        }

        // 마지막 N 비트 합 계산
        for (int i = sequence.length - N; i < sequence.length; i++) {
            lastSum += sequence[i] - '0';
        }

        // 합이 동일한지 확인
        return firstSum == lastSum;
    }
}
