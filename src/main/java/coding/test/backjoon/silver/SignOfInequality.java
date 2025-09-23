package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class SignOfInequality {
    private static int k;
    private static char[] soi;
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        soi = new char[k];
        for (int i = 0; i < k; i++) {
            soi[i] = st.nextToken().charAt(0);
        }
        boolean[] used = new boolean[10];
        int[] num = new int[k + 1];

        // 최대값 찾기 (큰 수부터 시도)
        findMax(num, 0, used);

        // 최소값 찾기 (작은 수부터 시도)
        findMin(num, 0, used);

        System.out.print(ans);
    }

    private static boolean findMax(int[] num, int curLen, boolean[] used) {
        if (curLen == k + 1) {
            if (verify(num)) {
                for (int i = 0; i <= k; i++) {
                    ans.append(num[i]);
                }
                ans.append("\n");
                return true; // 첫 번째로 찾은 것이 최대값
            }
            return false;
        }

        // 최대값을 위해 9부터 0까지 시도
        for (int i = 9; i >= 0; i--) {
            if (used[i]) continue;

            used[i] = true;
            num[curLen] = i;

            // 해당 루프에서 추가된 숫자가 부등호를 만족하는지 체크
            if (curLen == 0 || checkCondition(num, curLen - 1)) {
                if (findMax(num, curLen + 1, used)) {
                    used[i] = false;
                    return true;
                }
            }

            used[i] = false;
        }
        return false;
    }

    private static boolean findMin(int[] num, int curLen, boolean[] used) {
        if (curLen == k + 1) {
            if (verify(num)) {
                for (int i = 0; i <= k; i++) {
                    ans.append(num[i]);
                }
                ans.append("\n");
                return true; // 첫 번째로 찾은 것이 최소값
            }
            return false;
        }

        // 최소값을 위해 0부터 9까지 시도
        for (int i = 0; i <= 9; i++) {
            if (used[i]) continue;

            used[i] = true;
            num[curLen] = i;

            // 해당 루프에서 추가된 숫자가 부등호를 만족하는지 체크
            if (curLen == 0 || checkCondition(num, curLen - 1)) {
                if (findMin(num, curLen + 1, used)) {
                    used[i] = false;
                    return true;
                }
            }

            used[i] = false;
        }
        return false;
    }

    // 모든 부등호 조건 확인
    private static boolean verify(int[] num) {
        for (int i = 0; i < k; i++) {
            if (!checkCondition(num, i)) {
                return false;
            }
        }
        return true;
    }

    // 특정 위치의 부등호 조건만 확인
    private static boolean checkCondition(int[] num, int pos) {
        if (pos >= k) return true;

        if (soi[pos] == '<') {
            return num[pos] < num[pos + 1];
        } else {
            return num[pos] > num[pos + 1];
        }
    }
}
