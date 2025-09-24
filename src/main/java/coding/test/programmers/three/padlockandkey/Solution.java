package coding.test.programmers.three.padlockandkey;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int holes = 0, ln = lock.length, kn = key.length;
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < ln; j++) {
                holes += lock[i][j] == 0 ? 1 : 0;
            }
        }
        if (holes == 0) return true;

        for (int rotate = 0; rotate < 4; rotate++) {
            for (int i = -kn + 1; i < ln; i++) {
                for (int j = -kn + 1; j < ln; j++) {
                    boolean possible = insert(lock, key, i, j, holes);
                    if (possible) return true;
                }
            }

            int[][] newKey = new int[kn][kn];
            for (int i = 0; i < kn; i++) {
                for (int j = 0; j < kn; j++) {
                    newKey[j][kn - i - 1] = key[i][j];
                }
            }
            key = newKey;
        }

        return false;
    }

    private boolean insert(int[][] lock, int[][] key, int y, int x, int holes) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                int ny = y + i, nx = x + j;
                if (ny < 0 || nx < 0 || ny >= lock.length || nx >= lock[ny].length) {
                    continue;
                }

                if (key[i][j] == 1) {
                    if (lock[ny][nx] == 1) return false;
                    holes--;
                }
            }
        }

        return holes == 0;
    }
}
