package doit.data.structure.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsHeap { /* P94/문제14.절댓값힙구현하기 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //n은 연산의 개수
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) return o1 > o2 ? 1 : -1;
            else return firstAbs - secondAbs;
        });
        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if (q.isEmpty()) System.out.println("0");
                else System.out.println(q.poll());
            } else {
                q.add(request);
            }
        }
    }

    /* 우선순위 큐를 써서 풀었다. 이렇게 푸는 것보다 더 로우레벨에서 구현해야 될 것 같은데 방법이 떠오르지 않는다.. */
/*
    int val;

    public AbsHeap(int val) {
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
*/
}
