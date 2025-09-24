package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class PreviousPermutation { // https://www.acmicpc.net/problem/10973, 수학 & 조합론
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        if (prevPermutation(arr)) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            System.out.println(-1);
        }
    }

    // 이전 순열을 구하는 함수
    private static boolean prevPermutation(int[] arr) {
        int n = arr.length;

        // 1. 뒤에서부터 탐색하면서 arr[i] > arr[i+1]인 가장 큰 i를 찾는다
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        // 만약 그러한 i가 없다면 가장 작은 순열(오름차순)이므로 -1 반환
        if (i < 0) {
            return false;
        }

        // 2. arr[i] > arr[j]인 가장 큰 j를 찾는다 (i < j)
        int j = n - 1;
        while (arr[i] <= arr[j]) {
            j--;
        }

        // 3. arr[i]와 arr[j]를 교환
        swap(arr, i, j);

        // 4. i+1부터 끝까지 내림차순으로 정렬 (reverse)
        reverse(arr, i + 1, n - 1);

        return true;
    }

    // 배열의 두 원소를 교환
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 배열의 특정 구간을 뒤집는다
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}