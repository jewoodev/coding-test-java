package coding.test.doit.dynamic;

import java.io.*;

public class MakeIntTo1 {
    static int n;
    static int d[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 ==0) d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 ==0) d[i] = Math.min(d[i], d[i / 3] + 1);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(d[n]));
        bw.close();
        br.close();
    }
}
