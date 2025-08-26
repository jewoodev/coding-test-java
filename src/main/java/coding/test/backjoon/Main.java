package coding.test.backjoon;

import java.io.*;

public class Main {
    static int check(char[][] a) {
        int n = a.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;

            for (int j = 1; j < n; j++) {
                if (a[i][j] == a[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if (ans < cnt) ans = cnt;
            }

            cnt = 1;

            for (int j = 1; j < n; j++) {
                if (a[j][i] == a[j - 1][i]) {
                    cnt += 1;
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    char t = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;

                    int temp = check(arr);
                    if (ans < temp) ans = temp;

                    t = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = t;
                }

                if (i + 1 < N && arr[i][j] != arr[i + 1][j]) {
                    char t = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = t;

                    int temp = check(arr);
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
