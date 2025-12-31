package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

class Remainder { // https://www.acmicpc.net/problem/10430, 수학
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int firstResult = (A + B) % C;
        int secondResult = (A * B) % C;

        var ans = new StringBuilder();
        ans.append(firstResult).append("\n");
        ans.append(firstResult).append("\n");
        ans.append(secondResult).append("\n");
        ans.append(secondResult).append("\n");
        System.out.print(ans);
    }
}
