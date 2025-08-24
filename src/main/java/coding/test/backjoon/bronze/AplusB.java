package coding.test.backjoon.bronze;

import java.io.*;

public class AplusB { // https://www.acmicpc.net/problem/1000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] read = br.readLine().split(" ");
        bw.write(String.valueOf(Integer.parseInt(read[0]) + Integer.parseInt(read[1])));
        bw.flush();
    }
}
