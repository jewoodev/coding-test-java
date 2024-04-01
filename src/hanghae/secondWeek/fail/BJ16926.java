package hanghae.secondWeek.fail;

import java.io.*;
import java.util.*;

class BJ16926 {
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        arr = rotate(arr, R);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }

    private static int[][] rotate(int[][] arr, int R) {
        int cnt = Math.min(N, M) / 2; // 회전하는 라인 수
        for (int i = 0; i < R; i++) { // 주어진 횟수만큼 회전 연산을 하는 루프
            for (int j = 0; j < cnt; j++) { // 가장 바깥의 범위(회전을 하는 사각형 경로의 배열 원소)부터 안쪽으로 하나씩 들어가는 루프
                int temp = arr[j][j]; // 회전 연산을 위해 저장해두는 원소
                for (int col = j + 1; col < M - j; col++) { // top
                    arr[j][col - 1] = arr[j][col];
                }
                for (int row = j + 1; row < N - j; row++) { // right
                    arr[row - 1][M - 1 - j] = arr[row][M - 1 - j];
                }
                for (int col = M - 2 - j; col >= j; col--) { // bottom
                    arr[N - 1 - j][col + 1] = arr[N - 1 - j][col];
                }
                for (int row = N - 2 - j; row >= j; row--) { // left
                    arr[row + 1][j] = arr[row][j];
                }
                arr[j + 1][j] = temp;
            }
        }
        return arr;
    }
}