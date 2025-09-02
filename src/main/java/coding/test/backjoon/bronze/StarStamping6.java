package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

public class StarStamping6 { // https://www.acmicpc.net/problem/2441, 구현
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int M  = N;
        int i;

        for (i = 1; i < N * 2; i += 2) {
            M -= 1;
            String b = " ".repeat(M);
            String s = "*".repeat(i);
            bw.write(b + s + "\n");
        }

        i -= 4;
        M = 0;

        for (; i > 0; i -= 2) {
            M += 1;
            String b = " ".repeat(M);
            String s = "*".repeat(i);
            bw.write(b + s + "\n");
        }

        bw.flush();
    }
}
