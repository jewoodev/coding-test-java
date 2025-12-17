package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RotateArray1 { // https://www.acmicpc.net/problem/16926, 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()),
                R= Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer < layers; layer++) {
            rotateLayer(arr, N, M, layer, R);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void rotateLayer(int[][] arr, int N, int M, int layer, int R) {
        int startRow = layer;
        int endRow = N - 1 - layer;
        int startCol = layer;
        int endCol = M - 1 - layer;

        List<Integer> elements = new ArrayList<>();

        for (int j = startCol; j < endCol; j++) {
            elements.add(arr[startRow][j]);
        }

        for (int i = startRow; i < endRow; i++) {
            elements.add(arr[i][endCol]);
        }

        for (int j = endCol; j > startCol; j--) {
            elements.add(arr[endRow][j]);
        }

        for (int i = endRow; i > startRow; i--) {
            elements.add(arr[i][startCol]);
        }

        int size = elements.size();
        int actualRotation = R % size;

        int idx = actualRotation;
        for (int j = startCol; j < endCol; j++) {
            arr[startRow][j] = elements.get(idx % size);
            idx++;
        }

        for (int i = startRow; i < endRow; i++) {
            arr[i][endCol] = elements.get(idx % size);
            idx++;
        }

        for (int j = endCol; j > startCol; j--) {
            arr[endRow][j] = elements.get(idx % size);
            idx++;
        }

        for (int i = endRow; i > startRow; i--) {
            arr[i][startCol] = elements.get(idx % size);
            idx++;
        }
    }
}
