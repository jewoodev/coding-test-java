package coding.test.doit.data.structure.slidingwindow;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n은 카드의 개수
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            q.offer(i);
        }
        while (q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}
