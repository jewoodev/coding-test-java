package thisis.sort;

import java.io.*;
import java.util.PriorityQueue;

public class SortCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(); //숫자 카드 묶음의 크기

        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int[] answer = new int[n%2==0 ? (n/2):(n/2+1)];
        int a, b = 0;
        while (!q.isEmpty()) {
            a = q.poll();
            if (answer[0] == 0) {
                b = q.poll();
            }

            for (int i = 0; i < answer.length; i++) {
                if (i==0) {
                    answer[i] = a + b;
                    continue;
                }
                answer[i] = answer[i-1] + a;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer[answer.length-1]));
        bw.close();
        br.close();
    }
}
