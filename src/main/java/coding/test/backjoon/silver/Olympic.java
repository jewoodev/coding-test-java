package coding.test.backjoon.silver;

import java.io.*;
import java.util.*;

class Olympic {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        State[] arr = new State[n - 1];
        int idx = 0; // arr 초기화용
        State target = null;
        int answer = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            var cur = new State(num, g, s, b);

            if (num == k) {
                target = cur;
            } else arr[idx++] = cur;
        }

        for (int i = 0; i < n - 1; i++) {
            var cur = arr[i];

            if (cur.g > target.g) answer++;
            else if (cur.g == target.g && cur.s > target.s) answer++;
            else if (cur.g == target.g && cur.s == target.s && cur.b > target.b) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    private static class State {
        int num, g, s, b;
        private State(int num, int g, int s, int b) {
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }
    }
}
