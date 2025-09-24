package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class NextPermutation { // https://www.acmicpc.net/problem/10972, 수학 & 조합론
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        if (nextPermutation(arr)) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    private static boolean nextPermutation(int[] arr) {
        // 1. 무엇(i)으로 시작하는 '가장 마지막 순열'인지 파악
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // '가장 마지막 순열'이 수열의 부분 수열에 없다면,
        // 수열 자체가 '가장 마지막 순열' 이므로 -1 반환
        if (i < 0) return false;

        // 2. n-1 부터 역순으로, 'arr[i]보다 큰 수 중에 가장 작은 수'(j)를 찾기
        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }

        // 3. arr[i]와 arr[j] 교체
        swap(arr, i, j);

        // 4. i+1부터 끝까지 뒤집기
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
