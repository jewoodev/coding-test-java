package coding.test.backjoon.bronze;

import java.io.*;
import java.util.*;

class Zoac4 {
    public static void main(String[] args) {
        try (var br = new BufferedReader(new InputStreamReader(System.in))) {
            var st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int i = h / (n + 1);
            int j = w / (m + 1);

            if (h % (n + 1) != 0) i += 1;
            if (w % (m + 1) != 0) j += 1;

            System.out.println(i * j);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int solution(int[] input) {
        int h = input[0];
        int w = input[1];
        int n = input[2];
        int m = input[3];

        int i = h / (n + 1) + h % (n + 1);
        int j = w / (m + 1) + w % (m + 1);

        return i * j;
    }
}
