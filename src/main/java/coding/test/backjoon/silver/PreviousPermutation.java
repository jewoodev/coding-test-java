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
            sb.append(-1);
        }
        System.out.println(sb);
    }

    private static boolean prevPermutation(int[] arr) {
        // 1. 무엇(i)으로 시작하는 '가장 첫 순열'인지 파악
        int i = arr.length - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        // '가장 첫 순열'이 수열의 부분 수열에 없다면,
        // 수열 자체가 '가장 첫 순열' 이므로 -1 반환
        if (i < 0) return false;

        // 2. n-1부터 역순으로, 'arr[i]보다 작은 수 중에 가장 큰 수'(j)를 찾기
        int j = arr.length - 1;
        while (arr[i] <= arr[j]) {
            j--;
        }

        // 3. arr[i]와 arr[j]를 교환
        swap(arr, i, j);

        // 4. i+1부터 끝까지 뒤집기
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    // 배열의 두 원소를 교환
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 배열의 특정 구간을 뒤집는다
    private static void reverse(int[] arr, int i, int j) {
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}