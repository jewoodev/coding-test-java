package doit.data.structure.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main implements Comparable<Main> { //P94/문제14.절댓값힙구현하기
    int val;

    public Main(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(Main o) {
        if (Math.abs(this.val) == Math.abs(o.val)) return this.val - o.val;
        return Math.abs(this.val) - Math.abs(o.val);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n은 연산의 개수
        PriorityQueue<Main> q = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int nextInput = Integer.parseInt(br.readLine());
            if (nextInput == 0) {
                if (q.isEmpty()) sb.append("0").append("\n");
                else sb.append(q.poll().val).append("\n");
            }
            else q.offer(new Main(nextInput));
        }
        br.close();
        System.out.println(sb);
    }
}
