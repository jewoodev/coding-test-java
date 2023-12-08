package thisis.dfs;

import java.io.*;
import java.util.StringTokenizer;

public class InsertingOperators { // p349
    static int[] operator = new int[4];
    static int[] num;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        num = new int[n];

        // 숫자 값 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 갯수 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min).append("\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int number, int idx) {
        if (idx == n) {
            max = Math.max(max, number);
            min = Math.min(min, number);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0: dfs(number + num[idx], idx + 1); break;
                    case 1: dfs(number - num[idx], idx + 1); break;
                    case 2: dfs(number *  num[idx], idx + 1); break;
                    case 3: dfs(number / num[idx], idx + 1); break;
                }
                // 재귀호출이 종료되면 다시 해당 연산자의 갯수를 복구한다.
                operator[i]++;
            }
        }
    }
}
