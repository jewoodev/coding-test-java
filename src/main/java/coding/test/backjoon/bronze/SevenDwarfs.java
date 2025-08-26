package coding.test.backjoon.bronze;

import java.io.*;
import java.util.Arrays;

public class SevenDwarfs { // https://www.acmicpc.net/problem/2309
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dh = new int[9]; // 일곱 난쟁이의 키
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dh[i] = Integer.parseInt(br.readLine());
            sum += dh[i];
        }
        Arrays.sort(dh);

        int twoSum = sum - 100;

        int[] answer = find(dh, twoSum);

        for (int i = 0; i < 9; i++) {
            if (i == answer[0] || i == answer[1]) continue;
            bw.write(dh[i] + "\n");
        }

        bw.flush();
    }

    private static int[] find(int[] dh, int twoSum) {
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (dh[i] + dh[j] == twoSum) {
                    int[] answer = {i, j};
                    return answer;
                }
            }
        }

        int[] answer = {0, 0};
        return answer;
    }
}
