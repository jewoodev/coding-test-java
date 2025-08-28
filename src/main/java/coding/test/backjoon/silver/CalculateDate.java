package coding.test.backjoon.silver;

import java.io.*;

public class CalculateDate { // https://www.acmicpc.net/problem/1476
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int E = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);
        int M = Integer.parseInt(line[2]);

        int e = 1, s = 1, m = 1;
        for (int i = 1; ; i++) {
            if (e == E && s == S && m == M) {
                bw.write(i + "\n");
                break;
            }

            e += 1;
            s += 1;
            m += 1;

            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;
        }

        bw.flush();
    }
}