package coding.test.hanghae.beforehand.day2.fail;

import java.util.ArrayList;
import java.util.List;

//삼각 달팽이
public class TriangleSnail {
    static int N;
    private static List<Integer>[] al;

    public static int[] solution(int n) {
        int[] answer = {};
        N = n;
        al = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<>();
        }
        extracted(0, n, 1);
        return answer;
    }

    private static void extracted(int s, int e, int sVal) {
        for (int i = s; i < e; i++) {
            al[i].add(sVal);
            sVal++;
        }
        if (s < N) extracted(s + 1, e - 1, sVal);
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
