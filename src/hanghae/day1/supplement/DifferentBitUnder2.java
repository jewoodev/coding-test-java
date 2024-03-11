package hanghae.day1.supplement;

//2개 이하로 다른 비트 https://school.programmers.co.kr/learn/courses/30/lessons/77885
public class DifferentBitUnder2 {
    public static void main(String[] args) {
        System.out.println(solution(new long[] {2,7}));
    }

    private static long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++; //x보다 큰수로 만든다.
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        return answer;
    }
}
