package coding.test.backjoon.bronze;

import java.io.*;

public class AplusB4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        br.lines().forEach(line -> {
            String[] read = line.split(" ");
            sb.append(Integer.parseInt(read[0]) + Integer.parseInt(read[1])).append("\n");
        });
        bw.write(sb.toString());
        bw.flush();
    }
}