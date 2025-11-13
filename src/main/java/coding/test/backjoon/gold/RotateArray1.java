package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RotateArray1 { // https://www.acmicpc.net/problem/16926, 구현
    private static int[][] arr;
    private static int n, m, r, layers;

    public static void main(String[] args) throws IOException {
        init();
        findLayer();
        rotate();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    private static void findLayer() {
        layers = Math.min(n, m) / 2;
    }

    private static void rotate() {
        for (int layer = 0; layer < layers; layer++) {
            rotateLayer(layer);
        }
    }

    private static void rotateLayer(int layer) {
        int startRow = layer;
        int endRow = n - 1 - layer;
        int startCol = layer;
        int endCol = m - 1 - layer;

        // 해당 layer의 원소들을 리스트에 저장
        List<Integer> elements = new ArrayList<>();

        // 위쪽(왼 -> 오른)
        for (int j = startCol; j < endCol; j++) {
            elements.add(arr[startRow][j]);
        }

        // 오른쪽(위 -> 아래)
        for (int i = startRow; i < endRow; i++) {
            elements.add(arr[i][endCol]);
        }

        // 아래쪽(오른 -> 왼)
        for (int j = endCol; j > startCol; j--) {
            elements.add(arr[endRow][j]);
        }

        // 왼쪽(아래 -> 위)
        for (int i = endRow; i > startRow; i--) {
            elements.add(arr[i][startCol]);
        }

        // 회전 최적화(elements 갯수로 r을 나눈 나머지만큼만 회전)
        int size = elements.size();
        int actualRotation = r % size;
        int idx = actualRotation;

        for (int j = startCol; j < endCol; j++) { // 위쪽
            arr[startRow][j] = elements.get(idx % size);
            idx++;
        }
        for (int i = startRow; i < endRow; i++) { // 오른쪽
            arr[i][endCol] = elements.get(idx % size);
            idx++;
        }
        for (int j = endCol; j > startCol; j--) { // 아래쪽
            arr[endRow][j] = elements.get(idx % size);
            idx++;
        }
        for (int i = endRow; i > startRow; i--) { // 왼쪽
            arr[i][startCol] = elements.get(idx % size);
            idx++;
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
