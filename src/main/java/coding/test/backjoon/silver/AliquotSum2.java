package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class AliquotSum2 { // https://www.acmicpc.net/problem/17427
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int i = 1; i <= num; i++) {
            answer += (num / i) * i;
        }

        System.out.println(answer);
    }
}
