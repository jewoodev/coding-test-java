package coding.test.hanghae.secondweek.fail;

import java.io.*;
import java.util.*;

class BJ17140 {
    private static int[][] A;
    private static class NumberA implements Comparable<NumberA> {
        int value, cnt;
        NumberA(int v, int c) {
            value = v;
            cnt = c;
        }
        @Override
        public int compareTo(NumberA o) {
            if (this.cnt != o.cnt)
                return this.cnt - o.cnt;
            else
                return this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        A = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            if (time > 100) { // 100초를 넘기면 종료
                time = -1;
                break;
            }
            if (r < A.length && c < A[0].length) {
                if (A[r][c] == k) break;
            }
            if (A.length >= A[0].length) operationR();
            else operationC();
            time++;
        }
        System.out.print(time);
    }

    private static void operationR() {
        int maxSize = Integer.MIN_VALUE;
        int[][] tmp = new int[101][101];
        for (int i = 0; i < A.length; i++) {
            int[] arr = new int[101];
            List<NumberA> list = new ArrayList<>();
            // 1 ~ N 까지 카운트
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) continue;
                arr[A[i][j]]++;
            }
            // 숫자와 숫자의 등장횟수를 저장
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == 0) continue;
                list.add(new NumberA(j, arr[j]));
            }
            // 저장된 값들을 정렬한 후 최대사이즈 찾기
            Collections.sort(list);
            int k = 0;
            for (int j = 0; j < list.size(); j++) {
                tmp[i][k] = list.get(j).value;
                tmp[i][k + 1] = list.get(j).cnt;
                k += 2;
            }
            maxSize = Math.max(maxSize, k);
        }
        if (maxSize > 100) maxSize = 100;
        // 연산 후에 가장 큰 행을 기준으로 크기를 변경
        A = new int[A.length][maxSize];
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(tmp[i], 0, A[i], 0, maxSize);
        }
    }

    private static void operationC() {
        int maxSize = Integer.MIN_VALUE;
        int[][] tmp = new int[101][101];
        for (int j = 0; j < A[0].length; j++) {
            int[] arr = new int[101];
            List<NumberA> list = new ArrayList<>();
            // 1 ~ N 까지 카운트
            for (int i = 0; i < A.length; i++) {
                if (A[i][j] == 0) continue;
                arr[A[i][j]]++;
            }
            // 숫자와 숫자의 등장횟수를 저장
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                list.add(new NumberA(i, arr[i]));
            }
            // 저장된 값들을 정렬한 후 최대사이즈 찾기
            Collections.sort(list);
            int k = 0;
            for (int i = 0; i < list.size(); i++) {
                tmp[k][j] = list.get(i).value;
                tmp[k + 1][j] = list.get(i).cnt;
                k += 2;
            }
            maxSize = Math.max(maxSize, k);
        }
        if (maxSize > 100) maxSize = 100;
        // 연산 후에 가장 큰 열을 기준으로 크기를 변경
        A = new int[maxSize][A[0].length];
        for (int i = 0; i < maxSize; i++) {
            System.arraycopy(tmp[i], 0, A[i], 0, A[0].length);
        }
    }
}