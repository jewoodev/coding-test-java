package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

class One { // https://www.acmicpc.net/problem/4375, 브루트포스 & 중국인의 나머지 정리
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var ans = new StringBuilder();

        String line = br.readLine();
        while (line != null && !line.equals("")) {
            int n = Integer.parseInt(line);
            int num = 0;
            for (int i = 1; ; i++) {
                num = num * 10 + 1;
                num %= n;
                if (num == 0) {
                    ans.append(i).append("\n");
                    break;
                }
            }
            line = br.readLine();
        }
        br.close();

        System.out.print(ans);
    }
}
