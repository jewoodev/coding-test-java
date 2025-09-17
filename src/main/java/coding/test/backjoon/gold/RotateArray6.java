package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RotateArray6 { // https://www.acmicpc.net/problem/16935, 구현

    private static int[][] oneToFour(int[][] arr, int n, int k, int len) {
        for (int sy = 0; sy < n; sy += len) {
            for (int sx = 0; sx < n; sx += len) {
                // 부분 배열 초기화
                int[][] temp = new int[len][len];
                for (int m = 0; m < len; m++) {
                    for (int l = 0; l < len; l++) {
                        temp[m][l] = arr[sy + m][sx + l];
                    }
                }

                switch (k) {
                    case 1 -> temp = one(temp);
                    case 2 -> temp = two(temp);
                    case 3 -> temp = three(temp);
                    case 4 -> temp = four(temp);
                }

                for (int m = 0; m < len; m++) {
                    for (int l = 0; l < len; l++) {
                        arr[sy + m][sx + l] = temp[m][l];
                    }
                }
            }
        }
        return arr;
    }

    private static int[][] one(int[][] arr) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = arr[n - 1 - i][j];
            }
        }
        return ans;
    }

    private static int[][] five(int[][] arr, int subSize) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        int subCnt = n / subSize;
        for (int i = 0; i < subCnt; i++) {
            for (int j = 0; j < subCnt; j++) {
                int y1 = i * subSize;
                int x1 = j * subSize;
                int y2 = (subCnt - 1 - i) * subSize;
                int x2 = j * subSize;
                for (int y = 0; y < subSize; y++) {
                    for (int x = 0; x < subSize; x++) {
                        ans[y1 + y][x1 + x] = arr[y2 + y][x2 + x];
                    }
                }
            }
        }
        return ans;
    }

    private static int[][] two(int[][] arr) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = arr[i][n - 1 - j];
            }
        }
        return ans;
    }

    private static int[][] six(int[][] arr, int subSize) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        int subCnt = n / subSize;
        for (int i = 0; i < subCnt; i++) {
            for (int j = 0; j < subCnt; j++) {
                int y1 = i * subSize;
                int x1 = j * subSize;
                int y2 = i * subSize;
                int x2 = (subCnt - 1 - j) * subSize;
                for (int y = 0; y < subSize; y++) {
                    for (int x = 0; x < subSize; x++) {
                        ans[y1 + y][x1 + x] = arr[y2 + y][x2 + x];
                    }
                }
            }
        }
        return ans;
    }

    private static int[][] three(int[][] arr) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = arr[n - 1 - j][i];
            }
        }
        return ans;
    }

    // 7번 연산: 오른쪽으로 90도 회전 (부분배열 단위)
    private static int[][] seven(int[][] arr, int subSize) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        int subCnt = n / subSize;
        for (int i = 0; i < subCnt; i++) { // 부분배열의 Y축 기점
            for (int j = 0; j < subCnt; j++) { // 부분배열의 X축 기점
                // 현재 위치 (i, j)에 있는 부분배열
                int fromY = i * subSize;
                int fromX = j * subSize;

                // 오른쪽 90도 회전 후 위치: (j, subCnt-1-i)
                int toY = j * subSize;
                int toX = (subCnt - 1 - i)  * subSize;


                for (int x = 0; x < subSize; x++) {
                    for (int y = 0; y < subSize; y++) {
                        ans[toY + y][toX + x] = arr[fromY + y][fromX + x];
                    }
                }
            }
        }
        return ans;
    }

    private static int[][] four(int[][] arr) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = arr[j][n - 1 - i];
            }
        }
        return ans;
    }

    // 8번 연산: 왼쪽으로 90도 회전 (부분배열 단위)
    private static int[][] eight(int[][] arr, int subSize) {
        int n = arr.length;
        int[][] ans = new int[n][n];
        int subCnt = n / subSize;
        for (int i = 0; i < subCnt; i++) {
            for (int j = 0; j < subCnt; j++) {
                // 현재 위치 (i, j)에 있는 부분배열
                int fromY = i * subSize;
                int fromX = j * subSize;

                // 왼쪽 90도 회전 후 위치: (subCnt-1-j, i)
                int toY = (subCnt - 1 - j) * subSize;
                int toX = i * subSize;

                for (int y = 0; y < subSize; y++) {
                    for (int x = 0; x < subSize; x++) {
                        ans[toY + y][toX + x] = arr[fromY + y][fromX + x];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n x n
        n = 1 << n;
        int r = Integer.parseInt(st.nextToken()); // 연산 횟수
        int[][] arr = new int[n][n]; // 주어지는 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) { // r번 연산 시작
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // k 번 연산
            int l = Integer.parseInt(st.nextToken()); // 단계 l
            l = 1 << l;

            if (k < 5) arr = oneToFour(arr, n, k, l);
            else switch (k) {
                case 5 -> arr = five(arr , l);
                case 6 -> arr = six(arr , l);
                case 7 -> arr = seven(arr, l);
                case 8 -> arr = eight(arr, l);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
