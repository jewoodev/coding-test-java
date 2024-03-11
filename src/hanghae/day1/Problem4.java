package hanghae.day1;

import java.util.Stack;

public class Problem4 { //뒤에 있는 큰 수 찾기 https://school.programmers.co.kr/learn/courses/30/lessons/154539
    public static void main(String[] args) {
        int[] i = {2, 3, 3, 5};
        for (int ii : solution(i)) {
            System.out.println(ii);
        }
    }
    public static int[] solution(int[] numbers) {
        //number index 정보를 담을 Stack 생성
        Stack<Integer> stack = new Stack<>();

        //정답 배열 생성
        int[] answer = new int[numbers.length];

        //첫 번째 number 인덱스 stack에 push
        stack.push(0);

        //두 번째 원소부터 numbers 탐색
        for (int i = 1; i < numbers.length; i++) {
            //스택이 비어있지 않으면서 현재 스택이 바라보고 있는 값보다 number의 값이 크면 뒤에 있는 큰 수 해당
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                //뒤에 있는 큰 수에 해당하는 모든 값 pop
                answer[stack.pop()] = numbers[i];
            }
            //현재 인덱스 push
            stack.push(i);
        }
        //모든 index를 탐색 후 뒤에 있는 큰 수가 없는 경우 -1
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
    /*
    public static void main(String[] args) {
        int[] i = {2, 3, 3, 5};
        for (int ii : solution(i)) {
            System.out.println(ii);
        }
    }
    public static int[] solution(int[] numbers) {
        bigTail(numbers);
        return numbers;
    }

    private static void bigTail(int[] n) {
        for (int i = 0; i < n.length; i++) {
            find(n, i);
        }
    }

    private static void find(int[] n, int i) {
        if (i > n.length) n[i] = -1;
        else {
            if (n[i] < n[i + 1]) {
                n[i] = n[i + 1];
            } else if (n[i] >= n[i + 1]) {
                for (int j = i + 1; j < n.length; j++) {
                    if (n[i] < n[j]) {
                        for (int k = i; k < j; k++) {
                            n[k] = n[j];
                        }
                        break;
                    }
                    n[i] = -1;
                    break;
                }
            }
        }
    }
}*/
