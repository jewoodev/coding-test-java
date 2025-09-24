package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class AllPermutation { // https://www.acmicpc.net/problem/10974, 브루트포스 & 백트래킹
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
            sb.append(i).append(" ");
        }
        sb.append("\n");

        while (allPermutation(arr)) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static boolean allPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[i] >= arr[j]) {
            j--;
        }

        swap(arr, i, j);
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
