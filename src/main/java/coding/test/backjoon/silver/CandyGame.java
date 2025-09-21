package coding.test.backjoon.silver;

import java.io.*;

public class CandyGame { // https://www.acmicpc.net/problem/3085, 브루트 포스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int ans = 0;

        ans = check(arr, 0, N - 1, 0, N - 1); // 원본 상태일 때 최대 사탕 수로 갱신

        ans = findMaxCandyCnt(N, arr, ans); // 두 사탕 위치를 바꾸는 모든 경우의 수를 수행하여 최대 사탕 수 갱신

        // (O($50^{3}$ = 약 12만) 의 시간 복잡도)

        System.out.println(ans);
    }

    private static int check(char[][] a, int startRow, int endRow, int startCol, int endCol) {
        int n = a.length;
        int ans = 1;

        for (int i = startRow; i <= endRow; i++) {
            int cnt = 1;

            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if (ans < cnt) ans = cnt;
            }
        }

        for (int i = startCol; i <= endCol; i++) {
            int cnt = 1;

            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j - 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if (ans < cnt) ans = cnt;
            }
        }

        return ans;
    }

    private static int findMaxCandyCnt(int N, char[][] arr, int ans) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) { // 하나의 열 씩 탐색하며 인접한 두 사탕이 다를 때마다 바꾸며
                    char t = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;

                    int temp = check(arr, i, i, j, j + 1); // 먹을 수 있는 최대 사탕 수를
                    if (ans < temp) ans = temp; // 갱신

                    t = arr[i][j]; // 작업이 끝나면, 원상 복구
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;
                }

                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {  // 하나의 행 씩 탐색하며 동일하게
                    char t = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = t;

                    int temp = check(arr, i, i + 1, j, j);
                    if (ans < temp) ans = temp; // 갱신

                    t = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = t;
                }
            }
        }
        return ans;
    }
}
