package coding.test.backjoon.bronze;

import java.io.*;

public class AplusB3 { // https://www.acmicpc.net/problem/10950
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] read = br.readLine().split(" ");
            bw.write(Integer.parseInt(read[0]) + Integer.parseInt(read[1]) + "\n");
        }

        bw.flush();
    }
}