package coding.test.backjoon.silver;

import java.io.*;

public class One { // https://www.acmicpc.net/problem/4375, 브루트포스 & 중국인의 나머지 정리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        br.lines().forEach(line -> {
            int n = Integer.parseInt(line);
            int num = 0;
            for (int i = 1; ; i++) {
                num = num * 10 + 1;
                num %= n;
                if (num == 0) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        });

        bw.write(sb.toString());
        bw.flush();
    }
}
