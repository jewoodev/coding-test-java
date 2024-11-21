package coding.test.doit.dynamic;

import java.io.*;

public class TopDown {
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            d[i] = -1;
        }
        d[0] = 0;
        d[1] = 1;
        fibo(n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(d[n]));
        bw.close();
        br.close();
    }

    static int fibo(int n) {
        if (d[n] != -1) return d[n];
        return d[n] = fibo(n - 2) + fibo(n - 1);
    }
}
