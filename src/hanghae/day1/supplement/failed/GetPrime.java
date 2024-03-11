package hanghae.day1.supplement.failed;

import java.util.LinkedList;
import java.util.Queue;

//소수 찾기
public class GetPrime {
    public static void main(String[] args) {
        System.out.println(solution("17"));
    }
    public static int solution(String numbers) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numbers.length(); i++) {
            queue.add(Integer.valueOf(numbers.substring(i)));
        }
        while (!queue.isEmpty())
            if (isPrime(queue.poll()))
                answer++;;
        return answer;
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;
        else if (n == 2) return true;
        for (int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
