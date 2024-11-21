package coding.test.thisis.dynamic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class fibonacci {
    static BigInteger[] d = new BigInteger[101];
    public static void main(String[] args) throws IOException {
        d[1] = new BigInteger("1");
        d[2] = new BigInteger("1");

        for (int i = 3; i <= 99; i++) {
            d[i] = d[i - 1].add(d[i - 2]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(d[99]));
        bw.close();
    }
}
