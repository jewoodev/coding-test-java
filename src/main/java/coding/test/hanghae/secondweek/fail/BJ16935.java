package coding.test.hanghae.secondweek.fail;

import java.io.*;
import java.util.StringTokenizer;

class BJ16935 {
    private static int N, M, R, num;
    private static int[][] arr;
    private static int[][] tmpArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }

    private static void one() { // 상하 반전
        tmpArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpArr[N - 1 - i][j] = arr[i][j];
            }
        }
        arr = tmpArr;
    }

    private static void two() { // 좌우 반전
        tmpArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpArr[i][M - j - 1] = arr[i][j];
            }
        }
        arr = tmpArr;
    }

    private static void three() { // 오른쪽으로 90도 회전
        tmpArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpArr[j][N - i - 1] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        arr = tmpArr;
    }

    private static void four() {
        tmpArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpArr[M - j - 1][i] = arr[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        arr = tmpArr;
    }

    private static void five() { // 배열을 4구역으로 나눠 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 1
        tmpArr = new int[N][M];
        for (int i = 0; i < N / 2; i++) { // 1 -> 2
            for (int j = 0; j < M / 2; j++) {
                tmpArr[i][M / 2 + j] = arr[i][j];
            }
        }
        for (int i = 0; i < N / 2; i++) { // 2 -> 3
            for (int j = M / 2; j < M; j++) {
                tmpArr[N / 2 + i][j] = arr[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) { // 3 -> 4
            for (int j = 0; j < M / 2; j++) {
                tmpArr[i - N / 2][j] = arr[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) { // 4 -> 1
            for (int j = M / 2; j < M; j++) {
                tmpArr[i][j - M / 2] = arr[i][j];
            }
        }
        arr = tmpArr;
    }

    private static void six() { // 1 -> 4, 4 -> 3, 3 -> 2, 2 -> 1
        tmpArr = new int[N][M];
        for (int i = 0; i < N / 2; i++) { // 1 -> 4
            for (int j = 0; j < M / 2; j++) {
                tmpArr[N / 2 + i][j] = arr[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) { // 4 -> 3
            for (int j = 0; j < M / 2; j++) {
                tmpArr[i][j + M / 2] = arr[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) { // 3 -> 2
            for (int j = M / 2; j < M; j++) {
                tmpArr[i - N / 2][j] = arr[i][j];
            }
        }
        for (int i = 0; i < N / 2; i++) { // 2 -> 1
            for (int j = M / 2; j < M; j++) {
                tmpArr[i][j - M / 2] = arr[i][j];
            }
        }
        arr = tmpArr;
    }
}