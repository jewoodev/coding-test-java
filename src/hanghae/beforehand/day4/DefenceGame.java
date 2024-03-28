package hanghae.beforehand.day4;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//디펜스 게임
public class DefenceGame {
    public static int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int my = n;
        int card = k;
        for (int i = 0; i < enemy.length; i++) {
            my -= enemy[i];
            pq.add(enemy[i]);

            if (my < 0) {
                if (card > 0 && !pq.isEmpty()) {
                    my += pq.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
//        System.out.println(solution(2, 4, new int[]{3, 3, 3, 3}));
//        System.out.println(solution(5, 2, new int[]{99,1,99}));
        System.out.println(solution(10, 1, new int[]{2, 2, 2, 2, 2, 10}));
    }
}
