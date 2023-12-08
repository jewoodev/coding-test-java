package thisis.sort;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] size = new int[n]; //숫자 카드 묶음의 크기
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            size[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(size);
        for (int i : size) {
            q.add(i);
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
