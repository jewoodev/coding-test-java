package coding.test.backjoon.silver;

import java.util.*;
import java.io.*;

public class WriteNumInARow1 { // https://www.acmicpc.net/problem/1748, 수학 & 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long ans = 0;
        int num = Integer.parseInt(br.readLine());

        // ㅣ
        for (int start = 1, len = 1; start <= num; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > num) end = num;

            ans += (long) (end - start + 1) * len;
        }

        System.out.println(ans);
    }
}
