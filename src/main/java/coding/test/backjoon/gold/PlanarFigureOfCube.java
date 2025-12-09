package coding.test.backjoon.gold;

import java.util.*;
import java.io.*;

public class PlanarFigureOfCube { // https://www.acmicpc.net/problem/1917, 구현
    // 정육면체의 11가지 기본 전개도 패턴
    private static final String[][] BASIC_PATTERNS = {
            // 패턴 1: 십자형
            {"0010",
            "1111",
            "0010"},

            // 패턴 2: T자형 변형 1
            {"0100",
            "1111",
            "1000"},

            // 패턴 3: T자형 변형 2
            {"0010",
            "1111",
            "0100"},

            // 패턴 4: T자형 변형 3
            {"0001",
            "1111",
            "0100"},

            // 패턴 5: T자형 변형 4
            {"0001",
            "1111",
            "1000"},

            // 패턴 7: L자형 1
            {"1100",
            "0111",
            "0010"},

            // 패턴 8: L자형 2
            {"1100",
            "0111",
            "0001"},

            // 패턴 6: 일자형 2x3
            {"11100",
            "00111"},

            // 패턴 9: 지그재그형
            {"0010",
            "1110",
            "0011"},

            // 패턴 10: 대칭 T자형
            {"0001",
            "1111",
            "0001"},

            // 패턴 11: S자형
            {"1100",
            "0110",
            "0011"}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        for (int test = 0; test < 3; test++) {
            int[][] board = new int[6][6];

            for (int i = 0; i < 6; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 6; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (isCubeNet(board)) {
                ans.append("yes").append("\n");
            } else {
                ans.append("no").append("\n");
            }
        }

        System.out.print(ans);
    }

    private static boolean isCubeNet(int[][] board) {
        for (String[] basePattern : BASIC_PATTERNS) {
            String[] currentPattern = basePattern.clone();

            for (int reverse = 0; reverse < 2; reverse++) {
                // 회전 변형 (0°, 90°, 180°, 270°)
                for (int rotation = 0; rotation < 4; rotation++) {
                    // 모든 시작 위치에서 매칭 시도
                    for (int startX = 0; startX < 6; startX++) {
                        for (int startY = 0; startY < 6; startY++) {
                            if (checkPattern(board, currentPattern, startX, startY)) {
                                return true;
                            }
                        }
                    }
                    currentPattern = rotate90Clockwise(currentPattern);
                }
                currentPattern = leftRightReversal(basePattern);
            }
        }
        return false;
    }

    private static boolean checkPattern(int[][] board, String[] pattern, int startX, int startY) {
        int boardSize = 6;

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length(); j++) {
                int x = startX + i;
                int y = startY + j;

                // 보드 경계를 벗어나면 실패
                if (x < 0 || x >= boardSize || y < 0 || y >= boardSize) {
                    return false;
                }

                char patternCell = pattern[i].charAt(j);
                int boardCell = board[x][y];

                // 패턴과 보드가 일치하지 않으면 실패
                if (patternCell == '1' && boardCell != 1) return false;
                if (patternCell == '0' && boardCell != 0) return false;
            }
        }
        return true;
    }

    // 배열을 시계방향으로 90도 회전
    private static String[] rotate90Clockwise(String[] pattern) {
        int rows = pattern.length;
        int cols = pattern[0].length();
        String[] rotated = new String[cols];

        for (int j = 0; j < cols; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = rows - 1; i >= 0; i--) {
                sb.append(pattern[i].charAt(j));
            }
            rotated[j] = sb.toString();
        }
        return rotated;
    }

    // 배열을 좌우 대칭
    private static String[] leftRightReversal(String[] pattern) {
        String[] mirrored = new String[pattern.length];
        for (int i = 0; i < pattern.length; i++) {
            mirrored[i] = new StringBuilder(pattern[i]).reverse().toString();
        }
        return mirrored;
    }
}
