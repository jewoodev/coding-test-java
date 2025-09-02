package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

public class StarStamping4 { // https://www.acmicpc.net/problem/2441, 구현
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int M  = 0;

        for (int i = N; i > 0; i--) {
            M = N - i;
            String s = "*".repeat(i);
            String b = " ".repeat(M);
            bw.write(b + s + "\n");
        }
        bw.flush();
    }
}
