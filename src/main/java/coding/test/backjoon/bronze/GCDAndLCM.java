package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

public class GCDAndLCM { // https://www.acmicpc.net/problem/2609, 수학
    private static int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

        int gcd = gcd(x, y);
        int lcm = x * y / gcd;

        sb.append(gcd).append("\n").append(lcm);
        System.out.print(sb);
    }
}
