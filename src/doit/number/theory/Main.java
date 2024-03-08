package doit.number.theory;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    // 백준온라인저지(BOJ -1016) 제곱ㄴㄴ 수 문제풀이
    public static void main(String[] args) throws IOException {

        // 문제에서 주어지는 입력 받기
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();

        // 제곱ㄴㄴ수 판별에 사용 할 배열
        boolean[] arr = new boolean[(int) (Max - Min + 1)];

        // 배열에 저장 될 값 초기화를 위해 사용할 변수
        long init = Min;

        // 제곱ㄴㄴ 개수 저장 할 변수
        int count = 0;

        // 1 이상의 수에서 제곱을 해야 하기때문에 2부터 시작
        // 문제에서 max의 최대값은 1조1백만이므로 백만*백만 까지만 반복하면 됨
        // 1000001 * 1000001은 1조1백만 이상의 값이 나옴
        for (long i = 2; i <= Max ; i++) {
            // 제곱수 계산
            long squareNumber = i * i;

            // 제곱수가 max값 보다 크면 더 이상 반복하지 않음
            if (squareNumber > Max) {
                break;
            } else { // 제곱수가 max값 보다 작을 때

                // 제곱수로 나누어떨어지는 가장 작은 값을 찾기 위한 연산 시작
                // min을 제곱수로 나누어서 몫을 구함
                long quot = (Min / squareNumber);
                // 구한 몫에 다시 제곱수를 곱해서 그 값이 min보다 작으면 몫에 1을 더함
                if (quot * squareNumber < Min) quot++;
                for (long k = quot; squareNumber * k < Max; k++) {
                    arr[(int) ((squareNumber * k) - Min)] = true;
                }
            }
        }

        int cnt = 0;
        // 배열에서 제곱 ㄴㄴ수 개수 세기
        for (boolean b : arr) {
            if (!b) cnt++;
        }

        // 출력
        System.out.println(cnt);
    }
}
