package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RotateArray3 { // https://www.acmicpc.net/problem/16935, 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
                R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int r = 0; r < R; r++) {
            int op = Integer.parseInt(st.nextToken());

            if (op < 3) {
                arr = reverse(arr, op);
            } else if (op < 5) {
                arr = rotate(arr, op);
            } else arr = groupRotate(arr, op);
        }
        br.close();

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ans.append(arr[i][j]).append(" ");
            }
            ans.append("\n");
        }
        System.out.print(ans);
    }

    private static int[][] reverse(int[][] arr, int op) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] tempArr = new int[N][M];

        switch (op) {
            case 1 -> {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tempArr[i][j] = arr[N - 1 - i][j];
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tempArr[i][j] = arr[i][M - 1 - j];
                    }
                }
            }
        }

        return tempArr;
    }

    private static int[][] rotate(int[][] arr, int op) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] tempArr = new int[M][N];

        switch (op) {
            case 3 -> {
                for (int j = 0; j < M; j++) {
                    for (int i = 0; i < N; i++) {
                        tempArr[j][i] = arr[N - 1 - i][j];
                    }
                }
            }
            case 4 -> {
                for (int j = 0; j < M; j++) {
                    for (int i = 0; i < N; i++) {
                        tempArr[j][i] = arr[i][M - 1 - j];
                    }
                }
            }
        }

        return tempArr;
    }

    private static int[][] groupRotate(int[][] arr, int op) {
        int N = arr.length;
        int M = arr[0].length;
        int[][] tempArr = new int[N][M];

        switch (op) {
            case 5 -> five(arr, N, M, tempArr);
            case 6 -> six(arr, N, M, tempArr);
        }

        return tempArr;
    }

    private static void five(int[][] arr, int N, int M, int[][] tempArr) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempArr[i][j] = arr[i + N / 2][j];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                tempArr[i][j] = arr[i][j - M / 2];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempArr[i][j] = arr[i][j + M / 2];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                tempArr[i][j] = arr[i - N / 2][j];
            }
        }
    }

    private static void six(int[][] arr, int N, int M, int[][] tempArr) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempArr[i][j] = arr[i][j + M / 2];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                tempArr[i][j] = arr[i + N / 2][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempArr[i][j] = arr[i - N / 2][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                tempArr[i][j] = arr[i][j - M / 2];
            }
        }
    }
}
