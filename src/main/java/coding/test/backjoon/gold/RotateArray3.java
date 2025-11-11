package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RotateArray3 { // https://www.acmicpc.net/problem/16935, 구현
    private static int[][] arr;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        calculate();
        print();
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void calculate() throws IOException {
        String[] read = br.readLine().split(" ");
        for (int i = 0; i < read.length; i++) {
            String o = read[i];
            switch (o) {
                case "1" -> one();
                case "2" -> two();
                case "3" -> three();
                case "4" -> four();
                case "5" -> five();
                case "6" -> six();
            }
        }
    }

    private static void one() {
        int h = arr.length;
        int w = arr[0].length;
        int[][] temp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                temp[i][j] = arr[h - 1 - i][j];
            }
        }
        arr = temp;
    }

    private static void two() {
        int h = arr.length;
        int w = arr[0].length;
        int[][] temp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                temp[i][j] = arr[i][w - 1 - j];
            }
        }
        arr = temp;
    }

    private static void three() {
        int h = arr.length;
        int w = arr[0].length;
        int[][] temp = new int[w][h];
        for (int j = 0; j < w; j++) {
            for (int i = h - 1; i >= 0; i--) {
                temp[j][(h - 1) - i] = arr[i][j];
            }
        }
        arr = temp;
    }

    private static void four() {
        int h = arr.length;
        int w = arr[0].length;
        int[][] temp = new int[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = w - 1; j >= 0; j--) {
                temp[(w - 1) - j][i] = arr[i][j];
            }
        }
        arr = temp;
    }

    private static void five() {
        int h = arr.length;
        int w = arr[0].length;
        int[][] temp = new int[h][w];
        for (int i = 0; i < h / 2; i++) {
            for (int j = 0; j < w / 2; j++) {
                temp[i][j + w / 2] = arr[i][j];
            }
            for (int j = w / 2; j < w; j++) {
                temp[i + h / 2][j] = arr[i][j];
            }
        }
        for (int i = h / 2; i < h; i++) {
            for (int j = w / 2; j < w; j++) {
                temp[i][j - w / 2] = arr[i][j];
            }
            for (int j = 0; j < w / 2; j++) {
                temp[i - h / 2][j] = arr[i][j];
            }
        }
        arr = temp;
    }

    private static void six() {
        int h = arr.length;
        int w = arr[0].length;
        int[][] temp = new int[h][w];
        for (int i = 0; i < h / 2; i++) {
            for (int j = 0; j < w / 2; j++) {
                temp[i + h / 2][j] = arr[i][j];
            }
            for (int j = w / 2; j < w; j++) {
                temp[i][j - w / 2] = arr[i][j];
            }
        }
        for (int i = h / 2; i < h; i++) {
            for (int j = 0; j < w / 2; j++) {
                temp[i][j + w / 2] = arr[i][j];
            }
            for (int j = w / 2; j < w; j++) {
                temp[i - h / 2][j] = arr[i][j];
            }
        }
        arr = temp;
    }
    
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
