package coding.test.backjoon.gold;

import java.io.*;

public class RemoteControl { // https://www.acmicpc.net/problem/1107
    static boolean[] broken = new boolean[10];

    static int possible(int c) {
        if (c == 0) {
            if (broken[0]) return 0;
            else return 1;
        }

        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) return 0;
            len += 1;
            c /= 10;
        }

        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // M=0인 경우의 수정된 처리
        if (M == 0) {
            int directPress = String.valueOf(N).length();  // 숫자 버튼으로 직접 이동
            int plusMinusOnly = Math.abs(N - 100);        // +/- 버튼으로만 이동
            bw.write(Math.min(directPress, plusMinusOnly) + "\n");
            bw.flush();
            return;
        }

        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            broken[Integer.parseInt(temp[i])] = true;
        }

        // +/- 버튼으로만 이동하는 경우
        int ans = Math.abs(N - 100);

        // 숫자 버튼 조합 + +/- 버튼으로 이동하는 경우
        // 탐색 범위를 더 넓혀서 확인
        for (int i = 0; i <= 1000000; i++) {
            int len = possible(i);
            if (len > 0) {
                int press = Math.abs(i - N);
                ans = Math.min(ans, len + press);
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}