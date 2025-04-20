package coding.test.leetcode.cannot.medium._1861;

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        // 90도 회전
        char[][] rotated = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = box[i][j];
            }
        }
        
        // 각 열에 대해 중력 적용
        for (int j = 0; j < m; j++) {
            int emptyPos = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (rotated[i][j] == '*') {
                    emptyPos = i - 1;
                } else if (rotated[i][j] == '#') {
                    if (emptyPos > i) {
                        rotated[emptyPos][j] = '#';
                        rotated[i][j] = '.';
                        emptyPos--;
                    } else {
                        emptyPos = i - 1;
                    }
                }
            }
        }
        
        return rotated;
    }
} 