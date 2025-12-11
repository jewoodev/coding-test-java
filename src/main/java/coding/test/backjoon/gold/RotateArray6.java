package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class RotateArray6 { // https://www.acmicpc.net/problem/20327, 구현
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);

        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R개의 연산 수행
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            arr = operation(arr, k, l);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[][] operation(int[][] arr, int k, int l) {
        int blockSize = (int) Math.pow(2, l);

        if (k <= 4) {
            // 각 부분 배열 내부를 변환
            return transformBlocks(arr, k, blockSize);
        } else {
            // 부분 배열을 블록으로 보고 전체 배열 변환
            return transformArray(arr, k, blockSize);
        }
    }

    // 연산 1-4: 각 부분 배열 내부 변환
    private static int[][] transformBlocks(int[][] arr, int op, int blockSize) {
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i += blockSize) {
            for (int j = 0; j < size; j += blockSize) {
                // 각 블록에 대해 연산 수행
                int[][] block = extractBlock(arr, i, j, blockSize);
                block = applyBlockOperation(block, op);
                placeBlock(result, block, i, j);
            }
        }

        return result;
    }

    private static int[][] extractBlock(int[][] arr, int startI, int startJ, int blockSize) {
        int[][] block = new int[blockSize][blockSize];
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < blockSize; j++) {
                block[i][j] = arr[startI + i][startJ + j];
            }
        }
        return block;
    }

    private static int[][] applyBlockOperation(int[][] block, int op) {
        int n = block.length;
        int[][] result = new int[n][n];

        switch (op) {
            case 1: // 상하 반전
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = block[n - 1 - i][j];
                    }
                }
                break;
            case 2: // 좌우 반전
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = block[i][n - 1 - j];
                    }
                }
                break;
            case 3: // 오른쪽 90도
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = block[n - 1 - j][i];
                    }
                }
                break;
            case 4: // 왼쪽 90도
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = block[j][n - 1 - i];
                    }
                }
                break;
        }

        return result;
    }

    private static void placeBlock(int[][] arr, int[][] block, int startI, int startJ) {
        int n = block.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[startI + i][startJ + j] = block[i][j];
            }
        }
    }

    // 연산 5-8: 블록 단위로 배열 변환
    private static int[][] transformArray(int[][] arr, int op, int blockSize) {
        int blockCount = size / blockSize;
        int[][][] blocks = new int[blockCount][blockCount][];

        // 블록들을 추출
        for (int i = 0; i < blockCount; i++) {
            for (int j = 0; j < blockCount; j++) {
                blocks[i][j] = flattenBlock(arr, i * blockSize, j * blockSize, blockSize);
            }
        }

        // 블록 배열에 연산 적용
        int[][][] transformed = applyArrayOperation(blocks, op);

        // 다시 2D 배열로 조립
        return assembleBlocks(transformed, blockSize);
    }


    private static int[] flattenBlock(int[][] arr, int startI, int startJ, int blockSize) {
        int[] block = new int[blockSize * blockSize];
        int idx = 0;
        for (int i = 0; i < blockSize; i++) {
            for (int j = 0; j < blockSize; j++) {
                block[idx++] = arr[startI + i][startJ + j];
            }
        }
        return block;
    }

    private static int[][][] applyArrayOperation(int[][][] blocks, int op) {
        int n = blocks.length;
        int[][][] result = new int[n][n][];

        switch (op) {
            case 5: // 상하 반전
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = blocks[n - 1 - i][j];
                    }
                }
                break;
            case 6: // 좌우 반전
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = blocks[i][n - 1 - j];
                    }
                }
                break;
            case 7: // 오른쪽 90도
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = blocks[n - 1 - j][i];
                    }
                }
                break;
            case 8: // 왼쪽 90도
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result[i][j] = blocks[j][n - 1 - i];
                    }
                }
                break;
        }

        return result;
    }

    private static int[][] assembleBlocks(int[][][] blocks, int blockSize) {
        int blockCount = blocks.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < blockCount; i++) {
            for (int j = 0; j < blockCount; j++) {
                int[] block = blocks[i][j];
                int idx = 0;
                for (int di = 0; di < blockSize; di++) {
                    for (int dj = 0; dj < blockSize; dj++) {
                        result[i * blockSize + di][j * blockSize + dj] = block[idx++];
                    }
                }
            }
        }

        return result;
    }
}
