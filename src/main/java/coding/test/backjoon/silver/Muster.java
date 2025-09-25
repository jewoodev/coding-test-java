package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

public class Muster { // https://www.acmicpc.net/problem/11723, 비트마스킹
    private static int result = 0;
    private static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String operator = st.nextToken();
            if (operator.equals("all")) {
                result = (1 << 21) - 1;
                continue;
            } else if (operator.equals("empty")) {
                result = 0;
                continue;
            }

            int operand = Integer.parseInt(st.nextToken());

            switch (operator) {
                case "add" -> add(operand);
                case "check" -> check(operand);
                case "remove" -> remove(operand);
                case "toggle" -> toggle(operand);
            }
        }

        System.out.println(ans);
    }

    private static void add(int num) {
        result |= (1 << num);
    }

    private static void check(int num) {
        ans.append((result & (1 << num)) != 0 ? 1 : 0)
                .append("\n");
    }

    private static void remove(int num) {
        result &= ~(1 << num);
    }

    private static void toggle(int num) {
        result ^= (1 << num);
    }
}
