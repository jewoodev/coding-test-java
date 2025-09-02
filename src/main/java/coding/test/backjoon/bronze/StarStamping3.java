package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

public class StarStamping3 { // https://www.acmicpc.net/problem/2440, 구현
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();

        for (int i = N; i > 0; i--) {
            String s = "*".repeat(i);
            bw.write(s + "\n");
        }
        bw.flush();
    }
}
