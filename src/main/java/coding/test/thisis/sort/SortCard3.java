package coding.test.thisis.sort;

import java.io.*;
import java.util.PriorityQueue;

public class SortCard3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(); //숫자 카드 묶음의 크기

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            answer += a + b;
            q.add(a + b);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
