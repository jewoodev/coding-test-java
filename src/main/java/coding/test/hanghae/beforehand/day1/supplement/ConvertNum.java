package coding.test.hanghae.beforehand.day1.supplement;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ConvertNum { //숫자 변환하기 https://school.programmers.co.kr/learn/courses/30/lessons/154538
    public static void main(String[] args) {
        System.out.println(solution(10, 40, 30));
    }
    public static int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(x);
        visited.add(x);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == y) {
                    return count;
                }
                if (cur + n <= y && !visited.contains(cur + n)) {
                    q.add(cur + n);
                    visited.add(cur + n);
                }
                if (cur * 2 <= y && !visited.contains(cur * 2)) {
                    q.add(cur * 2);
                    visited.add(cur * 2);
                }
                if (cur * 3 <= y && !visited.contains(cur * 3)) {
                    q.add(cur * 3);
                    visited.add(cur * 3);
                }
            }
            count++;
        }
        return -1;
    }
}
