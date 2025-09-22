package coding.test.backjoon.gold;

import java.io.*;
import java.util.*;

public class MakePassword { // https://www.acmicpc.net/problem/1759, 브루트 포스
    private static final Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
    private static int l, c;
    private static char[] chars;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        chars = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        go(0, new char[l], 0);

        System.out.print(sb);
    }

    private static void go(int curLen, char[] password, int s) {
        if (curLen == l) {
            int vowelCnt = 0;
            for (char c : password) {
                if (vowel.contains(c)) vowelCnt++;
            }
            if (vowelCnt >= 1 && vowelCnt <= l - 2) {
                sb.append(password).append("\n");
            }
            return;
        }

        for (int i = s; i < c; i++) {
            password[curLen] = chars[i];
            go(curLen + 1, password, i + 1);
        }
    }
}
