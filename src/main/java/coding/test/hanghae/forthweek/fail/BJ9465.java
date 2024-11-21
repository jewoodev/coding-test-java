package coding.test.hanghae.forthweek.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BJ9465 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] stickers;
    static int[] stickers2;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init(); // 초기 세팅
            solve();
            write();
        }
        System.out.print(sb);
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        stickers = new int[2][n];
        stickers2 = new int[2 * n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int numThisSeq = Integer.parseInt(st.nextToken());
                stickers[i][j] = numThisSeq;
                if (i == 0) stickers2[j] = numThisSeq;
                else stickers2[n + j] = numThisSeq;
            }
        }
    }

    static void solve() {
        Arrays.sort(stickers2);
        int biggest1 = stickers2[stickers2.length - 1];
        int biggest2 = stickers2[stickers2.length - 2];

        int[] point1 = find(biggest1);
        int[] point2 = find(biggest2);

        for (int j = 0; j < 4; j++) {
            int nR = point1[0] + dR[j];
            int nC = point1[1] + dC[j];

            if (nR < 0 || nC < 0 || nR >= 2 || nC >= n) continue;
            stickers[nR][nC] = 0;
        }

        for (int j = 0; j < 4; j++) {
            int nR = point2[0] + dR[j];
            int nC = point2[1] + dC[j];

            if (nR < 0 || nC < 0 || nR >= 2 || nC >= n) continue;
            stickers[nR][nC] = 0;
        }
    }

    static int[] find(int stickerNumber) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                if (stickerNumber == stickers[i][j])
                    return new int[] {i, j};
            }
        }
        return null;
    }

    static void write() {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                sum += stickers[i][j];
            }
        }
        sb.append(sum).append("\n");
    }
}
