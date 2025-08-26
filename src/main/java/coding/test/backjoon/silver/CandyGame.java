package coding.test.backjoon.silver;

import java.io.*;

public class CandyGame { // https://www.acmicpc.net/problem/3085
    static int check(char[][] a, int startRow, int endRow, int startCol, int endCol) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int ans = 0;

        ans= check(arr, 0, N - 1, 0, N - 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    char t = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;

                    int temp = check(arr, i, i, j, j + 1);
                    if (ans < temp) ans = temp;

                    t = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;
                }

                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    char t = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = t;

                    int temp = check(arr, i, i + 1, j, j);
                    if (ans < temp) ans = temp;

                    t = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = t;
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
