package coding.test.backjoon.gold;

import java.io.*;

public class RemoteControl { // https://www.acmicpc.net/problem/1107
    static boolean[] broken = new boolean[10];
    static int possible(int c) {
        if (c == 0) {
            if (broken[0]) return 0;
            else return 1;
        }

        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) return 0;

            len += 1;
            c /= 10;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            broken[Integer.parseInt(temp[i])] = true;
        }

        int ans = N - 100;
        if (ans < 0) ans = -ans;

        for (int i = 0; i <= 1000000; i++) {
            int c = i;
            int len = possible(c);
            if (len > 0) {
                int press = c - N;
                if (press < 0) press = -press;
                if (ans > len + press) ans = len + press;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
    }
}
