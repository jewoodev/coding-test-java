package coding.test.hanghae.beforehand.day2.fail;

import java.util.LinkedList;
import java.util.Queue;

//두 큐 합 같게 만들기, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 조건을 만들지 못했다
public class MakeEqualSumOfTwoQueue {
    public static long solution(long[] queue1, long[] queue2) {
        long answer = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for (long n : queue1)
            q1.offer(n);
        for (long n : queue2)
            q2.offer(n);
        while (true) {
            if (isImpossible(q1, q2)) return -1;
            if (isSumEqual(q1, q2)) break;
            else {
                if (isFirstBigger(q1, q2)){
                    q2.offer(q1.poll());
                    answer++;
                }
                else {
                    q1.offer(q2.poll());
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean isImpossible(Queue<Long> q1, Queue<Long> q2) {
        return (getQueueSum(q1) + getQueueSum(q2)) % 2 != 0;
    }

    private static boolean isFirstBigger(Queue<Long> q1, Queue<Long> q2) {
        return getQueueSum(q1) > getQueueSum(q2);
    }

    private static boolean isSumEqual(Queue<Long> q1, Queue<Long> q2) {
        return getQueueSum(q1) == getQueueSum(q2);
    }

    private static long getQueueSum(Queue<Long> q1) {
        long sum = 0;
        for (Long i : q1)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new long[]{3, 2, 7, 2}, new long[]{4, 6, 5, 1}));
    }
}
